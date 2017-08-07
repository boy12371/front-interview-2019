package a123;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class chuangkou extends Pane {

	  public void tanchuang()
	  {
		  GridPane grid=new GridPane();
		  Stage menu1Stage = new Stage();
		    Scene menu1Scene = new Scene(grid,200,200);
		    menu1Stage.setScene(menu1Scene);
		    menu1Stage.show();
		    

}
}