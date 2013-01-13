package me.sevenstack.web.model;

public class Post{
	private Integer id;
	private String name;
	private String content;
	private Integer authorId;
	private String authorName;
	private Integer vistsNum;
	private Integer favNum;
	private Long createTime;
	private Long updateTime;
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
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
	public Integer getvistsNum(){
		return this.vistsNum;
	}
	public void setVistsNum(Integer vistsNum){
		this.vistsNum = vistsNum;
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
}