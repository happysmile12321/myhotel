package com.hm.mapper.yuding;


import com.hm.pojo.User;
import com.hm.pojo.UserYuding;
import com.hm.pojo.Yuding;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YudingMapper {

	//根据用户id号查询数据库中的记录
	List <UserYuding>selectYuding(int userid);

	Yuding selectYudingByKefangIdAndUserID(@Param("kefangid") int kefangid, @Param("userid") int id);
}
