package me.sevenstack.web.dao.impl;

import java.util.List;

import me.sevenstack.web.dao.UserDao;
import me.sevenstack.web.model.User;

import org.apache.ibatis.session.SqlSession;

import com.google.inject.Inject;

public class UserDaoImpl implements UserDao {
    @Inject
    private SqlSession session;

    @Override
    public User findOneUser(User user) throws Exception {
        return session.selectOne("findOneUser", user);
    }

    @Override
    public List<User> findUserList(User user) throws Exception {
        return session.selectList("findUserList", user);
    }

    @Override
    public User findUserById(Integer userId) throws Exception {
        return session.selectOne("findUserById", userId);
    }

    @Override
    public int updateUser(User user) throws Exception {
        return session.update("updateUser", user);
    }

    @Override
    public int saveUser(User user) throws Exception {
        return session.insert("saveUser", user);
    }

    @Override
    public int deleteUser(User user) throws Exception {
        return session.delete("deleteUser", user);
    }

    @Override
    public int deleteUserById(Integer userId) throws Exception {
        return session.delete("deleteUserById", userId);
    }

    @Override
    public User findLoginUser(User user) throws Exception {
        return session.selectOne("findLoginUser", user);
    }

}
