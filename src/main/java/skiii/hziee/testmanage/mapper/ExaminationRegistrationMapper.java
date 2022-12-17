package skiii.hziee.testmanage.mapper;
import org.apache.ibatis.annotations.*;
import skiii.hziee.testmanage.bean.ExaminationRegistration;


import java.util.Date;
import java.util.List;

@Mapper
public interface ExaminationRegistrationMapper {
    @Insert("insert into examination_reg(test_name,max_num,begin_time,end_time,place,owner)values(#{test_name},#{max_num},#{begin_time},#{end_time},#{place},#{owner})")
    void addToTest(@Param("test_name") String test_name,
                    @Param("max_num") Integer max_num,
                    @Param("begin_time") Date begin_time,
                    @Param("end_time") Date end_time,
                    @Param("place") String place,
                    @Param("owner") String owner);
    @Delete("delete FROM examination_reg WHERE test_id=#{test_id}")
    void deletemyTest(Integer test_id);
    @Select("select * from examination_reg")
    List<ExaminationRegistration> findAllTest(Integer id,
                            Integer test_id,
                           String test_name,
                           Integer now_num,
                           Integer max_num,
                           Date begin_time,
                           Date end_time,
                           String place,
                           String owner);

    @Select("select * from examination_reg where test_name=#{test_name}")
    List<ExaminationRegistration> SearchInTest(Integer id, Integer test_id,
                          @Param("test_name") String test_name,
                          Integer now_num,
                          Integer max_num,
                          Date begin_time,
                          Date end_time,
                          String place,
                          String owner);

    @Select("select * from examination_reg where owner=#{owner}")
    List<ExaminationRegistration> MyTest(Integer id,Integer test_id,
                      String test_name,
                      Integer now_num,
                      Integer max_num,
                      Date begin_time,
                      Date end_time,
                      String place,
                      @Param("owner") String owner);
}
