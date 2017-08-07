package package1;

import java.util.ArrayList;
import java.util.List;


import javax.swing.text.Document;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Callback;

import package1.Javafxshow.shanchushow;
import package1.Javafxshow.shanchushow2;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.cell.CheckBoxTableCell;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class Javasalershow extends Application 
{
	
	//private CuserModel cuser=new CuserModel();
	
	private static  List<Order> orderlist=null;
	FileMain filemain=new FileMain();
	public static void main(String[] args)
	{
		Application.launch(args);
	}
	@Override
	public void start(Stage primaryStage)
	{
		
	
		
MenuBar menuBar = new MenuBar();
		
GridPane   gridpane=new GridPane();
GridPane gridorder=getorderpane(primaryStage);
GridPane gridleave=getleave();
GridPane gridputmessage=getputmessage();
		
	    Menu menuFile = new Menu("订单");           
	    
	    Menu add=new Menu("订单管理 ");
	  
	    add.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
			
				
				gridorder.setVisible(true);
				gridleave.setVisible(false);
				gridputmessage.setVisible(false);
				 menuFile.hide();
			}
		});
	  
	    menuFile.getItems().addAll(add);
	    	
	    Menu menuEdit = new Menu("库存");                 
	    Menu add1=new Menu("库存管理");
	  
	   
	   
	    menuEdit.getItems().addAll(add1);
	
	    add1.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				gridorder.setVisible(false);
				gridleave.setVisible(true);
				gridputmessage.setVisible(false);
				 menuEdit.hide();
				 
			}
		});
	   
	    Menu menumessage = new Menu("留言");                 
	    Menu message1=new Menu("发布留言");
	  
	   
	   
	    menumessage.getItems().addAll(message1);
	
	    message1.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				gridorder.setVisible(false);
				gridleave.setVisible(false);
				gridputmessage.setVisible(true);
				 menuEdit.hide();
				 
			}
		});
	 
	   
	   
	   
	   

	 
	    menuBar.getMenus().addAll(menuFile, menuEdit,menumessage);
	 
	
	    
	    gridpane.add(menuBar,0,2);
	    gridpane.add(gridorder,0,3);
	    gridpane.add(gridputmessage,0,3);
	    gridpane.add(gridleave,0,3);
	    
	    gridleave.setVisible(false);
	    gridputmessage.setVisible(false);
	  //  gridorder.setVisible(false);
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		Scene scene =new Scene(gridpane,primaryScreenBounds.getWidth(),primaryScreenBounds.getHeight()-30);
	   
		
		primaryStage.setScene(scene);
		primaryStage.show();
		   System.out.println("333");
	
	}
	public GridPane getorderpane(Stage primaryStage)
	{
		GridPane grid=new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setHgap(10);
		grid.setVgap(10);
		Label label=new Label("订单管理");
		label.setFont(new Font("Times New Roman",20));
		grid.add(label,0,0);
		grid.add(getVBoxorder( primaryStage), 0, 1);
		
		return grid;
	}
	public GridPane getleave()
	{
		GridPane grid=new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setHgap(10);
		grid.setVgap(10);
		Label label=new Label("库存管理");
		label.setFont(new Font("Times New Roman",20));
		grid.add(label,0,0);
		grid.add(getVBoxleave(), 0, 1);
		
		return grid;
	}
	public GridPane getputmessage()
	{
		GridPane grid=new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setHgap(10);
		grid.setVgap(10);
		Label label=new Label("发布留言");
		label.setFont(new Font("Times New Roman",20));
		grid.add(label,0,0);
		TextArea text=new TextArea();
		
		grid.add(text, 5, 1);
		Button submit=new Button("发送");
		submit.setMaxWidth(1000);
		submit.setMaxHeight(100);
		grid.add(submit, 5, 3);
		submit.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
			String textsay=	text.getText();
		//	cuser.putmessage(textsay);
				 
			}
		});
		
		return grid;
	}
	@SuppressWarnings("unchecked")
	private VBox getVBoxorder(Stage  primaryStage)
	{
		   ObservableList<Order> data =
		        FXCollections.observableArrayList();
		   orderlist=filemain.getorder();
	//	orderlist=cuser.javafxloadorder();
		data.addAll(orderlist);
		VBox vBox=new VBox();
		vBox.setPadding(new Insets(10,10,10,10));
		TableView table=new TableView();
		TableColumn tc1=new TableColumn("书名");
		tc1.setMinWidth(400);
		tc1.setCellValueFactory( new PropertyValueFactory<>("Bookname"));
		TableColumn tc2=new TableColumn("价格");
		tc2.setMinWidth(400);
		tc2.setCellValueFactory( new PropertyValueFactory<>("Ordernumber"));
		
		TableColumn tc3=new TableColumn("操作");
		tc3.setMinWidth(400);
		
		tc3.setCellFactory(new Callback<TableColumn<Order, Boolean>, TableCell<Order, Boolean>>()
        {
            public TableCell<Order, Boolean> call(TableColumn<Order, Boolean> p) 
            {
            	 return new shanchushow3(primaryStage,table,data);
            }

        });
		
		
		table.getColumns().addAll(tc1,tc2,tc3);
		vBox.getChildren().addAll(table);
		
		table.setItems(data);
		return vBox;
	}
	static class shanchushow3 extends TableCell<Order, Boolean> 
	    {
	            final Button button = new Button("删除");
	       	 static ArrayList<Button> buttonlist=new  ArrayList<Button>();
	            shanchushow3(Stage r,TableView table, ObservableList<Order> data)
	            {
	            	button.setOnAction(e->shan(r,table,data));
	            }

	            private void shan(Stage stage,TableView table, ObservableList<Order> data) 
	            {
	                int size=   orderlist.size();
	 	           
	            	
	                orderlist.remove(0); 
	   	           data.clear();
	   	           data.addAll(orderlist);
	   	           table.setItems(data);
	   	           int buttonsize=   buttonlist.size();
	   	           buttonlist.get(buttonsize-1).setVisible(false);
	   	      System.out.println(buttonlist.indexOf(button));
	   	           // 	this.getTableRow().re
	   	            
	   	    		//	getTableRow().setVisible(false);
	   	    		}

	    		protected void updateItem(Boolean t, boolean empty) {
	                super.updateItem(t, empty);
	                if(!empty){
	                   	buttonlist.add(button);
	                    setGraphic(button);
	                }
	            }
	    }
	private VBox getVBoxleave()
	{
		

		   ObservableList<Leave> data =
		        FXCollections.observableArrayList();
		   data.addAll(filemain.getleave());
	//	data.addAll(cuser.javafxloadleave());
		VBox vBox=new VBox();
		vBox.setPadding(new Insets(10,10,10,10));
		TableView table=new TableView();
		TableColumn tc1=new TableColumn("书名");
		tc1.setMinWidth(300);
		tc1.setCellValueFactory( new PropertyValueFactory<>("Bookname"));
		
		TableColumn tc2=new TableColumn("价格");
		tc2.setMinWidth(300);
		tc2.setCellValueFactory( new PropertyValueFactory<>("Bookprice"));
		
		TableColumn tc3=new TableColumn("库存");
		tc3.setMinWidth(300);
		
		tc3.setCellValueFactory( new PropertyValueFactory<>("Leave"));
		TableColumn tc4=new TableColumn("销量");
		tc4.setMinWidth(300);
		
		tc4.setCellValueFactory( new PropertyValueFactory<>("Sale"));
	
	
		
	
     
		table.getColumns().addAll(tc1,tc2,tc3,tc4);
		vBox.getChildren().addAll(table);
		
		table.setItems(data);
		return vBox;
	}

}  
 