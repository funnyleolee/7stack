package me.sevenstack.web.action;

import java.util.ArrayList;
import java.util.List;

import me.sevenstack.util.Constants;
import me.sevenstack.web.annotation.LoginRequired;
import me.sevenstack.web.model.Post;
import me.sevenstack.web.model.User;
import me.sevenstack.web.service.PostService;

import org.apache.struts2.convention.annotation.Action;

import com.google.inject.Inject;

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
    @Action(value = "post-edit")
    public String postEdit() throws Exception {
        User user = (User) session.get(Constants.USER_SESSION);
        if (post != null) {
            if (post.getId() != null) {
                Post oldPost = postService.findPostById(post.getId());
                if (oldPost != null && user.getId().equals(oldPost.getAuthorId())) {
                    oldPost.setContent(post.getContent());
                    oldPost.setTitle(post.getTitle());
                    postService.updatePost(oldPost);
                }
            } else {
                post.setAuthorId(user.getId());
                postService.savePost(post);
            }
            return "index";
        }
        // 编辑页面初始化
        if (pid != null) {
            post = postService.findPostById(pid);
            // 过滤非本人编辑
            if (!user.getId().equals(post.getAuthorId())) {
                post = null;
                return "index";
            }
        }
        return "post-edit";
    }

    @LoginRequired
    @Action("post-del")
    public String postDel() throws Exception{
        User user = (User)session.get(Constants.USER_SESSION);
        if(pid != null){
            Post tmpPost = postService.findPostById(pid);
            if(tmpPost != null && user.getId().equals(tmpPost.getAuthorId())){
                tmpPost.setStatus(Constants.STATUS_DEL);
                postService.updatePostStatus(tmpPost);
            }
        }
        return "index";
    }

}
