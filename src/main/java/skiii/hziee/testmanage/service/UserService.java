package skiii.hziee.testmanage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import skiii.hziee.testmanage.bean.Admin;
import skiii.hziee.testmanage.bean.User;
import skiii.hziee.testmanage.mapper.UserMapper;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User LoginIn(String name, String password) {
        return userMapper.getInfo(name, password);
    }

    public void Insert(String name, String password) {
        userMapper.saveInfo(name, password);
    }

    public Admin AdminLogin(String name, String password) {
        return userMapper.getAdminInfo(name, password);
    }

    public User ManagerLogin(String name, String password) {
        return userMapper.getManagerInfo(name, password);
    }

    public void DeleteUser(Integer id){
        userMapper.deleteUser(id);
    }

    public void UpToManager(Integer id){
        userMapper.UpToManager(id);
    }

    public void DownToStu(Integer id){
        userMapper.DownToStu(id);
    }
}