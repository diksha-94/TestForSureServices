package edu.tests.TestForSure.response;

public class CommonResponse {
	private Boolean status;
	private String message;
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public CommonResponse(Boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public CommonResponse() {
		super();
	}
	@Override
	public String toString() {
		return "CommonResponse [status=" + status + ", message=" + message + "]";
	}
}
