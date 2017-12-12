import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SignUpWindow {
	static int r = 2;
	static int c = 2;

	public static final Font ITALIC_FONT =
            Font.font(
            		"System Regular",
                    FontPosture.ITALIC,
                    Font.getDefault().getSize()
            );
	
	public static void display(){
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Sign Up");
		window.setMinWidth(1050);
		window.setMinHeight(500);
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20));
		grid.setVgap(8);
		grid.setHgap(10);
		
		Text label = new Text ("Please sign up");
		GridPane.setConstraints(label, 3, 0, 2, 1);
		GridPane.setHalignment(label, HPos.CENTER);
		label.setFont(Font.font (20));
		label.setFill(Color.BLUE);
		
//		Label label = new Label("Please Sign Up");
//		GridPane.setConstraints(label, 3, 0, 2, 1);
//		GridPane.setHalignment(label, HPos.CENTER);
//		
		Button signUpButton = new Button("Sign Up");
		Button cancelButton = new Button("Cancel");
		
		//first name label
		Label firstNameLabel = new Label("Name:");
		GridPane.setConstraints(firstNameLabel, c, r-1);
		GridPane.setHalignment(firstNameLabel, HPos.RIGHT);
						
		//first name input
		TextField firstNameInput = new TextField();
		firstNameInput.setPromptText("First");
		GridPane.setConstraints(firstNameInput, c+1, r-1);
		
//		//last name label
//		Label lastNameLabel = new Label("Last:");
//		GridPane.setConstraints(lastNameLabel, c+1, r-1);
//		GridPane.setHalignment(lastNameLabel, HPos.RIGHT);
						
		//last name input
		TextField lastNameInput = new TextField();
		lastNameInput.setPromptText("Last");
		GridPane.setConstraints(lastNameInput, c+2, r-1, 2,1);

		//address label
		Label addressLabel = new Label("Address:");
		GridPane.setConstraints(addressLabel, c, r+1);
		GridPane.setHalignment(addressLabel, HPos.RIGHT);

						
		//address input
		TextField addressInput = new TextField();
		addressInput.setPromptText("Address");
		GridPane.setConstraints(addressInput, c+1, r+1, 1, 1);
		
//		//zipcode label
//		Label zipLabel = new Label("Zip Code:");
//		GridPane.setConstraints(zipLabel, c, r+2);
//		GridPane.setHalignment(zipLabel, HPos.RIGHT);
						
		//zipcode input
		TextField zipInput = new TextField();
		zipInput.setPromptText("Zip");
		GridPane.setConstraints(zipInput, c+2, r+1);
		
//		//state label
//		Label stateLabel = new Label("State:");
//		GridPane.setConstraints(stateLabel, c+2, r+2);
//		GridPane.setHalignment(stateLabel, HPos.RIGHT);
						
		//state input
		ChoiceBox<String> state = new ChoiceBox<>();
		state.getItems().addAll("AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", 
				"HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", 
				"MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", 
				"RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY");
		GridPane.setConstraints(state, c+3, r+1);
		state.setValue("AK");
		
		//email label
		Label emailLabel = new Label("Email Address:");
		GridPane.setConstraints(emailLabel, c+0, r+2);
		GridPane.setHalignment(emailLabel, HPos.RIGHT);
								
		//email input
		TextField emailInput = new TextField();
		emailInput.setPromptText("Email");
		GridPane.setConstraints(emailInput, c+1,r+2, 1, 1);
		
		//username label
		Label usernameLabel = new Label("Create Username:");
		GridPane.setConstraints(usernameLabel, c, r+3);
		GridPane.setHalignment(usernameLabel, HPos.RIGHT);
								
		//username input
		TextField usernameInput = new TextField();
		usernameInput.setPromptText("Username");
		GridPane.setConstraints(usernameInput, c+1, r+3);
		
		//username disclaimer
		Text userInfo = new Text ("(this will be used to sign in)");
		GridPane.setConstraints(userInfo, c+2, r+3);
		GridPane.setHalignment(userInfo, HPos.CENTER);
		userInfo.setFont(ITALIC_FONT);
								
		//pass label
		Label passLabel = new Label("Create Password:");
		GridPane.setConstraints(passLabel, c, r+4);
		GridPane.setHalignment(passLabel, HPos.RIGHT);
					
		//pass input
		TextField passInput = new TextField();
		passInput.setPromptText("Password");
		GridPane.setConstraints(passInput, c+1, r+4);
		
		//password disclaimer
		Text passInfo = new Text ("(username and password are case sensitive)");
		GridPane.setConstraints(passInfo, c+2, r+4);
		GridPane.setHalignment(passInfo, HPos.CENTER);
		passInfo.setFont(ITALIC_FONT);
		
		//ssn label
		Label ssnLabel = new Label("Social Security Number:");
		GridPane.setConstraints(ssnLabel, c+0, r+5);
		GridPane.setHalignment(ssnLabel, HPos.RIGHT);
								
		//ssn input
		TextField ssnInput = new TextField();
		ssnInput.setPromptText("000000000");
		GridPane.setConstraints(ssnInput, c+1, r+5);
		
		//ssn disclaimer
		Text secQInfo = new Text ("(this will be used for password recovery)");
		GridPane.setConstraints(secQInfo, c+2, r+5);
		GridPane.setHalignment(secQInfo, HPos.CENTER);
		secQInfo.setFont(ITALIC_FONT);
		
		//security question label
		Label questionLabel = new Label("Security Question:");
		GridPane.setConstraints(questionLabel, c+0, r+7);
		GridPane.setHalignment(questionLabel, HPos.RIGHT);
		
		//security question input
		ComboBox<String> question = new ComboBox<String>();
		question.getItems().addAll("What is the first name of the person you first kissed?",
				"What is the last name of the teacher who gave you your first failing grade?");
		GridPane.setConstraints(question, c+1,r+7);
		question.setPromptText("Select a security question");

		//recoveryAnswer label
		Label recoveryAnswerLabel = new Label("Recovery Answer:");
		GridPane.setConstraints(recoveryAnswerLabel, c+0, r+8);
		GridPane.setHalignment(recoveryAnswerLabel, HPos.RIGHT);
										
		//recoveryAnswer input
		TextField recoveryAnswerInput = new TextField();
		recoveryAnswerInput.setPromptText("Answer");
		GridPane.setConstraints(recoveryAnswerInput, c+1, r+8);
		
		//security answer disclaimer
		Text secAInfo = new Text ("(answer is case sensitive)");
		GridPane.setConstraints(secAInfo, c+2, r+7);
		GridPane.setHalignment(secAInfo, HPos.CENTER);
		secAInfo.setFont(ITALIC_FONT);
		
		//admin label
		Text adminLabel = new Text("(For admininistrators only)");
		GridPane.setConstraints(adminLabel, c+2, r+9);
		GridPane.setHalignment(adminLabel, HPos.RIGHT);
		adminLabel.setFont(ITALIC_FONT);
		
		//admin input
		TextField adminInput = new TextField();
		adminInput.setPromptText("Admin Password");
		GridPane.setConstraints(adminInput, c+3, r+9);
		
		
		signUpButton.setOnAction(e -> {
			User tempUser = new User();
			if(question.toString() != null){			
			if((ssnInput.getText()).length() == 9 && Validator.isInt(ssnInput.getText())){ 
			if((Validator.isInt(zipInput.getText()) && (Integer.parseInt(zipInput.getText()) < 90000))){
			if(firstNameInput.getLength() > 0 && 
					lastNameInput.getLength() > 0 && 
					addressInput.getLength() > 0 && zipInput.getLength() > 0
					&& emailInput.getLength() > 0 && 
					usernameInput.getLength() > 0 && passInput.getLength() > 0 &&
					ssnInput.getLength() > 0 &&
					recoveryAnswerInput.getLength() > 0){
			if((ssnInput.getText()).length() == 9 && Validator.isInt(ssnInput.getText())){
				
			if((zipInput.getText()).length() <= 5 && (zipInput.getText()).length() > 0 
				&& Validator.isInt(zipInput.getText()) && (Integer.parseInt(zipInput.getText()) < 90000)){
				if(tempUser.isNewUser(Integer.parseInt(ssnInput.getText())) && tempUser.isNewUser(usernameInput.getText())){
					tempUser.setfName(firstNameInput.getText());
					tempUser.setlName(lastNameInput.getText());
					tempUser.setAddress(addressInput.getText());
					tempUser.setZip(Integer.parseInt(zipInput.getText()));
					tempUser.setState(state.getValue());
					tempUser.setEmail(emailInput.getText());
					tempUser.setUserName(usernameInput.getText());
					tempUser.setPassword(passInput.getText());
					tempUser.setSsn(Integer.parseInt(ssnInput.getText()));
					tempUser.setSecurityQuestion(question.getValue());
					tempUser.setSecurityAnswer(recoveryAnswerInput.getText());
				if(adminInput.getText().equals("zaq12wsxZAQ!@WSX")){
					tempUser.setPermissionLevel(1);
				}else{
					tempUser.setPermissionLevel(0);
				}

				
				//User u = tempUser.register(tempUser);
				System.out.println(tempUser.getPermissionLevel());
				ConfirmSignUp.display(tempUser);
				if(ConfirmSignUp.confirm == true){
					window.close();
				}
//				}else{
//					window.showAndWait();
//				}
				
			}else{
				AlertBox1.display("Please check your input", "Your Zip code is incorrect");
			}
			}else{
				AlertBox1.display("Please check your input", "Your Social Security Number is incorrect");
			}
			}
			}else{
				AlertBox1.display("Please check your input", "All fields must be completed");
			}
			}else{
				AlertBox1.display("Please check your input", "Your Zip code is incorrect");
			}
			}else{
				AlertBox1.display("Please check your input", "Your Social Security Number is incorrect");
			}
			}else{
				AlertBox1.display("Please check your input", "You must select a Security Question");
			}
			
			
		});
		
		cancelButton.setOnAction(e -> window.close());
		
		GridPane.setConstraints(signUpButton, 4, 15);
		GridPane.setConstraints(cancelButton, 5, 15);
		
		grid.getChildren().addAll(firstNameLabel, firstNameInput, /*lastNameLabel*/ lastNameInput,
				addressLabel, addressInput, zipInput, /*zipLabel,label,   stateLabel*/state, 
				usernameLabel, usernameInput, passLabel, passInput, emailInput, emailLabel, ssnInput,ssnLabel,
				recoveryAnswerLabel, recoveryAnswerInput, question, questionLabel, 
				userInfo, secQInfo, secAInfo, passInfo, signUpButton, cancelButton, adminInput, adminLabel);

		
		Scene scene = new Scene(grid);
		window.setScene(scene);
		window.showAndWait();
		
		//System.out.println(xyz.toString());
	}
	
}
