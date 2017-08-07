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
    Text scenetitle=new Text("��ӭ������ѧ����������ϵͳ");
	scenetitle.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
	Text actiontarget = new Text();  
    actiontarget.setId("actiontarget"); 
    
  
		
    Stage menu1Stage = new Stage();
    Scene menu1Scene = new Scene(gridpane,500,500);
    

    Menu fileMenu = new Menu("ѧ��������Ϣ����");
    MenuItem newMenuItem = new MenuItem("�½�");
    MenuItem saveMenuItem = new MenuItem("ɾ��");
    MenuItem exitMenuItem = new MenuItem("�˳�");
    exitMenuItem.setOnAction(actionEvent -> Platform.exit());

    fileMenu.getItems().addAll(newMenuItem, saveMenuItem,
        new SeparatorMenuItem(), exitMenuItem);

    Menu webMenu = new Menu("�������");
    MenuItem htmMenuItem = new MenuItem("����ѧ����Ϣ");
    htmMenuItem.setOnAction(new EventHandler<ActionEvent>(){
		public void handle(ActionEvent e){
			 actiontarget.setText("����");
				gridstudent.setVisible(true);
				gridjiangli.setVisible(false);
				gridxiugai.setVisible(false);
				gridchaxun.setVisible(false);
				gridshanchu.setVisible(false);
				gridtongji.setVisible(false);
				fileMenu.hide();
		}
	});
    MenuItem dMenuItem = new MenuItem("�����뽱��");
    dMenuItem.setOnAction(new EventHandler<ActionEvent>(){
  		public void handle(ActionEvent e){
  			 actiontarget.setText("����");
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
    
    Menu sqlMenu = new Menu("������ѯ");
    MenuItem mysqlItem = new MenuItem("��ѯ");
    mysqlItem.setOnAction(new EventHandler<ActionEvent>(){
  		public void handle(ActionEvent e){
  			 actiontarget.setText("����");
  				gridstudent.setVisible(false);
  				gridjiangli.setVisible(false);
  				gridxiugai.setVisible(false);
  				gridchaxun.setVisible(true);
  				gridshanchu.setVisible(false);
  				gridtongji.setVisible(false);
  				fileMenu.hide();
  		}
  	});
    MenuItem msqlItem = new MenuItem("ͳ��");
    msqlItem.setOnAction(new EventHandler<ActionEvent>(){
  		public void handle(ActionEvent e){
  			 actiontarget.setText("����");
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
    
    Menu xgMenu = new Menu("�����޸�");
    MenuItem aMenuItem = new MenuItem("�޸�");
    aMenuItem.setOnAction(new EventHandler<ActionEvent>(){
  		public void handle(ActionEvent e){
  			 actiontarget.setText("����");
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
    Menu scMenu = new Menu("����ɾ��");
    MenuItem bMenuItem = new MenuItem("���");
    bMenuItem.setOnAction(new EventHandler<ActionEvent>(){
  		public void handle(ActionEvent e){
  			 actiontarget.setText("����");
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
    menu1Stage.setTitle("�û�");
    menuBar.getMenus().addAll(fileMenu, webMenu, sqlMenu,xgMenu,scMenu);
    

  }
  public GridPane getgridstudent()
  {
  	GridPane grid=new GridPane();
  	AddEffect.setNodePink(grid);
  	 String[] type={"��","��"};
	 ComboBox<String> cbo=new ComboBox<>();
	 ObservableList<String> items=FXCollections.observableArrayList(type);
	 ComboBox<String> cb=new ComboBox<>();
	 ObservableList<String> item=FXCollections.observableArrayList(type);
	 cb.getItems().addAll(item);
	 grid.setHgap(10);
	 grid.setVgap(10);
	 grid.setPadding(new Insets(25,25,25,25));
	 cbo.getItems().addAll(items);
	 Label userName=new Label("����:");
	 grid.add(userName,0,1);
	 TextField userTextField=new TextField();
	 grid.add(userTextField,1,1);
	 Label pw=new Label("���֤�ţ�");
	 grid.add(pw,0,2);
	 TextField pwBox=new TextField();
	 grid.add(pwBox,1,2);
	 Label date=new Label("��ѧ���");
	 grid.add(date,0,3);
	 TextField a=new TextField();
	 grid.add(a,1,3);
      Label xingbie=new Label("�Ա�");
      grid.add(xingbie,2,1);
      TextField b=new TextField();
      grid.add(b,3,1);
      Label xuehao=new Label("ѧ�ţ�");
      grid.add(xuehao,2,2);
      TextField c=new TextField();
      grid.add(c,3,2);
      Label xueyuan=new Label("ѧԺ��");
      grid.add(xueyuan,2,3);
      TextField d=new TextField();
      grid.add(d,3,3);
      Label zhuanye=new Label("רҵ��");
      grid.add(zhuanye,2,4);
      TextField e=new TextField();
      grid.add(e,3,4);
      Label bianhao=new Label("������ţ�");
      grid.add(bianhao,0,4);
      TextField f=new TextField();
      grid.add(f,1,4);
      Label liuji=new Label("������");
      grid.add(liuji,0,5);
      TextField g=new TextField();
      grid.add(cbo,1,5);
      Label lixiao=new Label("��У��");
      grid.add(lixiao,0,6);
      TextField h=new TextField();
      grid.add(cb,1,6);
      

      Button btn=new Button("����");
      
      Button bt=new Button("�ر�");
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
				 actiontarget.setText("ȷ��");
				}
		});
		 bt.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				 actiontarget.setText("�ر�");
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
	  Label jiangli1=new Label("����:");
	  grid.add(jiangli1,1,1);
	  TextArea o=new TextArea();
	  grid.add(o,2,1);
	  Label chufen1=new Label("����:");
	  grid.add(chufen1,1,4);
	  TextArea p =new TextArea();
	  grid.add(p,2,4);
	  Button bt=new Button("����");
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
		 
	  Text scenetitle=new Text("������ѯ");
		scenetitle.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
		grid.add(scenetitle,0,0,2,1);
		
		grid.setPadding(new Insets(25,25,25,25));
		Label userName=new Label("�����������򵵰���Ż�ѧ��:");
		grid.add(userName,0,1);
		TextField userTextField=new TextField();
		grid.add(userTextField,1,1);
		Button btn=new Button("��ѯ");
	    Button bt=new Button("�˳�");
	    
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
		 
	  Text scenetitle=new Text("������ѯ");
		scenetitle.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
		grid.add(scenetitle,0,0,2,1);
		
		grid.setPadding(new Insets(25,25,25,25));
		Label userName=new Label("�����������򵵰���Ż�ѧ��:");
		grid.add(userName,0,1);
		TextField userTextField=new TextField();
		grid.add(userTextField,1,1);
		Button btn=new Button("ɾ��");
	    Button bt=new Button("�˳�");
	    
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
		TableColumn tc1=new TableColumn("����");
		tc1.setCellValueFactory( new PropertyValueFactory<>("Name"));
		tc1.setMinWidth(50);
		TableColumn tc2=new TableColumn("�������");
		tc2.setMinWidth(50);
		tc2.setCellValueFactory( new PropertyValueFactory<>("bianhao"));
		TableColumn tc3=new TableColumn("ѧԺ");
		tc3.setMinWidth(50);
		tc3.setCellValueFactory( new PropertyValueFactory<>("xueyuan"));
		TableColumn tc4=new TableColumn("����");
		tc4.setMinWidth(50);
		tc4.setCellValueFactory( new PropertyValueFactory<>("liuji"));
		TableColumn tc5=new TableColumn("��У");
		tc4.setMinWidth(50);
		tc4.setCellValueFactory( new PropertyValueFactory<>("lixiao"));
		
		table.getColumns().addAll(tc1,tc2,tc3,tc4,tc5);
		vBox.getChildren().addAll(table);
		
		//table.setItems(data);
		
		
		return vBox;
  }
}
