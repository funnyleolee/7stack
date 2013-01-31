package me.sevenstack.web.dao;

import java.util.List;

import me.sevenstack.web.dao.impl.UserDaoImpl;
import me.sevenstack.web.model.User;

import com.google.inject.ImplementedBy;

@ImplementedBy(UserDaoImpl.class)
public interface UserDao{
	public User findOneUser(User user) throws Exception;

	public List<User> findUserList(User user) throws Exception;

	public User findUserById(Integer id) throws Exception;

	public int updateUser(User user) throws Exception;

	public int saveUser(User user) throws Exception;

	public int deleteUser(User user) throws Exception;

	public int deleteUserById(Integer id) throws Exception;
	public User findLoginUser(User user) throws Exception;
}
