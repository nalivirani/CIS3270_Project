import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FlightFind {
	
	static TableView<Flight> flights;
	
	@SuppressWarnings("unchecked")
	public static void display(User u){
		
		GridPane grid = new GridPane();
		BorderPane border = new BorderPane();

		Button searchByInfoButton = new Button("Search for Flights");
		Button addReservation = new Button("Add Reservation");
		//labels
		Label depCityLabel = new Label("Departure City: ");
		Label arrCityLabel = new Label("Arrival City: ");
		Label monthLabel = new Label("Month: ");
		Label dayLabel = new Label("Day: ");
		Label yearLabel = new Label("Year: ");
								
		//Departure City input ComboBox<String> question = new ComboBox<String>();
		ComboBox<String> depCityDrop = new ComboBox<>();
		depCityDrop.getItems().addAll("ATL", "ORD", "DCA", "DFW", "JFK", "LAX", "MIA", "DEN");
		depCityDrop.setValue("Select");
		
		//Arrival City input
		ComboBox<String> arrCityDrop = new ComboBox<>();
		arrCityDrop.getItems().addAll("ATL", "ORD", "DCA", "DFW", "JFK", "LAX", "MIA", "DEN");
		arrCityDrop.setValue("Select");


		//month drop down
		ComboBox<String> monthDrop = new ComboBox<>();
		monthDrop.getItems().addAll("January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November", "December");
		monthDrop.setValue("Month");
		
		//Day drop down
		ComboBox<Integer> dayDrop = new ComboBox<>();
		dayDrop.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
				19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31);
		dayDrop.setValue(01);
		
		//Year drop down
		ComboBox<Integer> yearDrop = new ComboBox<>();
		yearDrop.getItems().addAll(2017,2018);
		yearDrop.setValue(2017);
//		
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Search for Flights");
		window.setMinWidth(1050);
		window.setMinHeight(500);
		
		//flightnum cl
		TableColumn<Flight, Integer> fID = new TableColumn<>("Flight ID");
		fID.setMinWidth(50);
		fID.setCellValueFactory(new PropertyValueFactory<>("fID"));
		
		TableColumn<Flight, Integer> flightnum = new TableColumn<>("Flight #");
		flightnum.setMinWidth(50);
		flightnum.setCellValueFactory(new PropertyValueFactory<>("flightNum"));
		
		TableColumn<Flight, String> depCity = new TableColumn<>("Departure City");
		depCity.setMinWidth(125);
		depCity.setCellValueFactory(new PropertyValueFactory<>("depCity"));
		
		TableColumn<Flight, String> arrCity = new TableColumn<>("Arrival City");
		arrCity.setMinWidth(100);
		arrCity.setCellValueFactory(new PropertyValueFactory<>("arrCity"));
		
		TableColumn<Flight, LocalDate> depDate = new TableColumn<>("Departure Date");
		depDate.setMinWidth(130);
		depDate.setCellValueFactory(new PropertyValueFactory<>("depDate"));
		
		TableColumn<Flight, LocalDate> arrDate = new TableColumn<>("Arrival Date");
		arrDate.setMinWidth(100);
		arrDate.setCellValueFactory(new PropertyValueFactory<>("arrDate"));
		
		TableColumn<Flight, LocalTime> depTime = new TableColumn<>("Departure Time");
		depTime.setMinWidth(100);
		depTime.setCellValueFactory(new PropertyValueFactory<>("depTime"));
		
		TableColumn<Flight, LocalTime> arrTime = new TableColumn<>("Arrival Time");
		arrTime.setMinWidth(100);
		arrTime.setCellValueFactory(new PropertyValueFactory<>("arrTime"));
		
		TableColumn<Flight, Integer> distance = new TableColumn<>("distance");
		distance.setMinWidth(100);
		distance.setCellValueFactory(new PropertyValueFactory<>("distance"));
		
		TableColumn<Flight, String> stopType = new TableColumn<>("Stop Type");
		stopType.setMinWidth(100);
		stopType.setCellValueFactory(new PropertyValueFactory<>("stopType"));
		
		TableColumn<Flight, String> region = new TableColumn<>("region");
		region.setMinWidth(100);
		region.setCellValueFactory(new PropertyValueFactory<>("region"));
		
		TableColumn<Flight, BigDecimal> ticketPrice = new TableColumn<>("ticket Price");
		ticketPrice.setMinWidth(100);
		ticketPrice.setCellValueFactory(new PropertyValueFactory<>("ticketPrice"));
		
		TableColumn<Flight, BigDecimal> fcTicketPrice = new TableColumn<>("fc Ticket Price");
		fcTicketPrice.setMinWidth(100);
		fcTicketPrice.setCellValueFactory(new PropertyValueFactory<>("fcTicketPrice"));
		
		TableColumn<Flight, Integer> seats = new TableColumn<>("seats");
		seats.setMinWidth(100);
		seats.setCellValueFactory(new PropertyValueFactory<>("seats"));
		
		TableColumn<Flight, Integer> seatsRem = new TableColumn<>("seatsRem");
		seatsRem.setMinWidth(50);
		seatsRem.setCellValueFactory(new PropertyValueFactory<>("seatsRem"));
		
		TableColumn<Flight, Integer> numRows = new TableColumn<>("numRows");
		numRows.setMinWidth(150);
		numRows.setCellValueFactory(new PropertyValueFactory<>("numRows"));
		
		TableColumn<Flight, Integer> seatsPerRow = new TableColumn<>("seatsPerRow");
		seatsPerRow.setMinWidth(150);
		seatsPerRow.setCellValueFactory(new PropertyValueFactory<>("seatsPerRow"));
		
		searchByInfoButton.setOnAction(e ->{
			int m = Validator.intReturn(monthDrop.getValue());
			LocalDate lc = LocalDate.of(yearDrop.getValue(), m, dayDrop.getValue());
			Flight f1 = new Flight();
			List<Flight> flarr = new ArrayList<>(f1.searchFlights(depCityDrop.getValue(), arrCityDrop.getValue(), lc));

			ObservableList<Flight> flightsFound = FXCollections.observableArrayList(flarr);
			flights.setItems(flightsFound);
			});
		
		addReservation.setOnAction(e ->{
			Reservation temp = new Reservation();
			Flight f = new Flight();
			ObservableList<Flight> reservationSelected;
			if(!flights.getSelectionModel().getSelectedItems().isEmpty()){
				reservationSelected = flights.getSelectionModel().getSelectedItems();
				f = reservationSelected.get(0);
				f.setFlightNum(f.getFlightNum());
				temp.createReservation(f, u);
				AlertBox1.display("Sucess", "This flight is now reserved");
			}else{
				AlertBox1.display("No selection made", "Please make a selection!");
			}
		});
		
		flights = new TableView<>();
		//flights.setItems(flightsFound);
		flights.getColumns().addAll(flightnum, depCity, arrCity, depDate, arrDate, depTime, arrTime, 
				ticketPrice, seatsRem);
		
		
	
		
//		FlowPane flow = new FlowPane();
//	    flow.setPadding(new Insets(10));
//	    flow.setVgap(10);
//	    flow.setHgap(10);
//	    flow.setPrefWrapLength(170); // preferred width allows for two columns
//	    flow.setStyle("-fx-background-color: DAE6F3;");
//	    flow.getChildren().addAll(depCityLabel, depCityDrop, arrCityLabel, arrCityDrop, 
//	    		monthLabel, monthDrop,dayLabel, dayDrop, yearLabel, yearDrop, searchButton);

		
//		VBox vBox = new VBox();
//		vBox.setPadding(new Insets(10));
//		vBox.setSpacing(10);
//		vBox.getChildren().addAll(depCityLabel, depCityDrop, arrCityDrop, monthDrop, dayDrop, yearDrop);
		
		GridPane grid2 = new GridPane();
		grid2.setPadding(new Insets(20));
		grid2.setVgap(8);
		grid2.setHgap(10);
		grid2.getChildren().addAll(depCityLabel, depCityDrop, arrCityLabel, arrCityDrop, 
	    		monthLabel, monthDrop,dayLabel, dayDrop, yearLabel, yearDrop, 
	    		searchByInfoButton, addReservation);
		int c = 0;
		int r = (c+1) * 2;
		GridPane.setConstraints(depCityLabel,c, r);
		GridPane.setConstraints(depCityDrop, c, r+1);
		GridPane.setConstraints(arrCityLabel, c, r + 2);
		GridPane.setConstraints(arrCityDrop, c, r + 3);
		GridPane.setConstraints(monthLabel, c, r + 4);
		GridPane.setConstraints(monthDrop, c, r + 5);
		GridPane.setConstraints(dayLabel, c, r + 6);
		GridPane.setConstraints(dayDrop, c, r + 7);
		GridPane.setConstraints(yearLabel, c, r + 8);
		GridPane.setConstraints(yearDrop, c, r + 9);
		GridPane.setConstraints(searchByInfoButton, c, r + 15);
		GridPane.setConstraints(addReservation, c, r + 20);

		border.setRight(grid2);
		GridPane.setConstraints(border, 1 ,0);
		
		grid.setPadding(new Insets(20));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.getChildren().addAll(flights, border);
				
		Scene scene = new Scene(grid);
		window.setScene(scene);
		window.setMinWidth(800);
		window.show();

	}
	
//	public static ObservableList<Flight> getFlights(ArrayList<T> arrL){
//		ObservableList<Flight> flights = FXCollections.observableArrayList();		
//		flights.addAll(f1, f2);
//		return flights;
//	}

//	public static ObservableList<Flight> getFlights(Flight f1, Flight f2){
//		ObservableList<Flight> flights = FXCollections.observableArrayList();		
//		flights.addAll(f1, f2);
//		return flights;
//	}
//	
	
//	

}
