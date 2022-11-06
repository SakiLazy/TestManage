package skiii.hziee.testmanage.mapper;

import org.apache.ibatis.annotations.*;
import skiii.hziee.testmanage.bean.Admin;
import skiii.hziee.testmanage.bean.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE name = #{name} AND password = #{password}")
    User getInfo(@Param("name") String name, @Param("password") String password);

    @Insert("insert into user(name,password)values(#{name},#{password})")
    void saveInfo(@Param("name") String name,
                  @Param("password") String password);

    @Select("SELECT * FROM adminuser WHERE name = #{name} AND password = #{password}")
    Admin getAdminInfo(@Param("name") String name, @Param("password") String password);

    @Select("select * from user")
    List<User> findAllUser();

}
