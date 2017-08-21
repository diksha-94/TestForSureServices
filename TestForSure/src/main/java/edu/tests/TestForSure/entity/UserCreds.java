package edu.tests.TestForSure.entity;

public class UserCreds {
	private int id;
	private String userId;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserCreds(int id, String userId, String password) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
	}
	public UserCreds() {
		super();
	}
	@Override
	public String toString() {
		return "UserCreds [id=" + id + ", userId=" + userId + ", password=" + password + "]";
	}
}
