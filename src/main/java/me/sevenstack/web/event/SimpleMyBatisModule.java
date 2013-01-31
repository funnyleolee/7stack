package me.sevenstack.web.event;

import me.sevenstack.web.mapper.PostMapper;

import org.mybatis.guice.MyBatisModule;

public class SimpleMyBatisModule extends MyBatisModule{

    @Override
    protected void initialize() {
        addMapperClass(PostMapper.class);
        lazyLoadingEnabled(false);
    }
}
