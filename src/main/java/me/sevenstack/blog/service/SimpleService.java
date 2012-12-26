package me.sevenstack.blog.service;

import me.sevenstack.blog.model.User;
import me.sevenstack.blog.service.impl.SimpleServiceImp;

import com.google.inject.ImplementedBy;

@ImplementedBy(SimpleServiceImp.class)
public interface SimpleService {
	public String okey() throws Exception;

	public User getUserById(Integer id) throws Exception;

}
