package com.hm.service.userservice;

import com.hm.pojo.User;

import java.util.List;

public interface IUserService {

    //登陆业务
    User login(User user);
    //注册业务
    Integer register(User user);
    //查询用户
    boolean selectUserIsExit(String userName, String passWord, int userLock);
    //根据用户名来修改密码
    Integer modifyPasswordByUserName(String userName, String passWord);
    //根据Id查询用户信息
    User selectUserByID(int id);
    //用户管理，先查询所有用户信息
    List<User> selectUsers();

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}