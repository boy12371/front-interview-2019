package package1;

import java.io.Serializable;



public class Order implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	String name=null;
	String price=null;

  public Order(String name, String price)
  {
	  this.name=name;
      this.price=price;
  }
  public void setOrdernumber(String price)
  {
	  this.price=price;
  }
  public String getOrdernumber()
  {
  	return price;
  }
  public String getBookname() {
	  return name;
  }

  public void setBookname(String name) {
	  this.name=name;
  }
  

}