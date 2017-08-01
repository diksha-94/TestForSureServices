package edu.tests.TestForSure.entity;

public class UserDetails {
	private String username;
	private String email;
	private long mobile;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "UserDetails [username=" + username + ", email=" + email + ", mobile=" + mobile + "]";
	}
	public UserDetails(String username, String email, long mobile) {
		super();
		this.username = username;
		this.email = email;
		this.mobile = mobile;
	}
	public UserDetails() {
		super();
	}
}
