package com.hm.dao.kaifang;

import com.hm.pojo.Kaifang;

import java.util.List;





public interface KaifangMapper {
	
	
	
	public void insertBean(Kaifang bean);
	
	public void deleteBean(Kaifang bean);
	
	public void updateBean(Kaifang bean);

	public Kaifang selectBean(String where);
	
	public List<Kaifang> selectBeanList(final int start, final int limit, final String where);
	
	public int selectBeanCount(final String where);
	
	
}
