package me.sevenstack.web.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class User {
    private Integer userId;
    private String userName;
    private String password;
    private String passwordRepeat;
    private String email;
    private String address;
    private String mobile;
    private String telephone;
    private String sns;
    private List<Post> postList = new ArrayList<Post>();
    private byte remCode;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return StringUtils.trim(userName);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    public String getEmail() {
        return StringUtils.trim(email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSns() {
        return sns;
    }

    public void setSns(String sns) {
        this.sns = sns;
    }

	public byte getRemCode() {
		return remCode;
	}

	public void setRemCode(byte remCode) {
		this.remCode = remCode;
	}

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
	
    
}
