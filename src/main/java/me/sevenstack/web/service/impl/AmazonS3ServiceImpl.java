package me.sevenstack.web.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import me.sevenstack.web.service.AmazonS3Service;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.util.HttpUtils;

public class AmazonS3ServiceImpl implements AmazonS3Service {
    private static final Logger logger = Logger.getLogger(AmazonS3ServiceImpl.class);

    @Override
    public void upload() throws Exception {
        // TODO Auto-generated method stub

    }

    AmazonS3 s3client;

    String bucketName;

    private static final String BUCKET_NAME = "bucketName";

    private static final String ACCESS_KEY = "accessKey";

    private static final String SECRET_KEY = "secretKey";

    private static final String MAX_ERROR_RETRY = "maxErrorRetry";

    private static final String PROXY_HOST = "proxyHost";

    private static final String PROXY_PORT = "proxyPort";

    private static final String PROXY_USERNAME = "proxyUsername";

    private static final String PROXY_PASSWORD = "proxyPassword";

    public void setS3Client(AmazonS3Client s3Client) {
        this.s3client = s3Client;
    }

    public AmazonS3ServiceImpl(Map<String, String> props) {
        bucketName = props.get(BUCKET_NAME);
        s3client = new AmazonS3Client(new BasicAWSCredentials(props.get(ACCESS_KEY), props.get(SECRET_KEY)), initClientConfig(props));
    }

    /*
     * Initial client configuration options such as proxy settings, max retry
     * attempts, etc.
     */
    private ClientConfiguration initClientConfig(Map<String, String> props) {
        ClientConfiguration config = new ClientConfiguration();

        int maxErrorRetry = props.get(MAX_ERROR_RETRY) == null ? 0 : Integer.parseInt(props.get(MAX_ERROR_RETRY));
        config.withMaxErrorRetry(maxErrorRetry);

        String proxyHost = props.get(PROXY_HOST);
        if (StringUtils.isNotBlank(proxyHost)) {
            config.withProxyHost(proxyHost);
            config.withProxyPort(Integer.parseInt(props.get(PROXY_PORT)));
            config.withProxyUsername(props.get(PROXY_USERNAME));
            config.withProxyPassword(props.get(PROXY_PASSWORD));
        }
        return config;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ea.online.ebisu.avatar.avatar.AvatarStorageService#deleteObject(java
     * .lang.String)
     */

    public boolean deleteObject(String key) {
        try {
            s3client.deleteObject(bucketName, key);
        } catch (Exception e) {
            logger.error("Delete object from Amazon S3 error, bucketName=%s; key=%s; errorCode=%s", e);
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ea.online.ebisu.avatar.avatar.AvatarStorageService#putObject(java
     * .io.File)
     */
    public boolean putObject(File file, String key) {
        try {
            s3client.putObject(bucketName, key, file);
            s3client.setObjectAcl(bucketName, key, CannedAccessControlList.PublicRead);
        } catch (Exception e) {
            logger.error("Put object to Amazon S3 error, bucketName=%s;key=%s; errorCode=%s", e);
            return false;
        } finally {
            if (file != null) {
                file.delete();
            }
        }
        return true;
    }

    
    
    /********************************** check ********************************/
    /**
     * Get file size
     * 
     * @param File
     *            file
     * @return file size
     * @throws IOException
     */
    public static Integer getFileSize(File file) throws IOException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            return fis.available();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }

    /**
     * Get image file format type
     * 
     * @param imageFile
     *            image file
     * @return image type
     * @throws IOException
     */
    public static String getImageFormatName(File imageFile) throws IOException {
        ImageInputStream iis = null;
        try {
            iis = ImageIO.createImageInputStream(imageFile);
            // Find all image readers that recognize the image format
            Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
            if (iter == null || !iter.hasNext()) {
                throw new IOException("image format error");
            }
            ImageReader reader = iter.next();
            // Return the format name
            String formatName = reader.getFormatName();
            return formatName == null ? null : formatName.toUpperCase();
        } catch (RuntimeException e) {
            throw new IOException("image format error", e);
        } finally {
            if (iis != null) {
                iis.flush();
                iis.close();
            }
        }
    }

    /**
     * Get image dimension
     * 
     * @param imageFile
     *            image file
     * @return image dimension
     * @throws IOException
     */
    public static String getImageDimension(File imageFile) throws IOException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(imageFile);
            BufferedImage sourceImg = ImageIO.read(fis);
            if (sourceImg == null) {
                throw new IOException("image format error");
            }
            String dimension = sourceImg.getWidth() + "x" + sourceImg.getHeight();
            sourceImg.flush();
            return dimension;
        } catch (RuntimeException e) {
            throw new IOException("image format error", e);
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }

    private String getAvatarDimention(File file) throws Exception {
        String dimension;
        try {
            // Create template file
            dimension = getImageDimension(file);
            String imageType = getImageFormatName(file);
            Integer fileSize = getFileSize(file);
            // TODO checkImageFile(imageType, dimension, fileSize);

        } catch (IOException e) {
            throw new Exception();
        }
        return dimension;
    }

    /**
     * Convert byte stream base on base64 format to temporary file
     */
    public static File convertToTemporaryFileFromBase64(String stream) throws IOException {
        byte[] bytes = stream.getBytes("ASCII");
        byte[] decoded = Base64.decodeBase64(bytes);
        File file = File.createTempFile(UUID.randomUUID().toString(), null);
        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }
        file.createNewFile();
        OutputStream os = new FileOutputStream(file);
        try {
            ByteArrayInputStream buffer = new ByteArrayInputStream(decoded);
            byte[] barr = new byte[1024];
            while (true) {
                int r = buffer.read(barr);
                if (r <= 0) {
                    break;
                }
                os.write(barr, 0, r);
            }
        } finally {
            os.flush();
            os.close();
        }
        return file;
    }

    /**
     * covnert stream to string.
     */
    public static String inputStreamToString(InputStream result) throws IOException {
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[4096];
        for (int n; (n = result.read(b)) != -1;) {
            out.append(new String(b, 0, n));
        }
        return out.toString();
    }
    public static void main(String[] args) {
        // check
        // String stream = HttpUtils.inputStreamToString(inputStream);
        // file = createImageFile(stream);
        // String dimension = getAvatarDimention(file);
        // String imageType = getImageFormatName(file);
        // File uploadfile = new File(file.getPath().substring(0,
        // file.getPath().lastIndexOf('.') + 1) + imageType);
        // file.renameTo(uploadfile);
    }
}
