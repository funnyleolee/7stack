package me.sevenstack.web.dao;

import java.util.List;

import com.google.inject.ImplementedBy;

import me.sevenstack.web.dao.impl.PostDaoImpl;
import me.sevenstack.web.model.Comment;
import me.sevenstack.web.model.Pagination;
import me.sevenstack.web.model.Post;

@ImplementedBy(PostDaoImpl.class)
public interface PostDao {
	public Post findOnePost(Post post) throws Exception;

	public int findPostListCount(Post post) throws Exception;

	public List<Post> findPostList(Post post) throws Exception;

	public Post findPostById(Integer postId) throws Exception;

	public int updatePost(Post post) throws Exception;

	public int updatePostStatus(Post post) throws Exception;

	public int savePost(Post post) throws Exception;

	public int deletePost(Post post) throws Exception;

	public int deletePostById(Integer postId) throws Exception;

	public int findCommentListCount(Comment comment) throws Exception;

	public List<Comment> findCommentList(Comment comment) throws Exception;

	public int saveComment(Comment comment) throws Exception;

}
