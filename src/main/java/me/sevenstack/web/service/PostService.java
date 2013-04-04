package me.sevenstack.web.service;

import java.io.Serializable;
import java.util.List;

import com.google.inject.ImplementedBy;

import me.sevenstack.web.model.Comment;
import me.sevenstack.web.model.Pagination;
import me.sevenstack.web.model.Post;
import me.sevenstack.web.service.impl.PostServiceImpl;

@ImplementedBy(PostServiceImpl.class)
public interface PostService extends Serializable {

	public Post findPost(Post post) throws Exception;

	public Post findPostById(Integer postId) throws Exception;

	public int findPostListCount(Post post) throws Exception;

	public List<Post> findPostList(Post post) throws Exception;

	public Integer savePost(Post post) throws Exception;

	public void updatePost(Post post) throws Exception;

	public int updatePostStatus(Post post) throws Exception;

	public Integer saveOrUpdatePost(Post post) throws Exception;

	public void deletePost(Post post) throws Exception;

	public void deletePostById(Integer postId) throws Exception;

	public int findCommentListCount(Comment comment) throws Exception;

	public List<Comment> findCommentList(Comment comment) throws Exception;

	public int saveComment(Comment comment) throws Exception;
}