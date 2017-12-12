import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FlightFind {
	
	static TableView<Flight> flights;
	
	@SuppressWarnings("unchecked")
	public static void display(){
		
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
		
		//labels
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
//		GridPane.setValignment(depCityLabel, VPos.CENTER);
//		GridPane.setHalignment(depCityLabel, HPos.LEFT);
//		GridPane.setConstraints(depCityLabel, 1,0);
		
		//Day drop down
		ComboBox<Integer> dayDrop = new ComboBox<>();
		dayDrop.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
				19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31);
		dayDrop.setValue(01);
//		GridPane.setValignment(depCityLabel, VPos.CENTER);
//		GridPane.setHalignment(depCityLabel, HPos.LEFT);
//		GridPane.setConstraints(depCityLabel, 1,0);
		
		//Year drop down
		ComboBox<Integer> yearDrop = new ComboBox<>();
		yearDrop.getItems().addAll(2017,2018);
		yearDrop.setValue(2017);
//		GridPane.setValignment(depCityLabel, VPos.CENTER);
//		GridPane.setHalignment(depCityLabel, HPos.LEFT);
//		GridPane.setConstraints(depCityLabel, 1,0);
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
		
		TableColumn<Flight, Integer> flightnum = new TableColumn<>("Flight Number");
		flightnum.setMinWidth(50);
		flightnum.setCellValueFactory(new PropertyValueFactory<>("flightNum"));
		
		TableColumn<Flight, String> depCity = new TableColumn<>("Departure City");
		depCity.setMinWidth(250);
		depCity.setCellValueFactory(new PropertyValueFactory<>("depCity"));
		
		TableColumn<Flight, String> arrCity = new TableColumn<>("Arrival City");
		arrCity.setMinWidth(250);
		arrCity.setCellValueFactory(new PropertyValueFactory<>("arrCity"));
		
		TableColumn<Flight, LocalDate> depDate = new TableColumn<>("Departure Date");
		depDate.setMinWidth(250);
		depDate.setCellValueFactory(new PropertyValueFactory<>("depDate"));
		
		TableColumn<Flight, LocalDate> arrDate = new TableColumn<>("Arrival Date");
		arrDate.setMinWidth(250);
		arrDate.setCellValueFactory(new PropertyValueFactory<>("arrDate"));
		
		TableColumn<Flight, LocalTime> depTime = new TableColumn<>("Departure Time");
		depTime.setMinWidth(250);
		depTime.setCellValueFactory(new PropertyValueFactory<>("depTime"));
		
		TableColumn<Flight, LocalTime> arrTime = new TableColumn<>("Arrival Time");
		arrTime.setMinWidth(250);
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
		ticketPrice.setMinWidth(250);
		ticketPrice.setCellValueFactory(new PropertyValueFactory<>("ticketPrice"));
		
		TableColumn<Flight, BigDecimal> fcTicketPrice = new TableColumn<>("fc Ticket Price");
		fcTicketPrice.setMinWidth(250);
		fcTicketPrice.setCellValueFactory(new PropertyValueFactory<>("fcTicketPrice"));
		
		TableColumn<Flight, Integer> seats = new TableColumn<>("seats");
		seats.setMinWidth(150);
		seats.setCellValueFactory(new PropertyValueFactory<>("seats"));
		
		TableColumn<Flight, Integer> seatsRem = new TableColumn<>("seatsRem");
		seatsRem.setMinWidth(150);
		seatsRem.setCellValueFactory(new PropertyValueFactory<>("seatsRem"));
		
		TableColumn<Flight, Integer> numRows = new TableColumn<>("numRows");
		numRows.setMinWidth(150);
		numRows.setCellValueFactory(new PropertyValueFactory<>("numRows"));
		
		TableColumn<Flight, Integer> seatsPerRow = new TableColumn<>("seatsPerRow");
		seatsPerRow.setMinWidth(150);
		seatsPerRow.setCellValueFactory(new PropertyValueFactory<>("seatsPerRow"));
		
		
		
//		searchButton.setOnAction(e -> {
//			f1.searchFlights(null, null, null);
//		});
		// arr time
		// dep time
		
		
		//checkCity  f1.checkCity(depCity)
		
		//search button
//		ArrayList<Flight> fArr = new 
//				ArrayList<Flight>(f1.searchFlights(depCity.getText(), arrCity.getText(), lc));
	//	ObservableList<Flight> flightsFound = FXCollections.observableArrayList();
		//ArrayList<Flight> flightsFound = new ArrayList<>();
		searchByInfoButton.setOnAction(e ->{
			int m = Validator.intReturn(monthDrop.getValue());
			LocalDate lc = LocalDate.of(yearDrop.getValue(), m, dayDrop.getValue());
			Flight f1 = new Flight();
			List<Flight> flarr = new ArrayList<>(f1.searchFlights(depCityDrop.getValue(), arrCityDrop.getValue(), lc));
			//flarr = f1.searchFlights(depCityDrop.getValue(), arrCityDrop.getValue(), lc);
			ObservableList<Flight> flightsFound = FXCollections.observableArrayList(flarr);
			flights.setItems(flightsFound);
//			Iterator<Flight> i = (f1.searchFlights(depCityDrop.getValue(), arrCityDrop.getValue(), lc)).iterator();
//			
//			
//			while(i.hasNext()){
//				System.out.println(i.next()); 
//				flarr.add(i.next());
//			}
//			
//				if(f1.searchFlights(depCityDrop.getValue(), arrCityDrop.getValue(), lc).isEmpty()) {
//					System.out.println("It looks like we didn't find any flights matching your criteria. " +
//									   "Try your search again with a different city or departure date.");
//				}
//				else{
//					Iterator<Flight> x = flarr.iterator();
//					while(x.hasNext()){
//						System.out.println(x.next()); 
//						flightsFound.add(x.next());
//					}
//					ArrayList<Flight> flarr = new ArrayList<>(f1.searchFlights(depCity.getText(), arrCity.getText(), lc));
//					Iterator<Flight> i = flarr.iterator();
//					while (i.hasNext()) {
////					flarr.forEach(f1 = i.next());
//					flightsFound.add(f1);
					
				});
		//(f1.searchFlights(depCity.getText(), arrCity.getText(), lc))
				//f.addAll(f1.searchFlights(depCity.getText(), arrCity.getText(), lc))
		
//				f.updateArrDate(1, LocalDate.of(2017, 12, 25));
//				else {
//					for(Flight s : f){
//						f.addAll(f1.searchFlights(depCity.getText(), arrCity.getText(), lc));	
//					}
//				}
				//else {
					//ObservableList<Flight> arr = FXCollections.observableArrayList();
			
		//};
//		});

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
	    		monthLabel, monthDrop,dayLabel, dayDrop, yearLabel, yearDrop, searchByInfoButton);
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
		grid2.setStyle("-fx-background-color: DAE6F3;");

		border.setRight(grid2);
		GridPane.setConstraints(border, 1 ,0);
		
		grid.setPadding(new Insets(20));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.getChildren().addAll(flights, border);
				
		Scene scene = new Scene(grid);
		window.setScene(scene);
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
