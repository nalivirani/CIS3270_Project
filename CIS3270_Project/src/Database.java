//import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;

//import java.sql.*;

public class Database {
	
	protected String schema = "new_schema";
	protected String connectionID = "jdbc:mysql://localhost:3306/" + this.schema + "?autoReconnect=true&useSSL=false";
	protected static String dbUsername = "root";
	protected static String dbPassword = "cis3270";
	
	//public Database(String s, int i) {
		//connectionID = "jdbc:mysql://35.190.156.154:3306/flight-schedule-db?autoReconnect=true&useSSL=false";
		//this.table = s;
	//}

	public String getConnectionID() {
		return connectionID;
	}
	
	public void setConnectionID(int i) {
		if(i==1) {
			this.schema = "flight-schedule-db";
			this.connectionID = "jdbc:mysql://35.190.156.154:3306/" + this.schema + "?autoReconnect=true&useSSL=false";
		}
	}

	public String getDBusername() {
		return dbUsername;
	}

	public String getDBpassword() {
		return dbPassword;
	}
	
	//public String getTable() {
	//	return table;
	//}

	//public void setTable(String table) {
	//	this.table = table;
	//}
	
	//public Connection connect() {
		//try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Connection c = DriverManager.getConnection(this.getConnectionID(), this.getUsername(), this.getPassword());
			//return c;
		//}
		
		//catch (Exception e) {
			//e.printStackTrace();
		//}
	//}
	
//	public void disconnect(<>) {
//		this
//	}


	
}
