package edu.tests.TestForSure.entity;

public class Result{
	private String question_id;
	private String marked_option;
	private int time_spent;
	
	public Result(String question_id, String marked_option, int time_spent) {
		super();
		this.question_id = question_id;
		this.marked_option = marked_option;
		this.time_spent = time_spent;
	}
	public Result() {
		super();
	}
	public String getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}
	public String getMarked_option() {
		return marked_option;
	}
	public void setMarked_option(String marked_option) {
		this.marked_option = marked_option;
	}
	public int getTime_spent() {
		return time_spent;
	}
	public void setTime_spent(int time_spent) {
		this.time_spent = time_spent;
	}
	@Override
	public String toString() {
		return "Result [question_id=" + question_id + ", marked_option=" + marked_option + ", time_spent=" + time_spent + "]";
	}
}

