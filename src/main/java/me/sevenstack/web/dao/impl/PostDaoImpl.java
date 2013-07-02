package me.sevenstack.web.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import me.sevenstack.web.dao.PostDao;
import me.sevenstack.web.model.Comment;
import me.sevenstack.web.model.Post;

import org.apache.ibatis.session.SqlSession;

import com.google.inject.Inject;

public class PostDaoImpl implements PostDao {
	@Inject
	private SqlSession session;

	@Override
	public Post findOnePost(Post post) throws Exception {
		return session.selectOne("findOnePost", post);
	}

	@Override
	public Integer findPostListCount(Post post) throws Exception {
		return session.selectOne("findPostListCount", post);
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
	public Integer updatePost(Post post) throws Exception {
		post.setUpdateTime(new Date().getTime());
		return session.update("updatePost", post);
	}

	@Override
	public Integer updatePostStatus(Post post) throws Exception {
		post.setUpdateTime(new Date().getTime());
		return session.update("updatePostStatus", post);
	}

	@Override
	public Integer savePost(Post post) throws Exception {
		post.setCreateTime(new Date().getTime());
		post.setUpdateTime(new Date().getTime());
		return session.insert("insertPost", post);
	}

	@Override
	public Integer deletePost(Post post) throws Exception {
		return session.delete("deletePost", post);
	}

	@Override
	public Integer deletePostById(Integer id) throws Exception {
		return session.delete("deletePostById", id);
	}

	@Override
	public List<Comment> findCommentList(Comment comment) throws Exception {
		return session.selectList("findCommentListByPost", comment);
	}

	@Override
	public Integer findCommentListCount(Comment comment) throws Exception {
		return session.selectOne("findCommentListByPostCount", comment);
	}

	@Override
	public Integer saveComment(Comment comment) throws Exception {
		return session.insert("insertComment", comment);
	}
	
	@Override
	public List<Map<String, Object>> findCommentCountByPids(Map<String, Object> param)throws Exception{
	    return session.selectList("findCommentCountByPids", param);
	}

}
