package me.sevenstack.web.dao;

import java.util.List;
import java.util.Map;

import com.google.inject.ImplementedBy;

import me.sevenstack.web.dao.impl.PostDaoImpl;
import me.sevenstack.web.model.Comment;
import me.sevenstack.web.model.Pagination;
import me.sevenstack.web.model.Post;
import me.sevenstack.web.model.Tag;

@ImplementedBy(PostDaoImpl.class)
public interface PostDao {
	public Post findOnePost(Post post) throws Exception;

	public Integer findPostListCount(Post post) throws Exception;

	public List<Post> findPostList(Post post) throws Exception;

	public Post findPostById(Integer postId) throws Exception;

	public Integer updatePost(Post post) throws Exception;

	public Integer updatePostStatus(Post post) throws Exception;

	public Integer savePost(Post post) throws Exception;

	public Integer deletePost(Post post) throws Exception;

	public Integer deletePostById(Integer postId) throws Exception;

	public Integer findCommentListCount(Comment comment) throws Exception;

	public List<Comment> findCommentList(Comment comment) throws Exception;

	public Integer saveComment(Comment comment) throws Exception;

	public List<Map<String, Object>> findCommentCountByPids(Map<String, Object> param)throws Exception;
	
	public List<Tag> findTagListLikeName(String tagName)throws Exception;
}
