package com.hm.service.fenleiservice.impl;

import com.hm.mapper.fenlei.FenleiMapper;
import com.hm.pojo.Fenlei;
import com.hm.service.fenleiservice.IFenleiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IFenleiServiceimpl implements IFenleiService {
    @Autowired
    private FenleiMapper fenleiMapper;
    @Override
    public List<Fenlei> selectRoomType() {
        List<Fenlei> fenleis = fenleiMapper.selectRoomType();
        return fenleis;
    }
}
