package database.dao;
import database.entity.*;
import java.util.ArrayList;
import java.util.List;
public class OrderDao extends DatabaseOperation{
	public void saveOrder(Order or){
		String osql="insert into porder values(null,now(),?,?,?)";
		Object[] oparam={or.getCustomerName(),or.getCustomerPh(),or.getAmount()};
		int orderId=super.processInsertGetId(osql, oparam);
		
		String dsql[]=new String[or.getOrderDetail().size()];
		List<Object[]> dparam=new ArrayList<Object[]>();		
		for(int i=0;i<or.getOrderDetail().size();i++){
			OrderrDetail d=or.getOrderDetail().get(i);	
			System.out.println(d.getProdId());
			dsql[i]="insert into porder_detail "
					+ "values(null,?,?,?,?)";
			Object param[]=new Object[4];
			param[0]=d.getProdId(); //productId
			param[1]=1;
			param[2]=d.getPrice();//price
			param[3]=orderId;
			dparam.add(i,param);
		}	
		super.processCUDTran(dsql,dparam);
	}

}
