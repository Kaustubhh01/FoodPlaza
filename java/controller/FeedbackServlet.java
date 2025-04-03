package controller;

import java.io.IOException;
import java.util.List;

import dao.FeedbackDaoImpl;
import pojo.Feedback;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {
	
	FeedbackDaoImpl feeddi = new FeedbackDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String action = (String)req.getParameter("action");
		String name = (String)req.getParameter("cname");
		String email = (String)req.getParameter("uemail");
		String review = (String)req.getParameter("review");
		int rank = Integer.parseInt(req.getParameter("rank"));
		String suggestion = (String)req.getParameter("suggest");
		
		if(action!=null && action.equals("AddFeedback")) {
			boolean b = feeddi.addFeedback(new Feedback(name, email, review, rank, suggestion));
			if(b) {
				resp.sendRedirect("Success.jsp");
			}else {
				resp.sendRedirect("Fail.jsp");
			}
		}
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		List<Feedback> l = feeddi.getAllFeedback();
		
		if(l!=null && !(l.isEmpty())) {
			session.setAttribute("flist", l);
			resp.sendRedirect("FeedbackList.jsp");
		}else {
			resp.sendRedirect("Fail.jsp");
		}
		
		
	}

}
