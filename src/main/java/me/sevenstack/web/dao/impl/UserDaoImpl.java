package me.sevenstack.web.dao.impl;
import me.sevenstack.web.dao.UserDao;
import me.sevenstack.web.dao.basic.SimpleDao;
import me.sevenstack.web.model.User;

public class UserDaoImpl extends SimpleDao<User> implements UserDao{
	public User okey() throws Exception {
		User u = new User();
		u.setId(4);
		u.setAddress("King street No.23");
		//System.out.println(session.insert("users.saveUser",u));
		return null;
	}

}
