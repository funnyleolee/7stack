package me.sevenstack.web.service;

import me.sevenstack.web.model.User;
import me.sevenstack.web.service.impl.SimpleServiceImp;

import com.google.inject.ImplementedBy;

@ImplementedBy(SimpleServiceImp.class)
public interface SimpleService {
	public String okey() throws Exception;

	public User getUserById(Integer id) throws Exception;
	
	public int saveUser(User u)throws Exception;

}
