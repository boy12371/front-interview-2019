package a123;

import java.io.IOException;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Pane {
GridPane gridpane=new GridPane();
private String username,pw,date,xuexiao,xueyuan,zhuanye,bianhao,lixiao,liuji;
//FileMain file=new FileMain();
//List<Visit> visitlist=null;
//ObservableList<Visit> data=null;

  public void menu()
  {
	  
    MenuBar menuBar = new MenuBar();
    AddEffect.setNodePin(menuBar);
    
    GridPane grid=new GridPane();
    GridPane gridstudent=getgridstudent();
    GridPane gridjiangli=getgridjiangli();
    GridPane gridxiugai=getgridxiugai();
    GridPane gridchaxun=getgridchaxun();
    GridPane gridshanchu=getgridshanchu();
    VBox gridtongji=getgridtongji();
    grid.setAlignment(Pos.CENTER );
    Text scenetitle=new Text("欢迎来到大学生档案管理系统");
	scenetitle.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
	Text actiontarget = new Text();  
    actiontarget.setId("actiontarget"); 
    
  
		
    Stage menu1Stage = new Stage();
    Scene menu1Scene = new Scene(gridpane,500,500);
    

    Menu fileMenu = new Menu("学生档案信息管理");
    MenuItem newMenuItem = new MenuItem("新建");
    MenuItem saveMenuItem = new MenuItem("删除");
    MenuItem exitMenuItem = new MenuItem("退出");
    exitMenuItem.setOnAction(actionEvent -> Platform.exit());

    fileMenu.getItems().addAll(newMenuItem, saveMenuItem,
        new SeparatorMenuItem(), exitMenuItem);

    Menu webMenu = new Menu("档案入库");
    MenuItem htmMenuItem = new MenuItem("导入学生信息");
    htmMenuItem.setOnAction(new EventHandler<ActionEvent>(){
		public void handle(ActionEvent e){
			 actiontarget.setText("基本");
				gridstudent.setVisible(true);
				gridjiangli.setVisible(false);
				gridxiugai.setVisible(false);
				gridchaxun.setVisible(false);
				gridshanchu.setVisible(false);
				gridtongji.setVisible(false);
				fileMenu.hide();
		}
	});
    MenuItem dMenuItem = new MenuItem("处分与奖励");
    dMenuItem.setOnAction(new EventHandler<ActionEvent>(){
  		public void handle(ActionEvent e){
  			 actiontarget.setText("基本");
  				gridstudent.setVisible(false);
  				gridjiangli.setVisible(true);
  				gridxiugai.setVisible(false);
  				gridchaxun.setVisible(false);
  				gridshanchu.setVisible(false);
  				gridtongji.setVisible(false);
  				fileMenu.hide();
  		}
  	});
    webMenu.getItems().addAll(htmMenuItem,dMenuItem);
    
    Menu sqlMenu = new Menu("档案查询");
    MenuItem mysqlItem = new MenuItem("查询");
    mysqlItem.setOnAction(new EventHandler<ActionEvent>(){
  		public void handle(ActionEvent e){
  			 actiontarget.setText("基本");
  				gridstudent.setVisible(false);
  				gridjiangli.setVisible(false);
  				gridxiugai.setVisible(false);
  				gridchaxun.setVisible(true);
  				gridshanchu.setVisible(false);
  				gridtongji.setVisible(false);
  				fileMenu.hide();
  		}
  	});
    MenuItem msqlItem = new MenuItem("统计");
    msqlItem.setOnAction(new EventHandler<ActionEvent>(){
  		public void handle(ActionEvent e){
  			 actiontarget.setText("基本");
  				gridstudent.setVisible(false);
  				gridjiangli.setVisible(false);
  				gridxiugai.setVisible(false);
  				gridchaxun.setVisible(false);
  				gridshanchu.setVisible(false);
  				gridtongji.setVisible(true);
  				fileMenu.hide();
  		}
  	});
    sqlMenu.getItems().addAll(mysqlItem,msqlItem);
    
    Menu xgMenu = new Menu("档案修改");
    MenuItem aMenuItem = new MenuItem("修改");
    aMenuItem.setOnAction(new EventHandler<ActionEvent>(){
  		public void handle(ActionEvent e){
  			 actiontarget.setText("基本");
  				gridstudent.setVisible(false);
  				gridjiangli.setVisible(false);
  				gridxiugai.setVisible(true);
  				gridchaxun.setVisible(false);
  				gridshanchu.setVisible(false);
  				gridtongji.setVisible(false);
  				fileMenu.hide();
  		}
  	});
    xgMenu.getItems().addAll(aMenuItem);
    Menu scMenu = new Menu("档案删除");
    MenuItem bMenuItem = new MenuItem("清除");
    bMenuItem.setOnAction(new EventHandler<ActionEvent>(){
  		public void handle(ActionEvent e){
  			 actiontarget.setText("基本");
  				gridstudent.setVisible(false);
  				gridjiangli.setVisible(false);
  				gridxiugai.setVisible(false);
  				gridchaxun.setVisible(false);
  				gridshanchu.setVisible(true);
  				gridtongji.setVisible(false);
  				fileMenu.hide();
  		}
  	});
    scMenu.getItems().addAll(bMenuItem);
    grid.add(menuBar, 0, 0, 2, 1);  
    gridpane.add(menuBar,0,1);
    gridpane.add(gridstudent,0,3);
    gridpane.add(gridjiangli,0,3);
    gridpane.add(gridxiugai,0,3);
    gridpane.add(gridchaxun,0,3);  
    gridpane.add(gridshanchu, 0, 3);
    gridpane.add(gridtongji,0,3);
    gridstudent.setVisible(false);
    gridjiangli.setVisible(false);
    gridchaxun.setVisible(false);
    gridxiugai.setVisible(false);                 
    gridshanchu.setVisible(false); 
    gridtongji.setVisible(false);
    menu1Stage.setScene(menu1Scene);
    menu1Stage.show();
    menu1Stage.setTitle("用户");
    menuBar.getMenus().addAll(fileMenu, webMenu, sqlMenu,xgMenu,scMenu);
    

  }
  public GridPane getgridstudent()
  {
  	GridPane grid=new GridPane();
  	AddEffect.setNodePink(grid);
  	 String[] type={"是","否"};
	 ComboBox<String> cbo=new ComboBox<>();
	 ObservableList<String> items=FXCollections.observableArrayList(type);
	 ComboBox<String> cb=new ComboBox<>();
	 ObservableList<String> item=FXCollections.observableArrayList(type);
	 cb.getItems().addAll(item);
	 grid.setHgap(10);
	 grid.setVgap(10);
	 grid.setPadding(new Insets(25,25,25,25));
	 cbo.getItems().addAll(items);
	 Label userName=new Label("姓名:");
	 grid.add(userName,0,1);
	 TextField userTextField=new TextField();
	 grid.add(userTextField,1,1);
	 Label pw=new Label("身份证号：");
	 grid.add(pw,0,2);
	 TextField pwBox=new TextField();
	 grid.add(pwBox,1,2);
	 Label date=new Label("入学年份");
	 grid.add(date,0,3);
	 TextField a=new TextField();
	 grid.add(a,1,3);
      Label xingbie=new Label("性别：");
      grid.add(xingbie,2,1);
      TextField b=new TextField();
      grid.add(b,3,1);
      Label xuehao=new Label("学号：");
      grid.add(xuehao,2,2);
      TextField c=new TextField();
      grid.add(c,3,2);
      Label xueyuan=new Label("学院：");
      grid.add(xueyuan,2,3);
      TextField d=new TextField();
      grid.add(d,3,3);
      Label zhuanye=new Label("专业：");
      grid.add(zhuanye,2,4);
      TextField e=new TextField();
      grid.add(e,3,4);
      Label bianhao=new Label("档案编号：");
      grid.add(bianhao,0,4);
      TextField f=new TextField();
      grid.add(f,1,4);
      Label liuji=new Label("留级：");
      grid.add(liuji,0,5);
      TextField g=new TextField();
      grid.add(cbo,1,5);
      Label lixiao=new Label("离校：");
      grid.add(lixiao,0,6);
      TextField h=new TextField();
      grid.add(cb,1,6);
      

      Button btn=new Button("保存");
      
      Button bt=new Button("关闭");
      HBox hbBtn=new HBox(10);
      VBox hhBtn=new VBox(10);
      hbBtn.getChildren().add(btn);
      hhBtn.getChildren().add(bt);
      grid.add(hhBtn,0,10);
      grid.add(hbBtn,3,10);
      GridPane.setHalignment(bt,HPos.LEFT);
      Text actiontarget = new Text();  
      actiontarget.setId("actiontarget"); 
      
      /* btn.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				String number1=number.getText();
				String name1=name.getText();
				String cbo1=cbo.getValue();
				String time1=time.getText();
				String school1=school.getText();
				String major1=major.getText();
				file.addstudent(number1, name1, cbo1, time1, school1, major1);
				 actiontarget.setText("确定");
				}
		});
		 bt.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				 actiontarget.setText("关闭");
				System.exit(0);
			}
		});*/
		
      final Text actionarget=new Text();
      grid.add(actionarget,1,6);
      return grid;
  		

  	}
  public GridPane getgridjiangli()
  {
	  GridPane grid=new GridPane();
	  grid.setHgap(5);
	  grid.setVgap(5);
	  Label jiangli1=new Label("奖励:");
	  grid.add(jiangli1,1,1);
	  TextArea o=new TextArea();
	  grid.add(o,2,1);
	  Label chufen1=new Label("处分:");
	  grid.add(chufen1,1,4);
	  TextArea p =new TextArea();
	  grid.add(p,2,4);
	  Button bt=new Button("保存");
	  HBox Btn=new HBox(10);
		Btn.setAlignment(Pos.BOTTOM_RIGHT);
		Btn.getChildren().add(bt);
		grid.add(Btn,3,6);
	   
	  return grid;
  }
  
  public GridPane getgridchaxun()
  {
	  GridPane grid=new GridPane();
	  grid.setHgap(10);
	  grid.setVgap(10);
		 
	  Text scenetitle=new Text("档案查询");
		scenetitle.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
		grid.add(scenetitle,0,0,2,1);
		
		grid.setPadding(new Insets(25,25,25,25));
		Label userName=new Label("请输入姓名或档案编号或学号:");
		grid.add(userName,0,1);
		TextField userTextField=new TextField();
		grid.add(userTextField,1,1);
		Button btn=new Button("查询");
	    Button bt=new Button("退出");
	    
		HBox hbBtn=new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		
		hbBtn.getChildren().add(bt);
		grid.add(hbBtn,1,4);
		final Text actiontarget=new Text();
	    grid.add(actiontarget,1,6);
	    
		
	
	  return grid;
  }
  public GridPane getgridshanchu()
  {
	  GridPane grid=new GridPane();
	  grid.setHgap(10);
	  grid.setVgap(10);
		 
	  Text scenetitle=new Text("档案查询");
		scenetitle.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
		grid.add(scenetitle,0,0,2,1);
		
		grid.setPadding(new Insets(25,25,25,25));
		Label userName=new Label("请输入姓名或档案编号或学号:");
		grid.add(userName,0,1);
		TextField userTextField=new TextField();
		grid.add(userTextField,1,1);
		Button btn=new Button("删除");
	    Button bt=new Button("退出");
	    
		HBox hbBtn=new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		
		hbBtn.getChildren().add(bt);
		grid.add(hbBtn,1,4);
		final Text actiontarget=new Text();
	    grid.add(actiontarget,1,6);
		
	   
		
	  return grid;
  }
  public GridPane getgridxiugai()
  {
	  GridPane grid=new GridPane();
	  
	  return grid;
  }
  private VBox getgridtongji()
  {
	    
		VBox vBox=new VBox();
		
		vBox.setPadding(new Insets(10,10,10,10));
		TableView table=new TableView();
		AddEffect.setNodePin(table);
		TableColumn tc1=new TableColumn("姓名");
		tc1.setCellValueFactory( new PropertyValueFactory<>("Name"));
		tc1.setMinWidth(50);
		TableColumn tc2=new TableColumn("档案编号");
		tc2.setMinWidth(50);
		tc2.setCellValueFactory( new PropertyValueFactory<>("bianhao"));
		TableColumn tc3=new TableColumn("学院");
		tc3.setMinWidth(50);
		tc3.setCellValueFactory( new PropertyValueFactory<>("xueyuan"));
		TableColumn tc4=new TableColumn("留级");
		tc4.setMinWidth(50);
		tc4.setCellValueFactory( new PropertyValueFactory<>("liuji"));
		TableColumn tc5=new TableColumn("离校");
		tc4.setMinWidth(50);
		tc4.setCellValueFactory( new PropertyValueFactory<>("lixiao"));
		
		table.getColumns().addAll(tc1,tc2,tc3,tc4,tc5);
		vBox.getChildren().addAll(table);
		
		//table.setItems(data);
		
		
		return vBox;
  }
}
