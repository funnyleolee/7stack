package me.sevenstack.web.service.impl;

import java.util.List;

import me.sevenstack.web.dao.PostDao;
import me.sevenstack.web.model.Post;
import me.sevenstack.web.service.PostService;

import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;

public class PostServiceImpl implements PostService {

    private static final long serialVersionUID = 1L;

    @Inject
    private PostDao postDao;

    public Post findPost(Post post) throws Exception {
        return postDao.findOnePost(post);
    }

    public Post findPostById(Integer postId) throws Exception {
        return postDao.findPostById(postId);
    }

    public List<Post> findPostList(Post post) throws Exception {
        return postDao.findPostList(post);
    }

    @Transactional
    public Integer savePost(Post post) throws Exception {
        return postDao.savePost(post);
    }

    @Transactional
    public void updatePost(Post post) throws Exception {
        postDao.updatePost(post);

    }

    public Integer saveOrUpdatePost(Post post) throws Exception {
        if (post.getId() == null) {
            postDao.savePost(post);
        } else {
            postDao.updatePost(post);
        }
        return post.getId();
    }

    public void deletePost(Post post) throws Exception {
        postDao.deletePost(post);

    }

    public void deletePostById(Integer postId) throws Exception {
        postDao.deletePostById(postId);

    }

}
