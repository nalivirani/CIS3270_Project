import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FlightFind {
	
	static TableView<Flight> flights;
	
	public static void display(){
		
		//flight 1 object
		Flight f1 = new Flight(4325, null);
		f1.setArrCity("ATL");
		f1.setDepCity("LA");
		f1.setDistance(894);
		f1.setSeatsRem(21);
		
		//flight 2 object
		Flight f2 = new Flight(1832, null);
		f2.setArrCity("OR");
		f2.setDepCity("NY");
		f2.setDistance(641);
		f2.setSeatsRem(10);
		
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Search for Flights");
		window.setMinWidth(1050);
		window.setMinHeight(500);
		
		//flightnum cl
		TableColumn<Flight, Integer> flightnum = new TableColumn<>("Flight Number");
		flightnum.setMinWidth(150);
		flightnum.setCellValueFactory(new PropertyValueFactory<>("flightNum"));
		
		TableColumn<Flight, String> depCity = new TableColumn<>("Departure City");
		depCity.setMinWidth(250);
		depCity.setCellValueFactory(new PropertyValueFactory<>("depCity"));
		
		TableColumn<Flight, String> arrCity = new TableColumn<>("Arrival City");
		arrCity.setMinWidth(250);
		arrCity.setCellValueFactory(new PropertyValueFactory<>("arrCity"));
		
		flights = new TableView<>();
		flights.setItems(getFlights(f1,f2));
		flights.getColumns().addAll(flightnum, depCity,arrCity);

				
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.getChildren().addAll(flights);
		Scene scene = new Scene(grid);
		window.setScene(scene);
		window.show();

	}
	
	public static ObservableList<Flight> getFlights(Flight f1, Flight f2){
		ObservableList<Flight> flights = FXCollections.observableArrayList();		
		flights.addAll(f1, f2);
		return flights;
	}
	

}
