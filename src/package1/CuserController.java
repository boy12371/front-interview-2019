package package1;

import net.sf.json.JSONObject;

public class CuserController {
	
	

	private CuserModel cuser;
	
	public CuserController()
	{
		this.cuser = new CuserModel();
	}
	public CuserController(CuserModel cuser) {
		super();
		this.cuser = cuser;
	
	}
	
	public CuserModel getCuser() {
		return cuser;
	}
	public void setCuser(CuserModel cuser) {
		this.cuser = cuser;
	}
	
	
	
	public void updateView()
	{
		
	}
	
	public JSONObject findBook(String bookname)
	{
		 return this.cuser.findBook(bookname);
	}
	
	public JSONObject lookBook()
	{
			return this.cuser.lookBook();
	}
	public void buyBook(String bookname)
	{
		this.cuser.buyBook(bookname);
	}
	
	public int commonregist(String account,String password)
	{
		 return  this.cuser.commonregist(account,password);
	}
	public int commonlogin(String account,String password)
	{
		 return  this.cuser.commonlogin(account,password);
	}
	public int salerregist(String account,String password)
	{
		 return  this.cuser.salerregist(account,password);
	}
	public int salerlogin(String account,String password)
	{
		 return  this.cuser.salerlogin(account,password);
	}
	
	public int mannageregist(String account,String password)
	{
		 return  this.cuser.mannageregist(account,password);
	}
	public int mannagelogin(String account,String password)
	{
		 return  this.cuser.commonlogin(account,password);
	}
	public int addcart(String bookname,String bookprice)
	{
		 return  this.cuser.addcart(bookname,bookprice);
	}
    public int addorder(String bookname,String bookprice)
    {
    	 return  this.cuser.addorder(bookname,bookprice);
    }
    public JSONObject loadcart( )
    {
    	 return  this.cuser.loadcart();
    }
    public JSONObject loadorder( )
    {
    	 return  this.cuser.loadorder();
    }
    public JSONObject loadleave( )
    {
    	 return  this.cuser.loadleave();
    }
    public JSONObject loadmessage( )
    {
    	 return  this.cuser.loadmessage();
    }
    public JSONObject loaduser( )
    {
    	 return  this.cuser.loaduser();
    }
    public int putmessage( String message)
    {
    	 return  this.cuser.putmessage(message);
    }
    public int putcommit(String commit ,String bookname)
    {
    	 return  this.cuser.putcommit(commit,bookname);
    }
    public JSONObject loadcommit(String bookname)
    {
    	
    	
    	return this.cuser.loadcommit(bookname);
    }
    public int delectmessage( String message)

    {
    	 return  this.cuser.delectmessage(message);
    }
    public int delectuser(String username)
    {
    	
    	
    	return this.cuser.delectuser(username);
    }

}
