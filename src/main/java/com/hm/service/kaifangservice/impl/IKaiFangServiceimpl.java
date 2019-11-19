package com.hm.service.kaifangservice.impl;

import com.hm.mapper.kaifang.KaifangMapper;
import com.hm.pojo.KefangKaifangFenlei;
import com.hm.service.kaifangservice.IKaiFangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IKaiFangServiceimpl implements IKaiFangService {

    @Autowired
    private KaifangMapper kaifangMapper;

    @Override
    public List<KefangKaifangFenlei> selectKaiFang() {
        List<KefangKaifangFenlei> kefangKaifangFenleis = kaifangMapper.selectKaiFang();
        System.out.println(kefangKaifangFenleis+"#######service");
        return kefangKaifangFenleis;
    }
}
