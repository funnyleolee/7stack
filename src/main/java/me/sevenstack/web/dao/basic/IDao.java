package me.sevenstack.web.dao.basic;

import java.util.List;

public interface IDao<T> {

	public List<T> find(T t) throws Exception;

	public T findOne(T t) throws Exception;

	public int update(T t) throws Exception;

	public int insert(T t) throws Exception;

	public int delete(T t) throws Exception;

}
