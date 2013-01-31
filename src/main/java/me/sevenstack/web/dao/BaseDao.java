package me.sevenstack.web.dao;

import java.util.List;

import me.sevenstack.web.dao.impl.BaseDaoImpl;

import com.google.inject.ImplementedBy;

@ImplementedBy(BaseDaoImpl.class)
public interface BaseDao<T> {
    public T findOne(String mapperId, T t) throws Exception;

    public List<T> findList(String mapperId, T t) throws Exception;

    public T findById(String mapperId, Integer id) throws Exception;

    public int update(String mapperId, T t) throws Exception;

    public int insert(String mapperId, T t) throws Exception;

    public int delete(String mapperId, T t) throws Exception;

    public int deleteById(String mapperId, Integer id) throws Exception;

}
