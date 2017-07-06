package package1;

import java.sql.Date;

public class Message {	

	private  String message;
	private Date messagetime;
	public Message(String message, Date messagetime) {
		super();
		this.message = message;
		this.messagetime = messagetime;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getMessagetime() {
		return messagetime;
	}
	public void setMessagetime(Date messagetime) {
		this.messagetime = messagetime;
	}
}
