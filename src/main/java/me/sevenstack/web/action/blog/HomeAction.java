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
	public static void main(String[] args) {
		String str = "从头到尾，我都是本着帮人的原则、用科技带来便利的原则来的，没有一点利益色彩，和各方的合作也都是完全免费的，没有利益的瓜葛。然而这种想为人带来便利、节约操作和时间，被称为不公平。其实我很想问，那这个世界的公平，到底在哪里？让所有人一起在那里点查询刷新吗？那为什么有些人一顿饭吃掉上三五万，你蹲在路边吸溜吸溜吃泡面的时候没有感觉不公平？关于订票助手的，写点什么纪念吧关于订票助手，说点什么吧，怎么说也坚持这么久了。订票助手最初的出现是为了挤上网站。因为最初上12306是个体力活，需要输入用户名密码验证码，然后系统告诉你人多，然后你再输入用户名密码 验证码，如此反复。这样的好处是，当你最终挤上去的时候，你也为成功地锻炼了自己手指的灵活性，对于一个还要忙工作混饭吃的人，这很明显是个让人崩溃的事 情。而现代科技的...";
		System.out.println(str.length());
	}
}
