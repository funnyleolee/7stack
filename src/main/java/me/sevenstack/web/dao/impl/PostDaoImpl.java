package me.sevenstack.web.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.google.inject.Inject;

import me.sevenstack.web.dao.PostDao;
import me.sevenstack.web.model.Comment;
import me.sevenstack.web.model.Post;

public class PostDaoImpl implements PostDao {
    @Inject
    private SqlSession session;

    @Override
    public Post findOnePost(Post post) throws Exception {
        return session.selectOne("findOnePost", post);
    }

    @Override
    public List<Post> findPostList(Post post) throws Exception {
        return session.selectList("findPostList", post);
    }

    @Override
    public Post findPostById(Integer id) throws Exception {
        if (id == null) {
            return null;
        }
        return session.selectOne("findPostById", id);
    }

    @Override
    public int updatePost(Post post) throws Exception {
        post.setUpdateTime(new Date().getTime());
        return session.update("updatePost", post);
    }

    @Override
    public int updatePostStatus(Post post) throws Exception {
        post.setUpdateTime(new Date().getTime());
        return session.update("updatePostStatus", post);
    }

    @Override
    public int savePost(Post post) throws Exception {
        post.setCreateTime(new Date().getTime());
        post.setUpdateTime(new Date().getTime());
        return session.insert("insertPost", post);
    }

    @Override
    public int deletePost(Post post) throws Exception {
        return session.delete("deletePost", post);
    }

    @Override
    public int deletePostById(Integer id) throws Exception {
        return session.delete("deletePostById", id);
    }

    @Override
    public int saveComment(Comment comment) throws Exception {
        return session.insert("insertComment", comment);
    }

}
