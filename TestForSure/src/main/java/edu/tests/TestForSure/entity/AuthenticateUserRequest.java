package edu.tests.TestForSure.entity;

public class AuthenticateUserRequest {
	private String email;
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AuthenticateUserRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public AuthenticateUserRequest() {
		super();
	}
	@Override
	public String toString() {
		return "AuthenticateUserRequest [email=" + email + ", password=" + password + "]";
	}
}
