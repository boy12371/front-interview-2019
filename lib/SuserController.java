package package1;

import java.util.Scanner;

public class SuserController {
	
	
	

	


	private SuserModel suser;
	private SuserView suserview;
	private Book book;
	private Order order;
	private Message message;
	public SuserController() {
		this.suser = new SuserModel();
	
	}
	public SuserController(SuserModel suser, SuserView suserview, Book book, Order order, Message message) {
		super();
		this.suser = suser;
		this.suserview = suserview;
		this.book = book;
		this.order = order;
		this.message = message;
	}
	
	public SuserModel getSuser() {
		return suser;
	}



	public void setSuser(SuserModel suser) {
		this.suser = suser;
	}



	public SuserView getSuserview() {
		return suserview;
	}



	public void setSuserview(SuserView suserview) {
		this.suserview = suserview;
	}



	public Book getBook() {
		return book;
	}



	public void setBook(Book book) {
		this.book = book;
	}






	public void setOrder(Order order) {
		this.order = order;
	}




	
	public void updateView()
	{
		
	}
	
	
	
	public void getleftBook(String bookname)
	{
		
	}
	
	public void findOrder()
	{
		
	}
	

	public void addOrder()
	{
		
	}
	public void updateOrder()
	{
		
	}
	
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	
	
	
	public int login()
	{
		 String username;
		 String password;
		
		
		 Scanner input =new Scanner(System.in);
		
				 System.out.println("������ѡ�");
				 String option=input.next();
				if( option.equals("ע��"))
				{
					 System.out.println("�������û�����");
					username=input.next();
					 
					 System.out.println("���������룺");
					  password=input.next();
					  suser=new SuserModel(username,password);
					 this.setSuser(suser);
					 suser.sqlsave();
					 System.out.println("ע��ɹ�");
					 
					 return 0;
				}
				
				 System.out.println("�������û�����");
				  username=input.next();
				 
				 System.out.println("���������룺");
				  password=input.next();
				  suser=new SuserModel(username,password);
				
				  
				 if(suser.check()==1)
				 {
					 System.out.println("��½�ɹ�");
					 return 1;
				}
				 else
				 {
					 System.out.println("��¼ʧ��");
					 return 0;
				 }
					 
	}
	
	
	
	public void getOrder() {
		this.suser.getOrder();
	}
	
	public int register(String account,String password)
	{
		 return  this.suser.register(account,password);
	}
	public int login(String account,String password)
	{
		 return  this.suser.login(account,password);
	}
	
	
}
