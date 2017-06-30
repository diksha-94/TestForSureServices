package edu.tests.TestForSure.response;

public class CreateTestResponse {
	Boolean status;
	String message;
	int test_id;
	
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
	public int getTest_id() {
		return test_id;
	}
	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}
	@Override
	public String toString() {
		return "GetCategoryResponse [status=" + status + ", message="
				+ message + ", test_id=" + test_id + "]";
	}
	public CreateTestResponse(Boolean status, String message, int test_id) {
		super();
		this.status = status;
		this.message = message;
		this.test_id = test_id;
	}
	public CreateTestResponse() {
		super();
	}
	
}
