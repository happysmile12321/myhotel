package com.hm.service.yudingservice.impl;

import com.hm.mapper.yuding.YudingMapper;
import com.hm.pojo.UserYuding;
import com.hm.pojo.UserYudingKefangFenleiKaifang;
import com.hm.pojo.Yuding;
import com.hm.pojo.YudingKefangFenlei;
import com.hm.service.yudingservice.IYudingService;
import com.hm.utils.DateSaveInDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public List<UserYudingKefangFenleiKaifang> yudingChaXunAll() {
        List<UserYudingKefangFenleiKaifang> userYudings = yudingMapper.selectYudingAll();
        return userYudings;
    }

    @Override
    public List<YudingKefangFenlei> yudingChaXunAll_real() {
        List<YudingKefangFenlei> yudingKefangFenleis = yudingMapper.selectYudingAll_real();
        return yudingKefangFenleis;
    }


}
