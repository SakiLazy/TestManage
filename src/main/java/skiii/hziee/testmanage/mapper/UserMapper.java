package skiii.hziee.testmanage.mapper;

import org.apache.ibatis.annotations.*;
import skiii.hziee.testmanage.bean.Admin;
import skiii.hziee.testmanage.bean.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE name = #{name} AND password = #{password}")
    User getInfo(@Param("name") String name,
                 @Param("password") String password);

    @Insert("insert into user(name,password)values(#{name},#{password})")
    void saveInfo(@Param("name") String name,
                  @Param("password") String password);

    @Select("SELECT * FROM adminuser WHERE name = #{name} AND password = #{password}")
    Admin getAdminInfo(@Param("name") String name,
                       @Param("password") String password);

    @Select("SELECT * FROM user WHERE name = #{name} AND password = #{password} AND role = 2")
    User getManagerInfo(@Param("name") String name,
                        @Param("password") String password);

    @Select("select * from user where role = 1")
    List<User> findAllUser();

    @Select("select * from user where role = 2")
    List<User> findAllUserTwo();

    @Delete("delete FROM user WHERE id=#{id}")
    void deleteUser(Integer id);

    @Update("UPDATE user SET role = 2 WHERE id=#{id}")
    void UpToManager(Integer id);

    @Update("UPDATE user SET role = 1 WHERE id=#{id}")
    void DownToStu(Integer id);
}
