package edu.tests.TestForSure.entity;

public class Result{
	private int question_id;
	private String marked_option;
	
	public Result(int question_id, String marked_option) {
		super();
		this.question_id = question_id;
		this.marked_option = marked_option;
	}
	public Result() {
		super();
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getMarked_option() {
		return marked_option;
	}
	public void setMarked_option(String marked_option) {
		this.marked_option = marked_option;
	}
	@Override
	public String toString() {
		return "Result [question_id=" + question_id + ", marked_option=" + marked_option + "]";
	}
}

