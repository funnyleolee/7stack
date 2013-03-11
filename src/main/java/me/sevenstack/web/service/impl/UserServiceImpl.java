package me.sevenstack.web.service.impl;

import java.util.List;

import me.sevenstack.web.dao.UserDao;
import me.sevenstack.web.model.User;
import me.sevenstack.web.service.UserService;

import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;

public class UserServiceImpl implements UserService {

    private static final long serialVersionUID = 1L;

    @Inject
    private UserDao userDao;

    @Override
    public User findUser(User user) throws Exception {
        return userDao.findOneUser(user);
    }

    @Override
    public User findUserById(Integer userId) throws Exception {
        return userDao.findUserById(userId);
    }

    @Override
    public List<User> findUserList(User user) throws Exception {
        return userDao.findUserList(user);
    }

    @Override
    @Transactional
    public Integer saveUser(User user) throws Exception {

        return userDao.saveUser(user);
    }

    @Override
    public void updateUser(User user) throws Exception {
        userDao.updateUser(user);

    }

    @Override
    public Integer saveOrUpdateUser(User user) throws Exception {
        if (user.getUserId() == null) {
            userDao.saveUser(user);
        } else {
            userDao.updateUser(user);
        }
        return user.getUserId();
    }

    @Override
    public void deleteUser(User user) throws Exception {
        userDao.deleteUser(user);

    }

    @Override
    public void deleteUserById(Integer userId) throws Exception {
        userDao.deleteUserById(userId);

    }

    @Override
    public User findLoginUser(User user) throws Exception {
        return userDao.findLoginUser(user);
    }

}
