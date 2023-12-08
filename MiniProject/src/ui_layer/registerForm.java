package ui_layer;

import data_layer.dataWriter;
//import application_layer.DataWriter;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class registerForm extends StackPane {

	//Form elements
		private VBox rootBox = null;
		private Button btnRegister = null;
		
		private TextField txtName = null;
		private TextField txtSurname = null;
		private TextField txtEmail = null;
		private TextField txtContacts = null;
		private TextField txtPassword = null;
		//private ComboBox cmbStatus = null;
		
		public registerForm(Stage regStage) {
			//create Layout
			createLayout();
			
			//Event hander for save user button
			saveUser(regStage);
			
			//set stage
			regStage.setTitle("Register new user");
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
			
			Label instruction = new Label("  Enter new user information ");
			
			//GridPane to hold host-name and port number Textfields and labels
			GridPane grdConnect = new GridPane();
			grdConnect.setMaxWidth(rootBox.getMinWidth());
			grdConnect.setVgap(10);
			grdConnect.setHgap(20);
			
			//Labels
			grdConnect.add(new Label(""), 0, 0);
			grdConnect.add(new Label("  Name   "), 0, 1);
			grdConnect.add(new Label(""), 3, 1);
			grdConnect.add(new Label("  Surname	"), 0, 2);
			grdConnect.add(new Label(""), 3, 2);
			grdConnect.add(new Label("  Email	"), 0, 3);
			grdConnect.add(new Label(""), 3, 2);
			grdConnect.add(new Label("  Contacts  "), 0, 4);
			grdConnect.add(new Label(""), 3, 3);
			grdConnect.add(new Label("  Password  "), 0, 5);
	/*		grdConnect.add(new Label(""), 3, 3);
			grdConnect.add(new Label("  x cord  "), 0, 6);
			grdConnect.add(new Label(""), 3, 4);
			grdConnect.add(new Label("  y cord  "), 0, 7);
			grdConnect.add(new Label(""), 3, 5);
			grdConnect.add(new Label("  status  "), 0, 8);
			grdConnect.add(new Label(""), 0, 9); */
			
			//TextFields
			this.txtName = new TextField(null);
			txtName.setEditable(true);
			txtName.setMinWidth(250);
			
			this.txtSurname = new TextField(null);
			txtSurname.setEditable(true);
			txtSurname.setMinWidth(250);
			
			this.txtEmail = new TextField(null);
			txtEmail.setEditable(true);
			txtEmail.setMinWidth(250);
			
			this.txtContacts = new TextField(null);
			this.txtContacts.setEditable(true);
			this.txtContacts.setMinWidth(250);

			this.txtPassword = new TextField(null);
			this.txtPassword.setEditable(true);
			this.txtPassword.setMinWidth(250);
			
		/*	this.txtXLoc = new TextField(null);
			this.txtXLoc.setEditable(true);
			this.txtXLoc.setMinWidth(250);
			
			this.txtYLoc = new TextField(null);
			this.txtYLoc.setEditable(true);
			this.txtYLoc.setMinWidth(250);
			
			this.cmbStatus = new ComboBox();
			this.cmbStatus.setEditable(false);
			this.cmbStatus.setMinWidth(250);*/
				
				
			//adding textfields to grid
			grdConnect.add(txtName, 1, 1);
			grdConnect.add(txtSurname, 1, 2);
			grdConnect.add(txtEmail, 1, 3);
			grdConnect.add(txtContacts, 1, 4);
			grdConnect.add(txtPassword, 1, 5);
		//	grdConnect.add(txtXLoc, 1, 6);
			//grdConnect.add(txtYLoc, 1, 7);
		//	grdConnect.add(cmbStatus, 1, 8);
			
			//Button to capture and store user information
			this.btnRegister = new Button();
			this.btnRegister.setText("register");
			this.btnRegister.setMinWidth(150);
			
			grdConnect.add(this.btnRegister, 1, 9);
			
			//Add nodes Parent pane
			rootBox.getChildren().addAll(instruction, grdConnect);
			getChildren().add(rootBox);
		}
		
		private void saveUser(Stage regstage)
		{
			this.btnRegister.setOnAction(e -> {
				System.out.println("saving new user...");
				Alert alert = new Alert(AlertType.ERROR);
				
				if(dataWriter.AddNewRecord(this.txtName.getText(), this.txtSurname.getText(), this.txtEmail.getText(), Double.parseDouble(this.txtContacts.getText()), Integer.parseInt(this.txtPassword.getText())))
				{
					alert.setAlertType(AlertType.CONFIRMATION);
					alert.setContentText("New user successfully saved");
					alert.show();
					
					regstage.close();
				} 
			});
		}
}
