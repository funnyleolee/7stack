package me.sevenstack.web.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BaseModel {
    private Long createTime;
    private Long updateTime;
    private Pagination pagination;
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd HH:mm");
        return format.format(new Date(createTime));
    }

    public String getUpdateDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return df.format(new Date(updateTime));
    }
    public String getEnCreateDate(){
        SimpleDateFormat df = new SimpleDateFormat("dd MMMM yyyy",Locale.ENGLISH);
        return df.format(new Date(updateTime));
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
