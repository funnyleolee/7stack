package me.sevenstack.blog.dao;

import me.sevenstack.blog.dao.basic.BasicDao;
import me.sevenstack.blog.dao.impl.UserDaoImpl;
import me.sevenstack.blog.model.User;

import com.google.inject.ImplementedBy;

@ImplementedBy(UserDaoImpl.class)
public interface UserDao extends BasicDao<User> {
	public User okey() throws Exception;
}
