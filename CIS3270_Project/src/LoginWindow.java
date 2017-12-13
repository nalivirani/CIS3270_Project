import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginWindow{
	
	static String username = "user";
	static String password = "pass";
	static int adm = 1;
	
	static boolean auth = false;

	public static void display(){
		
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Flights Galore");
		window.setMinWidth(600);
		window.setMinHeight(300);
		//Label label = new Label("Please Login");
		
		Button loginButton = new Button("Login");
		Button cancelButton = new Button("Cancel");
		Button forgotPassButton = new Button("Forgot Password");
		
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
		
		
		//Login action
		loginButton.setOnAction(e -> {
			User u = new User();
			u = u.getUser(usernameInput.getText());
			if(u.isNewUser(u.getUserName())){
				SignUpWindow.display();
			}else if(usernameInput.getText().equals(u.getUserName()) 
					&& passInput.getText().equals(u.getPassword()) && u.getPermissionLevel()==0){
				window.setScene(CustomerMenu.display(u));
			}else if(usernameInput.getText().equals(u.getUserName()) 
					&& passInput.getText().equals(u.getPassword()) && u.getPermissionLevel()==1){
				window.setScene(AdminMenu.display(u));
			}else{
				AlertBox1.display("Login Error", "Please check your credentials");
			}
//			if(xyz.getUsername() == usernameInput.getText() && xyz.getPassword() == passInput.getText() 
//					&& xyz.getPermissionLevel() == 0){
//				window.setScene(CustomerMenu.display());
//			}else if(xyz.getUsername() == usernameInput.getText() && xyz.getPassword() == passInput.getText() 
//					&& xyz.getPermissionLevel() == 1){
//				window.setScene(AdminMenu.display());
//			}else{
//				AlertBox1.display("Login Error", "Please try again");
//			}
			
//			if(username.equals(usernameInput.getText()) && password.equals(passInput.getText()) && adm == 0){
//				window.setScene(CustomerMenu.display());
//			}else if(username.equals(usernameInput.getText()) && password.equals(passInput.getText()) && adm == 1){
//				window.setScene(AdminMenu.display());
//			}else{
//				AlertBox1.display("Login Error", "Please check your credentials");
//			}
//			
			
			//window.close();
		});
		
		cancelButton.setOnAction(e -> window.close());
		
		//forgot pass action
		forgotPassButton.setOnAction(e -> RecoverPassword.display());

		
		GridPane.setConstraints(loginButton, 2, 3);
		GridPane.setConstraints(cancelButton, 3, 3);
		GridPane.setConstraints(forgotPassButton, 2, 4, 2, 2);
		
		grid.getChildren().addAll(usernameLabel, usernameInput, passLabel, passInput, 
				loginButton, cancelButton, forgotPassButton);

		Scene scene = new Scene(grid, 300,300);
		window.setScene(scene);
		window.showAndWait();
	}

}
