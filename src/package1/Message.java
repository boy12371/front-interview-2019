package package1;

import java.io.Serializable;


public class Message implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7997208924977055468L;

	String name=null;
	
	String name2=null;
 
  public Message(String name, String name2)
  {
     
      this.name=name;
      this.name2=name2;
      
     
  }
  public String getUsername() {
      return this.name;
  }

  public void setUsername(String name) {
	  this.name=name;
  }
  
  public void setMessage(String name2)
  {
	   this.name2=name2;
	      
  }
  public String getMessage()
  {
	  return this.name2;
  }


}