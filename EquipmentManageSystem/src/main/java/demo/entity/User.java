package demo.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {
    String username;
    String password;
    String role;
}
