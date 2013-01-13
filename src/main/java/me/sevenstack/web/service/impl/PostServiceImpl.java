package me.sevenstack.web.service.impl;

import java.util.List;

import me.sevenstack.web.dao.basic.BasicDao;
import me.sevenstack.web.model.Post;
import me.sevenstack.web.service.PostService;

import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;

public class PostServiceImpl implements PostService {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private BasicDao<Post> postDao;

	public Post findPost(Post post) throws Exception {
		return postDao.findOne(post);
	}

	public Post findPostById(Integer postId) throws Exception {
		return postDao.findById(postId, Post.class);
	}

	public List<Post> findPostList(Post post) throws Exception {
		return postDao.find(post);
	}
	
	@Transactional
	public Integer savePost(Post post) throws Exception {
		postDao.insert(post);
		return post.getId();
	}

	public void updatePost(Post post) throws Exception {
		postDao.update(post);

	}

	public Integer saveOrUpdatePost(Post post) throws Exception {
		if(post.getId() == null){
			postDao.insert(post);
		}else{
			postDao.update(post);
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
