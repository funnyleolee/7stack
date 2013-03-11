package me.sevenstack.web.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseModel {
    private Long createTime;
    private Long updateTime;

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
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(new Date(createTime));
    }

    public String getUpdateDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return df.format(new Date(updateTime));
    }


}
