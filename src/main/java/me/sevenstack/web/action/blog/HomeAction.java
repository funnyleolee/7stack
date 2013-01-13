package me.sevenstack.web.action.blog;

import java.util.ArrayList;
import java.util.List;

import me.sevenstack.web.model.Post;
import me.sevenstack.web.service.PostService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/home")
@Results({
	@Result(name="home",location="/WEB-INF/pages/blog/home.jsp")
})
public class HomeAction extends ActionSupport{
	@Inject
	private PostService postService;
	private List<Post> postList = new ArrayList<Post>();
	public List<Post> getPostList() {
		return postList;
	}
	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}
	@Action("/home")
	public String index()throws Exception{
		postList = postService.findPostList(new Post());
		return "home";
	}
}
