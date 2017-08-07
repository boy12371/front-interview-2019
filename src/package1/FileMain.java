package package1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileMain {

  
    /*
    //反序列化对象
    
    */


	public static void main(String []args)
	{
		getuser();
	}
	
	public static void setuser()
	{
		try {
		
			
			  ObjectOutputStream outcommonuser= new ObjectOutputStream(new FileOutputStream("C:\\ProgramData\\commonuser.txt"));
			 for(int i=1;i<5;i++)
			{
				
				   outcommonuser.writeObject( new User("用户"+i, "一般用户"));    
				}
			for(int i=1;i<5;i++)
			{
				
				 
				   outcommonuser.writeObject( new User("用户"+i, "销售商"));    
			}
			outcommonuser.close();
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void setorder()
	{
		try {
			
			
			  ObjectOutputStream otuorder= new ObjectOutputStream(new FileOutputStream("C:\\ProgramData\\order.txt"));
			 for(int i=1;i<5;i++)
			{
				
				 otuorder.writeObject( new Order("java程序设计基础第"+i+"版", i*10+""));    
				}
		
			 otuorder.close();
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void setleave()
	{
		try {
			  ObjectOutputStream otuorder= new ObjectOutputStream(new FileOutputStream("C:\\ProgramData\\leave.txt"));
			for(int i=1;i<5;i++)
			{
			
	int leaveint=i*i*100-i*i*i*10;
				String leave=null;
				if(leaveint<=100)
					leave=leaveint+"(库存不足，需要补货)";
				else if(leaveint>=500)
					leave=leaveint+"(库存充足)";
				else  leave=leaveint+"";
				
			
				
				int saleint=i*i*300-i*200;
				String sale=null;
				if(saleint<100)
					sale=saleint+"(销量缓慢)";
				else   if(saleint>=2000)
					sale=saleint+"(销量冠军)";
				else  sale=saleint+"";
				
				otuorder.writeObject( new Leave("java程序设计基础第"+i+"版", i*10+"",leave,sale));    
		
			
			}
			
			otuorder.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}	
	public void setmessage()
	{
		try {
			  ObjectOutputStream otuorder= new ObjectOutputStream(new FileOutputStream("C:\\ProgramData\\message.txt"));
				 for(int i=1;i<5;i++)
				{
					
					 otuorder.writeObject( new Message("需要进货"+i+"本","已经进货"+i*5+"本"));   
					
					}
			
				 otuorder.close();
			
			
			
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static  List<User>  getuser()
	{
		List<User> userlist=new ArrayList<User>();
		try {
			setuser();
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\ProgramData\\commonuser.txt"));
			
		    try {
			//	System.out.println("obj1 " + (String) in.readObject());
		    	
		    	
				   while( true)
				    {
					   try{
						   User  user = (User) in.readObject();   
						   System.out.println(user.getUsername());
						   
						   
						   userlist.add(user);
					   }
					   catch(EOFException e){
						   System.out.println("111");
						    in.close();
						    return  userlist;
						 
						   
						   
					   }
					   
					
				    	
				    }
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    //读取字面值常量
		
		   //读取customer对象
		  
		  
		    in.close();
			
		
			
		
				
				
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return  userlist;
	}
	
	
	public  List<Order>  getorder()
	{
		List<Order> userlist=new ArrayList<Order>();
		try {
			
			setorder();
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\ProgramData\\order.txt"));
		    try {
			//	System.out.println("obj1 " + (String) in.readObject());
		    	
		    	
				   while( true)
				    {
					   try{
						   Order  order = (Order) in.readObject();   
						   System.out.println(order.getBookname());
						   userlist.add(order);
					   }
					   catch(EOFException e){
						   //已从流中读完。
						
						    in.close();
						    return  userlist;
						   }
					
					
				    	
				    }
			
					
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    //读取字面值常量
		
		   //读取customer对象
		  
		  
		    in.close();
			
		
			
		
				
				
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return  userlist;
	}
	
	public  List<Message>  getmessage()
	{
		List<Message> userlist=new ArrayList<Message>();
		try {
			
			setmessage();
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\ProgramData\\message.txt"));
		    try {
			//	System.out.println("obj1 " + (String) in.readObject());
		    	
		    	
				   while( true)
				    {
					   try{
						   Message  order = (Message) in.readObject();   
						   System.out.println(order.getUsername());
						   userlist.add(order);
					   }
					   catch(EOFException e){
						   //已从流中读完。
						
						    in.close();
						    return  userlist;
						   }
					
					
				    	
				    }
			
					
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    //读取字面值常量
		
		   //读取customer对象
		  
		  
		    in.close();
			
		
			
		
				
				
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return  userlist;
	}

	public  List<Leave>  getleave()
	{
		List<Leave> userlist=new ArrayList<Leave>();
		try {
			
			setleave();
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\ProgramData\\leave.txt"));
		    try {
			//	System.out.println("obj1 " + (String) in.readObject());
		    	
		    	
				   while( true)
				    {
					   try{
						   Leave  leave = (Leave) in.readObject();   
						   System.out.println(leave.getBookname());
						   userlist.add(leave);
					   }
					   catch(EOFException e){
						   //已从流中读完。
						
						    in.close();
						    return  userlist;
						   }
					
					
				    	
				    }
			
					
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    //读取字面值常量
		
		   //读取customer对象
		  
		  
		    in.close();
			
		
			
		
				
				
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return  userlist;
}
}