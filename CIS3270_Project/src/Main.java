
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	Stage main_window, signUp_window, login_window;
	Scene lobby, main_scene;
	
	public static void main(String[] args){
		launch(args);
	}
	

	@Override
	public void start(Stage main_window) throws Exception {
		
		Label header = new Label("Flights Galore");
		Button loginButton = new Button("Login");
		Button signUpButton = new Button("Sign Up");

		main_window.setTitle("Flights Galore");
		loginButton.setOnAction(e -> LoginWindow.display());		
		signUpButton.setOnAction(e -> SignUpWindow.display());
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		//set constraints
		GridPane.setConstraints(loginButton, 4,4);
		GridPane.setConstraints(header, 4, 3);
		
		//add to scene
		grid.getChildren().addAll(header, loginButton, signUpButton);

		
		
		Scene scene = new Scene(grid, 300, 500);
		main_window.setScene(scene);
		main_window.show();
		
		
		
	}

}
