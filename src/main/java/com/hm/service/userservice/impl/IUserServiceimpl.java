package com.hm.service.userservice.impl;

import com.hm.mapper.user.UserMapper;
import com.hm.pojo.User;
import com.hm.service.userservice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceimpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    public User login(User user) {
        User selectedUser = userMapper.selectUser(user);
        return selectedUser;
    }
    //用户注册，返回注册id，如果为0，则注册失败。
    //检查数据库中是否用username一样的用户，如果有，则注册失败
    public boolean isUserExits(String userName){
        //不存在返回null
        if(userMapper.selectUserByUserName(userName)==null){
            return false;
        }else{
            return true;
        }
    }
    public Integer register(User user) {
        boolean isExits = isUserExits(user.getUsername());
        //如果不存在，我们要创建用户
        if(!isExits){
            int i = userMapper.insertUser(user);
            int id = user.getId();
            if(i>0)
            {
                System.out.println(String.format("第%d位用户注册成功!!!",id));
            }else{
                System.out.println(String.format("第%d条记录插入失败!!!",id));
            }
            return id;
        }//否则返回0
      return 0;
    }

    //存在返回true
    public boolean selectUserIsExit(String userName, String passWord, int userLock) {
        User bindUser = new User();
        bindUser.setUsername(userName);
        bindUser.setPassword(passWord);
        bindUser.setUserlock(userLock);
        User user = userMapper.selectUserByUserName_PassWord_UserLock(bindUser);
        if(user!=null){
            return true;
        }
        return false;
    }

    public Integer modifyPasswordByUserName(String userName, String passWord) {
        User user = new User();
        user.setUsername(userName);
        user.setPassword(passWord);
        int i = userMapper.updatePassWordByUserName(user);
        return i;
    }
}
