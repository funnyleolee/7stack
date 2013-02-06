package me.sevenstack.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * 文件上传工具类
 * 
 * @author lijinlong
 * 
 */
public class FileUpload {
    private static Logger log = Logger.getLogger(FileUpload.class);
    private static Set<String> FILE_TYPE_SET = new TreeSet<String>();
    static {
        FILE_TYPE_SET.add("jpg");
        FILE_TYPE_SET.add("png");
        FILE_TYPE_SET.add("gif");
        FILE_TYPE_SET.add("tif");
        FILE_TYPE_SET.add("bmp");
    }

    public static String upload(File file, String path) throws FileNotFoundException, IOException {
        String fileType = FileType.getFileType(new FileInputStream(file));
        InputStream in = new FileInputStream(file);
        return upload(in, fileType, path);
    }

    public static String upload(String url, String path) throws MalformedURLException, IOException {
        String fileType = FileType.getFileType(new URL(url).openStream());
        InputStream in = new URL(url).openStream();
        return upload(in, fileType, path);
    }

    /**
     * 上传到本服务器
     * 
     * @param in
     * @return
     * @throws IOException
     */
    public static String upload(InputStream in, String fileType, String path) throws IOException {
        String fileLocation = "";
        if (fileType == null || !FILE_TYPE_SET.contains(fileType)) {
            return "";
        }
        String filePath = Constants.UPLOAD_PATH + path + "/" + UUID.randomUUID().toString().replaceAll("-", "");
        File parentFile = new File(filePath).getParentFile();
        System.out.println(parentFile.getPath());
        if (!parentFile.exists()) {
            parentFile.mkdir();
        }

        // FILE_SERVER
        File toFile = new File(filePath + "." + fileType);
        OutputStream os = new FileOutputStream(toFile);
        // 设置缓存
        byte[] buffer = new byte[100];
        int length = 0;

        while ((length = in.read(buffer)) > 0) {
            System.out.println(length);
            os.write(buffer, 0, length);
        }
        fileLocation = Constants.FILE_SERVER + path + "/" + toFile.getName();
        return fileLocation;
    }
}
