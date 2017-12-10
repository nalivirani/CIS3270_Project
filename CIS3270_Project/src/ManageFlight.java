import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ManageFlight {
	static TableView<Flight> flights;
	static TextField flightNumInput;
	static TextField depCityInput;
	static TextField arrCityInput;
	
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
		
		flightNumInput = new TextField();
		flightNumInput.setPromptText("Flight Number");
		flightNumInput.setMinWidth(100);
		
		depCityInput = new TextField();
		depCityInput.setPromptText("Departure City");
		depCityInput.setMinWidth(100);
		
		arrCityInput = new TextField();
		arrCityInput.setPromptText("Arrival City");
		arrCityInput.setMinWidth(100);
		
		//Buttons
		Button addButton = new Button("Add");
		addButton.setOnAction(e -> addButtonClicked());
		Button deleteButton = new Button("Delete");
		deleteButton.setOnAction(e -> deleteButtonClicked());
		
		flights = new TableView<>();
		flights.setItems(getFlights(f1,f2));
		flights.getColumns().addAll(flightnum, depCity,arrCity);

		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10));
		hBox.setSpacing(10);
		hBox.getChildren().addAll(flightNumInput, depCityInput, arrCityInput, addButton, deleteButton);
				
		VBox vBox = new VBox();
		vBox.getChildren().addAll(flights, hBox);
		Scene scene = new Scene(vBox);
		window.setScene(scene);
		window.show();

	}
	
	public static ObservableList<Flight> getFlights(Flight f1, Flight f2){
		ObservableList<Flight> flights = FXCollections.observableArrayList();		
		flights.addAll(f1, f2);
		return flights;
	}
	
	public static void addButtonClicked(){
		Flight f = new Flight();
		if(Validator.isInt(flightNumInput.getText()))
		f.setFlightNum((Integer.parseInt(flightNumInput.getText())));
		f.setDepCity(depCityInput.getText());
		f.setArrCity(arrCityInput.getText());
		flights.getItems().add(f);
		flightNumInput.clear();
		depCityInput.clear();
		arrCityInput.clear();
	}
	
	public static void deleteButtonClicked(){
		ObservableList<Flight> flightSelected, allFlights;
		allFlights = flights.getItems();
		flightSelected = flights.getSelectionModel().getSelectedItems();
		flightSelected.forEach(allFlights::remove);
	}
	

}