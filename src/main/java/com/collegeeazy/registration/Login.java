package com.collegeeazy.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    		String uenroll = request.getParameter("username");
    		String upwd = request.getParameter("password");
    		HttpSession session = request.getSession();
    		RequestDispatcher dispatcher = null;
    		
    		try {
    			Class.forName("com.mysql.jdbc.Driver");
    			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeeazy?useSSL=false","root","rishu@123#");
    			PreparedStatement pst = con.prepareStatement("select * from students where uenroll = ? and upwd = ?");
    			pst.setString(1, uenroll);
    			pst.setString(2, upwd);
    			  			 
    			ResultSet rs = pst.executeQuery();
    			if(rs.next()) {
    				session.setAttribute("name", rs.getString("uname"));
    				dispatcher = request.getRequestDispatcher("index.jsp");
    			}else {
    				request.setAttribute("status", "failed");
    				dispatcher = request.getRequestDispatcher("login.jsp");
    			}
    			dispatcher.forward(request,response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    		
	}

}
