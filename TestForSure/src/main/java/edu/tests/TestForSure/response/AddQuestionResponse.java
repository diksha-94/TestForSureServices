package edu.tests.TestForSure.response;

public class AddQuestionResponse {
	Boolean status;
	String message;
	int question_id;
	
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
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	@Override
	public String toString() {
		return "GetCategoryResponse [status=" + status + ", message="
				+ message + ", question_id=" + question_id + "]";
	}
	public AddQuestionResponse(Boolean status, String message, int question_id) {
		super();
		this.status = status;
		this.message = message;
		this.question_id = question_id;
	}
	public AddQuestionResponse() {
		super();
	}
	
}
