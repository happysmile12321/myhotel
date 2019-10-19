package com.hm.service.userservice;

import com.hm.pojo.User;

public interface IUserService {

    //登陆业务
    User login(User user);
    //注册业务
    Integer register(User user);
    //查询用户
    boolean selectUserIsExit(String userName, String passWord, int userLock);
    //根据用户名来修改密码
    Integer modifyPasswordByUserName(String userName, String passWord);


}