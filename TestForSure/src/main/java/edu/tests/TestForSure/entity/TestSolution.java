package edu.tests.TestForSure.entity;

public class TestSolution {
	private int id;
	private int test_id;
	private String ques_id;
	private String username;
	private Boolean corret;
	private int time_spent;
	private String correct_option;
	private String marked_option;
	private String explanation;
	private int test_report_id;
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
	public String getQues_id() {
		return ques_id;
	}
	public void setQues_id(String ques_id) {
		this.ques_id = ques_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Boolean getCorret() {
		return corret;
	}
	public void setCorret(Boolean corret) {
		this.corret = corret;
	}
	public int getTime_spent() {
		return time_spent;
	}
	public void setTime_spent(int time_spent) {
		this.time_spent = time_spent;
	}
	public String getCorrect_option() {
		return correct_option;
	}
	public void setCorrect_option(String correct_option) {
		this.correct_option = correct_option;
	}
	public String getMarked_option() {
		return marked_option;
	}
	public void setMarked_option(String marked_option) {
		this.marked_option = marked_option;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public int getTest_report_id() {
		return test_report_id;
	}
	public void setTest_report_id(int test_report_id) {
		this.test_report_id = test_report_id;
	}
	@Override
	public String toString() {
		return "TestSolution [id=" + id + ", test_id=" + test_id + ", ques_id=" + ques_id + ", username=" + username
				+ ", corret=" + corret + ", time_spent=" + time_spent + ", correct_option=" + correct_option
				+ ", marked_option=" + marked_option + ", explanation=" + explanation + ", test_report_id="
				+ test_report_id + "]";
	}
	public TestSolution(int id, int test_id, String ques_id, String username, Boolean corret, int time_spent,
			String correct_option, String marked_option, String explanation, int test_report_id) {
		super();
		this.id = id;
		this.test_id = test_id;
		this.ques_id = ques_id;
		this.username = username;
		this.corret = corret;
		this.time_spent = time_spent;
		this.correct_option = correct_option;
		this.marked_option = marked_option;
		this.explanation = explanation;
		this.test_report_id = test_report_id;
	}
	public TestSolution() {
		super();
	}
}
