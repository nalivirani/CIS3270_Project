
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.awt.SplashScreen;

public class MainLobby extends Application{
	Stage main_window, signUp_window, login_window;
	Scene lobby, main_scene;

	public static final Font ITALIC_FONT =
            Font.font(
            		"System Regular",
                    FontWeight.EXTRA_BOLD,
                    20
            );
	
	public static void main(String[] args){
		try {
			Thread.sleep(6200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
	        SplashScreen splashScreen = SplashScreen.getSplashScreen();//getSplashScreen();
	        if (splashScreen!=null) splashScreen.close();
	    } catch (Exception e) {}
//		
		launch(args);		
	}

	@Override
	public void start(Stage main_window) throws Exception {

		try { 
			Thread.sleep(300);
			
		}finally{}
		
		Text header = new Text("Flights Galore");
		
		GridPane.setHalignment(header, HPos.CENTER);
		GridPane.setValignment(header, VPos.CENTER);
		header.setFont(Font.font (20));
		
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
		GridPane.setConstraints(loginButton, 4,6);
		GridPane.setConstraints(signUpButton, 5,6);
		GridPane.setConstraints(header, 4, 3);
		
		//add to scene
		grid.getChildren().addAll(header, loginButton, signUpButton);
		
		Scene scene = new Scene(grid, 400, 500);
		main_window.setScene(scene);
		main_window.show();
		
	}
	
}

