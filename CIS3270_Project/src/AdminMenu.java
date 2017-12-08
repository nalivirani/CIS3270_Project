import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdminMenu {
	
	public static Scene display() {
		Stage window = new Stage();
		
		Button searchButton = new Button("Find Flights");
		Button manageReservationsButton = new Button("Manage Reservations");
		Button manageFlightsButton = new Button("Manage Flights");
		
		GridPane grid = new GridPane();
		grid.getChildren().addAll(searchButton, manageFlightsButton);
		grid.setPadding(new Insets(10));
		grid.setVgap(8);
		grid.setHgap(10);
			
		Scene scene = new Scene(grid, 300, 500);
		return scene;
		//window.setScene(scene);
		//window.show();
		
	}

}
