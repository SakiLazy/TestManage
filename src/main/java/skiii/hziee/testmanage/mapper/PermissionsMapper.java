package skiii.hziee.testmanage.mapper;

import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import skiii.hziee.testmanage.bean.Permissions;
import skiii.hziee.testmanage.bean.User;

import java.util.List;

@Mapper
public interface PermissionsMapper {

    @Select("select * from permissions")
    List<Permissions> listallpermissions();

    @Update("UPDATE permissions SET state = 1 WHERE name=#{name}")
    void Accept(String name);

    @Update("UPDATE permissions SET state = 0 WHERE name=#{name}")
    void Deny(String name);

    @Select("select state from permissions where name=#{name}")
    Permissions p_now_state(@Param("name")String name, Integer state);
}
