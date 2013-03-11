package me.sevenstack.web.model;

import com.petebevin.markdown.MarkdownProcessor;

public class Comment extends BaseModel{
    private Integer commentId;
    private String content;
    private User user;
    private Post post;
    private Integer userId;
    private Integer postId;
    
    public Integer getCommentId() {
        return commentId;
    }
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Post getPost() {
        return post;
    }
    public void setPost(Post post) {
        this.post = post;
    }
    
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getPostId() {
        return postId;
    }
    public void setPostId(Integer postId) {
        this.postId = postId;
    }
    
    public String getHtmlContent(){
        MarkdownProcessor markdown = new MarkdownProcessor();
        return markdown.markdown(content);
    }
}
