package edu.tests.TestForSure.entity;

import java.util.ArrayList;
public class TestDetailsRequest {
	private TestDetails testDetails;
	private ArrayList<Question> questionList;
	
	public TestDetails getTestDetails() {
		return testDetails;
	}
	public void setTestDetails(TestDetails testDetails) {
		this.testDetails = testDetails;
	}
	public ArrayList<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(ArrayList<Question> questionList) {
		this.questionList = questionList;
	}
	@Override
	public String toString() {
		return "CreateTestRequest [testDetails=" + testDetails + ", questionList=" + questionList + "]";
	}
	public TestDetailsRequest(TestDetails testDetails, ArrayList<Question> questionList) {
		super();
		this.testDetails = testDetails;
		this.questionList = questionList;
	}
	public TestDetailsRequest(){
		super();
	}
}
