package package1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public class CuserModel 
{
//	connsql.close();
		//pst.close();
			 

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

	public CuserModel() {
		
		 connsql=new  ConnSql();
		conn=connsql.connet();
		
	}
	public CuserModel(String name, String password) {
		
		 connsql=new  ConnSql();
		conn=connsql.connet();
			
		this.name = name;
		this.password = password;
	}
	
	public void sqlsave()
	{
		
	
		String sql="insert into commonuser(username,password) values( ' "+this.name+" ',"+this.password+")";
		
		try 
		{
			pst=conn.prepareStatement(sql);
			 ret=pst.executeUpdate();
		} catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
	}
	

	public int mannagelogin(String account,String password)
	{
	String sql="select password from manager where username='"+account+"'";
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
	
	
	public int mannageregist(String account,String password)
	{
		
		String sql="insert into keshe.manager(username,password) values('"+account+"','"+password+"')";
		
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
	
	
		
		
		
	
	
	public int commonlogin(String account,String password)
	{
	String sql="select password from commonuser where username='"+account+"'";
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
	public JSONObject lookBook()
	{
		String sql="select bookname,bookprice from books";
		
String bookname="",bookprice="";
		
		ResultSet ret=null;
		 Map<String, Object> map = new HashMap<String, Object>();  
		 ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();  
		   // HashMap<String,Object> jsonMap = new HashMap<String, Object>();  
		
		 HashMap<String,Object> jsonMap =null;
		 HashMap<String,Object> jsonMap2 =null;
		 ArrayList<HashMap<String, Object>> list2 = new ArrayList<HashMap<String, Object>>();  ;
		System.out.println("价格");
		  JSONObject jsonObject=null;
			try 
			{
				pst=conn.prepareStatement(sql);
				ret=pst.executeQuery();
				
				while(ret.next())
				{
				
					System.out.println("书名"+ret.getString(1));
					System.out.println("价格"+ret.getString(2));
				
					bookname= ret.getString(1);
					bookprice= ret.getString(2);
					
					jsonMap = new HashMap<String, Object>();  
					 jsonMap2 = new HashMap<String, Object>();  
					 jsonMap.put("bookname",bookname);
					 jsonMap2.put("bookprice",bookprice);
					 
					 list.add(jsonMap);  
					
					 list2.add(jsonMap2);  
					
				}
			
				     
			    map.put("bookname", list);  
			    map.put("bookprice", list2);  
			 jsonObject = new JSONObject();
			
				   jsonObject.putAll(map);
		System.out.println(jsonObject.toString());
					
				
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			
			return jsonObject;
	}
	
	
	public JSONObject findBook(String name)
	{
		String sql="select bookname,bookprice from books where bookname='"+name+"'";
		String bookname="",bookprice="";
		
		ResultSet ret=null;
		 Map<String, Object> map = new HashMap<String, Object>();  
		 ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();  
		   // HashMap<String,Object> jsonMap = new HashMap<String, Object>();  
		
		 HashMap<String,Object> jsonMap =null;
		 HashMap<String,Object> jsonMap2 =null;
		 ArrayList<HashMap<String, Object>> list2 = new ArrayList<HashMap<String, Object>>();  ;
		System.out.println("价格");
		  JSONObject jsonObject=null;
			try 
			{
				pst=conn.prepareStatement(sql);
				ret=pst.executeQuery();
				
				while(ret.next())
				{
				
					System.out.println("书名"+ret.getString(1));
					System.out.println("价格"+ret.getString(2));
				
					bookname= ret.getString(1);
					bookprice= ret.getString(2);
					
					jsonMap = new HashMap<String, Object>();  
					 jsonMap2 = new HashMap<String, Object>();  
					 jsonMap.put("bookname",bookname);
					 jsonMap2.put("bookprice",bookprice);
					 
					 list.add(jsonMap);  
				
					 list2.add(jsonMap2);  
					
				}
			
				     
			    map.put("bookname", list);  
			    map.put("bookprice", list2);  
			 jsonObject = new JSONObject();
			
				   jsonObject.putAll(map);
		System.out.println(jsonObject.toString());
					
				
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			
			return jsonObject;
	}
	public void buyBook(String bookname)
	{
String sql="insert into keshe.order(username,bookname) values('"+this.name+"','"+bookname+"')";
	
		try 
		{
			pst=conn.prepareStatement(sql);
			 ret=pst.executeUpdate();
		} catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
	}

	public void getOrder()
	{
		String sql="select bookname from keshe.order where username='"+this.name+"'";
		
		ResultSet ret=null;
			try 
			{
				pst=conn.prepareStatement(sql);
				ret=pst.executeQuery();
				
				while(ret.next())
				{
				
					System.out.println("书名"+ret.getString(1));
					
					
				}
				 
					 
				
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
		
	}
	
	public int putcommit(String commit,String bookname)
	{
	
	
		String sql="update  books set commits='"+commit+"' where bookname='"+bookname+"'";
	
		try 
		{
			pst=conn.prepareStatement(sql);
			 ret=pst.executeUpdate();
			 if(ret==1)
				 return 1;
		} catch (SQLException e) 
		{
			
		}
		return 0;
	}
	public void getCommit()
	{
		String username="Java程序设计第3版";
			String sql="select commits from books where bookname='"+username+"'";
		
		ResultSet ret=null;
			try 
			{
				pst=conn.prepareStatement(sql);
				ret=pst.executeQuery();
				
				while(ret.next())
				{
				
					System.out.println("评论"+ret.getString(1));
				
				}
			
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
	}
	
	
	public int commonregist(String account,String password)
	{
		
		String sql="insert into keshe.commonuser(username,password) values('"+account+"','"+password+"')";
		
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
	
	public int salerregist(String account,String password)
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
	
	public int salerlogin(String account,String password)
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
	
	public int addcart(String bookname,String bookprice)
	{
		String sql="insert into keshe.cart(bookname,bookprice) values('"+bookname+"',"+bookprice+")";
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
	public int addorder(String bookname,String bookprice)
	{
		String sql="insert into keshe.order(bookname,bookprice) values('"+bookname+"',"+bookprice+")";
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
	public JSONObject loadcart()
	{
		String sql="select bookname,bookprice from keshe.cart";
		String bookname="",bookprice="";
		
		ResultSet ret=null;
		 Map<String, Object> map = new HashMap<String, Object>();  
		 ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();  
		   // HashMap<String,Object> jsonMap = new HashMap<String, Object>();  
		
		 HashMap<String,Object> jsonMap =null;
		 HashMap<String,Object> jsonMap2 =null;
		 ArrayList<HashMap<String, Object>> list2 = new ArrayList<HashMap<String, Object>>();  ;
		
		  JSONObject jsonObject=null;
			try 
			{
				pst=conn.prepareStatement(sql);
				ret=pst.executeQuery();
				
				while(ret.next())
				{
				
					System.out.println("书名"+ret.getString(1));
					System.out.println("价格"+ret.getString(2));
				
					bookname= ret.getString(1);
					bookprice= ret.getString(2);
					
					jsonMap = new HashMap<String, Object>();  
					 jsonMap2 = new HashMap<String, Object>();  
					 jsonMap.put("bookname",bookname);
					 jsonMap2.put("bookprice",bookprice);
					 
					 list.add(jsonMap);  
					
					 list2.add(jsonMap2);  
					
				}
			
				     
			    map.put("bookname", list);  
			    map.put("bookprice", list2);  
			 jsonObject = new JSONObject();
			
				   jsonObject.putAll(map);
		System.out.println("loadcart:"+jsonObject.toString());
					
				
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			
			return jsonObject;
		
	}
	public JSONObject loadorder()
	{
		String sql="select bookname,bookprice from keshe.order";
		String bookname="",bookprice="";
		
		ResultSet ret=null;
		 Map<String, Object> map = new HashMap<String, Object>();  
		 ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();  
		   // HashMap<String,Object> jsonMap = new HashMap<String, Object>();  
		
		 HashMap<String,Object> jsonMap =null;
		 HashMap<String,Object> jsonMap2 =null;
		 ArrayList<HashMap<String, Object>> list2 = new ArrayList<HashMap<String, Object>>();  ;
		
		  JSONObject jsonObject=null;
			try 
			{
				pst=conn.prepareStatement(sql);
				ret=pst.executeQuery();
				
				while(ret.next())
				{
				
					System.out.println("书名"+ret.getString(1));
					System.out.println("价格"+ret.getString(2));
				
					bookname= ret.getString(1);
					bookprice= ret.getString(2);
					
					jsonMap = new HashMap<String, Object>();  
					 jsonMap2 = new HashMap<String, Object>();  
					 jsonMap.put("bookname",bookname);
					 jsonMap2.put("bookprice",bookprice);
					 
					 list.add(jsonMap);  
				
					 list2.add(jsonMap2);  
					
				}
			
				     
			    map.put("bookname", list);  
			    map.put("bookprice", list2);  
			 jsonObject = new JSONObject();
			
				   jsonObject.putAll(map);
		System.out.println(jsonObject.toString());
					
				
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			
			return jsonObject;
		
	}
	
	
	public JSONObject loadleave()
	{
		String sql="select bookname,bookprice,bookleave,booksale from keshe.books";
		String bookname="",bookprice="",bookleave="",booksale="";
		
		ResultSet ret=null;
		 Map<String, Object> map = new HashMap<String, Object>();  
		 ArrayList<HashMap<String, Object>> listbookname = new ArrayList<HashMap<String, Object>>();  
		   // HashMap<String,Object> jsonMap = new HashMap<String, Object>();  
		
		 HashMap<String,Object> jsonMapbookname =null;
		 HashMap<String,Object> jsonMapbookprice=null;
		 HashMap<String,Object> jsonMapbookleave =null;
		 HashMap<String,Object> jsonMapbooksale =null;
		 ArrayList<HashMap<String, Object>> listbookprice = new ArrayList<HashMap<String, Object>>();  ;
		 ArrayList<HashMap<String, Object>> listbookleave = new ArrayList<HashMap<String, Object>>();  
		 ArrayList<HashMap<String, Object>> listbooksale= new ArrayList<HashMap<String, Object>>();  
		  JSONObject jsonObject=null;
			try 
			{
				pst=conn.prepareStatement(sql);
				ret=pst.executeQuery();
				
				while(ret.next())
				{
				
					System.out.println("书名"+ret.getString(1));
					System.out.println("价格"+ret.getString(2));
				
					bookname= ret.getString(1);
					bookprice= ret.getString(2);
					bookleave= ret.getString(3);
					booksale= ret.getString(4);
					jsonMapbookname = new HashMap<String, Object>();  
					jsonMapbookprice = new HashMap<String, Object>();  
					jsonMapbookleave = new HashMap<String, Object>();  
					jsonMapbooksale = new HashMap<String, Object>();  
					
					jsonMapbookname.put("bookname",bookname);
					jsonMapbookprice.put("bookprice",bookprice);
					jsonMapbookleave.put("bookleave",bookleave);
					jsonMapbooksale.put("booksale",booksale);
					
					 listbookname.add(jsonMapbookname);  
					 listbookprice.add(jsonMapbookprice);
					 listbookleave.add(jsonMapbookleave);  
					 listbooksale.add(jsonMapbooksale);  
				}
			
				     
			    map.put("bookname", listbookname);  
			    
			    map.put("bookprice", listbookprice);  
			    map.put("bookleave", listbookleave);  
			    map.put("booksale", listbooksale);  
			    
			 jsonObject = new JSONObject();
			 
			
				   jsonObject.putAll(map);
		System.out.println(jsonObject.toString());
					
				
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			
			return jsonObject;
		
	}
	public JSONObject loadmessage()
	{
		String sql="select messagehead,messagesay from keshe.message";
		String messagehead="",messagesay="";
		
		ResultSet ret=null;
		 Map<String, Object> map = new HashMap<String, Object>();  
		 ArrayList<HashMap<String, Object>> listmessagehead = new ArrayList<HashMap<String, Object>>();  
		   // HashMap<String,Object> jsonMap = new HashMap<String, Object>();  
		
		 HashMap<String,Object> jsonMapmessagehead =null;
		 HashMap<String,Object> jsonMapmessagesay=null;
	
		 ArrayList<HashMap<String, Object>> listmessagesay = new ArrayList<HashMap<String, Object>>();  ;
		
		  JSONObject jsonObject=null;
			try 
			{
				pst=conn.prepareStatement(sql);
				ret=pst.executeQuery();
				
				while(ret.next())
				{
				
					System.out.println("书名"+ret.getString(1));
					System.out.println("价格"+ret.getString(2));
				
					messagehead= ret.getString(1);
					messagesay= ret.getString(2);
					
					jsonMapmessagehead = new HashMap<String, Object>();  
					jsonMapmessagesay = new HashMap<String, Object>();  
				
					
					jsonMapmessagehead.put("messagehead",messagehead);
					jsonMapmessagesay.put("messagesay",messagesay);
				
					listmessagehead.add(jsonMapmessagehead);  
					listmessagesay.add(jsonMapmessagesay);
				
				}
			
				     
			    map.put("messagehead", listmessagehead);  
			    
			    map.put("messagesay", listmessagesay);  
			  
			 jsonObject = new JSONObject();
			 
			
				   jsonObject.putAll(map);
		System.out.println(jsonObject.toString());
					
				
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			
			return jsonObject;
		
	}
	public int putmessage(String message)
	{
		String sql="insert into keshe.message(messagehead,messagesay) values('"+message+"',"+message+")";
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
	
	public JSONObject loaduser()
	{
		String sql="select username from keshe.commonuser";
		String username="",uservary="";
		
		ResultSet ret=null;
		 Map<String, Object> map = new HashMap<String, Object>();  
		 ArrayList<HashMap<String, Object>> listusername = new ArrayList<HashMap<String, Object>>();  
		   // HashMap<String,Object> jsonMap = new HashMap<String, Object>();  
		
		 HashMap<String,Object> jsonMapusername =null;
		 HashMap<String,Object> jsonMapuservary=null;
	
		 ArrayList<HashMap<String, Object>> listuservary = new ArrayList<HashMap<String, Object>>();  ;
		
		  JSONObject jsonObject=null;
			try 
			{
				pst=conn.prepareStatement(sql);
				ret=pst.executeQuery();
				
				while(ret.next())
				{
				
					System.out.println("书名"+ret.getString(1));
					
				
					username= ret.getString(1);
					uservary= "一般用户";
					
					jsonMapusername = new HashMap<String, Object>();  
					jsonMapuservary = new HashMap<String, Object>();  
				
					
					jsonMapusername.put("username",username);
					jsonMapuservary.put("uservary",uservary);
				
					listusername.add(jsonMapusername);  
					listuservary.add(jsonMapuservary);
				
				}
				String sql2="select username from keshe.saleruser";
				
					pst=conn.prepareStatement(sql2);
					ret=pst.executeQuery();
					while(ret.next())
					{
						username= ret.getString(1);
						uservary= "销售商";
						jsonMapusername = new HashMap<String, Object>();  
						jsonMapuservary = new HashMap<String, Object>();  
					
						
						jsonMapusername.put("username",username);
						jsonMapuservary.put("uservary",uservary);
					
						listusername.add(jsonMapusername);  
						listuservary.add(jsonMapuservary);
					}
			    map.put("username", listusername);  
			    
			    map.put("uservary", listuservary);  
			  
			 jsonObject = new JSONObject();
			 
			
				   jsonObject.putAll(map);
		System.out.println(jsonObject.toString());
					
				
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			
			return jsonObject;
		
	}
	public JSONObject loadcommit(String bookname)
	{
		String sql="select commits from keshe.books where bookname='"+bookname+"'";
		String commit="";
		
		ResultSet ret=null;
		 Map<String, Object> map = new HashMap<String, Object>();  
		 ArrayList<HashMap<String, Object>> listcommit = new ArrayList<HashMap<String, Object>>();  
		   // HashMap<String,Object> jsonMap = new HashMap<String, Object>();  
		
		 HashMap<String,Object> jsonMapcommit =null;
		
	
		
		  JSONObject jsonObject=null;
			try 
			{
				pst=conn.prepareStatement(sql);
				ret=pst.executeQuery();
				
				while(ret.next())
				{
				
					System.out.println("书名"+ret.getString(1));
					
				
					commit= ret.getString(1);
					
					jsonMapcommit = new HashMap<String, Object>();  
				
					
					jsonMapcommit.put("commit",commit);
				
					listcommit.add(jsonMapcommit);  
				
				}
			
			    map.put("commit", listcommit);  
			    
			  
			 jsonObject = new JSONObject();
			 
			
				   jsonObject.putAll(map);
		System.out.println(jsonObject.toString());
					
				
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			
			return jsonObject;
		
	}
	public int delectmessage(String message)
	{
		String sql="delete from keshe.message where messagehead='"+message+"'";
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
	
	public int delectuser(String username)
	{
		String sql="delete from keshe.commonuser where username='"+username+"'";
		try 
		{
			pst=conn.prepareStatement(sql);
			if((ret=pst.executeUpdate())==1)
				return 1;
			
			String sql2="delete from keshe.saleruser where username='"+username+"'";
			pst=conn.prepareStatement(sql2);
			if((ret=pst.executeUpdate())==1)
				return 1;
		} catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public List<User> javafxloaduser()
	{
		String sql="select username from keshe.commonuser";
		String username="",uservary="";
		
		ResultSet ret=null;
	
		List<User> userlist=new ArrayList<User>();
		
		
			try 
			{
				pst=conn.prepareStatement(sql);
				ret=pst.executeQuery();
				
				while(ret.next())
				{
				
					System.out.println("书名"+ret.getString(1));
					
				
					username= ret.getString(1);
					uservary= "一般用户";
					userlist.add(new User(username,uservary));
				
				
				}
				String sql2="select username from keshe.saleruser";
				
					pst=conn.prepareStatement(sql2);
					ret=pst.executeQuery();
					while(ret.next())
					{
						username= ret.getString(1);
						uservary= "销售商";
						userlist.add(new User(username,uservary));
					
					}
			
		
					
				
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			return userlist;
			
		
	}
	public List<Message> javafxloadmessage()
	{
		
		String sql="select messagehead,messagesay from keshe.message";
		String messagehead="",messagesay="";
		
		ResultSet ret=null;

		
				     
			  
		
		
	
		List<Message> messagelist=new ArrayList<Message>();
		
		
		try 
		{
			pst=conn.prepareStatement(sql);
			ret=pst.executeQuery();
			
			while(ret.next())
			{
			
		
			
				messagehead= ret.getString(1);
				messagesay= ret.getString(2);
		
				messagelist.add(new Message(messagehead,messagesay));
				
			}
				
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			return messagelist;
			
		
	}
	
	public List<Order> javafxloadorder()
	{
		String sql="select bookname,bookprice from keshe.order";
		String bookname="",bookprice="";
		
		ResultSet ret=null;
		List<Order> orderlist=new ArrayList<Order>();
		
	
			try 
			{
				pst=conn.prepareStatement(sql);
				ret=pst.executeQuery();
				
				while(ret.next())
				{
				
					System.out.println("书名"+ret.getString(1));
					System.out.println("价格"+ret.getString(2));
				
					bookname= ret.getString(1);
					bookprice= ret.getString(2);
					orderlist.add(new Order(bookname,bookprice));
				
				}
			
				     
			
		
					
				
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			
			return orderlist;
		
	}
	
	
	public List<Leave> javafxloadleave()
	{
		String sql="select bookname,bookprice,bookleave,booksale from keshe.books";
		String bookname="",bookprice="",bookleave="",booksale="";
		
		ResultSet ret=null;
		List<Leave> leavelsit=new ArrayList<Leave>();
	
			try 
			{
				pst=conn.prepareStatement(sql);
				ret=pst.executeQuery();
				
				while(ret.next())
				{
				
					System.out.println("书名"+ret.getString(1));
					System.out.println("价格"+ret.getString(2));
				
					bookname= ret.getString(1);
					bookprice= ret.getString(2);
					bookleave= ret.getString(3);
					booksale= ret.getString(4);
					
					leavelsit.add(new Leave(bookname,bookprice,bookleave,booksale));
			
				}
			
				     
	
				
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			
			return leavelsit;
		
	}
	

	
}
