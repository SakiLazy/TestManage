package skiii.hziee.testmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {

    @RequestMapping("/")
    public String Welcome() {
        return "/Login";
    }

    @RequestMapping(value = "/GotoAdminLoginPage")
    public String GotoAdminLoginPage() {
        return "/AdminLogin";
    }


    @RequestMapping(value = "/GotoLoginPage")
    public String GotoLoginPage() {
        return "/Login";
    }

    @RequestMapping(value = "/GotoRegisterPage")
    public String GotoRegisterPage() {
        return "/Register";
    }

    @RequestMapping(value = "/GotoManagerPage")
    public String GotoManagerPage() {
        return "/ManagerLogin";
    }
}