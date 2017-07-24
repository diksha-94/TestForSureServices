package edu.tests.TestForSure.sql;

import edu.tests.TestForSure.entity.Question;
import edu.tests.TestForSure.entity.TestDetails;

public class CreateTestQueries {

	/**
	 * Method to return an sql query to get all categories from
	 * examcategory table
	 *
	 */
	public static String getCategoryQueryBuilder() {
		String getCategory = "SELECT * from examcategory";
		return getCategory;
	}
	
	/**
	 * Method to return an sql query to get subcategory basis on category selected from
	 * examsubcategory table
	 *
	 */
	public static String getSubcategoryQueryBuilder(int cat_id) {
		String getSubcategory = "SELECT id,subcategory from examsubcategory WHERE cat_id = "+cat_id;
		return getSubcategory;
	}
	
	/** 
	 * Method to return an sql query to insert test details to
	 * testdetails table
	 * 
	 */
	public static String insertTestDetailsQueryBuilder(TestDetails testDetails) {
		String getTestDetails = "INSERT into testdetails (id, cat_id, subcat_id, title, no_of_ques, time_limit, correct_ans_marks, wrong_ans_marks) values ('"+
				testDetails.getId()+ "' , '" +testDetails.getCat_id() + "' , '"+testDetails.getSubcat_id() + "' , '"+testDetails.getTestTitle() + "' , '"+testDetails.getNo_of_ques() + "' , '"+
					testDetails.getTime_limit() + "' , '"+testDetails.getCorrect_ques_marks() + "' , '"+testDetails.getNegative_marks() + "')";
		return getTestDetails;
	}
	
	/**
	 * Method to return an sql query to update test details to
	 * testdetails table
	 * 
	 */
	public static String updateTestDetailsQueryBuilder(TestDetails testDetails) {
		String getTestDetails = "UPDATE testdetails SET cat_id = '"+testDetails.getCat_id()+"', subcat_id = '"+testDetails.getSubcat_id()+"',title = '"+testDetails.getTestTitle()+
				"', no_of_ques = '"+testDetails.getNo_of_ques()+"', time_limit = '"+testDetails.getTime_limit()+"', correct_ans_marks = '"+testDetails.getCorrect_ques_marks()+
				"', wrong_ans_marks = '"+testDetails.getNegative_marks()+"' WHERE id= '"+testDetails.getId()+"'";
		return getTestDetails;
	}
	
	/**
	 * Method to return an sql query to check if test already exists in
	 * testdetails table
	 * 
	 */
	public static String testAlreadyExistsQueryBuilder(int test_id) {
		String getTestDetails = "SELECT * FROM testdetails WHERE id = " + test_id;
		return getTestDetails;
	}
	
	/*public static String getLastInsertIdTestDetailsQueryBuilder(){
		String last_insert_id = "select last_insert_id() as last_id from testdetails";
		return last_insert_id;
	}*/
	
	public static String insertQuestionQueryBuilder(Question question) {
		String insertQuestion = "INSERT into questions (id, test_id, question_type, paragraph_text, question_text, optionA, optionB, optionC, optionD, correct_option, explanation) values ('"+
					question.getId() +"' , '" +question.getTest_id() + "' , '"+question.getQues_type() + "' , '"+question.getParagraph_text() + "' , '"+question.getQues_text() + "' , '"+
					question.getOptionA() + "' , '"+question.getOptionB() + "' , '"+question.getOptionC()+ "' , '"+question.getOptionD()+ "' , '"+question.getCorrect_option()+ "' , '"+question.getExplanation() + "')";
		return insertQuestion;
	}
	
	public static String updateQuestionQueryBuilder(Question question) {
		String updateQuestion = "UPDATE questions SET question_type = '"+question.getQues_type()+"',paragraph_text = '"+question.getParagraph_text()+
				"', question_text = '"+question.getQues_text()+"', optionA = '"+question.getOptionA()+"', optionB = '"+question.getOptionB()+
				"', optionC = '"+question.getOptionC()+"', optionD = '"+question.getOptionD()+"', correct_option = '"+question.getCorrect_option()+
				"', explanation = '"+question.getExplanation()+"' WHERE id= '"+question.getId()+"'AND test_id = '"+question.getTest_id()+"'";
		return updateQuestion;
	}
	public static String questionAlreadyExistsQueryBuilder(int id, int test_id) {
		String getquestion = "SELECT * FROM questions WHERE id = '" + id + "'AND test_id = '" + test_id + "'";
		return getquestion;
	}
	
	public static String getTestDetailsQueryBuilder(int categoryId, int subCatId) {
		String getTestDetails = "SELECT * FROM testdetails WHERE cat_id = '" + categoryId + "'AND subcat_id = '" + subCatId + "'";
		return getTestDetails;
	}
	public static String getTestDetailsQueryBuilder() {
		String getTestDetails = "SELECT * FROM testdetails";
		return getTestDetails;
	}
	public static String getTestDetailsQueryBuilder(int categoryId) {
		String getTestDetails = "SELECT * FROM testdetails WHERE cat_id = '" + categoryId + "'";
		return getTestDetails;
	}
	
	public static String getTestDetailsByStatusQueryBuilder(int categoryId, int subCatId) {
		String getTestDetails = "SELECT * FROM testdetails WHERE cat_id = '" + categoryId + "'AND subcat_id = '" + subCatId + "'AND active = 'true'";
		return getTestDetails;
	}
	public static String getTestDetailsByStatusQueryBuilder() {
		String getTestDetails = "SELECT * FROM testdetails WHERE active = 'true'";
		return getTestDetails;
	}
	public static String getTestDetailsByStatusQueryBuilder(int categoryId) {
		String getTestDetails = "SELECT * FROM testdetails WHERE cat_id = '" + categoryId + "'AND active = 'true'";
		return getTestDetails;
	}
	
	public static String getQuestionsQueryBuilder(int test_id) {
		String getTestDetails = "SELECT * FROM questions WHERE test_id = '" + test_id + "' AND active = 'true'";
		return getTestDetails;
	}
	
	public static String addNewExamCategory(String category) {
		String addCategory = "INSERT into examcategory (category) values ('" + category +"')";
		return addCategory;
	}
	
	public static String addNewExamSubcategory(int cat_id, String subcategory) {
		String addSubcategory = "INSERT into examsubcategory (cat_id, subcategory) values ('" + cat_id +"', '"+ subcategory+"')";
		return addSubcategory;
	}
	
	public static String deleteQuestion(int id, int test_id) {
		String deleteQuestion = "UPDATE questions SET active = 'false' WHERE id = '"+ id +"' AND test_id = '" + test_id+"'";
		return deleteQuestion;
	}
	
	public static String getPublishTestQueryBuilder(int test_id) {
		String publishTest = "UPDATE testdetails SET active = 'true ' WHERE id = '" + test_id + "'";
		return publishTest;
	}
	
	public static String getUnpublishTestQueryBuilder(int test_id) {
		String unpublishTest = "UPDATE testdetails SET active = 'false ' WHERE id = '" + test_id + "'";
		return unpublishTest;
	}
	public static String getTestDetailsByTestIdQueryBuilder(int testId) {
		String getTestDetails = "SELECT * FROM testdetails WHERE id = '" + testId + "'";
		return getTestDetails;
	}
	public static String getCategoryByIdQueryBuilder(int id) {
		String getCategory = "SELECT category FROM examcategory WHERE id = '" + id + "'";
		return getCategory;
	}
	public static String getSubcategoryByIdQueryBuilder(int id) {
		String getSubcategory = "SELECT subcategory FROM examsubcategory WHERE id = '" + id + "'";
		return getSubcategory;
	}
}
