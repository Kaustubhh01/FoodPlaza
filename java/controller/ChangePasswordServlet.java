package controller;

import java.io.IOException;

import dao.AdminDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cpservlet") 
public class ChangePasswordServlet extends HttpServlet {
	
	 AdminDaoImpl admindi = new AdminDaoImpl();
	 
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 HttpSession session = req.getSession();
		 
		 String email = req.getParameter("email");
		 String uEmail = (String) session.getAttribute("uEmail");
		 String aEmail = (String) session.getAttribute("aEmail");
		 String confirmpass = req.getParameter("cpass");
		 
		 if(email.equals(aEmail)) {
			 boolean b = admindi.adminchangepassword(email, confirmpass);
			 if(b) {
				 resp.sendRedirect("Success.jsp");
			 }else {
				 resp.sendRedirect("Fail.jsp");
			 }
		 }
		 
		 if(email.equals(uEmail)) {
			 boolean b = admindi.userchangepassword(email, confirmpass);
			 if(b) {
				 resp.sendRedirect("Success.jsp");
			 }else {
				 resp.sendRedirect("Fail.jsp");
			 }
		 }
		 
	}

}
