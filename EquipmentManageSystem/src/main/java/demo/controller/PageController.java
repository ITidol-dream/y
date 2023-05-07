package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
    @RequestMapping("/")
    public ModelAndView home(){
        return new ModelAndView("login");
    }
    @RequestMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @RequestMapping("/register")
    public ModelAndView register(){return new ModelAndView("register");}

    @RequestMapping("/buy")
    public ModelAndView buy(){return new ModelAndView("buy");}

    @RequestMapping("/success")
    public ModelAndView success(){return new ModelAndView("success");}
}
