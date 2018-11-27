package com.chinasoft;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/fileUpload")
public class FileUploadServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
//		Part part=req.getPart("fileName");
//		String header=part.getHeader("content-disposition");
//		System.out.println(header);
//		String fileName=header.substring(header.indexOf("filename=")+10,header.length()-1);
//		System.out.println(fileName);
//		part.write(fileName);
		
//		上传多个文件
		List<Part> parts=(List<Part>) req.getParts();
		for (Part part : parts) {
			String header=part.getHeader("content-disposition");
			System.out.println(header);
			String fileName=header.substring(header.indexOf("filename")+10, header.length()-1);
			System.out.println(fileName);
			part.write(req.getServletContext().getRealPath("/")+"/"+"Uplocal"+"/"+fileName);
		}
	}	
}
