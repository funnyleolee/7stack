package me.sevenstack.web.action.blog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.sevenstack.web.model.Post;
import me.sevenstack.web.service.PostService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;

@Results({ @Result(name = "home", location = "/", type = "redirect") })
public class PostAction extends ActionSupport {
	@Inject
	private PostService postService;

	private List<Post> postList = new ArrayList<Post>();
	private Post post;

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Action("list")
	public String list() throws Exception {
		System.out.println("list");
		postList = postService.findPostList(new Post());
		for(Post post : postList){
			//post.setContent(post.getContent().substring(0, 350));			
		}
		return "list";
	}

	@Action("detail")
	public String detail() {
		System.out.println("Detail");
		return "detail";
	}

	@Action("newPost")
	public String newPost() throws Exception {
		if (post != null) {
			post.setCreateTime(new Date().getTime());
			post.setUpdateTime(new Date().getTime());
			postService.savePost(post);
			return "home";
		}
		return "newPost";
	}
}
