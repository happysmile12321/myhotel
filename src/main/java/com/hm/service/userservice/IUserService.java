package com.hm.service.userservice;

import com.hm.pojo.User;

public interface IUserService {

    //登陆业务
    User login(User user);
    //注册业务
    Integer register(User user);


}