package demo;

import demo.entity.Equipment;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class EquipmentManageSystemApplicationTests {

    @Test
    void contextLoads() {

        ArrayList<Equipment> equipment = new ArrayList<>();
        equipment.add(new Equipment());
        equipment.add(new Equipment());
        System.out.println(equipment.get(0).getUsername());

    }

}
