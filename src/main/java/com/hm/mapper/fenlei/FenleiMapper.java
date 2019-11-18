package com.hm.mapper.fenlei;

import com.hm.pojo.Fenlei;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface FenleiMapper {

    //查询所有分类信息
    List<Fenlei> selectRoomType();

    //根据分类Id查询分类信息
    Fenlei selectRoomTypeByID(int id);

    //根据id删除房间类型
    int deleteRoomTypeByID(int id);

    int updateRoomTypeByID(@Param("leixing") String leixing,@Param("jiage") int jiage,@Param("id") int id);

    int addRoomType(@Param("leixing") String leixing, @Param("jiage") double jiage, @Param("createtime") Date date);
}
