package controller;

import java.io.IOException;
import java.util.List;

import dao.FoodDaoImpl;
import pojo.food;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/food")
public class FoodServlet extends HttpServlet{
	FoodDaoImpl foodobj = new FoodDaoImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		String email = (String) session.getAttribute("email");
		String pass = (String) session.getAttribute("pass");
		String action = req.getParameter("action");
		String fname = req.getParameter("fname");
		String ftype = req.getParameter("ftype");
		int fquantity = Integer.parseInt(req.getParameter("fquan")); 
		float fprice = Float.parseFloat(req.getParameter("fprice"));

		if (action != null && action.equals("AddFood")) {

			boolean b = foodobj.addFood(new food(fname,ftype,fquantity,fprice));

			if (b) {
				resp.sendRedirect("food");
			}
			else {
				resp.sendRedirect("Failed.jsp");
			}

		}

		if (action != null && action.equals("UpdateFood")) {
			food f = new food(fname,ftype,fquantity,fprice);
			int foodId = Integer.parseInt(req.getParameter("fid"));
			f.setFood_ID(foodId);
			boolean b = foodobj.updateFoodById(f);

			if (b) {
				resp.sendRedirect("food");
			}
			else {
				resp.sendRedirect("Failed.jsp");
			}

		}

		//		if (action != null && action.equals("DeleteFood")) {
		//
		//			boolean b = foodobj.deleteFoodById(new Food(ftype,fname,fquantity,fprice));
		//
		//			if (b) {
		//				resp.sendRedirect("Success.jsp");
		//			}
		//			else {
		//				resp.sendRedirect("Failed.jsp");
		//			}
		//
		//		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		String action = req.getParameter("action");

		if(action!=null && action.equals("delete")) {

			int foodId = Integer.parseInt(req.getParameter("foodId"));
			boolean b = foodobj.deleteFoodById(foodId);

			if(b) {
				resp.sendRedirect("food");
			}

			else {
				resp.sendRedirect("Failed.jsp");
			}
		}

		else {
			String email = (String) session.getAttribute("email");

			List<food> l = foodobj.getAllFood();

			if (l != null && !(l.isEmpty())) {

				session.setAttribute("flist", l);

				resp.sendRedirect("fl.jsp");

			}
			else {
				resp.sendRedirect("Failed.jsp");
			}

		}
	}

}
