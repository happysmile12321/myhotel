package com.hm.service.tuifangservice.impl;

import com.hm.mapper.kaifang.KaifangMapper;
import com.hm.pojo.KefangKaifangFenlei;
import com.hm.service.tuifangservice.ITuiFangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ITuiFangServiceimpl implements ITuiFangService {


    @Autowired
    private KaifangMapper kaifangMapper;
    @Override
    public List<KefangKaifangFenlei> selectTuiFang() {
        List<KefangKaifangFenlei> kefangKaifangFenleis = kaifangMapper.selectTuiFang();
        return kefangKaifangFenleis;
    }
}
