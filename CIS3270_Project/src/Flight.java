import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.math.BigDecimal;

public class Flight extends Database{
	
	private static final String TABLE = "flight";
	protected int fID;
	protected int flightNum;
	protected String depCity;
	protected String arrCity;
	protected LocalDate depDate;
	protected LocalDate arrDate;
	protected LocalTime depTime; 
	protected LocalTime arrTime;
	protected int distance;
	protected String stopType;
	protected String region;
	protected BigDecimal ticketPrice;
	protected BigDecimal fcTicketPrice;
	protected int seats;
	protected int seatsRem;
	protected int numRows;
	protected int seatsPerRow;
		
	public Flight() {
		
	}
	
	public Flight(int flightNum, LocalDate depDate, LocalTime depTime) {
		this.flightNum = flightNum;
		this.depDate   = depDate;
		this.depTime   = depTime;
	}
	
	public Flight(int fID, int flightNum, String depCity, String arrCity, LocalDate depDate, LocalDate arrDate,
				  LocalTime depTime, LocalTime arrTime, int distance, String stopType, String region, BigDecimal ticketPrice,
				  BigDecimal fcTicketPrice, int seats, int seatsRem, int numRows, int seatsPerRow) {
		
		this.fID = fID;
		this.flightNum = flightNum;
		this.depCity = depCity;
		this.arrCity = arrCity;
		this.depDate = depDate;
		this.arrDate = arrDate;
		this.depTime = depTime;
		this.arrTime = arrTime;
		this.distance = distance;
		this.stopType = stopType;
		this.region = region;
		this.ticketPrice = ticketPrice;
		this.fcTicketPrice = fcTicketPrice;
		this.seats = seats;
		this.seatsRem = seatsRem;
		this.numRows = numRows;
		this.seatsPerRow = seatsPerRow;
	}
	
	public int getfID() {
		return fID;
	}

	public void setfID(int fID) {
		this.fID = fID;
	}
	
	public int getFlightNum() {
		return flightNum;
	}
	
	public void setFlightNum(int flightNum) {
		this.flightNum = flightNum;
	}
	
	public LocalDate getDepDate() {
		return depDate;
	}
	
	public void setDepDate(LocalDate depDate) {
		this.depDate = depDate;
	}
	
	public LocalTime getDepTime() {
		return depTime;
	}
	
	public void setDepTime(LocalTime depTime) {
		this.depTime = depTime;
	}

	public String getDepCity() {
		return depCity;
	}
	
	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}
	
	public LocalDate getArrDate() {
		return arrDate;
	}
	
	public void setArrDate(LocalDate arrDate) {
		this.arrDate = arrDate;
	}
	
	public LocalTime getArrTime() {
		return arrTime;
	}
	
	public void setArrTime(LocalTime arrTime) {
		this.arrTime = arrTime;
	}
	
	public String getArrCity() {
		return arrCity;
	}
	
	public void setArrCity(String arrCity) {
		this.arrCity = arrCity;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public String getStopType() {
		return stopType;
	}
	
	public void setStopType(String stopType) {
		this.stopType = stopType;
	}
	
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
	public BigDecimal getTicketPrice() {
		return ticketPrice;
	}
	
	public void setTicketPrice(BigDecimal ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	public BigDecimal getFcTicketPrice() {
		return fcTicketPrice;
	}
	
	public void setFcTicketPrice(BigDecimal fcTicketPrice) {
		this.fcTicketPrice = fcTicketPrice;
	}
	
	public int getSeatsRem() {
		return seatsRem;
	}
	
	public void setSeatsRem(int seatsRem) {
		this.seatsRem = seatsRem;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getNumRows() {
		return numRows;
	}

	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}

	public int getSeatsPerRow() {
		return seatsPerRow;
	}

	public void setSeatsPerRow(int seatsPerRow) {
		this.seatsPerRow = seatsPerRow;
	}
	
	/*******************************************************************/

	public void seatRemInc(int n) {
		this.seatsRem += n;
	}
	
	public void seatRemDec(int n) {
		this.seatsRem -= n;
	}
	
	public void seatRemInc() {
		this.seatsRem += 1;
	}
	
	public void seatRemDec() {
		this.seatsRem -= 1;
	}
	
	public void printLocalDate() {
		System.out.println(" " + this.depDate);
	}
	
	public void printLocalTime() {
		System.out.println(" " + this.depTime);
	}
	
/*********************************************************************************
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>*
 * ><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><*
 *																				 *
 *********************************************************************************/


	public void updateFlightNum(int fID, int flightNum) {
		this.setFlightNum(flightNum);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update " + TABLE + " set flightNum = ? where id = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setInt(1, flightNum);
			userUpdate.setInt(2, fID);
			userUpdate.executeUpdate();
		}
		
		catch(Exception e) {
			
		}
	}
	
	public void updateDepCity(int fID, String depCity) {
		this.setDepCity(depCity);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update " + TABLE + " set depCity = ? where id = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setString(1, depCity);
			userUpdate.setInt(2, fID);
			userUpdate.executeUpdate();
		}
		
		catch(Exception e) {
			
		}
	}
	
	public void updateArrCity(int fID, String arrCity) {
		this.setDepCity(arrCity);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update " + TABLE + " set arrCity = ? where id = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setString(1, arrCity);
			userUpdate.setInt(2, fID);
			userUpdate.executeUpdate();
		}
		
		catch(Exception e) {
			
		}
	}
	
	public void updateDepDate(int fID, LocalDate depDate) {
		this.setDepDate(depDate);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update " + TABLE + " set depDate = ? where id = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setString(1, (depDate.toString()));
			userUpdate.setInt(2, fID);
			userUpdate.executeUpdate();
		}
		
		catch(Exception e) {
			
		}
	}
	
	public void updateArrDate(int fID, LocalDate arrDate) {
		this.setArrDate(arrDate);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update " + TABLE + " set arrDate = ? where id = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setString(1, (arrDate.toString()));
			userUpdate.setInt(2, fID);
			userUpdate.executeUpdate();
		}
		
		catch(Exception e) {
			
		}
	}
	
	public void updateDepTime(int fID, LocalTime depTime) {
		this.setDepTime(depTime);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update " + TABLE + " set depTime = ? where id = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setString(1, (depTime.toString()));
			userUpdate.setInt(2, fID);
			userUpdate.executeUpdate();
		}
		
		catch(Exception e) {
			
		}
	}
	
	public void updateArrTime(int fID, LocalTime arrTime) {
		this.setArrTime(arrTime);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update " + TABLE + " set arrTime = ? where id = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setString(1, (arrTime.toString()));
			userUpdate.setInt(2, fID);
			userUpdate.executeUpdate();
		}
		
		catch(Exception e) {
			
		}
	}
	
	public void updateDistance(int fID, int distance) {
		this.setDistance(distance);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update " + TABLE + " set distance = ? where id = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setInt(1, distance);
			userUpdate.setInt(2, fID);
			userUpdate.executeUpdate();
		}
		
		catch(Exception e) {
			
		}
	}
	
	public void updateStopType(int fID, String stopType) {
		this.setStopType(stopType);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update " + TABLE + " set stopType = ? where id = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setString(1, stopType);
			userUpdate.setInt(2, fID);
			userUpdate.executeUpdate();
		}
		
		catch(Exception e) {
			
		}
	}
	
	public void updateRegion(int fID, String region) {
		this.setRegion(region);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update " + TABLE + " set region = ? where id = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setString(1, region);
			userUpdate.setInt(2, fID);
			userUpdate.executeUpdate();
		}
		
		catch(Exception e) {
			
		}
	}
	
	public void updateTicketPrice(int fID, BigDecimal ticketPrice) {
		this.setTicketPrice(ticketPrice);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update " + TABLE + " set ticketPrice = ? where id = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setBigDecimal(1, ticketPrice);
			userUpdate.setInt(2, fID);
			userUpdate.executeUpdate();
		}
		
		catch(Exception e) {
			
		}
	}
	
	public void updateFCticketPrice(int fID, BigDecimal fcTicketPrice) {
		this.setFcTicketPrice(fcTicketPrice);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update " + TABLE + " set fcTicketPrice = ? where id = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setBigDecimal(1, fcTicketPrice);
			userUpdate.setInt(2, fID);
			userUpdate.executeUpdate();
		}
		
		catch(Exception e) {
			
		}
	}
	
	public void updateNumOfSeats(int fID, int seats) {
		this.setSeats(seats);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update " + TABLE + " set seats = ? where id = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setInt(1, seats);
			userUpdate.setInt(2, fID);
			userUpdate.executeUpdate();
		}
		
		catch(Exception e) {
			
		}
	}
	
	public void updateSeatsRem(int fID, int seatsRem) {
		this.setSeatsRem(seatsRem);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update " + TABLE + " set seatsRem = ? where id = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setInt(1, seatsRem);
			userUpdate.setInt(2, fID);
			userUpdate.executeUpdate();
		}
		
		catch(Exception e) {
			
		}
	}
	
	public void updateNumRows(int fID, int numRows) {
		this.setNumRows(numRows);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update " + TABLE + " set numRows = ? where id = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setInt(1, numRows);
			userUpdate.setInt(2, fID);
			userUpdate.executeUpdate();
		}
		
		catch(Exception e) {
			
		}
	}
	
	public void updateSeatsPerRow(int fID, int seatsPerRow) {
		this.setSeatsPerRow(seatsPerRow);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update " + TABLE + " set seatsPerRow = ? where id = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setInt(1, seatsPerRow);
			userUpdate.setInt(2, fID);
			userUpdate.executeUpdate();
		}
		
		catch(Exception e) {
			
		}
	}
	
	public void setFlightFull() {
		this.setSeatsRem(0);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update " + TABLE + " set seatsRem = ? where id = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setInt(1, 0);
			userUpdate.setInt(2, this.fID);
			userUpdate.executeUpdate();
		}
		
		catch(Exception e) {
			
		}
	}
	
	public void setFlightFull(int fID) {
		this.setSeatsRem(0);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update " + TABLE + " set seatsRem = ? where id = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setInt(1, 0);
			userUpdate.setInt(2, fID);
			userUpdate.executeUpdate();
		}
		
		catch(Exception e) {
			
		}
	}
	
// -------------------------------------------------------------------------------------------------------------------
	
	public void setFlightEmpty() {
		this.setSeatsRem(this.seats);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update " + TABLE + " set seatsRem = ? where id = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setInt(1, this.seats);
			userUpdate.setInt(2, this.fID);
			userUpdate.executeUpdate();
		}
		
		catch(Exception e) {
			
		}
	}
	
	public void setFlightEmpty(int fID) {
		this.setSeatsRem(this.seats);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update " + TABLE + " set seatsRem = ? where id = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setInt(1, this.seats);
			userUpdate.setInt(2, fID);
			userUpdate.executeUpdate();
		}
		
		catch(Exception e) {
			
		}
	}
	
// -------------------------------------------------------------------------------------------------------------------
	
	public void createFlight(Flight f) {
		
		try {
			
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String insertStatement = "insert into " + TABLE + " (id, flightNum, depCity, arrCity, depDate, arrDate, " + 
								    						    "depTime, arrTime, distance, stopType, region, ticketPrice, " +
								    						    "fcTicketPrice, seats, seatsRem, numRows, seatsPerRow) " + 
								    						    "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
			PreparedStatement flightInsert = c.prepareStatement(insertStatement);
		
			flightInsert.setInt       (1, f.fID);
			flightInsert.setInt       (2, f.flightNum);
			flightInsert.setString    (3, f.depCity);
			flightInsert.setString    (4, f.arrCity);
			flightInsert.setString    (5, f.depDate.toString());
			flightInsert.setString    (6, f.arrDate.toString());
			flightInsert.setString    (7, f.depTime.toString());
			flightInsert.setString    (8, f.arrTime.toString());
			flightInsert.setInt       (9, f.distance);
			flightInsert.setString    (10,f.stopType);
			flightInsert.setString    (11,f.region);
			flightInsert.setBigDecimal(12, f.ticketPrice);
			flightInsert.setBigDecimal(13, f.fcTicketPrice);
			flightInsert.setInt       (14, f.seats);
			flightInsert.setInt       (15, f.seatsRem);
			flightInsert.setInt       (16, f.numRows);
			flightInsert.setInt       (17, f.seatsPerRow);
			
			flightInsert.executeUpdate();
		}
		
		catch (Exception e){
			System.out.println("It looks like you entered a duplicate flight. Please try again.");		
		}
	}

/*********************************************************************************
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>*
 * ><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><*
 *																				 *
 *********************************************************************************/
		
	
	@Override
	public boolean equals(Object o) {
		
		if(!(o instanceof Flight)) {
			return false;
		}
	
		Flight f = (Flight) o;
		
		if(this.flightNum == f.flightNum && this.depDate == f.depDate && this.depTime == f.depTime) {
			return true;
		}
			
		else return false;
	}

	@Override
	public String toString() {
			
		return "Flight Number: " + this.getFlightNum() + "\nFrom: " + this.getDepCity() + " To: " + this.getArrCity() + "\nDeparting: " + this.getDepDate() + 
				" at " + this.getDepTime() + "\nEstimated Arrival: " + this.getArrTime() + " at "+ this.getArrDate() + "\n\nService: " + this.getStopType() + 
				"\nTicket Prices: \n\tFirst Class: " + this.getFcTicketPrice() + "\n\tEconomy: " + this.getTicketPrice() + " \n\n\n";
	}
	
	

	public void updateFlight(int ssn, String fName, String lName, String address, int zip, String state, String userName, String password, String email, String securityQuestion, String securityAnswer, int permissionLevel) {
		
		try {
			
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String insertStatement = "insert into user (SSN, FirstName, LastName, address, zip, State, Username, Password, email, " +
				 "SecurityQuestion, SecurityAnswer, PermissionLevel) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
			PreparedStatement flightInsert = c.prepareStatement(insertStatement);
		
			flightInsert.setInt   (1, ssn);
			flightInsert.setString(2, fName);
			flightInsert.setString(3, lName);
			
			flightInsert.setString(4, address);
			flightInsert.setInt   (5, zip);
			flightInsert.setString(6, state);
			
			flightInsert.setString(7, userName);
			flightInsert.setString(8, password);
			flightInsert.setString(9, email);
			
			flightInsert.setString(10,securityQuestion);
			flightInsert.setString(11,securityAnswer);
			flightInsert.setInt   (12, 0);
			
			flightInsert.executeUpdate();
		}
		
		catch (Exception e){
			e.printStackTrace();
			
		}	
	}
	
	public String[] checkCity(String depCity) {
		
		String[] cities = new String[7];
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String query = "select * from cities Where depCity=?";
		
			PreparedStatement flightQuery = c.prepareStatement(query);
			flightQuery.setString(1, depCity);
		
			ResultSet rs = flightQuery.executeQuery();
			
			while (rs.next()) {
								
				cities[0] = rs.getString("depCity");
				cities[1] = rs.getString("arCityOne");
				cities[2] = rs.getString("arCityTwo");
				cities[3] = rs.getString("arCityThr");
				cities[4] = rs.getString("arCityFor");
				cities[5] = rs.getString("arCityFve");
				cities[6] = rs.getString("arCitySix");}
			}
		
		catch (Exception e) {
			System.out.println("yay! you found an exception");
		}
		
		return cities;
	}
	
	public ArrayList<Flight> searchFlights (String depCity, String arrCity, LocalDate depDate) {
		
	//	ArrayList<Flight> flights = FXCollections.observableArrayList();
		ArrayList<Flight> flights = new ArrayList<>();
		
		Date dDate = new Date(0);
		Time dTime = new Time(0);
		Date aDate = new Date(0);
		Time aTime = new Time(0);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String query = "select * from " + TABLE + " Where depCity=? and arrCity=? and depDate=?";
		
			PreparedStatement flightQuery = c.prepareStatement(query);
			flightQuery.setString(1, depCity);
			flightQuery.setString(2, arrCity);
			flightQuery.setString(3, depDate.toString());
		
			ResultSet rs = flightQuery.executeQuery();		
			
			while (rs.next()) {
				
				dDate = rs.getDate("depDate");
				aDate = rs.getDate("arrDate");
				
				dTime = rs.getTime("depTime");
				aTime = rs.getTime("arrTime");
				
				flights.add(new Flight(
						
										rs.getInt("id"), 
										rs.getInt("flightNum"), 
										rs.getString("depCity"),
										rs.getString("arrCity"),
				
										dDate.toLocalDate(),
										aDate.toLocalDate(),
				
										dTime.toLocalTime(),
										aTime.toLocalTime(),
				
										rs.getInt("distance"),
										rs. getString("stopType"),
										rs.getString("region"),
				
										rs.getBigDecimal("ticketPrice"),
										rs.getBigDecimal("fcTicketPrice"),
										
										rs.getInt("seats"),
										rs.getInt("seatsRem"),
										rs.getInt("numRows"),
										rs.getInt("seatsPerRow")
				));
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return flights;
	}

	public ArrayList<Flight> searchFlights (int flightID) {
		
		ArrayList<Flight> flights = new ArrayList<>();
		
		Date dDate = new Date(0);
		Time dTime = new Time(0);
		Date aDate = new Date(0);
		Time aTime = new Time(0);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String query = "select * from " + TABLE + " Where id=?";
		
			PreparedStatement flightQuery = c.prepareStatement(query);
			flightQuery.setInt(1, flightID);
		
			ResultSet rs = flightQuery.executeQuery();		
			
			while (rs.next()) {
				
				dDate = rs.getDate("depDate");
				aDate = rs.getDate("arrDate");
				
				dTime = rs.getTime("depTime");
				aTime = rs.getTime("arrTime");
				
				flights.add(new Flight(
						
										rs.getInt("id"), 
										rs.getInt("flightNum"), 
										rs.getString("depCity"),
										rs.getString("arrCity"),
				
										dDate.toLocalDate(),
										aDate.toLocalDate(),
				
										dTime.toLocalTime(),
										aTime.toLocalTime(),
				
										rs.getInt("distance"),
										rs. getString("stopType"),
										rs.getString("region"),
				
										rs.getBigDecimal("ticketPrice"),
										rs.getBigDecimal("fcTicketPrice"),
										
										rs.getInt("seats"),
										rs.getInt("seatsRem"),
										rs.getInt("numRows"),
										rs.getInt("seatsPerRow")
				));
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return flights;
	}

	public String deleteFlight(int fID) {
		
		String response = "";
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String deleteStatement = "delete from " + TABLE + " Where id=?";
			PreparedStatement flightDelete = c.prepareStatement(deleteStatement);
			
			flightDelete.setInt(1, fID);
			flightDelete.executeUpdate();
			
			response = "The flight was succesfully deleted.";
			
			AlertBox1.display("Success", "This flight was deleted");
		}
		
		catch (Exception e) {
			response = "Something went wrong. Please try your request again.";
					
		}
		
		return response;
	}

}
