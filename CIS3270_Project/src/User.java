import java.sql.*;

public class User extends Database {
	
	private static final String TABLE = "user";
	private int ssn;
	private String fName;
	private String lName;
	private String address;
	private int zip;
	private String state;
	private String userName;
	private String password;
	private String email;
	private String securityQuestion;
	private String securityAnswer;
	private int permissionLevel;

	
	User() {
		super();
	}
	
	User(int i) {
		super(i);
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
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

	public void setPermissionLevel(int permissionLevel) {
		this.permissionLevel = permissionLevel;
	}
	
	public void pQuery(String username) {
		
		System.out.println("\nDatabase: " + super.schema +"\nTable: " + User.TABLE);
		
		try {
			Connection c = DriverManager.getConnection(super.getConnectionID(), super.getUsername(), super.getPassword());
		
			String query = "select * from User Where Username=?";
		
			PreparedStatement userQuery = c.prepareStatement(query);
			userQuery.setString(1, username);
		
			ResultSet rs = userQuery.executeQuery();
		
			while (rs.next()) {
		
				int ssn = rs.getInt("SSN");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String address = rs.getString("address");
				int zip = rs.getInt("zip");
				String state = rs.getString("State");
				String userName = rs.getString("UserName");
				String password = rs.getString("Password");
				String email = rs.getString("email");
				String securityQuestion = rs.getString("SecurityQuestion");
				String securityAnswer = rs.getString("SecurityAnswer");
				int permission = rs.getInt("PermissionLevel");
				
				System.out.println("\n   SSN  |  FName | LName |    address    | zip |State|  uName  |  Password  |       email       | SecurityQuestion |        SecurityAnswer        | Admin? |");
				
			
				System.out.print(ssn + ",  " + firstName + ", " + lastName + ", " + address + ", " + zip + ", " 
						   + state + ", " + userName + ", " + password + ", " + email + ", " + securityQuestion + ", " 
						   + securityAnswer + ", " + permission);
			}
			
			if (!rs.next()) {
				System.out.println("No records were found that match the input given");
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			System.out.println("\n");
		}
	
	}
	
	public void insert(int ssn, String fName, String lName, String address, int zip, String state, String userName, String password, String email, String securityQuestion, String securityAnswer, int permissionLevel) {
		System.out.println("\nDatabase: " + super.schema +"\nTable: " + User.TABLE);
		
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

	@Override
	public String toString() {
		return "User [ssn=" + ssn + ", fName=" + fName + ", lName=" + lName + ", address=" + address + ", zip=" + zip
				+ ", state=" + state + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", securityQuestion=" + securityQuestion + ", securityAnswer=" + securityAnswer + ", permissionLevel="
				+ permissionLevel + "]";
	}
	
	

}
