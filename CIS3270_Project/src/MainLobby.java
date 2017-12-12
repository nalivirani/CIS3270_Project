
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
import java.awt.SplashScreen;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class MainLobby extends Application{
	Stage main_window, signUp_window, login_window;
	Scene lobby, main_scene;
	
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
		
		launch(args);
//		User us = new User();
//		
//		us.login("Admin234","P@s$w0Rd321");
//		us.getUserName();
//		us.getfName();
		
//		Flight f1 = new Flight();
//		LocalDate lc = LocalDate.of(2017, 12,  10);
		
//		ArrayList<Flight> arr = new ArrayList<>(f1.searchFlights("ATL", "ORD", lc));
		
//		if(arr.isEmpty()) {
//			System.out.println("It looks like we didn't find any flights matching your criteria. " +
//							   "Try your search again with a different city or departure date.");
//		}
//		
//		//f.updateArrDate(1, LocalDate.of(2017, 12, 25));
//		
//		else {
//			Iterator<Flight> i = arr.iterator();
//			while (i.hasNext()) {
//				System.out.print(i.next());
//			}
//		}

		
	}

	@Override
	public void start(Stage main_window) throws Exception {

		try { 
			Thread.sleep(300);
			
		}finally{}
//		catch (InterruptException ie) {
//			
//		}
		
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

