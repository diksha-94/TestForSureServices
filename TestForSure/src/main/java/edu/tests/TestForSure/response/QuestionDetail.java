package edu.tests.TestForSure.response;

public class QuestionDetail{
	private String ques_id;
	private Boolean correct;
	private String correct_option;
	private String marked_option;
	private String explanation;
	public String getQues_id() {
		return ques_id;
	}
	public void setQues_id(String ques_id) {
		this.ques_id = ques_id;
	}
	public Boolean getCorrect() {
		return correct;
	}
	public void setCorrect(Boolean correct) {
		this.correct = correct;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
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
	@Override
	public String toString() {
		return "QuestionDetail [ques_id=" + ques_id + ", correct=" + correct + ", explanation=" + explanation +", correct_option=" + correct_option +", marked_option=" + marked_option + "]";
	}
	public QuestionDetail(String ques_id, Boolean correct, String explanation, String correct_option, String marked_option) {
		super();
		this.ques_id = ques_id;
		this.correct = correct;
		this.explanation = explanation;
		this.correct_option = correct_option;
		this.marked_option = marked_option;
	}
	public QuestionDetail() {
		super();
	}
}