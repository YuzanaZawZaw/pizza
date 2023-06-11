package database.dao;
import database.entity.*;

import java.util.ArrayList;
import java.util.List;

public class TypeDao extends DatabaseOperation {
	public List<Type> getAll(){
		String sql="select * from ptype";
		List<Object[]> l=super.processRetrive(sql);
		List<Type> tl=new ArrayList<Type>();
		for(Object[] o:l){
			Type t=new Type();
			t.setTypeId((Integer)o[0]);
			t.setTypeName((String)o[1]);
			tl.add(t);
		}
		return tl==null || tl.isEmpty() ? null : tl;

	}
}
