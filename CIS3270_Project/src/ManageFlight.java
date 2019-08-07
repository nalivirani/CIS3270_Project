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
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ManageFlight {
	static TableView<Flight> flights;
	
	static TextField flightNumInput;
	//static TextField depCityInput;
	//static TextField arrCityInput;
	static TextField flightIDInput;
	static TextField flightNumberInput;
	static TextField tPrice;
	
	@SuppressWarnings("unchecked")
	public static void display(User tempUser){
		
		GridPane grid = new GridPane();
		BorderPane border = new BorderPane();

		Button searchByInfoButton = new Button("Manage Flights");
		//Button searchByIDButton = new Button("Search by Flight ID");
		
		//labels
		//Label orSearchByLabel = new Label(" ~ OR SEARCH BY ~ ");
		
		Label fIDLabel = new Label("Flight ID: ");
		Label fnumLabel = new Label("Flight Number: ");
		
		Label depCityLabel = new Label("Departure City: ");
		Label depCityLabel2 = new Label("Departure City: ");

		Label arrCityLabel = new Label("Arrival City: ");
		Label arrCityLabel2 = new Label("Arrival City: ");
		
		Label monthLabel = new Label("Month: ");
		Label monthLabel2 = new Label("Dep Month: ");
		Label monthLabel3 = new Label("Arr Month: ");
		
		Label dayLabel = new Label("Day: ");
		Label dayLabel2 = new Label("Dep Day: ");
		Label dayLabel3 = new Label("Arr Day: ");
		
		Label yearLabel = new Label("Year: ");
		Label yearLabel2 = new Label("Dep Year: ");
		Label yearLabel3 = new Label("Arr Year: ");
		
		ComboBox<String> depCityDrop = new ComboBox<>();
		depCityDrop.getItems().addAll("ATL", "ORD", "DCA", "DFW", "JFK", "LAX", "MIA", "DEN");
		depCityDrop.setValue("Select");
		
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
		flightNumberInput.setPromptText("Flight Number");
		flightNumberInput.setMinWidth(100);

		//Departure City input ComboBox<String> question = new ComboBox<String>();
		ComboBox<String> depCityADD = new ComboBox<>();
		depCityADD.getItems().addAll("ATL", "ORD", "DCA", "DFW", "JFK", "LAX", "MIA", "DEN");
		depCityADD.setValue("Select");
		
		//Arrival City input
		ComboBox<String> arrCityADD = new ComboBox<>();
		arrCityADD.getItems().addAll("ATL", "ORD", "DCA", "DFW", "JFK", "LAX", "MIA", "DEN");
		arrCityADD.setValue("Select");
		
		//month drop down
		ComboBox<String> monthSearchDrop = new ComboBox<>();
		monthSearchDrop.getItems().addAll("January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November", "December");
		monthSearchDrop.setValue("Month");
		
		//Day drop down
//		ComboBox<Integer> daySearchDrop = new ComboBox<>();
//		daySearchDrop.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
//				19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31);
//		daySearchDrop.setValue(01);
		
		ComboBox<Integer> daySearchDrop = new ComboBox<>();
		daySearchDrop.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
				19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31);
		daySearchDrop.setValue(01);
		
		//Year drop down
		ComboBox<Integer> yearSearchDrop = new ComboBox<>();
		yearSearchDrop.getItems().addAll(2017,2018);
		yearSearchDrop.setValue(2017);
		
//		String month = monthSearchDrop.getValue();
//		int mon = Validator.intReturn(month);
//		int year = yearSearchDrop.getValue();
//		int day = daySearchDrop.getValue();
//		LocalDate depLocDate = LocalDate.of(year, mon ,day );

		//month drop down
		ComboBox<String> monthSearchDrop2 = new ComboBox<>();
		monthSearchDrop2.getItems().addAll("January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November", "December");
		monthSearchDrop2.setValue("Month");
		
		//Day drop down
		ComboBox<Integer> daySearchDrop2 = new ComboBox<>();
		daySearchDrop2.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
				19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31);
		daySearchDrop2.setValue(01);
		
		//Year drop down
		ComboBox<Integer> yearSearchDrop2 = new ComboBox<>();
		yearSearchDrop2.getItems().addAll(2017,2018);
		yearSearchDrop2.setValue(2017);
		
		ComboBox<String> monthSearchDrop3 = new ComboBox<>();
		monthSearchDrop3.getItems().addAll("January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November", "December");
		monthSearchDrop3.setValue("Month");
		
		//Day drop down
		ComboBox<Integer> daySearchDrop3 = new ComboBox<>();
		daySearchDrop3.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
				19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31);
		daySearchDrop3.setValue(01);
		
		//Year drop down
		ComboBox<Integer> yearSearchDrop3 = new ComboBox<>();
		yearSearchDrop3.getItems().addAll(2017,2018);
		yearSearchDrop3.setValue(2017);
		
		
		
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
		
		
//		double tp = Double.parseDouble(tPrice.getText());
//		
//		BigDecimal realTicketPrice = new BigDecimal(tp);
		
		BigDecimal price = new BigDecimal(100.00);
		
		//Buttons
		Button addButton = new Button("Add Flight");
		addButton.setOnAction(e -> {
			
			int d = Validator.intReturn(monthSearchDrop.getValue());
			LocalDate depaDate = LocalDate.of(yearSearchDrop.getValue(), d, daySearchDrop.getValue());
			
			int a = Validator.intReturn(monthSearchDrop2.getValue());
			LocalDate arriDate = LocalDate.of(yearSearchDrop2.getValue(), a, daySearchDrop2.getValue());
			
			LocalTime depLocTime = LocalTime.of(depHour, depMinute);
			LocalTime arrLocTime = LocalTime.of(arrHour, arrMinute);
			
			Flight f = new Flight();
			f.setfID(Validator.intReturn(flightIDInput.getText()));
			//f.setFlightNum();
			String s = flightNumberInput.getText();
			int a2 = Validator.intReturn(s);
			f.setFlightNum(a2);
			f.setDepCity(depCityADD.getValue());
			f.setArrCity(arrCityADD.getValue());
			f.setDepDate(depaDate);
			f.setArrDate(arriDate);
			f.setDepTime(depLocTime);
			f.setArrTime(arrLocTime);
			f.setTicketPrice(price);
			f.setSeatsRem(150);
			addButtonClicked(f);
			
			List<Flight> flarr = new ArrayList<>(f.searchFlights(f.fID));
			//flarr = f1.searchFlights(depCityDrop.getValue(), arrCityDrop.getValue(), lc);
			ObservableList<Flight> flightsFound = FXCollections.observableArrayList(flarr);
			flights.setItems(flightsFound);
		});
		
		
		Button deleteButton = new Button("Delete selected Flight");
		deleteButton.setOnAction(e -> {
			Flight temp = new Flight();
			temp = flights.getSelectionModel().getSelectedItems().get(0);
			deleteButtonClicked();
			int id = temp.getfID();
			temp.deleteFlight(id);
			
		});
		
		flights = new TableView<>();
//		flights.setItems(getFlights(f1,f2));
		flights.getColumns().addAll(flightnum, depCity, arrCity, depDate, arrDate, depTime, arrTime, 
				ticketPrice, seatsRem);
		
		GridPane grid2 = new GridPane();
		grid2.setPadding(new Insets(20));
		grid2.setVgap(8);
		grid2.setHgap(10);
		grid2.getChildren().addAll(depCityLabel, depCityDrop, arrCityLabel, arrCityDrop, 
	    		monthLabel, monthDrop, dayLabel, dayDrop, yearLabel, yearDrop, searchByInfoButton);
		//flightIDInput , searchByIDButton, orSearchByLabel
		GridPane grid3 = new GridPane();
		grid3.setPadding(new Insets(20));
		grid3.setVgap(8);
		grid3.setHgap(10);
		grid3.getChildren().addAll(flightIDInput, depCityADD, arrCityADD, flightNumberInput,
				monthSearchDrop, daySearchDrop, yearSearchDrop, 
	    		monthSearchDrop2, daySearchDrop2, yearSearchDrop2, hourDrop, minuteDrop, 
	    		hourArrDrop, minuteArrDrop,  addButton, deleteButton, depCityLabel2, arrCityLabel2,
	    		monthLabel2, monthLabel3, dayLabel2, dayLabel3, yearLabel2, yearLabel3, fIDLabel, fnumLabel);
		grid3.setPadding(new Insets(20, 50, 200, 10));
		//vBox2.setCenterShape(true);
		
		GridPane.setConstraints(fIDLabel, 0, 0);
		GridPane.setConstraints(flightIDInput, 1, 0);
		GridPane.setConstraints(fnumLabel, 2, 0);
		GridPane.setConstraints(flightNumberInput, 3, 0);
		GridPane.setConstraints(depCityLabel2, 0 ,1);
		GridPane.setConstraints(depCityADD, 1 ,1);
		GridPane.setConstraints(arrCityLabel2, 0, 2);
		GridPane.setConstraints(arrCityADD, 1, 2);
		
		GridPane.setConstraints(monthLabel2, 0, 3);
		GridPane.setConstraints(monthSearchDrop, 0, 4);
		GridPane.setConstraints(dayLabel2, 1, 3);
		GridPane.setConstraints(daySearchDrop, 1, 4);
		GridPane.setConstraints(yearLabel2, 2, 3);
		GridPane.setConstraints(yearSearchDrop, 2, 4);
		
		GridPane.setConstraints(monthLabel3, 0, 5);
		GridPane.setConstraints(monthSearchDrop2, 0, 6);
		GridPane.setConstraints(dayLabel3, 1, 5);
		GridPane.setConstraints(daySearchDrop2, 1, 6);
		GridPane.setConstraints(yearLabel3, 2, 5);
		GridPane.setConstraints(yearSearchDrop2, 2, 6);
		
		GridPane.setConstraints(hourDrop, 3, 4);
		GridPane.setConstraints(minuteDrop, 4, 4);
		GridPane.setConstraints(hourArrDrop, 3, 6);
		GridPane.setConstraints(minuteArrDrop, 4, 6);
		GridPane.setConstraints(addButton, 1, 10);
		GridPane.setConstraints(deleteButton, 1, 11);
		
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
//monthSearchDrop, daySearchDrop, yearSearchDrop, 
//		monthSearchDrop2, daySearchDrop2, yearSearchDrop2, hourDrop, minuteDrop, 
//		hourArrDrop, minuteArrDrop 
		
		
		
		border.setLeft(grid2);
		border.setCenter(grid3);
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
		//Reservation tempR = new Reservation();
		tempF.createFlight(f);
		//tempR.createReservation(tempF, u);
	}
	
	public static void deleteButtonClicked(){
		ObservableList<Flight> flightSelected, allFlights;
		allFlights = flights.getItems();
		flightSelected = flights.getSelectionModel().getSelectedItems();
		flightSelected.forEach(allFlights::remove);
	}
	

}