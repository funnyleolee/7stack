package me.sevenstack.web.service.impl;

import java.util.List;

import me.sevenstack.web.dao.BaseDao;
import me.sevenstack.web.dao.basic.BasicDao;
import me.sevenstack.web.model.Post;
import me.sevenstack.web.service.PostService;

import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;

public class PostServiceImpl implements PostService {

    private static final long serialVersionUID = 1L;

    @Inject
    private BaseDao<Post> postDao;

    public Post findPost(Post post) throws Exception {
        return postDao.findOne("findPostList", post);
    }

    public Post findPostById(Integer postId) throws Exception {
        return postDao.findById("findPostById", postId);
    }

    public List<Post> findPostList(Post post) throws Exception {
        return postDao.findList("findPostList", post);
    }

    @Transactional
    public Integer savePost(Post post) throws Exception {
        return postDao.insert("insertPost", post);
    }

    @Transactional
    public void updatePost(Post post) throws Exception {
        postDao.update("updatePost", post);

    }

    public Integer saveOrUpdatePost(Post post) throws Exception {
        if (post.getId() == null) {
            postDao.insert("insertPost",post);
        } else {
            postDao.update("updatePost",post);
        }
        return post.getId();
    }

    public void deletePost(Post u) throws Exception {
        postDao.delete(u);

    }

    public void deletePostById(Integer postId) throws Exception {
        postDao.deleteById(postId, Post.class);

    }

}
