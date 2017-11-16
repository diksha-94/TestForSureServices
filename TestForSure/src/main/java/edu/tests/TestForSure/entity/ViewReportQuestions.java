package edu.tests.TestForSure.entity;

import java.math.BigDecimal;

public class ViewReportQuestions {
	private String quesId;
	private Boolean correct;
	private BigDecimal timeSpent;
	private String correctOption;
	private String markedOption;
	private String explanation;
	private String questionType;
	private String paragraphText;
	private String questionText;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	public String getQuesId() {
		return quesId;
	}
	public void setQuesId(String quesId) {
		this.quesId = quesId;
	}
	public Boolean getCorrect() {
		return correct;
	}
	public void setCorrect(Boolean correct) {
		this.correct = correct;
	}
	public BigDecimal getTimeSpent() {
		return timeSpent;
	}
	public void setTimeSpent(BigDecimal timeSpent) {
		this.timeSpent = timeSpent;
	}
	public String getCorrectOption() {
		return correctOption;
	}
	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}
	public String getMarkedOption() {
		return markedOption;
	}
	public void setMarkedOption(String markedOption) {
		this.markedOption = markedOption;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getParagraphText() {
		return paragraphText;
	}
	public void setParagraphText(String paragraphText) {
		this.paragraphText = paragraphText;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
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
	public ViewReportQuestions(String quesId, Boolean correct, BigDecimal timeSpent, String correctOption,
			String markedOption, String explanation, String questionType, String paragraphText, String questionText,
			String optionA, String optionB, String optionC, String optionD) {
		super();
		this.quesId = quesId;
		this.correct = correct;
		this.timeSpent = timeSpent;
		this.correctOption = correctOption;
		this.markedOption = markedOption;
		this.explanation = explanation;
		this.questionType = questionType;
		this.paragraphText = paragraphText;
		this.questionText = questionText;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
	}
	public ViewReportQuestions() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ViewReportQuestions [quesId=" + quesId + ", correct=" + correct + ", timeSpent=" + timeSpent
				+ ", correctOption=" + correctOption + ", markedOption=" + markedOption + ", explanation=" + explanation
				+ ", questionType=" + questionType + ", paragraphText=" + paragraphText + ", questionText="
				+ questionText + ", optionA=" + optionA + ", optionB=" + optionB + ", optionC=" + optionC + ", optionD="
				+ optionD + "]";
	}
}
