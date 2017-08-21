package edu.tests.TestForSure.entity;

import java.util.ArrayList;

public class AddQuestionsFromBankRequest {
	private int test_id;
	private ArrayList<String> question_id;
	public int getTest_id() {
		return test_id;
	}
	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}
	public ArrayList<String> getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(ArrayList<String> question_id) {
		this.question_id = question_id;
	}
	public AddQuestionsFromBankRequest(int test_id, ArrayList<String> question_id) {
		super();
		this.test_id = test_id;
		this.question_id = question_id;
	}
	public AddQuestionsFromBankRequest() {
		super();
	}
	@Override
	public String toString() {
		return "AddQuestionsFromBankRequest [test_id=" + test_id + ", question_id=" + question_id + "]";
	}
}
