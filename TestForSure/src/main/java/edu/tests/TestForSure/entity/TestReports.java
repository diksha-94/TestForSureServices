package edu.tests.TestForSure.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TestReports {
	private int id;
	private int test_id;
	private String username;
	private String emailid;
	private Long mobile_number;
	private BigDecimal marks_scored;
	private BigDecimal time_taken;
	private int rank;
	private int questions_attempted;
	private int correct_ques;
	private int incorrect_ques;
	private int total_ques;
	private Date last_updated_on;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTest_id() {
		return test_id;
	}
	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public Long getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(Long mobile_number) {
		this.mobile_number = mobile_number;
	}
	public BigDecimal getMarks_scored() {
		return marks_scored;
	}
	public void setMarks_scored(BigDecimal marks_scored) {
		this.marks_scored = marks_scored;
	}
	public BigDecimal getTime_taken() {
		return time_taken;
	}
	public void setTime_taken(BigDecimal time_taken) {
		this.time_taken = time_taken;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getQuestions_attempted() {
		return questions_attempted;
	}
	public void setQuestions_attempted(int questions_attempted) {
		this.questions_attempted = questions_attempted;
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
	public int getTotal_ques() {
		return total_ques;
	}
	public void setTotal_ques(int total_ques) {
		this.total_ques = total_ques;
	}
	public Date getLast_updated_on() {
		return last_updated_on;
	}
	public void setLast_updated_on(Date last_updated_on) {
		this.last_updated_on = last_updated_on;
	}
	public TestReports(int id, int test_id, String username, String emailid, Long mobile_number, BigDecimal marks_scored,
			BigDecimal time_taken, int rank, int questions_attempted, int correct_ques, int incorrect_ques, int total_ques, Date last_updated_on) {
		super();
		this.id = id;
		this.test_id = test_id;
		this.username = username;
		this.emailid = emailid;
		this.mobile_number = mobile_number;
		this.marks_scored = marks_scored;
		this.time_taken = time_taken;
		this.rank = rank;
		this.questions_attempted = questions_attempted;
		this.correct_ques = correct_ques;
		this.incorrect_ques = incorrect_ques;
		this.total_ques = total_ques;
		this.last_updated_on = last_updated_on;
	}
	public TestReports() {
		super();
	}
	@Override
	public String toString() {
		return "TestReports [id=" + id + ", test_id=" + test_id + ", username=" + username + ", emailid=" + emailid
				+ ", mobile_number=" + mobile_number + ", marks_scored=" + marks_scored + ", time_taken=" + time_taken
				+ ", rank=" + rank + ", questions_attempted=" + questions_attempted + ", correct_ques=" + correct_ques
				+ ", incorrect_ques=" + incorrect_ques + ", total_ques=" + total_ques+ ", last_updated_on=" + last_updated_on+ "]";
	}
}
