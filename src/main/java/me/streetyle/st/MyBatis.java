package me.streetyle.st;

import java.io.Reader;

import me.sevenstack.web.mapper.PostMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatis {
    
    public static void main(String[] args)throws Exception {
        
        
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        
        
        
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        
        SqlSession session = sqlMapper.openSession();
        try {
            PostMapper pm= session.getMapper(PostMapper.class);
           // System.out.println(pm.count());
            
            System.out.println(session.selectOne("me.sevenstack.web.mapper.PostMapper.count"));
        } finally {
        session.close();
        }
    }
}
