package skiii.hziee.testmanage.controller;

import skiii.hziee.testmanage.bean.ExaminationRegistration;
import skiii.hziee.testmanage.service.ExaminationRegistrationService;
import skiii.hziee.testmanage.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/examination_registration")
public class ExaminationRegistrationController extends BaseController<ExaminationRegistration,ExaminationRegistrationService> {

    /**
     *考试报名对象
     */
    @Autowired
    public ExaminationRegistrationController(ExaminationRegistrationService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}