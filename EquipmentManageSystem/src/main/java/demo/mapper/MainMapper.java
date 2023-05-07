package demo.mapper;

import demo.entity.Equipment;
import demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Mapper
@Component
public interface MainMapper {
    @Select("select * from equipment where username = #{username}")
    ArrayList<Equipment> select(@Param("username") String username);

    @Insert("insert into user (username,password,role) values (#{username},#{password},#{role})")
    void registerUser(@Param("username") String username,
                      @Param("password") String password,
                      @Param("role") String role);

    @Insert("insert into equipment (username,equipmentname,quality) values (#{username},#{equipmentname},#{quality})")
    void buy(@Param("username") String username,
                      @Param("equipmentname") String equipmentname,
                      @Param("quality") String quality);

}
