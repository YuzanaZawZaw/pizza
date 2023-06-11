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

@WebServlet("/basketPath")
public class BasketController extends HttpServlet{
	private PizzaService myService=new PizzaService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PizzaForm myForm=new PizzaForm();
		String pid=req.getParameter("frmOrderProdId");
		HttpSession s=req.getSession(false);
		ArrayList<String> bpl=new ArrayList<String>();
		if(s.getAttribute("frmBasketList")!=null){
			bpl=(ArrayList<String>) s.getAttribute("frmBasketList");
		}
		bpl.add(pid);
		HttpSession ss=req.getSession(false);
		String id=(String) ss.getAttribute("frmTypeId");
		myForm.setFrmTypeId(id);
		this.myService.processSearch(myForm);
		req.setAttribute("frmForm", myForm);
				
		s.setAttribute("frmBasketList",bpl);
				
		RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
		rd.forward(req, resp);
	}

	
}
