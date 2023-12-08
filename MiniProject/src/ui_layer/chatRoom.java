package ui_layer;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class chatRoom extends StackPane {

	private VBox rootBox = null;
	private MenuBar menuBar = null;
	private HBox mainBox = null;
	private VBox graphBox = null;
	private VBox buttonBox1 = null;
	private VBox buttonBox2 = null;

	public chatRoom(Stage theStage) {
		
		//Create layout
		createLayout();
		
		Scene scene = new Scene(this);
		theStage.setScene(scene);
		theStage.setTitle("FindMeWork");
		theStage.show();
	}
	
	private void createLayout() {
		//screen sizes
		this.setMinSize(900, 450);
		this.setAlignment(Pos.CENTER);
		
		this.rootBox = new VBox();
		this.mainBox = new HBox();
		
		this.createMenu();
		///this.createUserButtons();
		
		//Initiate roots
		//this.mainBox.getChildren().addAll(buttonBox1, graphBox, buttonBox2);
		
		this.rootBox.getChildren().addAll(menuBar, mainBox);
		
		this.getChildren().addAll(rootBox);
	}
	
	private void createMenu() {
		this.menuBar = new MenuBar();

			
		Menu menu2 = new Menu("Users");
			MenuItem menu2Item2 = new MenuItem("Create a new user");
			menu2Item2.setOnAction(e -> {
				//display form to capture new user information
				//this.regPane = new RegisterForm(new Stage());
			});
			
			menu2.getItems().addAll(menu2Item2);
			
		this.menuBar.getMenus().addAll( menu2);
	}
}
