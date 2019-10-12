package com.hm.mapper.user;

import com.hm.pojo.User;

public interface UserMapper {

	//查询用户是否在数据库中存在 -> 登陆模块
	User selectUser(User loginUser);

	//在数据库中插入记录 -> 注册模块
	int insertUser(User user);

	//根据用户名查询是否存在用户，如果不存在，则返回null
	User selectUserByUserName(String userName);
	
}
