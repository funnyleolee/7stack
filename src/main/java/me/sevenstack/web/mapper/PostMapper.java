package me.sevenstack.web.mapper;

import me.sevenstack.web.model.Post;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
public interface PostMapper {
    @Select("select * from posts where id =#{id}")
    @Results({
        @Result(property="id"),
        @Result(property="title"),
        @Result(property="content")
    })
    public Post getOnePost(Post param);
    
  
}
