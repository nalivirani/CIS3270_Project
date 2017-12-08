import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class LoginWindow{
	
	static String username;

	public static void display(){
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Login");
		window.setMinWidth(600);
		window.setMinHeight(300);
		Label label = new Label("Please Login");
		
		Button loginButton = new Button("Login");
		Button cancelButton = new Button("Cancel");
		
		GridPane grid = new GridPane();
		Insets ins = new Insets(10,10,10,10);
		grid.setPadding(ins);
		grid.setVgap(8);
		grid.setHgap(10);
		
		//name label
		Label usernameLabel = new Label("Username");
		GridPane.setConstraints(usernameLabel,0,0);
						
		//name input
		TextField usernameInput = new TextField();
		usernameInput.setPromptText("Username");
		GridPane.setConstraints(usernameInput, 1,0);
						
		//pass label
		Label passLabel = new Label("Password");
		GridPane.setConstraints(passLabel,0,1);
						
		//pass input
		TextField passInput = new TextField();
		passInput.setPromptText("Password");
		GridPane.setConstraints(passInput, 1, 1);
		
		loginButton.setOnAction(e -> {
			username = usernameInput.getText();
			window.close();
		});
		
		cancelButton.setOnAction(e -> window.close());
		
		GridPane.setConstraints(loginButton, 1, 2);
		GridPane.setConstraints(cancelButton, 1, 3);
		
		grid.getChildren().addAll(usernameLabel, usernameInput, passLabel, passInput, loginButton, cancelButton);

		Scene scene = new Scene(grid, 300,300);
		window.setScene(scene);
		window.showAndWait();
	}

}
