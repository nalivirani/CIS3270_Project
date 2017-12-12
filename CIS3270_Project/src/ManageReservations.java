import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManageReservations {
	
	static TableView<Reservation> reservations;

	@SuppressWarnings("unchecked")
	public static void display(User tempUser) {
		
		Stage window = new Stage();
		
		Reservation tempReservation = new Reservation();

		//flightnum cl
		TableColumn<Reservation, Integer> flightNum = new TableColumn<>("Flight Number");
		flightNum.setMinWidth(150);
		flightNum.setCellValueFactory(new PropertyValueFactory<>("flightNum"));
		
		TableColumn<Reservation, Integer> ticketNum = new TableColumn<>("Ticket Number");
		ticketNum.setMinWidth(150);
		ticketNum.setCellValueFactory(new PropertyValueFactory<>("TicketNum"));
		
		TableColumn<Reservation, String> depCity = new TableColumn<>("Departure City");
		depCity.setMinWidth(250);
		depCity.setCellValueFactory(new PropertyValueFactory<>("depCity"));
		
		TableColumn<Reservation, String> arrCity = new TableColumn<>("Arrival City");
		arrCity.setMinWidth(250);
		arrCity.setCellValueFactory(new PropertyValueFactory<>("arrCity"));
		
		TableColumn<Reservation, LocalDate> depDate = new TableColumn<>("Departure Date");
		depDate.setMinWidth(100);
		depDate.setCellValueFactory(new PropertyValueFactory<>("depDate"));
		
		TableColumn<Reservation, LocalDate> arrDate = new TableColumn<>("Arrival Date");
		arrDate.setMinWidth(100);
		arrDate.setCellValueFactory(new PropertyValueFactory<>("arrDate"));
		
		List<Reservation> rearr = new ArrayList<>(tempReservation.searchReservations(tempUser.getSsn()));
		ObservableList<Reservation> reservationsFound = FXCollections.observableArrayList(rearr);		
		reservationsFound.addAll(rearr); 
		
		reservations = new TableView<>();
		
		reservations.getColumns().addAll(flightNum,ticketNum, depCity,arrCity, depDate, arrDate);
		reservations.setItems(reservationsFound);
		
//		GridPane grid = new GridPane();			
//		grid.setPadding(new Insets(20));
//		grid.setVgap(8);
//		grid.setHgap(10);
//		grid.getChildren().addAll(reservations);
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(reservations);
				
		Scene scene = new Scene(vBox);
		window.setScene(scene);
		window.show();
	}
	
//	
//	public static ObservableList<Reservation> getReservations(ArrayList<Reservation> r1, User u1){
//		List<Reservation> rearr = new ArrayList<>(r1.searchReservation(u1.getSsn()));
//	ObservableList<Reservation> reservations = FXCollections.observableArrayList(rearr);		
//	rervations.addAll(r1);
//		return flights;
//	}
		
		

}
