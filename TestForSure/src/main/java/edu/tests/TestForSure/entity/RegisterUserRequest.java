package edu.tests.TestForSure.entity;

public class RegisterUserRequest {
	private User userDetails;
	private String password;
	public User getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RegisterUserRequest(User userDetails, String password) {
		super();
		this.userDetails = userDetails;
		this.password = password;
	}
	public RegisterUserRequest() {
		super();
	}
	@Override
	public String toString() {
		return "RegisterUserRequest [userDetails=" + userDetails + ", password=" + password + "]";
	}
}
