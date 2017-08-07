package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class ConnSql
{
	//public static final String url="jdbc:mysql://119.29.35.45:3306/keshe";
	public static final String url="jdbc:mysql://127.0.0.1:3306/keshe";
	public static final String name="com.mysql.jdbc.Driver";
	public static final String user="root";
	public static final String password="123456";
	
	public Connection conn=null;
	public PreparedStatement pst=null;
	
	public ConnSql()
	{
		try
		{
			Class.forName(name);
			conn=DriverManager.getConnection(url, user, password);
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void close()
	{
		try{
			this.conn.close();

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public Connection connet()
	{
		return conn;
	}
	
	
}
