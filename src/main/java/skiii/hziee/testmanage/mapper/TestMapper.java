package skiii.hziee.testmanage.mapper;

import org.apache.ibatis.annotations.*;
import skiii.hziee.testmanage.bean.Test;

import java.util.Date;
import java.util.List;

@Mapper
public interface TestMapper {

    @Insert("insert into test(test_name,max_num,begin_time,end_time)values(#{test_name},#{max_num},#{begin_time},#{end_time})")
    void addNewTest(@Param("test_name") String test_name,
                    @Param("max_num") Integer max_num,
                    @Param("begin_time") Date begin_time,
                    @Param("end_time") Date end_time);

    @Delete("delete FROM test WHERE test_id=#{test_id}")
    void deleteTest(Integer test_id);

    @Select("select * from test")
    List<Test> findAllTest(Integer test_id,String test_name,Integer now_num,Integer max_num,Date begin_time,Date end_time);

}
