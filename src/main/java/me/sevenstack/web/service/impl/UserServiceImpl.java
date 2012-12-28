package me.sevenstack.web.service.impl;

import java.util.List;

import me.sevenstack.web.dao.basic.BasicDao;
import me.sevenstack.web.model.User;
import me.sevenstack.web.service.UserService;

import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;

public class UserServiceImpl implements UserService {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private BasicDao<User> userDao;

	public User findUser(User user) throws Exception {
		return userDao.findOne(user);
	}

	public User findUserById(Integer userId) throws Exception {
		return userDao.findById(userId, User.class);
	}

	public List<User> findUserList(User user) throws Exception {
		return userDao.find(user);
	}
	
	@Transactional
	public Integer saveUser(User user) throws Exception {
		userDao.insert(user);
		return user.getId();
	}

	public void updateUser(User user) throws Exception {
		userDao.update(user);

	}

	public Integer saveOrUpdateUser(User user) throws Exception {
		if(user.getId() == null){
			userDao.insert(user);
		}else{
			userDao.update(user);
		}
		return user.getId();
	}

	public void deleteUser(User u) throws Exception {
		userDao.delete(u);

	}

	public void deleteUserById(Integer userId) throws Exception {
		userDao.deleteById(userId, User.class);

	}

}
