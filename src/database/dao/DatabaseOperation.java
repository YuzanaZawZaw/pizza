package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DatabaseOperation {
	private DataSource getDataSource(){
		DataSource ds=null;
		try{
			InitialContext ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/jdbc/posdb");			
		}catch(Exception e){
			e.printStackTrace();
		}		
		return ds;
	}
	public int processInsertGetId(String sql,Object ...params){
		int pkid=-1;
		try{
			//get the connection upon datasource
			Connection con=getDataSource().getConnection();
				//prepare the statement for sql
				PreparedStatement stmt=con.prepareStatement(sql);
					//assign the parameter value on sql ?
					int i=1;
					for(Object o:params){
						stmt.setObject(i++,o);
					}
					//execute the sql 
					stmt.execute();	
					
					stmt=con.prepareStatement("select last_insert_id()");
					ResultSet rs=stmt.executeQuery();
					if(rs.next()) pkid=rs.getInt(1);
				stmt.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return pkid;
	}
	public boolean processCUDTran(String sqls[],List<Object[]> params){
		Connection con=null;
		try{			
			con=getDataSource().getConnection();
			con.setAutoCommit(false);
				for(int i=0;i<sqls.length;i++){
					String sql=sqls[i];
					Object[] param=null;
					if(params.get(i)!=null) param=params.get(i);
					
					PreparedStatement stmt=con.prepareStatement(sql);
					if(param!=null){
						for(int k=0;k<param.length;k++)
							stmt.setObject(k+1, param[k]);
					}
					stmt.execute();		
				}
			con.commit();	
			con.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			try {
				if(con!=null) con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}
	public boolean processCUD(String sql,Object ...params){
		try{
			//get the connection upon datasource
			Connection con=getDataSource().getConnection();
				//prepare the statement for sql
				PreparedStatement stmt=con.prepareStatement(sql);
					//assign the parameter value on sql ?
					int i=1;
					for(Object o:params){
						stmt.setObject(i++,o);
					}
					//execute the sql 
					stmt.execute();			
				stmt.close();
			con.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public List<Object[]> processRetrive(String sql,Object ...params){
		List<Object[]> l=new ArrayList<Object[]>();
		try{
			Connection con=getDataSource().getConnection();
				PreparedStatement stmt=con.prepareStatement(sql);
					int i=1;
					for(Object o:params){
						stmt.setObject(i++,o);
					}
					ResultSet rs=stmt.executeQuery();
						ResultSetMetaData meta=rs.getMetaData();
						int col=meta.getColumnCount();
						while(rs.next()){
							//get one record
							Object[] record=new Object[col];
							for(int ri=1;ri<=col;ri++){
								record[ri-1]=rs.getObject(ri);
							}
							//store one record into list
							l.add(record);
						}					
					rs.close();
				stmt.close();
			con.close();			
		}catch(Exception e){
			e.printStackTrace();
		}
		return l==null || l.isEmpty() ? null : l;
	}
	
}




