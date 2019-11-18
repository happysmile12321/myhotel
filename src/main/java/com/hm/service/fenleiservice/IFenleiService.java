package com.hm.service.fenleiservice;

import com.hm.pojo.Fenlei;

import java.util.Date;
import java.util.List;

public interface IFenleiService {
    List<Fenlei> selectRoomType();

    Fenlei selectRoomTypeByID(int id);

    int deleteRoomTypeByID(int id);

    int updateFenleiInfoByFenleiID(String leixing, int jiage, int id);

    int addRoomType(String leixing, double jiage, Date createtime);
}
