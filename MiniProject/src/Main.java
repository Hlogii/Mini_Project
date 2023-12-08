//import gui_layer.MainForm;
import java.awt.Button;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import ui_layer.Login;
import ui_layer.chatRoom;
import ui_layer.registerForm;

public class Main extends Application {

	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
	/*	StackPane st = new StackPane();
		Button btn = new Button("Helllo");
		Scene scene = new Scene(st);
		primaryStage.setScene(scene);
		primaryStage.show(); */
		
		//registerForm  form = new registerForm(primaryStage);
		Login loginForm = new Login(primaryStage);
		
		chatRoom cr = new chatRoom(primaryStage);
	}

}
