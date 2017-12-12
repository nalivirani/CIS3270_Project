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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
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
	static TextField flightIDInput;
	static TextField flightNumberInput;
	static TextField tPrice;
	
	@SuppressWarnings("unchecked")
	public static void display(){
		
//		//flight 1 object
//		Flight f1 = new Flight(4325, null);
//		f1.setArrCity("ATL");
//		f1.setDepCity("LA");
//		f1.setDistance(894);
//		f1.setSeatsRem(21);
//		
//		//flight 2 object
//		Flight f2 = new Flight(1832, null);
//		f2.setArrCity("OR");
//		f2.setDepCity("NY");
//		f2.setDistance(641);
//		f2.setSeatsRem(10);
		
		GridPane grid = new GridPane();
		BorderPane border = new BorderPane();

		//flight 1 object
		//Flight f1 = new Flight();
//		f1.setArrCity("ATL");
//		f1.setDepCity("LA");
//		f1.setDistance(894);
//		f1.setSeatsRem(21);
		
//		//flight 2 object
//		Flight f2 = new Flight(1832, null);
//		f2.setArrCity("OR");
//		f2.setDepCity("NY");
//		f2.setDistance(641);
//		f2.setSeatsRem(10);
		
//		Flight f1 = new Flight();
//		LocalDate lc = LocalDate.of(2017, 12,  25);
//		f1.searchFlights("ATL", null, lc);

		Button searchByInfoButton = new Button("Search for Flights");
		Button searchByIDButton = new Button("Search by Flight ID");
		
		//labels
		Label orSearchByLabel = new Label(" ~ OR SEARCH BY ~ ");
		
		Label depCityLabel = new Label("Departure City: ");
		Label arrCityLabel = new Label("Arrival City: ");
		Label monthLabel = new Label("Month: ");
		Label dayLabel = new Label("Day: ");
		Label yearLabel = new Label("Year: ");
//		GridPane.setValignment(depCityLabel, VPos.CENTER);
//		GridPane.setHalignment(depCityLabel, HPos.LEFT);
//		GridPane.setConstraints(depCityLabel, 1,0);
		//grid.add(depCityLabel, 0, 0);
								
		//Departure City input ComboBox<String> question = new ComboBox<String>();
		ComboBox<String> depCityDrop = new ComboBox<>();
		depCityDrop.getItems().addAll("ATL", "ORD");
		depCityDrop.setValue("Select");
//		GridPane.setValignment(depCityLabel, VPos.CENTER);
//		GridPane.setHalignment(depCityLabel, HPos.LEFT);
//		GridPane.setConstraints(depCityLabel, 1,0);
		
		//Arrival City input
		ComboBox<String> arrCityDrop = new ComboBox<>();
		arrCityDrop.getItems().addAll("ATL", "ORD");
		arrCityDrop.setValue("Select");
//		GridPane.setValignment(depCityLabel, VPos.CENTER);
//		GridPane.setHalignment(depCityLabel, HPos.LEFT);
//		GridPane.setConstraints(depCityLabel, 1,0);


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
		
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Search for Flights");
		window.setMinWidth(1050);
		window.setMinHeight(500);
		
		//flightnum cl
		TableColumn<Flight, Integer> fID = new TableColumn<>("Flight ID");
		fID.setMinWidth(25);
		fID.setCellValueFactory(new PropertyValueFactory<>("fID"));
		
		TableColumn<Flight, Integer> flightnum = new TableColumn<>("Flight Number");
		flightnum.setMinWidth(25);
		flightnum.setCellValueFactory(new PropertyValueFactory<>("flightNum"));
		
		TableColumn<Flight, String> depCity = new TableColumn<>("Departure City");
		depCity.setMinWidth(50);
		depCity.setCellValueFactory(new PropertyValueFactory<>("depCity"));
		
		TableColumn<Flight, String> arrCity = new TableColumn<>("Arrival City");
		arrCity.setMinWidth(50);
		arrCity.setCellValueFactory(new PropertyValueFactory<>("arrCity"));
		
		TableColumn<Flight, LocalDate> depDate = new TableColumn<>("Departure Date");
		depDate.setMinWidth(100);
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
		distance.setMinWidth(150);
		distance.setCellValueFactory(new PropertyValueFactory<>("distance"));
		
		TableColumn<Flight, String> stopType = new TableColumn<>("Stop Type");
		stopType.setMinWidth(250);
		stopType.setCellValueFactory(new PropertyValueFactory<>("stopType"));
		
		TableColumn<Flight, String> region = new TableColumn<>("region");
		region.setMinWidth(250);
		region.setCellValueFactory(new PropertyValueFactory<>("region"));
		
		TableColumn<Flight, BigDecimal> ticketPrice = new TableColumn<>("ticket Price");
		ticketPrice.setMinWidth(100);
		ticketPrice.setCellValueFactory(new PropertyValueFactory<>("ticketPrice"));
		
		TableColumn<Flight, BigDecimal> fcTicketPrice = new TableColumn<>("fc Ticket Price");
		fcTicketPrice.setMinWidth(250);
		fcTicketPrice.setCellValueFactory(new PropertyValueFactory<>("fcTicketPrice"));
		
		TableColumn<Flight, Integer> seats = new TableColumn<>("seats");
		seats.setMinWidth(150);
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
			//flarr = f1.searchFlights(depCityDrop.getValue(), arrCityDrop.getValue(), lc);
			ObservableList<Flight> flightsFound = FXCollections.observableArrayList(flarr);
			flights.setItems(flightsFound);
		});
		
//		searchByIDButton.setOnAction(e ->{
//			int m = Validator.intReturn(flightIDInput.getText());
//			Flight f1 = new Flight();
//			List<Flight> flarr = new ArrayList<>(f1.searchFlights(m));
//			ObservableList<Flight> flightsFound = FXCollections.observableArrayList(flarr);
//			flights.setItems(flightsFound);
//		});
//		
		flightIDInput = new TextField();
		flightIDInput.setPromptText("Flight ID");
		flightIDInput.setMinWidth(100);
		
		flightNumberInput = new TextField();
		flightNumberInput.setPromptText("Flight ID");
		flightNumberInput.setMinWidth(100);
		
		depCityInput = new TextField();
		depCityInput.setPromptText("Departure City");
		depCityInput.setMinWidth(100);
		
		arrCityInput = new TextField();
		arrCityInput.setPromptText("Arrival City");
		arrCityInput.setMinWidth(100);
		
		//month drop down
		ComboBox<String> monthSearchDrop = new ComboBox<>();
		monthSearchDrop.getItems().addAll("January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November", "December");
		monthSearchDrop.setValue("Month");
		
		//Day drop down
		ComboBox<Integer> daySearchDrop = new ComboBox<>();
		daySearchDrop.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
				19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31);
		daySearchDrop.setValue(01);
		
		//Year drop down
		ComboBox<Integer> yearSearchDrop = new ComboBox<>();
		daySearchDrop.getItems().addAll(2017,2018);
		daySearchDrop.setValue(2017);
		
//		String month = monthSearchDrop.getValue();
//		int a = Validator.intReturn(month);
//		LocalDate depLocDate = LocalDate.of(yearSearchDrop.getValue(), a , daySearchDrop.getValue());
//		
		//month drop down
		ComboBox<String> monthSearchDrop2 = new ComboBox<>();
		monthSearchDrop.getItems().addAll("January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November", "December");
		monthSearchDrop.setValue("Month");
		
		//Day drop down
		ComboBox<Integer> daySearchDrop2 = new ComboBox<>();
		daySearchDrop.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
				19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31);
		daySearchDrop.setValue(01);
		
		//Year drop down
		ComboBox<Integer> yearSearchDrop2 = new ComboBox<>();
		daySearchDrop.getItems().addAll(2017,2018);
		daySearchDrop.setValue(2017);
		
		LocalDate arrLocDate = LocalDate.of(yearSearchDrop2.getValue(), Validator.intReturn(monthSearchDrop2.getValue()), daySearchDrop2.getValue());
		
		//hour dropdown
		ComboBox<String> hourDrop = new ComboBox<>();
		hourDrop.getItems().addAll("00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
				"13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23");
		hourDrop.setValue("00");
		int depHour = Integer.parseInt(hourDrop.getValue());
		//minute dropdown
		ComboBox<String> minuteDrop = new ComboBox<>();
		minuteDrop.getItems().addAll("00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", 
				"13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", 
				"30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", 
				"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59");
		minuteDrop.setValue("00");
		int depMinute = Integer.parseInt(minuteDrop.getValue());
		
		//hour dropdown
		ComboBox<String> hourArrDrop = new ComboBox<>();
		hourArrDrop.getItems().addAll("00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
				"13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23");
		hourArrDrop.setValue("00");
		int arrHour = Integer.parseInt(hourDrop.getValue());
		//minute dropdown
		ComboBox<String> minuteArrDrop = new ComboBox<>();
		minuteArrDrop.getItems().addAll("00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", 
				"13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", 
				"30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", 
				"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59");
		minuteArrDrop.setValue("00");
		int arrMinute = Integer.parseInt(minuteDrop.getValue());
		
		LocalTime depLocTime = LocalTime.of(depHour, depMinute);
		LocalTime arrLocTime = LocalTime.of(arrHour, arrMinute);
		double tp = Double.parseDouble(tPrice.getText());
		
		BigDecimal realTicketPrice = new BigDecimal(tp);
		
		
		//Buttons
		Button addButton = new Button("Add");
		addButton.setOnAction(e -> {
			Flight f = new Flight();
			f.setfID(Validator.intReturn(flightIDInput.getText()));
			f.setFlightNum(Validator.intReturn(flightNumberInput.getText()));
			f.setDepCity(depCityInput.getText());
			f.setArrCity(arrCityInput.getText());
			f.setDepDate(null);
			f.setArrDate(arrLocDate);
			f.setDepTime(depLocTime);
			f.setArrTime(arrLocTime);
			addButtonClicked(f);
			List<Flight> flarr = new ArrayList<>(f.searchFlights(f.fID));
			//flarr = f1.searchFlights(depCityDrop.getValue(), arrCityDrop.getValue(), lc);
			ObservableList<Flight> flightsFound = FXCollections.observableArrayList(flarr);
			flights.setItems(flightsFound);
		});
		Button deleteButton = new Button("Delete");
		deleteButton.setOnAction(e -> deleteButtonClicked());
		
		flights = new TableView<>();
//		flights.setItems(getFlights(f1,f2));
		flights.getColumns().addAll(flightnum, depCity, arrCity, depDate, arrDate, depTime, arrTime, 
				ticketPrice, seatsRem);
		
		GridPane grid2 = new GridPane();
		grid2.setPadding(new Insets(20));
		grid2.setVgap(8);
		grid2.setHgap(10);
		grid2.getChildren().addAll(depCityLabel, depCityDrop, arrCityLabel, arrCityDrop, 
	    		monthLabel, monthDrop,dayLabel, dayDrop, yearLabel, yearDrop, searchByInfoButton, 
	    		monthSearchDrop, daySearchDrop, yearSearchDrop, 
	    		monthSearchDrop2, daySearchDrop2, yearSearchDrop2, hourDrop, minuteDrop, 
	    		hourArrDrop, minuteArrDrop );
		//flightIDInput , searchByIDButton, orSearchByLabel
		VBox vBox2 = new VBox();
		vBox2.getChildren().addAll(flightIDInput, depCityInput, arrCityInput, addButton, deleteButton);
		vBox2.setPadding(new Insets(20, 50, 200, 10));
		//vBox2.setCenterShape(true);
		
		int c = 0;
		int r = ((c+1) * 2 - 1);
	//	GridPane.setConstraints(orSearchByLabel, 0, 2);

		GridPane.setConstraints(depCityLabel,c, r);
		GridPane.setConstraints(depCityDrop, c, r + 1);
		GridPane.setConstraints(arrCityLabel, c, r + 2);
		GridPane.setConstraints(arrCityDrop, c, r + 3);
		GridPane.setConstraints(monthLabel, c, r + 4);
		GridPane.setConstraints(monthDrop, c, r + 5);
		GridPane.setConstraints(dayLabel, c, r + 6);
		GridPane.setConstraints(dayDrop, c, r + 7);
		GridPane.setConstraints(yearLabel, c, r + 8);
		GridPane.setConstraints(yearDrop, c, r + 9);
		//GridPane.setConstraints(searchByIDButton, c, r - 1);
		//GridPane.setConstraints(flightIDInput, c + 5, r+10);
		GridPane.setConstraints(searchByInfoButton, c, r + 12);
		grid2.setStyle("-fx-background-color: DAE6F3;");

		border.setLeft(grid2);
		border.setCenter(vBox2);
		GridPane.setConstraints(border, 1 ,0);
		
		grid.setPadding(new Insets(20));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.getChildren().addAll( border);//flights,

//		HBox hBox = new HBox();
//		hBox.setPadding(new Insets(10));
//		hBox.setSpacing(10);
//		hBox.getChildren().addAll(flightNumInput, depCityInput, arrCityInput, addButton, deleteButton);
				
		VBox vBox = new VBox();
		vBox.getChildren().addAll(flights, grid); //hBox);
		Scene scene = new Scene(vBox);
		window.setScene(scene);
		window.show();

	}
	
//	public static ObservableList<Flight> getFlights(Flight f1, Flight f2){
//		ObservableList<Flight> flights = FXCollections.observableArrayList();		
//		flights.addAll(f1, f2);
//		return flights;
//	}
	
	public static void addButtonClicked(Flight f){
		Flight tempF = new Flight();
		tempF.createFlight(f);
	}
	
	public static void deleteButtonClicked(){
		ObservableList<Flight> flightSelected, allFlights;
		allFlights = flights.getItems();
		flightSelected = flights.getSelectionModel().getSelectedItems();
		flightSelected.forEach(allFlights::remove);
	}
	

}