package me.sevenstack.web.model;

import me.sevenstack.util.Utils;

public class Post{
	private Integer id;
	private String title;
	private String content;
	private Integer authorId;
	private String authorName;
	private Integer vistisNum;
	private Integer favNum;
	private Long createTime;
	private Long updateTime;
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent(){
		return this.content;
	}
	public void setContent(String content){
		this.content = content;
	}
	public Integer getAuthorId(){
		return this.authorId;
	}
	public void setAuthorId(Integer authorId){
		this.authorId = authorId;
	}
	public String getAuthorName(){
		return this.authorName;
	}
	public void setAuthorName(String authorName){
		this.authorName = authorName;
	} 
	
	public Integer getVistisNum() {
		return vistisNum;
	}
	public void setVistisNum(Integer vistisNum) {
		this.vistisNum = vistisNum;
	}
	public Integer getFavNum(){
		return this.favNum;
	}
	public void setFavNum(Integer favNum){
		this.favNum = favNum;
	}
	public Long getCreateTime(){
		return this.createTime;
	}
	public void setCreateTime(Long createTime){
		this.createTime = createTime;
	}
	public Long getUpdateTime(){
		return this.updateTime;
	}
	public void setUpdateTime(Long updateTime){
		this.updateTime = updateTime;
	}
	public String getSummary(){
	   // String more = "<p><a href='"+this.getId()+"'>(全文...)</a></p>";
	    return Utils.subHTML(this.content, 500, "");
	}
}