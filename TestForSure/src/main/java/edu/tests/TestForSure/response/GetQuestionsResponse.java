package edu.tests.TestForSure.response;

import java.util.ArrayList;

import edu.tests.TestForSure.entity.Question;

public class GetQuestionsResponse {
	ArrayList<Question> question;
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
	public ArrayList<Question> getQuestion() {
		return question;
	}
	public void setQuestion(ArrayList<Question> question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "GetTestDetailsResponse [question=" + question + ", status=" + status + ", message=" + message
				+ "]";
	}
	public GetQuestionsResponse(ArrayList<Question> question, Boolean status, String message) {
		super();
		this.question = question;
		this.status = status;
		this.message = message;
	}
	public GetQuestionsResponse() {
		super();
	}
}
