package skiii.hziee.testmanage.controller;
import lombok.SneakyThrows;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yaml.snakeyaml.reader.StreamReader;
import skiii.hziee.testmanage.bean.ExaminationRegistration;
import skiii.hziee.testmanage.mapper.PermissionsMapper;
import skiii.hziee.testmanage.mapper.ExaminationRegistrationMapper;
import skiii.hziee.testmanage.service.ExaminationRegistrationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ExaminationRegistrationController {
    final String manageTest = "manageTest";
    final String addnewTest = "addnewTest";
    final Integer juststate = 0;

    @Autowired
    ExaminationRegistrationMapper examinationRegistrationMapper;

    @Autowired
    ExaminationRegistrationService examinationRegistrationService;

    @Autowired
    PermissionsMapper permissionsMapper;

}
