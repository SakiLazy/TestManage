package skiii.hziee.testmanage.controller;

import lombok.SneakyThrows;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import skiii.hziee.testmanage.bean.Test;
import skiii.hziee.testmanage.mapper.TestMapper;
import skiii.hziee.testmanage.service.TestService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TestController{

    @Autowired
    TestMapper testMapper;

    @Autowired
    TestService testService;

    @RequestMapping(value = "/GotoManageTest")
    public String GotoManageTest(Model model, Integer test_id, String test_name, Integer now_num, Integer max_num, Date begin_time, Date end_time) {
        List<Test> test = testMapper.findAllTest(test_id,test_name,now_num,max_num,begin_time,end_time);
        model.addAttribute("all_test", test);
        return "/Manager/ManageTest";
    }

    @RequestMapping(value = "/DeleteTest")
    public String DeleteUser(@Param("test_id") Integer test_id) {
        testMapper.deleteTest(test_id);
        return "redirect:/GotoManageTest";
    }

    @RequestMapping(value = "/AddNewTest")
    public String AddNewTest(@Param("test_name") String test_name,
                             @Param("max_num") Integer max_num,
                             @Param("begin_time")String begin_time,
                             @Param("end_time")String end_time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = sdf.parse(begin_time.replace("T"," "));
        Date date2 = sdf.parse(end_time.replace("T"," "));
//        String date1 = sdf.format(begin_time);
//        String date2 = sdf.format(end_time);
        testMapper.addNewTest(test_name,max_num,date1,date2);
//        testMapper.addNewTest(test_name,max_num,begin_time,end_time);
        return "redirect:/GotoManageTest";
    }
}
