package demo.service;

import demo.entity.Equipment;
import demo.entity.User;
import demo.mapper.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Component
public class MainService {

    @Autowired
    MainMapper mainMapper;
    public ArrayList<Equipment> select(String username){
        return mainMapper.select(username);
    }

    public void registerUser(User user){
        mainMapper.registerUser(user.getUsername(),user.getPassword(), user.getRole());
    }

    public void buy(Equipment equipment){
        mainMapper.buy(equipment.getUsername(), equipment.getEquipmentname(), equipment.getQuality());
    }

}
