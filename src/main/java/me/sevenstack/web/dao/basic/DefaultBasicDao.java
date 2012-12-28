package me.sevenstack.web.dao.basic;

import java.util.List;
import java.util.Map;

import me.sevenstack.web.model.User;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;

import com.google.inject.Inject;

public class DefaultBasicDao<T> implements BasicDao<T> {
	
	@Inject
	private SqlSession session;

	public List<T> find(T t) throws Exception {
		return session.selectList(genMappingName(t, "find#List"), t);
	}

	public List<T> findAll(Class<?> cls) throws Exception {
		return session.selectList(genMappingName(cls, "findAll#List"));
	}

	public T findOne(T t) throws Exception {
		return session.selectOne(genMappingName(t, "findOne"), t);
	}

	public int update(T t) throws Exception {
		return session.update(genMappingName(t, "update"), t);
	}

	public int insert(T t) throws Exception {
		return session.insert(genMappingName(t, "insert"),t);
	}

	public int delete(T t) throws Exception {
		return session.insert(genMappingName(t, "delete"),t);
	}

	public T findById(Integer id, Class<?> clazz) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(genMappingName(clazz, "find#ById"), id);
	}

	public List<T> findByMap(Map<String, String> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateById(T t, Integer id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteById(Integer id, Class<?> clazz) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	protected String genMappingName(T t,String opt){
		return genMappingName(t.getClass(), opt);
	}
	protected static String genMappingName(Class<?> cls,String opt){
		
		
		String className = cls.getSimpleName();
		String nameSpace = StringUtils.uncapitalize(className)+"Mapping";
		if(opt.contains("#")){
			opt = opt.replace("#", className);
		}else{
			opt += className;
		}
		return nameSpace+"."+opt;
	}
}
