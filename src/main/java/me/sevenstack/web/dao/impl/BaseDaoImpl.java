package me.sevenstack.web.dao.impl;

import java.util.List;

import me.sevenstack.web.dao.BaseDao;

import org.apache.ibatis.session.SqlSession;

import com.google.inject.Inject;

public class BaseDaoImpl<T> implements BaseDao<T>{
    @Inject
    private SqlSession session;

    @Override
    public T findOne(String mapperId, T t) throws Exception {
        return session.selectOne(mapperId, t);
    }
    @Override
    public List<T> findList(String mapperId, T t) throws Exception {
        return session.selectList(mapperId,t);
    }

    @Override
    public T findById(String mapperId, Integer id) throws Exception {
        return session.selectOne(mapperId, id);
    }

    @Override
    public int update(String mapperId, T t) throws Exception {
        return session.update(mapperId, t);
    }

    @Override
    public int insert(String mapperId, T t) throws Exception {
        return session.insert(mapperId, t);
    }

    @Override
    public int delete(String mapperId, T t) throws Exception {
        return session.delete(mapperId, t);
    }

    @Override
    public int deleteById(String mapperId, Integer id) throws Exception {
        return session.delete(mapperId, id);
    }

}
