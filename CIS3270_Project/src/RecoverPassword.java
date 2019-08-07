import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RecoverPassword {
	static TextField usernameInput;
	static TextField answerInput;

	public static void display() {
			
		Stage window = new Stage();
		window.setMinHeight(50);
		window.setMinWidth(550);
//		BorderPane border = new BorderPane();
//		User tempUser = new User();
		Label prompt = new Label("Please enter Username (case sensitive)");
		Label secQ = new Label();
		Label secA = new Label();
		//Label prompt2 = new Label();
		Label pass = new Label();
		Button continueButton = new Button("Continue");
		continueButton.setOnAction(e ->{
			User u = new User();
			User tempUser = u.getUser(usernameInput.getText());
			secQ.setText(tempUser.getSecurityQuestion());
			secA.setText("Please enter answer to security question");
		});
		Button nextButton = new Button("Next");
		nextButton.setOnAction(e -> {
			User u = new User();
			User tempUser = u.getUser(usernameInput.getText());
//			if(answerInput.getText() != null){
			if(answerInput.getText().equalsIgnoreCase(tempUser.getSecurityAnswer()))
				AlertBox1.display("Password Recovered", "Your password is " + tempUser.getPassword());
			else{
				AlertBox1.display("Please check your input", "Your answer is incorrect");
			}
			
			
		});
		usernameInput = new TextField();
		usernameInput.setPromptText("Enter Username");
		usernameInput.setMinWidth(100);
		
		answerInput = new TextField();
		answerInput.setPromptText("Enter Security Answer");
		answerInput.setMinWidth(100);
			
		//border.setTop(usernameInput);
		VBox vBox = new VBox();
		vBox.getChildren().addAll(prompt, usernameInput, continueButton, secQ, secA, 
				answerInput, nextButton, pass);
		
		
					
		Scene scene = new Scene(vBox);
		window.setScene(scene);
		window.show();
	}
}
