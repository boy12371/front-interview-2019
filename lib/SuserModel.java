package package1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SuserModel 
{


	private String name;
	private String password;
	private ConnSql connsql;
	private Connection conn=null;
	private PreparedStatement pst=null;
	private int ret;
	
	
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
	
	
	public SuserModel() {
		 connsql=new  ConnSql();
			conn=connsql.connet();
				
	
	
	}
	
	public SuserModel(String name, String password) {
		 connsql=new  ConnSql();
			conn=connsql.connet();
				
		this.name = name;
		this.password = password;
	
	}
	
	public void sqlsave()
	{
		
	
		String sql="insert into saleruser(username,password) values( '"+this.name+"',"+this.password+")";
		
		try 
		{
			pst=conn.prepareStatement(sql);
			 ret=pst.executeUpdate();
		} catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
	}
	
	public int check()
	{
	String sql="select password from saleruser where username='"+this.name+"'";
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
	
	
	public void getOrder()
	{
		String sql="select bookname from keshe.order";
		
		ResultSet ret=null;
			try 
			{
				pst=conn.prepareStatement(sql);
				ret=pst.executeQuery();
				
				while(ret.next())
				{
				
					System.out.println(" È√˚"+ret.getString(1));
					
					
				}
			
					 
				
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
	}
	
	public int register(String account,String password)
	{
		
		String sql="insert into keshe.saleruser(username,password) values('"+account+"','"+password+"')";
		
		try 
		{
			pst=conn.prepareStatement(sql);
			if((ret=pst.executeUpdate())==1)
				return 1;
			
				
		} catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		return 0;
	

		}
	
	public int login(String account,String password)
	{
	String sql="select password from saleruser where username='"+account+"'";
	String password1="";
	ResultSet ret=null;
		try 
		{
			pst=conn.prepareStatement(sql);
			ret=pst.executeQuery();
			System.out.println(password);
			//System.out.println(ret.toString());
			while(ret.next())
			{
			
			
				
				password1=ret.getString(1);
				
			}
			if(password1.equals(password))
				return 1;
			else
				return 0;
			
		} catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
			return 0;
	}
	

}
