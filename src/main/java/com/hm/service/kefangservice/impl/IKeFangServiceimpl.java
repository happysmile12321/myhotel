package com.hm.service.kefangservice.impl;

import com.hm.mapper.kefang.KefangMapper;
import com.hm.pojo.KefangFeilei;
import com.hm.service.kefangservice.IKeFangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IKeFangServiceimpl implements IKeFangService {
    @Autowired
    private KefangMapper kefangMapper;
    @Override
    public List<KefangFeilei> selectKeFang(KefangFeilei kefangFeilei) {

        List<KefangFeilei> kefangFeileis = kefangMapper.selectKeFangFcenLei(kefangFeilei);
        return kefangFeileis;
    }
}
