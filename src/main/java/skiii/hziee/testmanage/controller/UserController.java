package skiii.hziee.testmanage.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import skiii.hziee.testmanage.bean.Admin;
import skiii.hziee.testmanage.bean.Test;
import skiii.hziee.testmanage.bean.User;
import skiii.hziee.testmanage.mapper.TestMapper;
import skiii.hziee.testmanage.mapper.UserMapper;
import skiii.hziee.testmanage.service.UserService;

import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    TestMapper testMapper;

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String login(String name, String password, Model model) {
        User user = userService.LoginIn(name, password);
        model.addAttribute("user_name", name);
        int roles = user.getRole();
        if (roles == 1) {
            return "redirect:/GotoJoinTest";
        } else {
            return "/error";
        }
    }

    @RequestMapping(value = "/GotoJoinTest")
    public String GotoJoinTest(Model model,
                                 Integer test_id,
                                 String test_name,
                                 Integer now_num,
                                 Integer max_num,
                                 Date begin_time,
                                 Date end_time,
                                 String place,
                                 String owner) {
        List<Test> test = testMapper.findAllTest(test_id, test_name, now_num, max_num, begin_time, end_time, place, owner);
        model.addAttribute("all_test", test);
        return "/Student/StuJoinTest";

    }

    @RequestMapping(value = "/AdminloginIn", method = RequestMethod.POST)
    public String Adminlogin(String name, String password, Model model) {
        Admin admin = userService.AdminLogin(name, password);
        if (admin != null) {
            return "/Admin/AdminIndex";
        } else {
            return "/error";
        }
    }

    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public String Register(String name, String password, Model model) {
        userService.Insert(name, password);
        model.addAttribute("user_name", name);
        return "/Login";
    }

    @RequestMapping(value = "/ManagerloginIn", method = RequestMethod.POST)
    public String Managerlogin(String name, String password, Model model) {
        User user = userService.ManagerLogin(name, password);
        String nowname = userService.ManagerLogin(name, password).getName();
        model.addAttribute("now_manage_user", nowname);
        int roles = user.getRole();
        if (roles == 2) {
            return "/Manager/ManagerIndex";
        } else {
            return "/error";
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
        return "/Admin/ManageUsersTwo";
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

    @RequestMapping(value = "/FindUserWithStu")
    public String finduserwithstu(@Param("name") String name, Model model) {
        List<User> user = userMapper.FindUserWithStu(name);
        model.addAttribute("alluser", user);
        return "/Admin/ManageUsers";
    }

    @RequestMapping(value = "/FindUserWithManager")
    public String finduserwithmanagername(@Param("name") String name, Model model) {
        List<User> userTwo = userMapper.FindUserWithManager(name);
        model.addAttribute("alluserTwos", userTwo);
        return "/Admin/ManageUsersTwo";
    }

    @RequestMapping(value = "/AddNewUser")
    public String addnewuser(@Param("name") String name, @Param("password") String password) {
        userMapper.saveInfo(name, password);
        return "redirect:/GotoManageUsers";
    }
}