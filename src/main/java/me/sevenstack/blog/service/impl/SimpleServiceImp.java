package me.sevenstack.blog.service.impl;

import java.util.Date;

import org.mybatis.guice.transactional.Transactional;

import me.sevenstack.blog.annotation.Bind;
import me.sevenstack.blog.dao.basic.BasicDao;
import me.sevenstack.blog.model.User;
import me.sevenstack.blog.service.SimpleService;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

@Singleton
public class SimpleServiceImp implements SimpleService {
	@Inject
	private BasicDao<User> userDao;
	@Inject
	private BasicDao<Date> objDao;
	@Transactional
	public String okey() throws Exception {
		User u = new User();
		u.setName("test");
		u.setAddress("=sdfsdf");
		userDao.insert(u);
		userDao.findById(8,User.class);
		//objDao.findOne(new Date());
		System.out.println(objDao.equals(objDao));
		return "";
	}
	@Transactional
	public int saveUser(User u)throws Exception{
		int i = userDao.insert(u);
		return i;
	}
	@Transactional
	public User getUserById(Integer id) throws Exception {
		return userDao.findById(id,User.class);
	}
}
