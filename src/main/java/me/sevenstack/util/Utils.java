package me.sevenstack.util;

import java.security.MessageDigest;

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
}
