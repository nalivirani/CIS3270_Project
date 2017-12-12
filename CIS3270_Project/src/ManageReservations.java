import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManageReservations {
	
	static TableView<Reservation> reservations;

	@SuppressWarnings("unchecked")
	public static void display(User tempUser) {
		
		Stage window = new Stage();
		BorderPane border = new BorderPane();
		
		Reservation tempReservation = new Reservation();
		
		Button deleteReservation = new Button("Delete reservation");

		//flightnum cl
		
		TableColumn<Reservation, Integer> ticketNum = new TableColumn<>("Ticket Number");
		ticketNum.setMinWidth(150);
		ticketNum.setCellValueFactory(new PropertyValueFactory<>("TicketNum"));
		
		TableColumn<Reservation, Integer> flightNum = new TableColumn<>("Flight Number");
		flightNum.setMinWidth(150);
		flightNum.setCellValueFactory(new PropertyValueFactory<>("flightNum"));
		
		TableColumn<Reservation, String> depCity = new TableColumn<>("Departure City");
		depCity.setMinWidth(150);
		depCity.setCellValueFactory(new PropertyValueFactory<>("depCity"));
		
		TableColumn<Reservation, String> arrCity = new TableColumn<>("Arrival City");
		arrCity.setMinWidth(125);
		arrCity.setCellValueFactory(new PropertyValueFactory<>("arrCity"));
		
		TableColumn<Reservation, LocalDate> depDate = new TableColumn<>("Departure Date");
		depDate.setMinWidth(250);
		depDate.setCellValueFactory(new PropertyValueFactory<>("depDate"));
		
		TableColumn<Reservation, LocalDate> arrDate = new TableColumn<>("Arrival Date");
		arrDate.setMinWidth(200);
		arrDate.setCellValueFactory(new PropertyValueFactory<>("arrDate"));
		
		TableColumn<Reservation, BigDecimal> ticketPrice = new TableColumn<>("Ticket Price");
		ticketPrice.setMinWidth(100);
		ticketPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		List<Reservation> rearr = new ArrayList<>(tempReservation.searchReservations(tempUser.getSsn()));
		ObservableList<Reservation> reservationsFound = FXCollections.observableArrayList(rearr);		
		//reservationsFound.addAll(rearr); 
		
		reservations = new TableView<>();
		
		reservations.getColumns().addAll(ticketNum, depCity,arrCity, depDate, ticketPrice);
		reservations.setItems(reservationsFound);
		
		deleteReservation.setOnAction(e -> {
			Reservation temp = new Reservation();
			temp = reservations.getSelectionModel().getSelectedItems().get(0);
			deleteButtonClicked();
			System.out.println(temp.getTicketNum());
			temp.deleteReservation(temp.getTicketNum());
		
		});
		
//		GridPane grid = new GridPane();			
//		grid.setPadding(new Insets(20));
//		grid.setVgap(8);
//		grid.setHgap(10);
//		grid.getChildren().addAll(reservations);
		
		border.setBottom(deleteReservation);
		VBox vBox = new VBox();
		vBox.getChildren().addAll(reservations, border);
				
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
	
	public static void deleteButtonClicked(){
		//Reservation r = new Reservation();
		ObservableList<Reservation> reservationSelected, allReservations;
		allReservations = reservations.getItems();
		reservationSelected = reservations.getSelectionModel().getSelectedItems();
		reservationSelected.forEach(allReservations::remove);
		//((Reservation) reservationSelected).deleteReservation(r); 
	}
	
		
		

}
