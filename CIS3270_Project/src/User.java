import java.sql.*;

public class User extends Database {
	
	protected static final String TABLE = "user";
	private int ssn;
	protected String fName;
	protected String lName;
	protected String address;
	protected int zip;
	protected String state;
	protected String userName;
	private String password;
	protected String email;
	protected String securityQuestion;
	private String securityAnswer;
	protected int permissionLevel;
	
	public User() {
		super();
	}
	
	public User(int ssn, String fName, String lName, String address, int zip, String state, String username, String password, String email, String securityQuestion, String securityAnswer) {
		super();
		this.ssn = ssn;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.zip = zip;
		this.state = state;
		this.userName = username;
		this.password = password;
		this.email = email;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}
	
	public User(String username) {
		super();
		this.userName = username;
		
	}

	public int getSsn() {
		return ssn;
	}
	
	public int getSsn(String username) {
		int ssn = 0;
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String query = "select SSN from user Where Username=?";
			PreparedStatement userQuery = c.prepareStatement(query);
			userQuery.setString(1, username);
		
			ResultSet rs = userQuery.executeQuery();
			
			ssn = rs.getInt("SSN"); 
			
			c.close();
		}
		
		catch(Exception e) {
			
		}
		
		return ssn;
	}
	
	protected void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public int getPermissionLevel() {
		return permissionLevel;
	}

	protected void setPermissionLevel(int permissionLevel) {
		this.permissionLevel = permissionLevel;
	}
/* **********************************************************************************
 * *-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/*
 * **********************************************************************************/	
	
	@Override
	public String toString() {
		
		return "User: " + this.getUserName() + "\nName: " + this.getfName() + " " + this.getlName() +
				"\nAddress: " + this.getAddress() + " " + this.getState() + " " + this.getZip() +
				"\nemail: " + this.getEmail() + "\nSSN: " + this.getSsn();
	}
	
	public boolean canLogin(String username) {
		if(!this.isNewUser(this.getSsn(username))) {
			return true;
		}
		else return false;
	}
	
	public User login(String username, String password) {
		User u = new User(username);

			try {
				Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
			
				String query = "select * from user Where UserName=? and Password=?";
				PreparedStatement userQuery = c.prepareStatement(query);
				userQuery.setString(1, username);
				userQuery.setString(2, password);
			
				ResultSet rs = userQuery.executeQuery();
				
				while(rs.next()) {
					u.setSsn(rs.getInt("SSN"));
					u.setfName(rs.getString("FirstName"));
					u.setlName(rs.getString("LastName"));
					u.setAddress(rs.getString("address"));
					u.setZip(rs.getInt("zip"));
					u.setState(rs.getString("State"));
					u.setUserName(rs.getString("UserName"));
					u.setPassword(rs.getString("Password"));
					u.setEmail(rs.getString("email"));
					u.setSecurityQuestion(rs.getString("SecurityQuestion"));
					u.setSecurityAnswer(rs.getString("SecurityAnswer"));
					u.setPermissionLevel(rs.getInt("PermissionLevel"));
					
				
				}
				c.close();
				
				if (u.getfName() != null ) {
				
					System.out.println("Logging in...");
					Thread.sleep(2000);
					System.out.println("\nWelcome back, " + u.userName + " !");
			}
				
			}
			
			catch(Exception e) {
				
				System.out.println("Login unsuccessful. Please verify your login credentials and try again.");
			}

		return u;
		
	}
	
	public void logout() {
		this.setSsn(0);
		this.setfName("");
		this.setlName("");
		this.setAddress("");
		this.setZip(0);
		this.setEmail("");
		this.setUserName("");
		this.setPassword("");
		this.setSecurityQuestion("");
		this.setSecurityAnswer("");
		this.setPermissionLevel(0);
	}
	
	public void updateFname(int ssn, String newFname) {
		this.fName = newFname;
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update user set FirstName = ? where SSN = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setString(1, newFname);
			userUpdate.setInt(2, ssn);
			userUpdate.executeUpdate();
			
			c.close();
		}
		
		catch(Exception e) {
			
		}
	}
	
	public void updateLname(int ssn, String newLname) {
		this.lName = newLname;
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update user set LastName = ? where SSN = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setString(1, newLname);
			userUpdate.setInt(2, ssn);
			
			userUpdate.executeUpdate();
			
			c.close();
		}
		
		catch(Exception e) {
			
		}
	}

	public void updateAddress(int ssn, String newAddress) {
		this.address = newAddress;
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update user set Address = ? where SSN = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setString(1, newAddress);
			userUpdate.setInt(2, ssn);
			
			userUpdate.executeUpdate();
			
			c.close();
		}
		
		catch(Exception e) {
			
		}
	}

	public void updateZip(int ssn, int newZip) {
		this.zip = newZip;
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update user set zip = ? where SSN = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setInt(1, newZip);
			userUpdate.setInt(2, ssn);
			
			userUpdate.executeUpdate();
			
			c.close();
		}
		
		catch(Exception e) {
			
		}
	}

	public void updateState(int ssn, String newState) {
		this.state = newState;
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update user set State = ? where SSN = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setString(1, newState);
			userUpdate.setInt(2, ssn);
			
			userUpdate.executeUpdate();
			
			c.close();
		}
		
		catch(Exception e) {
			
		}
	}

	public void updateUsername(int ssn, String newUsername) {
		this.userName = newUsername;
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update user set UserName = ? where SSN = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setString(1, newUsername);
			userUpdate.setInt(2, ssn);
			
			userUpdate.executeUpdate();
			
			c.close();
		}
		
		catch(Exception e) {
			
		}
	}

	public void updatePassword(int ssn, String newPassword) {
		this.password = newPassword;
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update user set Password = ? where SSN = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setString(1, newPassword);
			userUpdate.setInt(2, ssn);
			
			userUpdate.executeUpdate();
			
			c.close();
		}
		
		catch(Exception e) {
			
		}
	}
	public void updateEmail(int ssn, String newEmail) {
		this.email = newEmail;
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update user set email = ? where SSN = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setString(1, newEmail);
			userUpdate.setInt(2, ssn);
			
			userUpdate.executeUpdate();
			
			c.close();
		}
		
		catch(Exception e) {
			
		}
	}

	public void updateSecQuestion(int ssn, String newSecQuestion) {
		this.securityQuestion = newSecQuestion;
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update user set SecurityQuestion = ? where SSN = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setString(1, newSecQuestion);
			userUpdate.setInt(2, ssn);
			
			userUpdate.executeUpdate();
			
			c.close();
		}
		
		catch(Exception e) {
			
		}
	}

	public void updateSecAnswer(int ssn, String newSecAnswer) {
		this.setSecurityAnswer(newSecAnswer);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String update = "update user set SecurityAnswer = ? where SSN = ?";
		
			PreparedStatement userUpdate = c.prepareStatement(update);
			userUpdate.setString(1, newSecAnswer);
			userUpdate.setInt(2, ssn);
			
			userUpdate.executeUpdate();
			
			c.close();
		}
		
		catch(Exception e) {
			
		}
	}

	public void adminPermission(User u) {
		if (u.getPermissionLevel() == 1) {
			
			try {
				Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
			
				String update = "update user set PermissionLevel = ? where SSN = ?";
			
				PreparedStatement userUpdate = c.prepareStatement(update);
				userUpdate.setInt(1, 1);
				userUpdate.setInt(2, u.getSsn());
				
				userUpdate.executeUpdate();
				
				this.permissionLevel = 1;
				c.close();
				
				System.out.println("The user's account privileges have been updated. The user now has admin rights.");
			}	
			
			catch(Exception e) {
				System.out.println("something went wrong, please try again.");
			}
		}
		
		else if (this.permissionLevel == 1) {
			System.out.println("This user already has admin rights.");
		}
		
		else System.out.println("The admin override password entered was invalid.");
	}
	
	public void revokeAdminPermission(int ssn, String adminOverridePassowrd) {
		
		if (adminOverridePassowrd.equals("zaq12wsxZAQ!@WSX")) {
			
			try {
				Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
			
				String update = "update user set PermissionLevel = ? where SSN = ?";
			
				PreparedStatement userUpdate = c.prepareStatement(update);
				userUpdate.setInt(1, 0);
				userUpdate.setInt(2, ssn);
				
				userUpdate.executeUpdate();
				
				System.out.println("The user's account privileges have been updated. The user now has admin rights.");
				
				this.permissionLevel = 0;
				c.close();
			}	
			
			catch(Exception e) {
				System.out.println("something went wrong, please try again.");
			}
		}
		
		else System.out.println("The admin override password entered was invalid.");
	}
	
	public boolean isNewUser(int ssn) {
		boolean b = false;
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String query = "select * from user Where SSN=?";
		
			PreparedStatement userQuery = c.prepareStatement(query);
			userQuery.setInt(1, ssn);
		
			ResultSet rs = userQuery.executeQuery();
			
			if (!rs.next()) {
				b = true;
			}
			
			else b = false;
		}
		
			catch(Exception e) {
			}

			return b;
	}
	
	public boolean isNewUser(String username) {
		boolean b = false;
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String query = "select * from user Where username=?";
		
			PreparedStatement userQuery = c.prepareStatement(query);
			userQuery.setString(1, username);
		
			ResultSet rs = userQuery.executeQuery();
			
			if (!rs.next()) {
				b = true;
			}
			
			else b = false;
		}
		
			catch(Exception e) {
			}
		
			return b;
	}
	
	public User getUser(String username) {
		
		User userResult = new User();
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String query = "select * from user Where Username=?";
		
			PreparedStatement userQuery = c.prepareStatement(query);
			userQuery.setString(1, username);
		
			ResultSet rs = userQuery.executeQuery();
		
			while (rs.next()) {
		
				userResult.setSsn(rs.getInt("SSN"));
				userResult.fName = rs.getString("FirstName");
				userResult.lName = rs.getString("LastName");
				userResult.address = rs.getString("address");
				userResult.zip = rs.getInt("zip");
				userResult.state = rs.getString("State");
				userResult.userName = rs.getString("UserName");
				userResult.password = rs.getString("Password");
				userResult.email = rs.getString("email");
				userResult.securityQuestion = rs.getString("SecurityQuestion");
				userResult.securityAnswer = rs.getString("SecurityAnswer");
				userResult.setPermissionLevel(rs.getInt("PermissionLevel"));
				
			}
//			
//			if (!rs.next()) {
//				System.out.println("No records were found that match the input given");
//			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return userResult;	
	}
	
	public User register(User u) {
		
		try {
			
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String insertStatement = "insert into user (SSN, FirstName, LastName, address, zip, State, Username, Password, email, " +
				 "SecurityQuestion, SecurityAnswer) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
			PreparedStatement userInsert = c.prepareStatement(insertStatement);
		
			userInsert.setInt   (1, u.ssn);
			userInsert.setString(2, u.fName);
			userInsert.setString(3, u.lName);
			userInsert.setString(4, u.address);
			userInsert.setInt   (5, u.zip);
			userInsert.setString(6, u.state);
			userInsert.setString(7, u.userName);
			userInsert.setString(8, u.password);
			userInsert.setString(9, u.email);
			userInsert.setString(10,u.securityQuestion);
			userInsert.setString(11,u.securityAnswer);
			
			userInsert.executeUpdate();
		}
		
		catch (Exception e){
			e.printStackTrace();		
		}
		
		return u;
	}
	
	public void register(int ssn, String fName, String lName, String address, int zip, String state, String userName, String password, String email, String securityQuestion, String securityAnswer) {
		
		try {
			
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String insertStatement = "insert into user (SSN, FirstName, LastName, address, zip, State, Username, Password, email, " +
				 "SecurityQuestion, SecurityAnswer) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
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
			
			userInsert.executeUpdate();
		}
		
		catch (Exception e){
			e.printStackTrace();		
		}
	}
	
	public String passwordRecover(String username, String securityAnswer) {
		
		String sA = "";
		String p = "";
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getDBusername(), super.getDBpassword());
		
			String query = "select password, securityAnswer from user Where Username=?";
		
			PreparedStatement userQuery = c.prepareStatement(query);
			userQuery.setString(1, username);
		
			ResultSet rs = userQuery.executeQuery();
			
			while (rs.next()) {
				p = rs.getString("Password");
				sA = rs.getString("SecurityAnswer");
			}
			
			if (securityAnswer.equalsIgnoreCase(sA)) {
			  return p;
			}
			
		    else p = "Your answer to the security question was invalid";
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return p;
	}
}