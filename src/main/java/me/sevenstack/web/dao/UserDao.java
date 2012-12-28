package me.sevenstack.web.dao;

import me.sevenstack.web.dao.basic.BasicDao;
import me.sevenstack.web.dao.impl.UserDaoImpl;
import me.sevenstack.web.model.User;

import com.google.inject.ImplementedBy;

@ImplementedBy(UserDaoImpl.class)
public interface UserDao extends BasicDao<User> {
	public User okey() throws Exception;
}
