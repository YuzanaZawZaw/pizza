package database.entity;
import java.util.Date;
import java.util.List;
public class Order {
	private int orderId;
	private Date orderDate;
	private String customerName;
	private String customerPh;
	private int amount;
	private List<OrderrDetail> orderDetail;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPh() {
		return customerPh;
	}
	public void setCustomerPh(String customerPh) {
		this.customerPh = customerPh;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public List<OrderrDetail> getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(List<OrderrDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}
	

}
