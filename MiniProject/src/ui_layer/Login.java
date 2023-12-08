package ui_layer;

import data_layer.dataReader;
import data_layer.dataWriter;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import user_layer.User;

public class Login extends StackPane  {

	
	private VBox rootBox = null;
	private Button btnLogin = null;
	
	private TextField txtEmail = null;
	private TextField txtPassword = null;
	
	public Login(Stage regStage) {
		//create Layout
		createLayout();
		
		//Event hander for save user button
		checkUser(regStage);
		
		//set stage
		regStage.setTitle("Login");
		regStage.setScene(new Scene(this));
		regStage.show();
		
		regStage.setOnHiding(e -> {
			regStage.close();
		});
	}
	
	

	private void createLayout() {
		// TODO Auto-generated method stub
		//set scene size
		this.setMinSize(350, 360);
		this.rootBox = new VBox();
		this.rootBox.setAlignment(Pos.TOP_CENTER);
		
		Label instruction = new Label("  Enter your login information ");
		
		//GridPane to hold host-name and port number Textfields and labels
		GridPane grdConnect = new GridPane();
		grdConnect.setMaxWidth(rootBox.getMinWidth());
		grdConnect.setVgap(10);
		grdConnect.setHgap(20);
		
		//Labels
		grdConnect.add(new Label(""), 0, 0);
		grdConnect.add(new Label("  Email   "), 0, 1);
		grdConnect.add(new Label(""), 3, 1);
		grdConnect.add(new Label("  Password	"), 0, 2);
		
		this.txtEmail = new TextField(null);
		txtEmail.setEditable(true);
		txtEmail.setMinWidth(250);
		
		this.txtPassword = new TextField(null);
		txtPassword.setEditable(true);
		txtPassword.setMinWidth(250);
		
		
		grdConnect.add(txtEmail, 1, 1);
		grdConnect.add(txtPassword, 1, 2);
		
		//Button to capture and store user information
		this.btnLogin = new Button();
		this.btnLogin.setText("Login");
		this.btnLogin.setMinWidth(250);
		
		grdConnect.add(this.btnLogin, 1, 9);
		
		//Add nodes Parent pane
		rootBox.getChildren().addAll(instruction, grdConnect);
		getChildren().add(rootBox);
	
	}
	
	private void checkUser(Stage regstage)
	{
		this.btnLogin.setOnAction(e -> {
			System.out.println("Login user...");
			Alert alert = new Alert(AlertType.ERROR);
			
			
			User nUser = dataReader.readData();
			if(nUser.Email == this.txtEmail.getText() && nUser.Password == Integer.parseInt(this.txtPassword.getText())) {
				System.out.println("Correct details");
				
				regstage.close();
			}else 
			{
				System.out.println("Correct details");
			}
			
			
			 
		});
	}

}
