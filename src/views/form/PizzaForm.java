package views.form;
import database.entity.*;
import java.util.List;

public class PizzaForm {
	private List<Type> frmTypeList;
	private List<Product> frmProductList;
	private String frmTypeId;
	private List<String> frmBasketProdList;
	private String frmCname;
	private String frmCph;
	private String frmGrandTotal;
	
	
	public List<Type> getFrmTypeList() {
		return frmTypeList;
	}
	public void setFrmTypeList(List<Type> frmTypeList) {
		this.frmTypeList = frmTypeList;
	}
	public List<Product> getFrmProductList() {
		return frmProductList;
	}
	public void setFrmProductList(List<Product> frmProductList) {
		this.frmProductList = frmProductList;
	}
	public String getFrmTypeId() {
		return frmTypeId;
	}
	public void setFrmTypeId(String frmTypeId) {
		this.frmTypeId = frmTypeId;
	}
	public List<String> getFrmBasketProdList() {
		return frmBasketProdList;
	}
	public void setFrmBasketProdList(List<String> frmBasketProdList) {
		this.frmBasketProdList = frmBasketProdList;
	}
	public String getFrmCname() {
		return frmCname;
	}
	public void setFrmCname(String frmCname) {
		this.frmCname = frmCname;
	}
	public String getFrmCph() {
		return frmCph;
	}
	public void setFrmCph(String frmCph) {
		this.frmCph = frmCph;
	}
	public String getFrmGrandTotal() {
		return frmGrandTotal;
	}
	public void setFrmGrandTotal(String frmGrandTotal) {
		this.frmGrandTotal = frmGrandTotal;
	}
	
}
