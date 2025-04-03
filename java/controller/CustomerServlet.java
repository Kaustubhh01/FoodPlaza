package controller;

import java.io.IOException;
import java.util.List;

import dao.CustomerDaoImpl;
import pojo.customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {

	CustomerDaoImpl custobj = new CustomerDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		String action = req.getParameter("action");

		if(action!=null && action.equals("delete")) {

			String EmailId = req.getParameter("emailId");
			boolean b = custobj.deleteCustomerById(EmailId);
			if(b) {
				resp.sendRedirect("customer");
			}

			else {
				resp.sendRedirect("Failed.jsp");
			}
		}

		else {
			String email = (String) session.getAttribute("email");

			List<customer> l = custobj.getAllCustomer();

			if (l != null && !(l.isEmpty())) {

				session.setAttribute("clist", l);

				resp.sendRedirect("cl.jsp");

			}
			else {
				resp.sendRedirect("Failed.jsp");
			}

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		String email1 = (String) session.getAttribute("email");
		String pass1 = (String) session.getAttribute("pass");

		String action = req.getParameter("action");
		String name = req.getParameter("cname");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		String adr = req.getParameter("adr");
		long cNo =  Long.parseLong(req.getParameter("cNo"));

		if (action != null && action.equals("AddCustomer")) {

			boolean b = custobj.addCustomer(new customer(name,email,pass,adr,cNo));

			if (b) {
				resp.sendRedirect("customer");
			}
			else {
				resp.sendRedirect("Failed.jsp");
			}

		}

		if (action != null && action.equals("UpdateCustomer")) {

			boolean b = custobj.updateCustomerById(new customer(name, email1, pass1, adr, cNo));

			if (b) {
				resp.sendRedirect("Success.jsp");
			}
			else {
				resp.sendRedirect("Failed.jsp");
			}

		}

	}

}
