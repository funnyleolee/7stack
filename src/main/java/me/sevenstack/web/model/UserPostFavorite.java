package me.sevenstack.web.model;

import java.io.Serializable;
/**
 * 用户喜欢的文章对应关系
 * @author lijinlong
 *
 */
public class UserPostFavorite extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer userId;
    private Integer postId;

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
}
