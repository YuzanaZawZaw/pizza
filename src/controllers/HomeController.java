package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.PizzaService;
import views.form.PizzaForm;

@WebServlet("/homePath")
public class HomeController extends HttpServlet{
	private PizzaService myService=new PizzaService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PizzaForm myForm=new PizzaForm();
		this.myService.processLoad(myForm);
		req.setAttribute("frmForm", myForm);
		HttpSession s=req.getSession();
		s.setAttribute("frmBasketList", null);
		RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PizzaForm myForm=new PizzaForm();
		myForm.setFrmTypeId(req.getParameter("frmTypeId"));
		this.myService.processSearch(myForm);
		req.setAttribute("frmForm", myForm);
		
		HttpSession s=req.getSession(false);
		s.setAttribute("frmTypeId", myForm.getFrmTypeId());
		RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
		rd.forward(req, resp);
	}
	
}
