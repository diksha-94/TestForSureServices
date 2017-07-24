package edu.tests.TestForSure.response;

import edu.tests.TestForSure.entity.TestDetails;

public class GetSingleTestDetailsResponse {
	TestDetails testDetails;
	
	String category;
	String subcategory;
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
	public TestDetails getTestDetails() {
		return testDetails;
	}
	public void setTestDetails(TestDetails testDetails) {
		this.testDetails = testDetails;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	@Override
	public String toString() {
		return "GetSingleTestDetailsResponse [testDetails=" + testDetails + ", category=" + category + ", subcategory="
				+ subcategory + ", status=" + status + ", message=" + message + "]";
	}
	public GetSingleTestDetailsResponse() {
		super();
	}
}
