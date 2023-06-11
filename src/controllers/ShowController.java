package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.PizzaService;
import views.form.PizzaForm;

@WebServlet(value={"/showPath","/orderPath"})
public class ShowController extends HttpServlet{
	private PizzaService myService=new PizzaService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PizzaForm myForm=new PizzaForm();
		HttpSession s=req.getSession(false);
		ArrayList<String> bpl=new ArrayList<String>();
		bpl=(ArrayList<String>) s.getAttribute("frmBasketList");
		
		s.setAttribute("frmBasketList",bpl);
		myForm.setFrmBasketProdList(bpl);
		this.myService.processBasketShow(myForm);
		req.setAttribute("frmForm", myForm);
		
		RequestDispatcher rd=req.getRequestDispatcher("show.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PizzaForm myForm=new PizzaForm();
		HttpSession s=req.getSession(false);
		ArrayList<String> bpl=new ArrayList<String>();
		bpl=(ArrayList<String>) s.getAttribute("frmBasketList");
		s.setAttribute("frmBasketList",bpl);
		
		//order
		myForm.setFrmCname(req.getParameter("frmCname"));
		myForm.setFrmCph(req.getParameter("frmCph"));
		myForm.setFrmGrandTotal(req.getParameter("frmGtotal"));
		//orderdetail
		myForm.setFrmBasketProdList(bpl);
		
		this.myService.processOrder(myForm);
		this.myService.processLoad(myForm);
		s.setAttribute("frmBasketList",null);
		req.setAttribute("frmForm", myForm);
		
		RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
		rd.forward(req, resp);
	}
	
}
