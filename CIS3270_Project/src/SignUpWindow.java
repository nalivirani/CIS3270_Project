import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SignUpWindow {
	
	public static void display(){
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Sign Up");
		window.setMinWidth(600);
		window.setMinHeight(300);
		Label label = new Label("Please Sign Up");
		
		Button signUpButton = new Button("Sign Up");
		Button cancelButton = new Button("Cancel");
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		//first name label
		Label firstNameLabel = new Label("First:");
		GridPane.setConstraints(firstNameLabel, 0, 0);
		GridPane.setHalignment(firstNameLabel, HPos.RIGHT);
						
		//first name input
		TextField firstNameInput = new TextField();
		firstNameInput.setPromptText("First");
		GridPane.setConstraints(firstNameInput, 1, 0);
		
		//last name label
		Label lastNameLabel = new Label("Last:");
		GridPane.setConstraints(lastNameLabel, 2, 0);
		GridPane.setHalignment(lastNameLabel, HPos.RIGHT);
						
		//last name input
		TextField lastNameInput = new TextField();
		lastNameInput.setPromptText("Last");
		GridPane.setConstraints(lastNameInput, 3, 0);

		//address label
		Label addressLabel = new Label("Address:");
		GridPane.setConstraints(addressLabel, 0, 1);
		GridPane.setHalignment(addressLabel, HPos.RIGHT);

						
		//address input
		TextField addressInput = new TextField();
		addressInput.setPromptText("Address");
		GridPane.setConstraints(addressInput, 1, 1, 2, 1);
		
		//zipcode label
		Label zipLabel = new Label("Zip Code:");
		GridPane.setConstraints(zipLabel, 0, 2);
		GridPane.setHalignment(zipLabel, HPos.RIGHT);
						
		//zipcode input
		TextField zipInput = new TextField();
		zipInput.setPromptText("Zip");
		GridPane.setConstraints(zipInput, 1, 2);
		
		//state label
		Label stateLabel = new Label("State:");
		GridPane.setConstraints(stateLabel, 2, 2);
		GridPane.setHalignment(stateLabel, HPos.RIGHT);
						
		//state input
		ChoiceBox<String> state = new ChoiceBox<>();
		state.getItems().addAll("AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", 
				"HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", 
				"MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", 
				"RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY");
		GridPane.setConstraints(state, 3, 2);
		state.setValue("AK");
		
		//name label
		Label usernameLabel = new Label("Create Username:");
		GridPane.setConstraints(usernameLabel, 0, 3);
		GridPane.setHalignment(usernameLabel, HPos.RIGHT);
								
		//name input
		TextField usernameInput = new TextField();
		usernameInput.setPromptText("Username");
		GridPane.setConstraints(usernameInput, 1, 3);
								
		//pass label
		Label passLabel = new Label("Create Password:");
		GridPane.setConstraints(passLabel, 2, 3);
		GridPane.setHalignment(passLabel, HPos.RIGHT);
					
		//pass input
		TextField passInput = new TextField();
		passInput.setPromptText("Password");
		GridPane.setConstraints(passInput, 3, 3);
		
		//email label
		Label emailLabel = new Label("Email Address:");
		GridPane.setConstraints(emailLabel, 0, 4);
		GridPane.setHalignment(emailLabel, HPos.RIGHT);
								
		//email input
		TextField emailInput = new TextField();
		emailInput.setPromptText("Email");
		GridPane.setConstraints(emailInput, 1, 4, 2, 1);
		
		//ssn label
		Label ssnLabel = new Label("Social Security Number:");
		GridPane.setConstraints(ssnLabel, 0, 5);
		GridPane.setHalignment(ssnLabel, HPos.RIGHT);
								
		//ssn input
		TextField ssnInput = new TextField();
		ssnInput.setPromptText("000000000");
		GridPane.setConstraints(ssnInput, 1, 5);
		
		//security question label
		Label questionLabel = new Label("Security Question:");
		GridPane.setConstraints(questionLabel, 0, 6);
		GridPane.setHalignment(questionLabel, HPos.RIGHT);
		
		//security question input
		ChoiceBox<String> question = new ChoiceBox<>();
		question.getItems().addAll("What is the first name of the person you first kissed?",
				"What is the last name of the teacher who gave you your first failing grade?");
		GridPane.setConstraints(question, 0, 7);
		state.setValue("AK");
		
		//recoveryAnswer label
		Label recoveryAnswerLabel = new Label("Recovery Answer:");
		GridPane.setConstraints(recoveryAnswerLabel, 0, 8);
		GridPane.setHalignment(recoveryAnswerLabel, HPos.RIGHT);
										
		//recoveryAnswer input
		TextField recoveryAnswerInput = new TextField();
		recoveryAnswerInput.setPromptText("Answer");
		GridPane.setConstraints(recoveryAnswerInput, 1, 8);
		
//		signUpButton.setOnAction(e -> {
//			username = usernameInput.getText();
//			window.close();
//			getChoice(state);
//		});
		
		cancelButton.setOnAction(e -> window.close());
		
		//GridPane.setConstraints(signUpButton, 1, 2);
		//GridPane.setConstraints(cancelButton, 1, 3);
		
		grid.getChildren().addAll(firstNameLabel, firstNameInput, lastNameLabel, lastNameInput,
				addressLabel, addressInput, zipInput, zipLabel, state, stateLabel, 
				usernameLabel, usernameInput, passLabel, passInput, emailInput, emailLabel, ssnInput,ssnLabel,
				recoveryAnswerLabel, recoveryAnswerInput, question);
		//signUpButton, cancelButton

		Scene scene = new Scene(grid, 850, 500);
		window.setScene(scene);
		window.showAndWait();
	}
}
