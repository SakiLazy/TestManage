package skiii.hziee.testmanage.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import skiii.hziee.testmanage.bean.Permissions;
import skiii.hziee.testmanage.bean.User;
import skiii.hziee.testmanage.mapper.PermissionsMapper;

import java.util.List;

@Controller
public class PermissionsController {

    @Autowired
    PermissionsMapper permissionsMapper;

    @RequestMapping("/GotoManagePermissions")
    public String listallpermissions(Model model) {
        List<Permissions> permissions = permissionsMapper.listallpermissions();
        model.addAttribute("allpermissions", permissions);
        return "/Admin/ManagePermissions";
    }

    @RequestMapping("/Accept")
    public String accept(@Param("name")String name){
        permissionsMapper.Accept(name);
        return "redirect:/GotoManagePermissions";
    }

    @RequestMapping("/Deny")
    public String deny(@Param("name")String name){
        permissionsMapper.Deny(name);
        return "redirect:/GotoManagePermissions";
    }


}
