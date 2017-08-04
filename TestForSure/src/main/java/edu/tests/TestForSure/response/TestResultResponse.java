package edu.tests.TestForSure.response;

import java.util.ArrayList;

public class TestResultResponse {
	private int test_id;
	private int total_ques;
	private int ques_attempted;
	private int correct_ques;
	private int incorrect_ques;
	private int total_marks;
	private int marks_scored;
	private int rank;
	private int time_taken;
	private int total_candidate;
	private String username;
	private ArrayList<QuestionDetail> question_details;
	private CommonResponse common_response;
	public int getTest_id() {
		return test_id;
	}
	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}
	public int getTotal_ques() {
		return total_ques;
	}
	public void setTotal_ques(int total_ques) {
		this.total_ques = total_ques;
	}
	public int getQues_attempted() {
		return ques_attempted;
	}
	public void setQues_attempted(int ques_attempted) {
		this.ques_attempted = ques_attempted;
	}
	public int getCorrect_ques() {
		return correct_ques;
	}
	public void setCorrect_ques(int correct_ques) {
		this.correct_ques = correct_ques;
	}
	public int getIncorrect_ques() {
		return incorrect_ques;
	}
	public void setIncorrect_ques(int incorrect_ques) {
		this.incorrect_ques = incorrect_ques;
	}
	public int getTotal_marks() {
		return total_marks;
	}
	public void setTotal_marks(int total_marks) {
		this.total_marks = total_marks;
	}
	public int getMarks_scored() {
		return marks_scored;
	}
	public void setMarks_scored(int marks_scored) {
		this.marks_scored = marks_scored;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getTime_taken() {
		return time_taken;
	}
	public void setTime_taken(int time_taken) {
		this.time_taken = time_taken;
	}
	public ArrayList<QuestionDetail> getQuestion_details() {
		return question_details;
	}
	public void setQuestion_details(ArrayList<QuestionDetail> question_details) {
		this.question_details = question_details;
	}
	public CommonResponse getCommon_response() {
		return common_response;
	}
	public void setCommon_response(CommonResponse common_response) {
		this.common_response = common_response;
	}
	public int getTotal_candidate() {
		return total_candidate;
	}
	public void setTotal_candidate(int total_candidate) {
		this.total_candidate = total_candidate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "TestResultResponse [test_id=" + test_id + ", total_ques=" + total_ques + ", ques_attempted="
				+ ques_attempted + ", correct_ques=" + correct_ques + ", incorrect_ques=" + incorrect_ques
				+ ", total_marks=" + total_marks + ", marks_scored=" + marks_scored + ", rank=" + rank + ", time_taken=" + time_taken
				+ ", question_details=" + question_details + ", common_response=" + common_response+ ", total_candidate=" + total_candidate 
				+ ", username=" + username + "]";
	}
	public TestResultResponse(int test_id, int total_ques, int ques_attempted, int correct_ques, int incorrect_ques,
			int total_marks, int marks_scored, int rank, int time_taken, ArrayList<QuestionDetail> question_details, CommonResponse common_response,
			int total_candidate, String username) {
		super();
		this.test_id = test_id;
		this.total_ques = total_ques;
		this.ques_attempted = ques_attempted;
		this.correct_ques = correct_ques;
		this.incorrect_ques = incorrect_ques;
		this.total_marks = total_marks;
		this.marks_scored = marks_scored;
		this.rank = rank;
		this.time_taken = time_taken;
		this.question_details = question_details;
		this.common_response = common_response;
		this.total_candidate = total_candidate;
		this.username = username;
	}
	public TestResultResponse() {
		super();
	}
}

