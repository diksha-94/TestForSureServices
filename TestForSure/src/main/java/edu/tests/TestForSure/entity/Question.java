package edu.tests.TestForSure.entity;

public class Question {
	private int id;
	private int test_id;
	private String ques_type;
	private String paragraph_text;
	private String ques_text;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String correct_option;
	private String explanation;
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
	public String getQues_type() {
		return ques_type;
	}
	public void setQues_type(String ques_type) {
		this.ques_type = ques_type;
	}
	public String getParagraph_text() {
		return paragraph_text;
	}
	public void setParagraph_text(String paragraph_text) {
		this.paragraph_text = paragraph_text;
	}
	public String getQues_text() {
		return ques_text;
	}
	public void setQues_text(String ques_text) {
		this.ques_text = ques_text;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getCorrect_option() {
		return correct_option;
	}
	public void setCorrect_option(String correct_option) {
		this.correct_option = correct_option;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", test_id=" + test_id + ", ques_type=" + ques_type + ", paragraph_text="
				+ paragraph_text + ", ques_text=" + ques_text + ", optionA=" + optionA + ", optionB=" + optionB
				+ ", optionC=" + optionC + ", optionD=" + optionD + ", correct_option=" + correct_option
				+ ", explanation=" + explanation + "]";
	}
	public Question(int id, int test_id, String ques_type, String paragraph_text, String ques_text, String optionA,
			String optionB, String optionC, String optionD, String correct_option, String explanation) {
		super();
		this.id = id;
		this.test_id = test_id;
		this.ques_type = ques_type;
		this.paragraph_text = paragraph_text;
		this.ques_text = ques_text;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.correct_option = correct_option;
		this.explanation = explanation;
	}
	public Question(){
		super();
	}
	
}
