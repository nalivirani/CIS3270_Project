
 abstract public class User {
	//this is the abstract user class
	protected String firstName;
	protected String lastName;
	protected String address;
	protected int zipCode;
	protected String stateOfResidence;
	protected String username;
	protected String password;
	protected String email;
	protected long ssn;
	protected String recoveryQuestion;
	protected boolean isAdmin;
	protected String recoveryAnswer;
	
	public User(){
		this.firstName = "No first name";
		this.lastName = "No last name";
		this.address = "No address";
		this.zipCode = 12345;
		this.stateOfResidence = "No state listed";
		this.username = "No username created";
		this.password = "No password created";
		this.email = "No email address";
		this.ssn = 123456789;
		this.recoveryQuestion = "No security question created";
		this.recoveryAnswer = "No answer set";
		this.isAdmin = false;
	}
	
	
	protected abstract void createUser();
	protected abstract boolean isAdmin();


	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", zipCode="
				+ zipCode + ", stateOfResidence=" + stateOfResidence + ", username=" + username + ", password="
				+ password + ", email=" + email + ", ssn=" + ssn + ", recoveryQuestion=" + recoveryQuestion
				+ ", isAdmin=" + isAdmin + "]";
	}

}
