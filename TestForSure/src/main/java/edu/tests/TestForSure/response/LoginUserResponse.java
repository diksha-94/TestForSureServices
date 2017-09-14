package edu.tests.TestForSure.response;

public class LoginUserResponse {
	private String username;
	private String password;
	private CommonResponse response;
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
	public CommonResponse getResponse() {
		return response;
	}
	public void setResponse(CommonResponse response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "LoginUserResponse [username=" + username + ", password=" + password + ", response=" + response + "]";
	}
	public LoginUserResponse(String username, String password, CommonResponse response) {
		super();
		this.username = username;
		this.password = password;
		this.response = response;
	}
	public LoginUserResponse() {
		super();
	}
}
