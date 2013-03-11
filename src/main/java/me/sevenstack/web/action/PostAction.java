package me.sevenstack.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.sevenstack.task.ImageReplaceTask;
import me.sevenstack.task.TaskScheduling;
import me.sevenstack.util.Constants;
import me.sevenstack.web.annotation.LoginRequired;
import me.sevenstack.web.model.Comment;
import me.sevenstack.web.model.Post;
import me.sevenstack.web.model.User;
import me.sevenstack.web.service.PostService;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;

import com.google.inject.Inject;
import com.petebevin.markdown.MarkdownFilter;
import com.petebevin.markdown.MarkdownProcessor;

public class PostAction extends BaseAction {
    private static final long serialVersionUID = 1L;

    @Inject
    private PostService postService;

    private List<Post> postList = new ArrayList<Post>();
    private Post post;
    private Comment comment;
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

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
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
            if (post.getPostId() != null) {
                Post oldPost = postService.findPostById(post.getPostId());
                if (oldPost != null && user.getUserId().equals(oldPost.getAuthorId())) {
                    oldPost.setContent(post.getContent());
                    oldPost.setTitle(post.getTitle());
                    oldPost.setContent(post.getContent());
                    postService.updatePost(oldPost);
                }
            } else {
                post.setAuthorId(user.getUserId());
                post.setContent(post.getContent());
                Integer postId = postService.savePost(post);
                post.setPostId(postId);
            }
            if (!"dev".equals(Constants.ENV)) {
                // 任务调度
                Map<String, Object> taskMap = new HashMap<String, Object>();
                taskMap.put("postId", post.getPostId());
                TaskScheduling.scheduling(ImageReplaceTask.class, taskMap);
            }
            return "index";
        }
        // 编辑页面初始化
        if (pid != null) {
            post = postService.findPostById(pid);
            // 过滤非本人编辑
            if (!user.getUserId().equals(post.getAuthorId())) {
                post = null;
                return "index";
            }
        }
        return "post-edit";
    }

    @LoginRequired
    @Action("post-del")
    public String postDel() throws Exception {
        User user = (User) session.get(Constants.USER_SESSION);
        if (pid != null) {
            Post tmpPost = postService.findPostById(pid);
            if (tmpPost != null && user.getUserId().equals(tmpPost.getAuthorId())) {
                tmpPost.setStatus(Constants.STATUS_DEL);
                postService.updatePostStatus(tmpPost);
            }
        }
        return "index";
    }

    @Action("save-comment")
    public String saveComment()throws Exception{
        User user = (User) session.get(Constants.USER_SESSION);
        if(user !=null && comment!=null && comment.getPostId() != null 
                && StringUtils.isNotBlank(StringUtils.trim(comment.getContent()))){
            comment.setUserId(user.getUserId());
            postService.saveComment(comment);
        }
        if(comment.getPostId() != null){
            response.sendRedirect(comment.getPostId()+"");
            return NONE;
        }else{
            return "index";
        }
    }
}
