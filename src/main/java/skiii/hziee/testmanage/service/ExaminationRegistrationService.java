package skiii.hziee.testmanage.service;

import skiii.hziee.testmanage.bean.ExaminationRegistration;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import skiii.hziee.testmanage.mapper.ExaminationRegistrationMapper;

import java.util.Date;
import java.util.List;
/**
 * 考试报名：(ExaminationRegistration)表服务接口
 *
 */
@Service
public class ExaminationRegistrationService {
    @Autowired
    ExaminationRegistrationMapper examinationRegistrationMapper;
}
