package package1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerModel {

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String name;
	private String password;
	
	private ConnSql connsql;
	private Connection conn=null;
	private PreparedStatement pst=null;
	private int ret;
	
	
	public ManagerModel() {
		
		
		 connsql=new  ConnSql();
			conn=connsql.connet();
	
	}
	
	public ManagerModel(String name, String password) {
		
		
		 connsql=new  ConnSql();
			conn=connsql.connet();
		this.name = name;
		this.password = password;
	}
	
	
	public int check()
	{
	String sql="select password from manager where username='"+this.name+"'";
	String password=null;
	ResultSet ret=null;
		try 
		{
			pst=conn.prepareStatement(sql);
			ret=pst.executeQuery();
			//System.out.println(ret.toString());
			while(ret.next())
			{
			
				System.out.println(ret.getString(1));
				
				password=ret.getString(1);
			}
			if(password.equals(this.password))
				return 1;
			
		} catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
			return 0;
	}
	

	
}
