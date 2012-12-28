package me.sevenstack.web.dao.basic;

import java.util.List;
import java.util.Map;

import com.google.inject.ImplementedBy;

@ImplementedBy(DefaultBasicDao.class)
public interface BasicDao<T> extends IDao<T> {
	public List<T> findAll(Class<?> clazz) throws Exception;
	public T findById(Integer id,Class<?> clazz) throws Exception;

	public List<T> findByMap(Map<String, String> param) throws Exception;

	public int updateById(T t, Integer id) throws Exception;

	public int deleteById(Integer id,Class<?> clazz) throws Exception;

}
