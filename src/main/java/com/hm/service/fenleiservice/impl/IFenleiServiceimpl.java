package com.hm.service.fenleiservice.impl;

import com.hm.mapper.fenlei.FenleiMapper;
import com.hm.pojo.Fenlei;
import com.hm.service.fenleiservice.IFenleiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public Fenlei selectRoomTypeByID(int id) {
        Fenlei fenlei = fenleiMapper.selectRoomTypeByID(id);
        return fenlei;
    }

    @Override
    public int deleteRoomTypeByID(int id) {
        int row = fenleiMapper.deleteRoomTypeByID(id);
        return row;
    }

    @Override
    public int updateFenleiInfoByFenleiID(String leixing, int jiage, int id) {
        int row = fenleiMapper.updateRoomTypeByID(leixing,jiage,id);
        return row;
    }

    @Override
    public int addRoomType(String leixing, double jiage, Date createtime) {
        Date date = new Date();
        int row = fenleiMapper.addRoomType(leixing,jiage,date);
        return row;
    }
}
