package edu.tests.TestForSure.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TestDetails {
	private int id;
	private int cat_id;
	private int subcat_id;
	private String testTitle;
	private int no_of_ques;
	private BigDecimal time_limit;
	private int correct_ques_marks;
	private BigDecimal negative_marks;
	private Boolean active;
	private String imagePath;
	private Date last_updated_on;
	private String shuffleQuestions;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	public int getSubcat_id() {
		return subcat_id;
	}
	public void setSubcat_id(int subcat_id) {
		this.subcat_id = subcat_id;
	}
	public String getTestTitle() {
		return testTitle;
	}
	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}
	public int getNo_of_ques() {
		return no_of_ques;
	}
	public void setNo_of_ques(int no_of_ques) {
		this.no_of_ques = no_of_ques;
	}
	public BigDecimal getTime_limit() {
		return time_limit;
	}
	public void setTime_limit(BigDecimal time_limit) {
		this.time_limit = time_limit;
	}
	public int getCorrect_ques_marks() {
		return correct_ques_marks;
	}
	public void setCorrect_ques_marks(int correct_ques_marks) {
		this.correct_ques_marks = correct_ques_marks;
	}
	public BigDecimal getNegative_marks() {
		return negative_marks;
	}
	public void setNegative_marks(BigDecimal negative_marks) {
		this.negative_marks = negative_marks;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Date getLast_updated_on() {
		return last_updated_on;
	}
	public void setLast_updated_on(Date last_updated_on) {
		this.last_updated_on = last_updated_on;
	}
	public String getShuffleQuestions() {
		return shuffleQuestions;
	}
	public void setShuffleQuestions(String shuffleQuestions) {
		this.shuffleQuestions = shuffleQuestions;
	}
	@Override
	public String toString() {
		return "TestDetails [id=" + id + ", cat_id=" + cat_id + ", subcat_id=" + subcat_id + ", testTitle=" + testTitle
				+ ", no_of_ques=" + no_of_ques + ", time_limit=" + time_limit + ", correct_ques_marks="
				+ correct_ques_marks + ", negative_marks=" + negative_marks + ", active=" + active + ", imagePath="
				+ imagePath + ", last_updated_on=" + last_updated_on + ", shuffleQuestions=" + shuffleQuestions + "]";
	}
	public TestDetails(int id, int cat_id, int subcat_id, String testTitle, int no_of_ques, BigDecimal time_limit,
			int correct_ques_marks, BigDecimal negative_marks, Boolean active, String imagePath, Date last_updated_on, String shuffleQuestions) {
		super();
		this.id = id;
		this.cat_id = cat_id;
		this.subcat_id = subcat_id;
		this.testTitle = testTitle;
		this.no_of_ques = no_of_ques;
		this.time_limit = time_limit;
		this.correct_ques_marks = correct_ques_marks;
		this.negative_marks = negative_marks;
		this.active = active;
		this.imagePath = imagePath;
		this.last_updated_on = last_updated_on;
		this.shuffleQuestions = shuffleQuestions;
	}
	public TestDetails(){
		super();
	}
	
}
