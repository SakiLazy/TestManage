package skiii.hziee.testmanage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import skiii.hziee.testmanage.bean.Test;
import skiii.hziee.testmanage.mapper.TestMapper;

import java.util.Date;
import java.util.List;

@Service
public class TestService {

    @Autowired
    TestMapper testMapper;

//    public Test getAllTest(Integer test_id, String test_name, Integer now_num, Integer max_num, Date begin_time,Date end_time) {
//        List<Test> tests = testMapper.findAllTest(test_id,test_name,now_num,max_num,begin_time,end_time);
//        return (Test) tests;
//    }
}
