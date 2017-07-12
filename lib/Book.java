package package1;



public class Book {
 
private String   bookname;
 private double   bookprice;
 private int   bookid;
 private String   bookauthor;
public Book(String bookname, double bookprice, int bookid, String bookauthor) {
	super();
	this.bookname = bookname;
	this.bookprice = bookprice;
	this.bookid = bookid;
	this.bookauthor = bookauthor;
}

public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
public double getBookprice() {
	return bookprice;
}
public void setBookprice(double bookprice) {
	this.bookprice = bookprice;
}
public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}
public String getBookauthor() {
	return bookauthor;
}
public void setBookauthor(String bookauthor) {
	this.bookauthor = bookauthor;
}
 
 
}
