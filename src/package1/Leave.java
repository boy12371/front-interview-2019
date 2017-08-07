package package1;

import java.io.Serializable;



public class Leave implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name=null;
	String price=null;
	String leave=null;
	String saler=null;

 
  public Leave(String name, String price, String leave, String saler) {
	
		this.name = name;
		this.price = price;
		this.leave = leave;
		this.saler = saler;
	}

public String getBookname() {
      return this.name;
  }

  public void setBookname(String name) {
	  this.name = name;
  }
  public String getBookprice() {
	  return this.price;
  }

  public void setBookprice(String price) {
	  this.price = price;
  }
  
  
  public void setLeave(String leave)
  {
	  this.leave = leave;
	
  }
  public String getLeave()
  {
	  return this.leave;
  }



  public String getSale()
  {
	  return this.saler;
  }
  public void setSale(String saler)
  {
		this.saler = saler;
  }
}