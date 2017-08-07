package a123;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class denglu extends Application
{
	
	public String name;
	public String password;
	String a,c,d;
	String b;
	
	@Override
	public void start(Stage primaryStage)throws Exception
	{
		
		java.io.File file=new java.io.File("message.txt");
		PrintWriter output=new PrintWriter(file);
		Scanner input=new Scanner(file);
		while(input.hasNext())
		{
			String a=input.next();
			String b=input.next();
			String c=input.next();
			String d=input.next();
			System.out.println(a+""+b+""+c+""+d+"");
		}
		input.close();
		primaryStage.setTitle("大学生档案管理系统");//标题
		StackPane pane=new StackPane();
		GridPane grid=new GridPane();//创建一个二维网格的面板
		AddEffect.setNodeBlue(grid);
	//	Image image=new Image("xiaosi/i.jpg");
		//pane.getChildren().add(new ImageView(image));
		pane.getChildren().add(grid);

	
		Text scenetitle=new Text("欢迎");
		scenetitle.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
		grid.add(scenetitle,0,0,2,1);
		Label userName=new Label("用户名:");
		grid.add(userName,0,1);
		TextField userTextField=new TextField();
		grid.add(userTextField,1,1);
		Label pw=new Label("密码：");
		grid.add(pw,0,2);
		PasswordField pwBox=new PasswordField();
		grid.add(pwBox,1,2);
		grid.setPadding(new Insets(25,25,25,25));
		grid.setAlignment(javafx.geometry.Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		Button btn=new Button("登录");
	    Button bt=new Button("注册");
	    
		HBox hbBtn=new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		
		hbBtn.getChildren().add(bt);
		grid.add(hbBtn,1,4);
		Label label1=new Label("注册成功");
		label1.setVisible(false);
		grid.add(label1,1,5);
		Label label2=new Label("注册失败，请填写账号和密码");
		label2.setVisible(false);
		grid.add(label2,1,5);
		final Text actiontarget=new Text();
        grid.add(actiontarget,1,6);
       
        	btn.setOnAction(new EventHandler<ActionEvent>()
        	{
			public void handle(ActionEvent e)
			{
				
					 Main tp=new Main();
					 tp.menu();
					 primaryStage.close();
			  
			}
			});
        bt.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent e)
			{
			String name=userTextField.getText();
			String password=pwBox.getText();
			output.println("name "+name);
			output.println("password "+password);
			output.close();
			if(name==null||password==null||name.equals("")||password.equals(""))
			{
				label2.setVisible(true);
				 label1.setVisible(false);
			}
			else  
				
			{
				label1.setVisible(true);
				 label2.setVisible(false);
			}
				
			}
			});
    	Scene scene=new Scene(pane);
		primaryStage.setScene(scene);
		
		primaryStage.show();
    
	}
	
	
	
		
public static void main(String[] args)
{
		Application.launch(args);

}

}
