package skiii.hziee.testmanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import skiii.hziee.testmanage.bean.Admin;
import skiii.hziee.testmanage.bean.User;
import skiii.hziee.testmanage.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String login(String name, String password, Model model) {
        User user = userService.LoginIn(name, password);
        model.addAttribute("user_name", name);
        if (user != null) {
            return "Index";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/AdminloginIn", method = RequestMethod.POST)
    public String Adminlogin(String name, String password, Model model) {
        Admin admin = userService.AdminLogin(name, password);
        if (admin != null) {
            return "/Admin/AdminIndex";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public String Register(String name, String password, Model model) {
        userService.Insert(name, password);
        model.addAttribute("user_name", name);
        return "/Index";
    }
}