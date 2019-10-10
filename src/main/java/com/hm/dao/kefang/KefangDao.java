package com.hm.dao.kefang;

import com.hm.pojo.Kefang;

import java.util.List;





public interface KefangDao  {
	
	
	
	public void insertBean(Kefang bean);
	
	public void deleteBean(Kefang bean);
	
	public void updateBean(Kefang bean);

	public Kefang selectBean(String where);
	
	public List<Kefang> selectBeanList(final int start, final int limit, final String where);
	
	public int selectBeanCount(final String where);
	
	
}
