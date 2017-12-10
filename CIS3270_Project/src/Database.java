

//import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;

//import java.sql.*;

public class Database {

	protected String connectionID;
	protected static String username = "root";
	protected static String password = "student";
	protected String schema;
	
	public Database() {
		this.schema = "new_schema";
		this.connectionID = "jdbc:mysql://localhost:3306/" + this.schema + "?autoReconnect=true&useSSL=false";
		
	}
	
	//public Database(String s) {
	//	connectionID = "jdbc:mysql://localhost:3306/new_schema?autoReconnect=true&useSSL=false";
		//this.table = s;
	//}
	
	public Database(int i) {
		this.schema = "flight-schedule-db";
		this.connectionID = "jdbc:mysql://35.190.156.154:3306/" + this.schema + "?autoReconnect=true&useSSL=false";
	}
	
	//public Database(String s, int i) {
		//connectionID = "jdbc:mysql://35.190.156.154:3306/flight-schedule-db?autoReconnect=true&useSSL=false";
		//this.table = s;
	//}

	public String getConnectionID() {
		return connectionID;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
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
