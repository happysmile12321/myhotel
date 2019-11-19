package com.hm.mapper.kaifang;

import com.hm.pojo.KefangKaifangFenlei;

import java.util.List;

public interface KaifangMapper {


	List<KefangKaifangFenlei> selectKaiFang();

	List<KefangKaifangFenlei> selectTuiFang();
}
