package edu.tests.TestForSure.entity;
import java.math.BigDecimal;
import java.util.Date;

public class AttemptedTests {
	private int test_id;
	private int report_id;
	private int cat_id;
	private int subcat_id;
	private String title;
	private int no_of_ques;
	private BigDecimal time_limit;
	private int correct_ques_marks;
	private BigDecimal negative_marks;
	private String imagePath;
	private Date last_updated_on;
	public int getTest_id() {
		return test_id;
	}
	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}
	public int getReport_id() {
		return report_id;
	}
	public void setReport_id(int report_id) {
		this.report_id = report_id;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	@Override
	public String toString() {
		return "AttemptedTests [test_id=" + test_id + ", report_id=" + report_id + ", cat_id=" + cat_id + ", subcat_id="
				+ subcat_id + ", title=" + title + ", no_of_ques=" + no_of_ques + ", time_limit=" + time_limit
				+ ", correct_ques_marks=" + correct_ques_marks + ", negative_marks=" + negative_marks + ", imagePath="
				+ imagePath + ", last_updated_on=" + last_updated_on + "]";
	}
	public AttemptedTests(int test_id, int report_id, int cat_id, int subcat_id, String title, int no_of_ques,
			BigDecimal time_limit, int correct_ques_marks, BigDecimal negative_marks, String imagePath,
			Date last_updated_on) {
		super();
		this.test_id = test_id;
		this.report_id = report_id;
		this.cat_id = cat_id;
		this.subcat_id = subcat_id;
		this.title = title;
		this.no_of_ques = no_of_ques;
		this.time_limit = time_limit;
		this.correct_ques_marks = correct_ques_marks;
		this.negative_marks = negative_marks;
		this.imagePath = imagePath;
		this.last_updated_on = last_updated_on;
	}
	public AttemptedTests() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
