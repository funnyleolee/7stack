package me.sevenstack.web.action.fs;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.omg.CORBA.Context;
import org.omg.CORBA.ContextList;
import org.omg.CORBA.DomainManager;
import org.omg.CORBA.ExceptionList;
import org.omg.CORBA.NVList;
import org.omg.CORBA.NamedValue;
import org.omg.CORBA.Object;
import org.omg.CORBA.Policy;
import org.omg.CORBA.Request;
import org.omg.CORBA.SetOverrideType;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import com.sun.corba.se.spi.activation.Server;

public class MongoUpload extends HttpServlet {
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");   //[0-9]+.jpg
		
		MongoClient mongo = new MongoClient("your mongo server ip", port);
		DB db = mongo.getDB("db");
		db.authenticate("username", "password".toCharArray());
		String filename = id;
		GridFS photo = new GridFS(db, "imgs");
		GridFSDBFile imgout = photo.findOne(filename);
		
		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();
		BufferedImage img = ImageIO.read(imgout.getInputStream());
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(img);
        out.close();
        mongo.close();
	}
	//这一段是响应图片上传，并返回图片的访问地址
    public String processUploadFile(FileItem item) throws Exception
{
	String filename = item.getName();
	int index = filename.lastIndexOf(".");
	filename = System.currentTimeMillis() + filename.substring(index);
	System.out.println(filename);
	long filesize = item.getSize();
	if(filename == null || filename.length() == 0)
		return null;
	
	MongoClient client = new MongoClient("your mongo server ip");
	DB db = client.getDB("db");
	db.authenticate("username", "password".toCharArray());
	GridFS photo = new GridFS(db, "imgs");
	GridFSInputFile in = null;
	in = photo.createFile(item.getInputStream());
	in.setFilename(filename);
	in.save();
	client.close();
	String url = "/imgs?id=" + filename;
	System.out.println(url);
	return url;
}
	

}
