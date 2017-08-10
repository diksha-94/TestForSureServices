package edu.tests.TestForSure.response;

import java.util.ArrayList;
import edu.tests.TestForSure.entity.QuestionBank;

public class GetQuestionsBankResponse {
	ArrayList<QuestionBank> questions;
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
	public ArrayList<QuestionBank> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<QuestionBank> questions) {
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "GetTestDetailsResponse [questions=" + questions + ", status=" + status + ", message=" + message
				+ "]";
	}
	public GetQuestionsBankResponse(ArrayList<QuestionBank> questions, Boolean status, String message) {
		super();
		this.questions = questions;
		this.status = status;
		this.message = message;
	}
	public GetQuestionsBankResponse() {
		super();
	}
}
