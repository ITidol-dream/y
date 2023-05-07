package demo.controller;

import demo.entity.Equipment;
import demo.entity.User;
import demo.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class AuthController {
    @Autowired
    User user;
    @Autowired
    Equipment equipment;
    @Autowired
    MainService mainService;
    @PostMapping("/dologin")
    public ModelAndView dologin(@RequestParam("username")String username,
                                @RequestParam("role")String role,
                                @RequestParam("password")String password,
                                ModelMap modelMap,
                                HttpSession session){
        user.setPassword(password);
        user.setUsername(username);
        user.setRole(role);
        ArrayList<Equipment> lists =  mainService.select(username);
        session.setAttribute("username",username);
        session.setAttribute("password",password);
        session.setAttribute("role",username);
        modelMap.addAttribute("lists",lists);
        return new ModelAndView("index");
    }

    @PostMapping("/doregister")
    public ModelAndView doregister(@RequestParam("username")String username,
                @RequestParam("role")String role,
                @RequestParam("password")String password){
        user.setPassword(password);
        user.setUsername(username);
        user.setRole(role);
        mainService.registerUser(user);
        return new ModelAndView("login");
    }
    @PostMapping("/dobuy")
    public ModelAndView dobuy(@RequestParam("equipmentname")String equipmentname,
                              @RequestParam("num")int num,
                              @RequestParam("quality")String quality,
                              @SessionAttribute(value = "username", required = false) String username){
        System.out.println(equipmentname);
        System.out.println(num);
        System.out.println(quality);
        equipment.setUsername(username);
        equipment.setEquipmentname(equipmentname);
        equipment.setQuality(quality);
        for (int i = 1;i<=num;i++){
            mainService.buy(equipment);
        }
        return new ModelAndView("login");
    }

    @PostMapping("/doindex")
    public ModelAndView doindex(@SessionAttribute(value = "username", required = false) String username,
                                @SessionAttribute(value = "password", required = false) String password,
                                @SessionAttribute(value = "role", required = false) String role,
                                ModelMap modelMap){
        user.setPassword(password);
        user.setUsername(username);
        user.setRole(role);
        ArrayList<Equipment> lists =  mainService.select(username);
        modelMap.addAttribute("lists",lists);
        return new ModelAndView("index");
    }
}
