package sneha.ust.model;

//User Login Bean Class

public class Login {

	//initializing variables
	private int userId;
	private String username;
	private String password;
	
	//default constructor
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Parameterized constructor
	public Login(int userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	
	//Getters and Setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	//To String Method
	@Override
	public String toString() {
		return "Login [userId=" + userId + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
	
}
