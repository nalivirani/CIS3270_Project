
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.VBox;

public class ConfirmSignUp {
	
	static boolean confirm = false; ;
	
	public static void display(User xyz){
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Sign up");
		window.setMinWidth(600);
		window.setMinHeight(600);
		
		String str = "~set permission level~";
		
		if(xyz.getPermissionLevel() == 1){
			str = "Admin";
			
		}else{
			str = "Customer";
		}
		
		Label fname = new Label("First Name: 	" + xyz.getfName());
		Label lname = new Label("Last Name: 	" + xyz.getlName());
		Label addr = new Label("Address: 	" + xyz.getAddress());
		Label zip = new Label("Zip Code: 	" + Integer.toString(xyz.getZip()));
		Label st = new Label("State: 	" + xyz.getState());
		Label email = new Label("Email: 	" + xyz.getEmail());
		Label usr = new Label("Username: 	" + xyz.getUserName());
		Label pss = new Label("Password: 	" + xyz.getPassword());
		Label ssn = new Label("Social Security Number: 	" + Integer.toString(xyz.getSsn()));
		Label secQ = new Label("Security Question: 	" + xyz.getSecurityQuestion());
		Label secA = new Label("Security Question: 	" + xyz.getSecurityAnswer());
		Label adm = new Label("Permission Level: 	" + str);
		
		Button editButton = new Button("Edit");
		editButton.setOnAction(e -> window.close());	
		
		Button confirmButton = new Button("Confirm");		
		confirmButton.setOnAction(e -> {
			confirm = !confirm;
			@SuppressWarnings("unused")
			User u = xyz.register(xyz);
			xyz.adminPermission(xyz);
			window.close();
		});		
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(fname, lname, addr, zip, st, email, usr, pss, ssn, secQ, secA,
				adm, confirmButton, editButton);
		layout.setAlignment(Pos.CENTER);
	
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();

	
	}
}
