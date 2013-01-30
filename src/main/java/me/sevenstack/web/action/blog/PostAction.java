package me.sevenstack.web.action.blog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.sevenstack.web.annotation.LoginRequired;
import me.sevenstack.web.model.Post;
import me.sevenstack.web.service.PostService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;
public class PostAction extends BaseAction {
    private static final long serialVersionUID = 1L;

    @Inject
    private PostService postService;

    private List<Post> postList = new ArrayList<Post>();
    private Post post;
    private Integer pid;

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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Action("post")
    public String post() throws Exception {
        post = postService.findPostById(pid);
        return "post";
    }

    @Action("post-list")
    public String postList() throws Exception {
        postList = postService.findPostList(new Post());
        return "post-list";
    }

    @LoginRequired
    @Action(value="post-new")
    public String postNew() throws Exception {
        if (post != null) {
            post.setCreateTime(new Date().getTime());
            post.setUpdateTime(new Date().getTime());
            postService.savePost(post);
            return "index";
        }
        return "post-new";
    }
    

}
