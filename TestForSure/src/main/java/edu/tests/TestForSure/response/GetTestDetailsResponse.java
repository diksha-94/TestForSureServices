package edu.tests.TestForSure.response;

import java.util.ArrayList;

import edu.tests.TestForSure.entity.TestDetails;

public class GetTestDetailsResponse {
	ArrayList<TestDetails> testDetails;
	Boolean status;
	String message;
	
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
	public ArrayList<TestDetails> getTestDetails() {
		return testDetails;
	}
	public void setTestDetails(ArrayList<TestDetails> testDetails) {
		this.testDetails = testDetails;
	}
	@Override
	public String toString() {
		return "GetTestDetailsResponse [testDetails=" + testDetails + ", status=" + status + ", message=" + message
				+ "]";
	}
	public GetTestDetailsResponse(ArrayList<TestDetails> testDetails, Boolean status, String message) {
		super();
		this.testDetails = testDetails;
		this.status = status;
		this.message = message;
	}
	public GetTestDetailsResponse() {
		super();
	}
}
