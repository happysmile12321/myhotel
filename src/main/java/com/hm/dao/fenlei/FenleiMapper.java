package com.hm.dao.fenlei;

import com.hm.pojo.Fenlei;

import java.util.List;

public interface FenleiMapper {

    public void insertBean(Fenlei bean);

    public void deleteBean(int id);

    public void updateBean(Fenlei bean);

    public Fenlei selectBean(String where);

    public List<Fenlei> selectBeanList(final int start, final int limit, final String where);

    public int selectBeanCount(final String where);
}
