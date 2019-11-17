package com.hm.service.yudingservice.impl;

import com.hm.mapper.yuding.YudingMapper;
import com.hm.pojo.Fenlei;
import com.hm.pojo.User;
import com.hm.pojo.UserYuding;
import com.hm.pojo.Yuding;
import com.hm.service.yudingservice.IYudingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IYudingServiceimpl implements IYudingService {
    @Autowired
    YudingMapper yudingMapper;
    @Override
    public List<UserYuding> yudingChaXun(int userid) {
        List<UserYuding> userYudings = yudingMapper.selectYuding(userid);
        return userYudings;

    }

    @Override
    public Yuding yudingChaXunByYuDingKeFangIDAndUserID(int kefangid, int id) {
        Yuding yuding = yudingMapper.selectYudingByKefangIdAndUserID(kefangid,id);
        return yuding;
    }



}
