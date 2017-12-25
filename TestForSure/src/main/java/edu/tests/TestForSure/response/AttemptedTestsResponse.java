package edu.tests.TestForSure.response;

import java.util.ArrayList;

import edu.tests.TestForSure.entity.AttemptedTests;

public class AttemptedTestsResponse {
	private ArrayList<AttemptedTests> attemptedTests;
	private CommonResponse response;
	public ArrayList<AttemptedTests> getAttemptedTests() {
		return attemptedTests;
	}
	public void setAttemptedTests(ArrayList<AttemptedTests> attemptedTests) {
		this.attemptedTests = attemptedTests;
	}
	public CommonResponse getResponse() {
		return response;
	}
	public void setResponse(CommonResponse response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "AttemptedTestsResponse [attemptedTests=" + attemptedTests + ", response=" + response + "]";
	}
	public AttemptedTestsResponse(ArrayList<AttemptedTests> attemptedTests, CommonResponse response) {
		super();
		this.attemptedTests = attemptedTests;
		this.response = response;
	}
	public AttemptedTestsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
}
