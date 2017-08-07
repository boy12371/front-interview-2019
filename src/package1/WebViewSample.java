package package1;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import net.sf.json.JSONObject;
import netscape.javascript.JSObject;
 
 
public class WebViewSample extends Application {
    private Scene scene;
    private static Stage stage;
    @Override public void start(Stage stage) {
        // create the scene
    	this.stage=stage;
    	Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setTitle("Web View");
        Browser bros=new Browser();
        scene = new Scene(bros,primaryScreenBounds.getWidth()-0,primaryScreenBounds.getHeight()-30, Color.web("#666970"));
        stage.setScene(scene);
    //   scene.getStylesheets().add("css/bootstrap.min.css");        
        stage.show();
        stage.setResizable(false);
    //    javafxshow();
      
       // stage.setFullScreen(true);
    }
 
    public static void main(String[] args){
        launch(args);
    }
    
    public static  Stage getStage()
    {
    	
    	return stage;
    }
}
class Browser extends Region {
	
	private CuserController ccontro;
	private Javafxshow javafxshow ;
	private Javasalershow javasalershow ;
	
	private JSObject win;
    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();
     
    public Browser() {
    	   win
          = (JSObject) webEngine.executeScript("window");
    	  	win.setMember("app", new JavaApp());
    	
    	  	ccontro=new CuserController();
    	
    	       
        //apply the styles
        getStyleClass().add("browser");
        // load the web page
       // webEngine.load("http://localhost:8080/my/login.html");
        String url = getClass().getResource("html/login.html").toExternalForm();
        webEngine.load(url);
        //add the web view to the scene
        getChildren().add(browser);
        
     
 
    }
    
  
    
    private Node createSpacer() {
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        return spacer;
    }
    
    
    public class JavaApp {
    	  public void javafxshow()
    	    {
    	    	javafxshow=new Javafxshow();
    	    //	System.out.println((WebViewSample.getStage()).toString());
    	    	javafxshow.start(WebViewSample.getStage());
    	    }
    	    public void javasalershow()
    	    {
    	    	javasalershow=new Javasalershow();
    	    //	System.out.println((WebViewSample.getStage()).toString());
    	    	javasalershow.start(WebViewSample.getStage());
    	    }
        public void exit() {
            System.out.println("123");
            
        }
        public void change( )
        {
        	win.setMember("app", new JavaApp());
        }
        public int commonregist(String account,String password) {


         return	ccontro.commonregist(account,password);
            
        }
        
        public int commonlogin(String account,String password) {
        	 return	ccontro.commonlogin(account,password);
            
        }
        
        public int salerregist(String account,String password) {


            return	ccontro.salerregist(account,password);
               
           }
           
           public int salerlogin(String account,String password) {
           	 return	ccontro.salerlogin(account,password);
               
           }
        
        
        
        
        public int mannageregist(String account,String password) {
        	   return	ccontro.mannageregist(account,password);
        }
      
     
        public int mannagelogin(String account,String password) {
       	 return	ccontro.mannagelogin(account,password);
         
        }
        
        public JSONObject commonsearch(String bookname)
        {
        	
        	 return	ccontro.findBook( bookname);
        }
        public JSONObject lookbook()
        {
        	
        	 return	ccontro.lookBook();
        }
        
        public int addcart(String bookname,String bookprice)
        {
        	System.out.println("had add cart"+bookname);
        	return ccontro.addcart( bookname,bookprice);
        }
        public int addorder(String bookname,String bookprice)
        {
        	System.out.println("had add order");
        	
        	return ccontro.addorder( bookname,bookprice);
        }
        public void balance(JSONObject booklist)
        {
        	System.out.println("had add balance");
        	
        	//return ccontro.balance( bookname,bookprice);
        }
        public JSONObject loadcart()
        {
        	System.out.println("had add loadcart");
        	
        	return ccontro.loadcart( );
        }
        public JSONObject loadorder()
        {
        	System.out.println("had add loadorder");
        	
        	return ccontro.loadorder( );
        }
        public JSONObject loadleave()
        {
        	System.out.println("had add loadleave");
        	
        	return ccontro.loadleave( );
        }
        public JSONObject loadmessage()
        {
        	System.out.println("had add loadmessage");
        	
        	return ccontro.loadmessage( );
        }
        public int putmessage(String message)
        {
        	System.out.println("had add putmessage");
        	
        	return ccontro.putmessage( message);
        }
        public JSONObject loaduser()
        {
        	System.out.println("had add loaduser");
        	
        	return ccontro.loaduser( );
        }
        public int putcommit(String commit ,String bookname)
        {
        	System.out.println("had add putcommit");
        	
        	return ccontro.putcommit(  commit,bookname);
        }
        public JSONObject loadcommit(String bookname)
        {
        	System.out.println("had add loadcommit");
        	
        	return ccontro.loadcommit( bookname);
        }
        public int delectmessage(String message)
        {
        	System.out.println("had add delectmessage");
        	
        	return ccontro.delectmessage( message);
        }
        public int delectuser(String username)
        {
        	System.out.println("had add username");
        	
        	return ccontro.delectuser( username);
        }
        
      
        /*
         * 
        public int balance(String bookname,String bookprice)
        {
        	//return ccontro.balance( bookname,bookprice);
        }
        */
        
    }
    @Override protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        layoutInArea(browser,0,0,w,h,0, HPos.CENTER, VPos.CENTER);
    }
 
    @Override protected double computePrefWidth(double height) {
        return 900;
    }
 
    @Override protected double computePrefHeight(double width) {
        return 600;
    }
}
