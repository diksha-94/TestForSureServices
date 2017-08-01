package edu.tests.TestForSure.entity;

import java.util.ArrayList;

public class GetTestResultRequest {
	private UserDetails userDetails;
	private TestId testDetails;
	private ArrayList<Result> result;
	public TestId getTestDetails() {
		return testDetails;
	}
	public void setTestDetails(TestId testDetails) {
		this.testDetails = testDetails;
	}
	public ArrayList<Result> getResult() {
		return result;
	}
	public void setResult(ArrayList<Result> result) {
		this.result = result;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	@Override
	public String toString() {
		return "GetTestResultRequest [testDetails=" + testDetails + ", result=" + result + ", userDetails=" + userDetails +"]";
	}
	public GetTestResultRequest(UserDetails userDetails, TestId testDetails, ArrayList<Result> result) {
		super();
		this.userDetails = userDetails;
		this.testDetails = testDetails;
		this.result = result;
	}
	public GetTestResultRequest() {
		super();
	}
}