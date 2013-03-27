package me.sevenstack.util;

import java.util.regex.Pattern;

public class Constants {
    public static String ENV = "dev";
    public static String USER_SESSION = "session-me.sevenstack.web.model.user";
    public static Byte STATUS_DEL = new Byte("1");
    public static Byte STATUS_NORMAL = new Byte("0");
    public static String UPLOAD_PATH = "/data/7stack/";
    public static String FILE_SERVER = "http://fs.streetyle.me/";
    public static Pattern EMAIL_PATTERN = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");

}
