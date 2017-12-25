package edu.tests.TestForSure.entity;

public class ChangePasswordRequest {
	private String emailId;
	private String oldPassword;
	private String newPassword;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	@Override
	public String toString() {
		return "ChangePasswordRequest [emailId=" + emailId + ", oldPassword=" + oldPassword + ", newPassword="
				+ newPassword + "]";
	}
	public ChangePasswordRequest(String emailId, String oldPassword, String newPassword) {
		super();
		this.emailId = emailId;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}
	public ChangePasswordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
}
