import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.math.BigDecimal;

public class Reservation extends Database{

	protected static final String TABLE = "reservation";
	protected int ticketNum;
	protected int fID;
	protected int flightNum;
	protected int ssn;
	
	protected String depCity;
	protected String arrCity;
	
	protected LocalDate depDate;
	protected LocalTime depTime;
	
	protected String seatClass;
	protected String seat;
	
	protected BigDecimal price;
	

	public Reservation() {
		super();

	}
	
	public Reservation(int fID, int ssn) {
		super();
		this.fID = fID;
		this.ssn = ssn;
	}

	public Reservation(int ticketNum, int fID, int flightNUm, int ssn, String depCity, String arrCity, LocalDate depDate,
					   LocalTime depTime, String seatClass, String seat) {
		super();
		this.ticketNum = ticketNum;
		this.fID = fID;
		this.ssn = ssn;
		this.depCity = depCity;
		this.arrCity = arrCity;
		this.depDate = depDate;
		this.depTime = depTime;
		this.seatClass = seatClass;
		this.seat = seat;
	}

	public int getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}

	public int getfID() {
		return fID;
	}

	public void setfID(int fID) {
		this.fID = fID;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getDepCity() {
		return depCity;
	}

	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}

	public String getArrCity() {
		return arrCity;
	}

	public void setArrCity(String arrCity) {
		this.arrCity = arrCity;
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

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	
	
	public void createReservation(Flight f, User u) {
		
		String sC = "";
		//BigDecimal price = new BigDecimal(0.00);
		
//		if(seatClass.contains("first") || seatClass.contains("First")) {
//			sC = "First-Class";
//			price = f.fcTicketPrice;
//		}
//		
//		else {
//			sC = "Economy";
//			price = f.ticketPrice;
//		}
		
		try {
			
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String insertStatement = "insert into " + TABLE + " (fID, flightNum, ssn, depCity, arrCity, depDate, " + 
								    						    "depTime, seat, seatClass) " + 
								    						    "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
			PreparedStatement reservationInsert = c.prepareStatement(insertStatement);
		
			reservationInsert.setInt       (1, f.fID);
			reservationInsert.setInt       (2, f.flightNum);
			reservationInsert.setInt       (3, u.getSsn());
			reservationInsert.setString    (4, f.depCity);
			reservationInsert.setString    (5, f.arrCity);
			reservationInsert.setString    (6, f.depDate.toString());
			reservationInsert.setString    (7, f.depTime.toString());
			reservationInsert.setString    (8, "1 A");
			reservationInsert.setString    (9, sC);
			//reservationInsert.setBigDecimal(10, price);
			
			reservationInsert.executeUpdate();
		}
		
		catch (Exception e){
			e.printStackTrace();		
		}
		
	}
	
	public void deleteReservation(int ticketNumber) {
		
			try {
				Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
			
				String deleteStatement = "delete from " + TABLE + " Where ticketNum=?";
				PreparedStatement reservationDelete = c.prepareStatement(deleteStatement);
				
				reservationDelete.setInt(1, ticketNumber);
				reservationDelete.executeUpdate();
				
				AlertBox1.display("Success", "This reservation was deleted");
			}
			
			catch (Exception e) {
			System.out.println("Something went wrong. Please try your request again.");
						
			}
			
		}
	
	
	public ArrayList<Reservation> searchReservations (int ssn) {
		
		ArrayList<Reservation> reservations = new ArrayList<>();
		
		Date dDate = new Date(0);
		Time dTime = new Time(0);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String query = "select * from " + TABLE + " Where ssn=?";
		
			PreparedStatement reservationQuery = c.prepareStatement(query);
			reservationQuery.setInt(1, ssn);
		
			ResultSet rs = reservationQuery.executeQuery();		
			
			while (rs.next()) {
				
				dDate = rs.getDate("depDate");
				dTime = rs.getTime("depTime");
				
				reservations.add(new Reservation(
						
										rs.getInt("ticketNum"), 
										rs.getInt("fID"), 
										rs.getInt("flightNum"),
										rs.getInt("ssn"),
										
										rs.getString("depCity"),
										rs.getString("arrCity"),
				
										dDate.toLocalDate(),
										dTime.toLocalTime(),
				
										rs. getString("seat"),
										rs.getString("seatClass")
				));
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return reservations;
	}
	
	
	public boolean exists(int ticketNum) {
		boolean exists = false;
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String query = "select * from " + TABLE + " Where ticketNum=?";
		
			PreparedStatement userQuery = c.prepareStatement(query);
			userQuery.setInt(1, ticketNum);
		
			ResultSet rs = userQuery.executeQuery();
			
			if (rs.next()) {
				exists = true;
			}
			
			else exists = false;
		}
		
			catch(Exception e) {
			}

			return exists;
	}
	
}
