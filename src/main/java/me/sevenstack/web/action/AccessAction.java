package me.sevenstack.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.sevenstack.web.service.PostService;

import org.apache.struts2.convention.annotation.Action;

import com.google.inject.Inject;

public class AccessAction extends BaseAction{
    @Inject
    private PostService postService;
    private String queryText;

    public String getQueryText() {
        return queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }
    @Action("comment_count")
    public String findCommentCount()throws Exception{
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("postIds", queryText.split(","));
        List<Map<String, Object>> resultList = postService.findCommentCountByPids(param);
        respondJson(resultList);
        return NONE;
    }
}
