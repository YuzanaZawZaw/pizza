package services;

import java.util.ArrayList;

import database.dao.OrderDao;
import database.dao.ProductDao;
import database.dao.TypeDao;
import database.entity.Order;
import database.entity.OrderrDetail;
import database.entity.Product;
import views.form.PizzaForm;

public class PizzaService {
	private ProductDao myProdDao;
	private TypeDao myTypeDao;
	private OrderDao myOrderDao;
	public PizzaService(){
		this.myProdDao=new ProductDao();
		this.myTypeDao=new TypeDao();
		this.myOrderDao=new OrderDao();
	}
	public void processOrder(PizzaForm myForm){
		Order o=new Order();
		o.setCustomerName(myForm.getFrmCname());
		o.setCustomerPh(myForm.getFrmCph());
		o.setAmount(Integer.parseInt(myForm.getFrmGrandTotal()));
		
		ArrayList<OrderrDetail> odl=new ArrayList<OrderrDetail>();
		for(String pid:myForm.getFrmBasketProdList()){
			int id=Integer.parseInt(pid);
			Product p=this.myProdDao.getAllById(id);
			OrderrDetail od=new OrderrDetail();
			od.setPrice(p.getProdPrice());
			od.setProdId(p.getProdId());
			odl.add(od);
		}
		o.setOrderDetail(odl);

		this.myOrderDao.saveOrder(o);		
		
	}
	public void processLoad(PizzaForm myForm){
		myForm.setFrmTypeList(this.myTypeDao.getAll());
		myForm.setFrmTypeId("0");
		myForm.setFrmProductList(null);		
	}
	public void processSearch(PizzaForm myForm){
		myForm.setFrmTypeList(this.myTypeDao.getAll());
		myForm.setFrmTypeId(myForm.getFrmTypeId());
		myForm.setFrmProductList(this.myProdDao.getAll(
				Integer.parseInt(myForm.getFrmTypeId())
				));		
	}
	public void processBasketShow(PizzaForm myForm){
		ArrayList<Product> bpl=new ArrayList<Product>();
		for(String strPid:myForm.getFrmBasketProdList()){
			Product p=this.myProdDao.getAllById(
					Integer.parseInt(strPid)
					);
			bpl.add(p);
		}
		myForm.setFrmProductList(bpl);
	}
}
