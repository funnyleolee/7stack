package me.sevenstack.blog.dao.basic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class SimpleDao<T> implements BasicDao<T>{
	@Inject
	private SqlSession session;
	
	public List<T> find(T t) {

		return null;
	}

	public List<T> findAll() throws Exception {
		;
		return null;
	}

	public T findOne(T t) throws Exception {
		return session.selectOne(genNv(t, "findOne"), t);
	}
	
	public T findById(Integer id,Class<?> cls) throws Exception {
		return session.selectOne(genNv(cls, "findById"),id);
	}
	
	public int update(T t) throws Exception {
		return session.update(genNv(t, "update"), t);
	}

	public int insert(T t) throws Exception {
		return session.insert(genNv(t, "insert"), t);
	}

	public int delete(T t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	

	public List<T> findByMap(Map<String, String> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateById(T t, Integer id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteById(Integer id,Class<?> cls) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	protected String genNv(T t,String opt){
		return genNv(t.getClass(), opt);
	}
	protected String genNv(Class<?> cls,String opt){
		
		String str = cls.getSimpleName();
		return str+"."+opt+str;
	}
}
