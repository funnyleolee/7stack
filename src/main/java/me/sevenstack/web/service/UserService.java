package me.sevenstack.web.service;

import java.io.Serializable;
import java.util.List;

import com.google.inject.ImplementedBy;

import me.sevenstack.web.model.User;
import me.sevenstack.web.service.impl.UserServiceImpl;
@ImplementedBy(UserServiceImpl.class)
public interface UserService extends Serializable {

	public User findUser(User user) throws Exception;

	public User findUserById(Integer userId) throws Exception;
	
	public User findLoginUser(User user) throws Exception;

	public List<User> findUserList(User user) throws Exception;

	public Integer saveUser(User user) throws Exception;

	public void updateUser(User user) throws Exception;

	public Integer saveOrUpdateUser(User user) throws Exception;

	public void deleteUser(User u) throws Exception;

	public void deleteUserById(Integer userId) throws Exception;

}
