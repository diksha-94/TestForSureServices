package edu.tests.TestForSure.response;

import java.util.*;

import edu.tests.TestForSure.entity.TestReports;

public class GetTestReportResponse {
	private ArrayList<TestReports> testReports;
	private Boolean status;
	private String message;

	public ArrayList<TestReports> getTestReports() {
		return testReports;
	}

	public void setTestReports(ArrayList<TestReports> testReports) {
		this.testReports = testReports;
	}

	@Override
	public String toString() {
		return "GetTestReportResponse [testReports=" + testReports + ", status=" + status + ", message=" + message
				+ "]";
	}

	public GetTestReportResponse() {
		super();
	}

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

	public GetTestReportResponse(ArrayList<TestReports> testReports, Boolean status, String message) {
		super();
		this.testReports = testReports;
		this.status = status;
		this.message = message;
	}
}
