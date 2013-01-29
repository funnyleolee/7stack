package me.sevenstack.util;

import java.security.MessageDigest;

import org.apache.commons.lang3.StringUtils;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.PrototypicalNodeFactory;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.lexer.Lexer;
import org.htmlparser.tags.CompositeTag;
import org.htmlparser.util.NodeList;

import com.petebevin.markdown.MarkdownProcessor;

public class Utils {
	public static String sha(String text) throws Exception {
		MessageDigest sha = MessageDigest.getInstance("SHA-1");
		sha.update(text.getBytes("UTF-8"));
		return hex(sha.digest());
	}

	public static String md5(String text) throws Exception {
		MessageDigest sha = MessageDigest.getInstance("MD5");
		sha.update(text.getBytes("UTF-8"));
		return hex(sha.digest());
	}

	private static String hex(byte[] arr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; ++i) {
			sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1,
					3));
		}
		return sb.toString();
	}

	@SuppressWarnings("serial")
	public static String subHTML(String html, int len) throws Exception {
		try {
			html = StringUtils.left(html, len);
			if(html.lastIndexOf("<") > html.lastIndexOf(">")){
				html = html.substring(0,html.lastIndexOf("<"));
			}
			// 注册自定义的新结点解析器,这是必要的...
			PrototypicalNodeFactory nf = new PrototypicalNodeFactory();
			nf.registerTag(new FontTag());
			Parser parser = new Parser(html);
			parser.setNodeFactory(nf);
			NodeList nodelist = parser.parse(new NodeFilter() {

				public boolean accept(Node node) {
					if (node instanceof CompositeTag) {
						return true;
					}
					return false;
				}
			});

			StringBuffer bf = new StringBuffer();
			for (int i = 0; i < nodelist.size(); i++) {
				CompositeTag tag = (CompositeTag) nodelist.elementAt(i);
				// 记住这里只需循环第一层就能帮你补齐的了
				if (tag.getParent() == null) {
					bf.append(tag.toHtml());
					
					System.out.println(tag.getStringText());
					//tag.
				}
			}

			return bf.toString();
		} catch (Exception e) {
			throw new Exception("HTML解析失败", e);
		}
	}
	public static void main(String[] args)throws Exception {
		System.out.println(subHTML("<SPAN>sdfsdfs><div>sfdsf</div></span>", 20000));	
	}
}
