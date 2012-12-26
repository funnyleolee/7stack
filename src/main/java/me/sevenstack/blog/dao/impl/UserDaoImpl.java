package me.sevenstack.blog.dao.impl;

import me.sevenstack.blog.dao.UserDao;
import me.sevenstack.blog.dao.basic.SimpleDao;
import me.sevenstack.blog.model.User;

public class UserDaoImpl extends SimpleDao<User> implements UserDao{
	public User okey() throws Exception {
		User u = new User();
		u.setId(4);
		u.setAddress("King street No.23");
		//System.out.println(session.insert("users.saveUser",u));
		return null;
	}

}
