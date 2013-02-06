package me.sevenstack.util;

import java.io.InputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.PrototypicalNodeFactory;
import org.htmlparser.tags.CompositeTag;
import org.htmlparser.util.NodeList;

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
            sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }

    @SuppressWarnings("serial")
    public static String toHTML(String html) {
        try {
            if (html.lastIndexOf("<") > html.lastIndexOf(">")) {
                html = html.substring(0, html.lastIndexOf("<"));
            }
            html += "...";
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
                    // tag.
                }
            }

            return bf.toString();
        } catch (Exception e) {
            // throw new Exception("HTML解析失败", e);
        }
        return "";
    }

    public static String subHTML(String param, int length, String end) {
        StringBuffer result = new StringBuffer();
        int n = 0;
        char temp;
        boolean isCode = false; // 是不是HTML代码
        boolean isHTML = false; // 是不是HTML特殊字符,如&nbsp;
        for (int i = 0; i < param.length(); i++) {
            temp = param.charAt(i);
            if (temp == '<') {
                isCode = true;
            } else if (temp == '&') {
                isHTML = true;
            } else if (temp == '>' && isCode) {
                n = n - 1;
                isCode = false;
            } else if (temp == ';' && isHTML) {
                isHTML = false;
            }

            if (!isCode && !isHTML) {
                n = n + 1;
                // UNICODE码字符占两个字节
                if ((temp + "").getBytes().length > 1) {
                    n = n + 1;
                }
            }

            result.append(temp);
            if (n >= length) {
                break;
            }
        }
        result.append(end);
        // 取出截取字符串中的HTML标记
        String temp_result = result.toString().replaceAll("(>)[^<>]*(<?)", "$1$2");
        // 去掉不需要结素标记的HTML标记
        temp_result = temp_result
                .replaceAll(
                        "</?(AREA|BASE|BASEFONT|BODY|BR|COL|COLGROUP|DD|DT|FRAME|HEAD|HR|HTML|IMG|INPUT|ISINDEX|LI|LINK|META|OPTION|P|PARAM|TBODY|TD|TFOOT|TH|THEAD|TR|area|base|basefont|body|br|col|colgroup|dd|dt|frame|head|hr|html|img|input|isindex|li|link|meta|option|p|param|tbody|td|tfoot|th|thead|tr)[^<>]*/?>",
                        "");
        // 去掉成对的HTML标记
        temp_result = temp_result.replaceAll("<([a-zA-Z]+)[^<>]*>(.*?)</\\1>", "$2");
        // 用正则表达式取出标记
        Pattern p = Pattern.compile("<([a-zA-Z]+)[^<>]*>");
        Matcher m = p.matcher(temp_result);

        List<String> endHTML = new ArrayList<String>();

        while (m.find()) {
            endHTML.add(m.group(1));
        }
        // 补全不成对的HTML标记
        for (int i = endHTML.size() - 1; i >= 0; i--) {
            result.append("</");
            result.append(endHTML.get(i));
            result.append(">");
        }
        return toHTML(result.toString());
    }

    public static String replacePic(String content) throws Exception {

        List<String> picList = new ArrayList<String>();
        List<String> matchPicList = new ArrayList<String>();
        String regEx = "<[i|I][m|M][g|G].*?[s|S][R|r][C|c]=['|\"](.*?)['|\"]";
        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(content);
        while (mat.find()) {
            picList.add(mat.group(1));
        }
        for (String picUrl : picList) {
            String ext = isPic(new URL(picUrl).openStream());
            if (StringUtils.isNotBlank(ext)) {
                matchPicList.add(picUrl);
            }
        }

        for (String oldPic : matchPicList) {
            String newPic = FileUpload.upload(oldPic, "static");
            content.replaceAll(oldPic, newPic);
        }
        return content;
    }
    public static Map<String, String> PIC_EXT = new HashMap<String, String>();
    static{
        PIC_EXT.put("-1-40", "jpg");
        PIC_EXT.put("6677", "bmp");
        PIC_EXT.put("-11980", "png");
        PIC_EXT.put("7173", "gif");
    }
    public static String isPic(final InputStream fs) {
        String s = "";
        try {
           
            byte[] b1 = new byte[1];
            byte[] b2 = new byte[1];
            fs.read(b1);
            fs.read(b2);
            // int sb1 = ((b1[0] < 0) ? (b1[0] + 256) : (b1[0]));
            // int sb2 = ((b2[0] < 0) ? (b2[0] + 256) : (b2[0]));
            fs.close();
            // -1-40是jpg;7173是gif;6677是BMP,13780(-11980)是PNG; 7790是exe,8297是rar

            s = "" + b1[0] + b2[0];
            /*if ((s.equals("-1-40")) || (s.equals("6677")) || (s.equals("-11980")) || (s.equals("7173")) || (s.equals("5666"))) {
                System.out.println(s);
                return true;
            } else {
                return false;
            }*/
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
        return PIC_EXT.get(s);
    }

    public static void main(String[] args)throws Exception {
        System.out.println(replacePic("<img src='http://ww3.sinaimg.cn/mw600/73e9091dtw1e1jnxdg3upg.jpg' alt='蝙蝠侠的假日'>"));
    }
}