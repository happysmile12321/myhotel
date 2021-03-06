package com.hm.service.yudingservice;

import com.hm.pojo.UserYuding;
import com.hm.pojo.UserYudingKefangFenleiKaifang;
import com.hm.pojo.Yuding;
import com.hm.pojo.YudingKefangFenlei;

import java.util.List;

public interface IYudingService {

    //普通用户--预订记录查询service
    List<UserYuding> yudingChaXun(int userid);

    Yuding yudingChaXunByYuDingKeFangIDAndUserID(int kefangid, int id);

    List<UserYudingKefangFenleiKaifang> yudingChaXunAll();

    List<YudingKefangFenlei> yudingChaXunAll_real();
}
