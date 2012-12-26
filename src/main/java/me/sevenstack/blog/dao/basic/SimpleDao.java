package me.sevenstack.blog.dao.basic;

import java.util.List;
import java.util.Map;

import me.sevenstack.blog.model.User;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.google.inject.Inject;

public class SimpleDao<T> implements BasicDao<T> {
	@Inject
	private SqlSessionFactory sessionFactory;

	public SqlSession getSession(){
		return sessionFactory.openSession();
	}

	public List<T> find(T t) {

		return null;
	}

	public List<T> findAll() throws Exception {
		;
		return null;
	}

	public T findOne(T t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(T t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(T t) throws Exception {
		System.out.println(getSession()+"======>>>>");
		SqlSession session = getSession();
		
		session.insert("saveUser", t);
		session.commit();
		// System.out.println(session.getMapper(t.getClass()));
		// System.out.println(session.getConnection());
		return 0;
	}

	public int delete(T t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public T findById(Integer id) throws Exception {
		try {
			User u = new User();
			u.setId(id);
			System.out.println(getSession().selectOne("users.getUserById"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<T> findByMap(Map<String, String> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateById(T t, Integer id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
