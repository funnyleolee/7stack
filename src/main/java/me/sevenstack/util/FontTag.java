package me.sevenstack.util;

import org.htmlparser.tags.CompositeTag;

public class FontTag extends CompositeTag {
	private static final long serialVersionUID = 1L;
	private static final String[] ids = { "FONT","BR","SPAN" };
	private static final String[] endTagEnders = { "BODY"};

	public String[] getIds() {
		return ids;
	}

	public String[] getEndTagEnders() {
		return endTagEnders;
	}
}
