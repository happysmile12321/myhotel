package com.hm.mapper.user;

import com.hm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

	//查询用户是否在数据库中存在 -> 登陆模块
	User selectUser(User loginUser);

	//在数据库中插入记录 -> 注册模块
	int insertUser(User user);

	//根据用户名查询是否存在用户，如果不存在，则返回null
	User selectUserByUserName(String userName);

	//根据用户名,密码,用户锁查询是否存在用户，如果不存在，则返回null
	User selectUserByUserName_PassWord_UserLock(User user);

	//根据用户名来修改密码
	int updatePassWordByUserName(User user);

	//根据Id来查用户信息
    User selectUserByID(int id);
	//查询所有用户信息
    List<User> selectUsers();
	//根据用户名和身份查询用户是否存在于数据库
    User selectUserByUserName_UserRole(@Param("username") String username, @Param("role") int role);
	//更新用户信息
    int updateUser(User user);

	int deleteUser(int id);
}
