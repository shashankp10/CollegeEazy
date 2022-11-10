package com.collegeeazy.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("name");
		String upwd = request.getParameter("pass");
		String umobile = request.getParameter("contact");
		String enrollment = request.getParameter("enrollment");
		String branch = request.getParameter("branch");
		String semester = request.getParameter("semester");
		RequestDispatcher dispatcher = null;
		Connection con = null;
	 	// database code
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeeazy?useSSL=false","root","rishu@123#");
			PreparedStatement pst = con.prepareStatement("insert into users(uname,uenroll,ubranch,usem,ucontact,upswd) values(?,?,?,?,?,?)");
			pst.setString(1, uname);
			pst.setString(2, enrollment);
			pst.setString(3, branch);
			pst.setString(4, semester);
			pst.setString(5, umobile);
			pst.setString(6, umobile);
			
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("registration.jsp");
			if(rowCount>0 && uname!=null && upwd!=null && umobile!=null 
				  	&& enrollment!=null && branch!=null && semester!=null) {
				request.setAttribute("status","success");	
			}
			else {
				request.setAttribute("status", "failed");
			}
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
