package me.sevenstack.task;

import me.sevenstack.util.Utils;
import me.sevenstack.web.event.SimpleXMLMyBatisModule;
import me.sevenstack.web.model.Post;
import me.sevenstack.web.service.PostService;

import com.google.inject.Guice;
import com.google.inject.struts2.Struts2GuicePluginModule;

public class ImageReplaceTask extends Task {
	@Override
	public void execute() throws Exception {
		PostService postService = Guice.createInjector(new Struts2GuicePluginModule(),new SimpleXMLMyBatisModule()).getInstance(PostService.class);
		Integer postId = (Integer) params.get("postId");
		if (postId != null) {
			Post post = postService.findPostById(postId);
			if (post != null) {
				post.setContent(Utils.replacePic(post.getContent()));
				postService.updatePost(post);
			}
		}
		System.out.println("===============post img replace");
	}
}
