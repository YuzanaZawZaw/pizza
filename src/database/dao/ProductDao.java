package database.dao;
import database.entity.*;
import java.util.ArrayList;
import java.util.List;
public class ProductDao extends DatabaseOperation{
	public List<Product> getAll(int typeId){
		String sql="select p.* "
				+ "from pproduct p, ptype t "
				+ "where t.type_id=? "
				+ "and t.type_id=p.type_id";
		List<Object[]> l=super.processRetrive(sql,typeId);		
		List<Product> tl=new ArrayList<Product>();
		for(Object[] o:l){
			Product p=new Product();
			p.setProdId((Integer)o[0]);
			p.setProdName((String)o[1]);
			p.setProdPrice((Integer)o[2]);
			p.setTypeId((Integer)o[3]);
			tl.add(p);
		}
		return tl==null || tl.isEmpty() ? null : tl;
	}
	public Product getAllById(int pId){
		String sql="select p.*,t.* "
				+ "from pproduct p, ptype t "
				+ "where p.prod_id=? "
				+ "and t.type_id=p.type_id";
		List<Object[]> l=super.processRetrive(sql,pId);		
		List<Product> tl=new ArrayList<Product>();
		for(Object[] o:l){
			Product p=new Product();
			p.setProdId((Integer)o[0]);
			p.setProdName((String)o[1]);
			p.setProdPrice((Integer)o[2]);
			p.setTypeId((Integer)o[3]);
			
			Type t=new Type();
			t.setTypeId((Integer)o[4]);
			t.setTypeName((String)o[5]);
			p.setType(t);
			
			tl.add(p);
		}
		return tl==null || tl.isEmpty() ? null : tl.get(0);
	}

}
