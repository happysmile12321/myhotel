package com.hm.mapper.fenlei;

import com.hm.pojo.Fenlei;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class TestFenleiMapper {
    SqlSession sqlSession;

    {
        try {
            InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*增*/
    public void testFenleiMapper() throws IOException {
        FenleiMapper fenleiMapper = sqlSession.getMapper(FenleiMapper.class);
        Fenlei fenlei = new Fenlei();
        fenlei.setDeletestatus(0);
        fenlei.setJiage(128);
        fenlei.setLeixing("家庭温馨旅馆");
        Date date = new Date();
        fenlei.setCreatetime(date);
        fenleiMapper.insertBean(fenlei);
        System.out.println("您插入的id是：" + fenlei.getId());
        sqlSession.commit();
        sqlSession.close();
    }
    /*删*/
    public void testDeleteFenleiMapper(){
        FenleiMapper mapper = sqlSession.getMapper(FenleiMapper.class);
        mapper.deleteBean(23);
        sqlSession.commit();
        sqlSession.close();
    }
    /*改*/
    public void testUpdateFenleiMapper(){
        FenleiMapper mapper = sqlSession.getMapper(FenleiMapper.class);
        Fenlei fenlei = new Fenlei();
        fenlei.setDeletestatus(1);
        fenlei.setJiage(111111.11111);
        fenlei.setLeixing("傻瓜面馆");
        Date date = new Date();
        fenlei.setCreatetime(date);
        //set id
        fenlei.setId(22);
        mapper.updateBean(fenlei);
        sqlSession.commit();
        sqlSession.close();
    }


}
