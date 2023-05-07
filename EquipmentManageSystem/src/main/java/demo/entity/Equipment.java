package demo.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Equipment {
    int no;
    String username;
    String equipmentname;
    String quality;
}
