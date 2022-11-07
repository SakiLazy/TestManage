package skiii.hziee.testmanage.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import skiii.hziee.testmanage.bean.Admin;
import skiii.hziee.testmanage.bean.User;
import skiii.hziee.testmanage.mapper.UserMapper;
import skiii.hziee.testmanage.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

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

    @RequestMapping(value = "/ManagerloginIn", method = RequestMethod.POST)
    public String Managerlogin(String name, String password, Model model) {
        User user = userService.ManagerLogin(name, password);
        if (user != null) {
            return "/Manager/ManagerIndex";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/GotoManageUsers")
    public String GotoManageUser(Model model) {
        List<User> user = userMapper.findAllUser();
        model.addAttribute("alluser", user);
        return "/Admin/ManageUsers";
    }

    @RequestMapping(value = "/GotoManageUsersTwo")
    public String GotoManageUserTwo(Model model) {
        List<User> userTwo = userMapper.findAllUserTwo();
        model.addAttribute("alluserTwo", userTwo);
        return "/Admin/ManageUsersTWO";
    }

    @RequestMapping(value = "/DeleteUser")
    public String DeleteUser(@Param("id") Integer id) {
        userService.DeleteUser(id);
        return "redirect:/GotoManageUsers";
    }

    @RequestMapping(value = "/UpToManager")
    public String uptoManager(@Param("id") Integer id) {
        userService.UpToManager(id);
        return "redirect:/GotoManageUsers";
    }

    @RequestMapping(value = "/DownToStu")
    public String downtoStu(@Param("id") Integer id) {
        userService.DownToStu(id);
        return "redirect:/GotoManageUsers";
    }
}