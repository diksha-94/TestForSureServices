package edu.tests.TestForSure.entity;

public class QuestionBank {
	private int id;
	private String test_id;	//can be multiple in database(comma separated)
	private String question_type;
	private String paragraph_text;
	private String question_text;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String correct_option;
	private String explanation;
	private String active;
	private int category_id;
	private int subcategory_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTest_id() {
		return test_id;
	}
	public void setTest_id(String test_id) {
		this.test_id = test_id;
	}
	public String getQuestion_type() {
		return question_type;
	}
	public void setQuestion_type(String question_type) {
		this.question_type = question_type;
	}
	public String getParagraph_text() {
		return paragraph_text;
	}
	public void setParagraph_text(String paragraph_text) {
		this.paragraph_text = paragraph_text;
	}
	public String getQuestion_text() {
		return question_text;
	}
	public void setQuestion_text(String question_text) {
		this.question_text = question_text;
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
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getSubcategory_id() {
		return subcategory_id;
	}
	public void setSubcategory_id(int subcategory_id) {
		this.subcategory_id = subcategory_id;
	}
	
	public QuestionBank(){
		super();
	}
	
	public QuestionBank(int id, String test_id, String question_type, String paragraph_text, String question_text,
			String optionA, String optionB, String optionC, String optionD, String correct_option, String explanation,
			String active, int category_id, int subcategory_id) {
		super();
		this.id = id;
		this.test_id = test_id;
		this.question_type = question_type;
		this.paragraph_text = paragraph_text;
		this.question_text = question_text;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.correct_option = correct_option;
		this.explanation = explanation;
		this.active = active;
		this.category_id = category_id;
		this.subcategory_id = subcategory_id;
	}
	@Override
	public String toString() {
		return "QuestionBank [id=" + id + ", test_id=" + test_id + ", question_type=" + question_type
				+ ", paragraph_text=" + paragraph_text + ", question_text=" + question_text + ", optionA=" + optionA
				+ ", optionB=" + optionB + ", optionC=" + optionC + ", optionD=" + optionD + ", correct_option="
				+ correct_option + ", explanation=" + explanation + ", active=" + active + ", category_id="
				+ category_id + ", subcategory_id=" + subcategory_id + "]";
	}
	
}
