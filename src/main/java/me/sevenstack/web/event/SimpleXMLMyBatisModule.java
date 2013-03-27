package me.sevenstack.web.event;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.mybatis.guice.XMLMyBatisModule;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 是xml配置文件的MyBatisModule
 * 
 * @author lijinlong
 * 
 */
public class SimpleXMLMyBatisModule extends XMLMyBatisModule {

    @Override
    protected void initialize() {
        try {

            String evnId = "dev";
            Properties p = new Properties();
            p.load(new FileInputStream(this.getClass().getResource("/").getPath() + "mysql.properties"));
            /*if (vcap != null) {
                evnId = "prd";
                JSONObject db = JSON.parseObject(vcap).getJSONArray("mysql-5.1").getJSONObject(0).getJSONObject("credentials");
                p.setProperty("db.url", "jdbc:mysql://" + db.getString("host") + ":" + db.getString("port") + "/" + db.getString("name"));
                p.setProperty("db.username", db.getString("username"));
                p.setProperty("db.password", db.getString("password"));
            }*/
            if(System.getenv("OPENSHIFT_APP_NAME") != null){
                p.setProperty("db.url", "jdbc:mysql://" + System.getenv("OPENSHIFT_MYSQL_DB_HOST") + ":" + System.getenv("OPENSHIFT_MYSQL_DB_PORT") + "/" + System.getenv("OPENSHIFT_APP_NAME"));
                p.setProperty("db.username", "OPENSHIFT_MYSQL_DB_USERNAME");
                p.setProperty("db.password", "OPENSHIFT_MYSQL_DB_PASSWORD");
            }
            addProperties(p);
            setEnvironmentId(evnId);
        } catch (IOException e) {
            System.out.println("初始化失败");
            e.printStackTrace();
        }
        setClassPathResource("mybatis-config.xml");
    }
    public static void main(String[] args) {
        System.out.println(System.getenv("JAVA_HOME"));
    }

}
