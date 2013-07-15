package me.sevenstack.web.model;

public class Tag extends BaseModel {
    private Integer tagId;
    private String tagName;
    public Integer getTagId() {
        return tagId;
    }
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
    public String getTagName() {
        return tagName;
    }
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
