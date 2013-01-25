package me.sevenstack.web.action.blog;

import java.util.ArrayList;
import java.util.List;

import me.sevenstack.web.model.Post;
import me.sevenstack.web.service.PostService;

import org.apache.struts2.convention.annotation.Action;

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;

public class PostAction extends ActionSupport{
    @Inject
    private PostService postService;

    private List<Post> postList = new ArrayList<Post>();

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    @Action("list")
    public String list() throws Exception {
        System.out.println("list");
        postList = postService.findPostList(new Post());
        return "list";
    }
    
    @Action("detail")
    public String detail() {
        System.out.println("Detail");
        return "detail";
    }
}
