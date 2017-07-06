package package1;

import java.util.Date;

public class Order {

	
	private int  orderid;
	private Book book;
	private Date ordertime;
	public Order(int orderid, Book book, Date ordertime) {
		super();
		this.orderid = orderid;
		this.book = book;
		this.ordertime = ordertime;
	}
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
}
