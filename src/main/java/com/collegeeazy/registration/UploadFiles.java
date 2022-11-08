package com.collegeeazy.registration;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig
public class UploadFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Part p = request.getPart("files");
		String fileName = p.getSubmittedFileName();
		String description = request.getParameter("description");
		HttpSession session = request.getSession();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeeazy?useSSL=false","root","rishu@123#");
			PreparedStatement ps = con.prepareStatement("insert into notes(fileName,dscp) values(?,?)");
			ps.setString(1, fileName);
			//ps.setString(2, file);
			ps.setString(2, description);
			
			if(ps.executeUpdate()==1) {
				String path = getServletContext().getRealPath("")+"images";
				File file = new File(path);
				p.write(path+file.separator+fileName);
				session.setAttribute("msg", "File Uploaded Successfully!!");
				
//				System.out.println(path);
//				System.out.println("Upload success");
				response.sendRedirect("UploadNotes.jsp");
			}
			else {
				System.out.println("Error in server");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
