package me.sevenstack.web.model;

import java.util.ArrayList;
import java.util.List;

import me.sevenstack.util.Utils;

public class Post extends BaseModel {
    private Integer postId;
    private String title;
    private String content;
    private Integer authorId;
    private Integer visitsNum;
    private Integer favNum;
    private Byte status;
    private Long createTime;
    private Long updateTime;
    private User author;
    private List<Comment> commentList = new ArrayList<Comment>();
    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getVisitsNum() {
        return visitsNum;
    }

    public void setVisitsNum(Integer visitsNum) {
        this.visitsNum = visitsNum;
    }

    public Integer getFavNum() {
        return this.favNum;
    }

    public void setFavNum(Integer favNum) {
        this.favNum = favNum;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getSummary() {
        // String more = "<p><a href='"+this.getId()+"'>(全文...)</a></p>";
        return Utils.subHTML(this.content, 500, "");
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }
}