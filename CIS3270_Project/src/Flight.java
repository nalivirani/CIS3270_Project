//import java.util.Calendar;
import java.time.LocalDateTime;
//import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.time.ZonedDateTime;
//import java.sql.Time;
//import java.text.DateFormat;
//import java.time.*;
import java.math.BigDecimal;
//import java.text.*;

@SuppressWarnings("unused")
public class Flight extends Database{
	
	private static final String TABLE = "flight";
	protected int flightNum;
	//protected java.sql.Date depDate;
	protected java.time.LocalDateTime depDateTime;
	protected String depCity;
	protected java.time.LocalDateTime arrDateTime;
	//protected Time arrTime;
	protected String arrCity;
	protected int distance;
	protected String stopType;
	protected String region;
	protected BigDecimal ticketPrice;
	protected BigDecimal fcTicketPrice;
	protected int seats;
	protected int seatsRem;
		
	public Flight(){
		
	}
	
	public Flight(int flightNum, java.time.LocalDateTime depDateTime) {
		this.flightNum = flightNum;
		this.depDateTime = depDateTime;
	}
		
	public int getFlightNum() {
		return flightNum;
	}
	public void setFlightNum(int flightNum) {
		this.flightNum = flightNum;
	}
	public java.time.LocalDateTime getDepDateTime() {
		return depDateTime;
	}
	public void setDepDateTime(java.time.LocalDateTime depDateTime) {
		this.depDateTime = depDateTime;
	}
//	public java.time.LocalDateTime getDepTime() {
	//	return depDateTime;
//	}
	//public void setDepTime(java.time.LocalDateTime depDateTime) {
	//	this.depTime = depTime;
	//}
	public String getDepCity() {
		return depCity;
	}
	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}
	public java.time.LocalDateTime getArrDateTime() {
		return arrDateTime;
	}
	public void setArrDateTime(java.time.LocalDateTime arrDateTime) {
		this.arrDateTime = arrDateTime;
	}
	//public Time getArrTime() {
	//	return arrTime;
	//}
	//public void setArrTime(Time arrTime) {
	//	this.arrTime = arrTime;
	//}
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
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public int getSeatsRem() {
		return seatsRem;
	}
	public void setSeatsRem(int seatsRem) {
		this.seatsRem = seatsRem;
	}
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
	
	public void printLocalDateTime() {
		System.out.println(" " + this.depDateTime);
	}

	@Override
	public boolean equals(Object o) {
		
		if(!(o instanceof Flight)) {
			return false;
		}
	
		Flight f = (Flight) o;
		
		if(this.flightNum == f.flightNum && this.depDateTime == f.depDateTime) {
			return true;
		}
			
		else return false;
	}

	@Override
	public String toString() {
			
		return "Flight Number: " + this.getFlightNum() + "\nFrom: " + this.getDepCity() + " To: " + this.getArrCity() + "\nDeparting: " + this.getDepDateTime() + 
				"\nEstimated Arrival: " + this.getArrDateTime() + "\n\nService: " + this.getStopType() + 
				"\nTicket Prices: \nFirst Class: " + this.getFcTicketPrice() + "\nEconomy: " + this.getTicketPrice();
	}
	
//	@SuppressWarnings("finally")
	public Flight pQuery(int flightNum) {
		
		System.out.println("\nDatabase: " + super.schema +"\nTable: " + Flight.TABLE);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getUsername(), super.getPassword());
		
			//String query = "select * from Flight Where depCity=? and arrCity=? and depDate=?";
			String query = "select * from Flight Where flightNum=?";
		
			PreparedStatement flightQuery = c.prepareStatement(query);
			flightQuery.setInt(1, flightNum);
			//userQuery.setString(2, arrCity);
			//userQuery.setDate  (3, depDate);
		
			ResultSet rs = flightQuery.executeQuery();
			
		//	DateFormat df = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss z");
		
			while (rs.next()) {
				
				Flight fr = new Flight(this.flightNum, this.depDateTime);
		
				fr.flightNum = rs.getInt("flightNum");
				fr.depCity = rs.getString("depCity");
				//this.depDateTime = rs.getDate("depDateTime");
				fr.arrCity = rs.getString("arrCity");
				fr.distance = rs.getInt("distance");
				fr.stopType = rs.getString("stopType");
				fr.region = rs.getString("region");
				fr.fcTicketPrice = rs.getBigDecimal("FCTicketPrice");
				fr.ticketPrice = rs.getBigDecimal("FCTicketPrice");
				
				
				//fr.setDepCity(this.depCity);
				//fr.setArrCity(this.arrCity);
				//fr.setDistance(this.distance);
				//fr.setStopType(this.stopType);
				//fr.setRegion(this.region);
				//fr.setFcTicketPrice(this.fcTicketPrice);
				//fr.setTicketPrice(this.ticketPrice);
				//fr.setDepDateTime(this.depDateTime);
				
				return fr;
				
				//ArrayList 
				
				//System.out.println("\n   flightNum  |  depCity | arrCity |    address    | zip |State|  uName  |  Password  |       email       | SecurityQuestion |        SecurityAnswer        | Admin? |");
				
			
			//	System.out.print(flightNum + ",  " + depCity + ", " +  address + ", " + zip + ", " 
				//		   + state + ", " + userName + ", " + password + ", " + email + ", " + securityQuestion + ", " 
					//	   + securityAnswer + ", " + permission);
			}
			
			if (!rs.next()) {
				System.out.println("No records were found that match the input given");
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//finally {
			System.out.println("\n");
			Flight z = new Flight(1, this.depDateTime);
			return z;
			//return fr;
		//}
	
	}
	
	public void insert(int ssn, String fName, String lName, String address, int zip, String state, String userName, String password, String email, String securityQuestion, String securityAnswer, int permissionLevel) {
		System.out.println("\nDatabase: " + super.schema +"\nTable: " + Flight.TABLE);
		
		try {
			
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getUsername(), super.getPassword());
		
			String insertStatement = "insert into user (SSN, FirstName, LastName, address, zip, State, Username, Password, email, " +
				 "SecurityQuestion, SecurityAnswer, PermissionLevel) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
			PreparedStatement userInsert = c.prepareStatement(insertStatement);
		
			userInsert.setInt   (1, ssn);
			userInsert.setString(2, fName);
			userInsert.setString(3, lName);
			userInsert.setString(4, address);
			userInsert.setInt   (5, zip);
			userInsert.setString(6, state);
			userInsert.setString(7, userName);
			userInsert.setString(8, password);
			userInsert.setString(9, email);
			userInsert.setString(10,securityQuestion);
			userInsert.setString(11,securityAnswer);
			userInsert.setInt   (12, 0);
			
			userInsert.executeUpdate();
		}
		catch (Exception e){
			e.printStackTrace();
			
	}
		
		finally {
			int a = 0;
			System.out.println(a);
		}
	}
	
			
}
