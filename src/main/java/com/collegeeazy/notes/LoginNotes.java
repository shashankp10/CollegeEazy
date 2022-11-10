package com.collegeeazy.notes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/uploadnotes")
public class LoginNotes extends HttpServlet  {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher dispatcher = null;
		
		if(userID.equals("admin") && password.equals("root")) {
			//session.setAttribute("name", rs.getString("uname"));
			dispatcher = request.getRequestDispatcher("UploadNotes.jsp");
		}else {
			request.setAttribute("status", "failed");
			dispatcher = request.getRequestDispatcher("loginNotes.jsp");
		}
		dispatcher.forward(request,response);
	}
}
