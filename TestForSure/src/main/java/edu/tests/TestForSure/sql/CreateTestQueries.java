package edu.tests.TestForSure.sql;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.tests.TestForSure.entity.Question;
import edu.tests.TestForSure.entity.TestDetails;
import edu.tests.TestForSure.entity.UserDetails;
import edu.tests.TestForSure.response.QuestionDetail;
import edu.tests.TestForSure.response.TestResultResponse;

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
		String getTestDetails = "INSERT into testdetails (id, cat_id, subcat_id, title, no_of_ques, time_limit, correct_ans_marks, wrong_ans_marks, shuffle_ques) values ('"+
				testDetails.getId()+ "' , '" +testDetails.getCat_id() + "' , '"+testDetails.getSubcat_id() + "' , '"+testDetails.getTestTitle() + "' , '"+testDetails.getNo_of_ques() + "' , '"+
					testDetails.getTime_limit() + "' , '"+testDetails.getCorrect_ques_marks() + "' , '"+testDetails.getNegative_marks()+ "' , '"+testDetails.getShuffleQuestions() + "')";
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
				"', wrong_ans_marks = '"+testDetails.getNegative_marks()+"', shuffle_ques = '"+testDetails.getShuffleQuestions()+"' WHERE id= '"+testDetails.getId()+"'";
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
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String insertQuestion = "INSERT into questions (id, test_id, question_type, paragraph_text, question_text, optionA, optionB, optionC, optionD, correct_option, explanation, last_updated_on) values ('"+
					question.getId() +"' , '" +question.getTest_id() + "' , '"+question.getQues_type() + "' , '"+question.getParagraph_text() + "' , '"+question.getQues_text() + "' , '"+
					question.getOptionA() + "' , '"+question.getOptionB() + "' , '"+question.getOptionC()+ "' , '"+question.getOptionD()+ "' , '"+question.getCorrect_option()+ "' , '"+
					question.getExplanation()+ "' , '"+ timeStamp + "')";
		return insertQuestion;
	}
	
	public static String updateQuestionQueryBuilder(Question question) {
		String updateQuestion = "UPDATE questions SET question_type = '"+question.getQues_type()+"',paragraph_text = '"+question.getParagraph_text()+
				"', question_text = '"+question.getQues_text()+"', optionA = '"+question.getOptionA()+"', optionB = '"+question.getOptionB()+
				"', optionC = '"+question.getOptionC()+"', optionD = '"+question.getOptionD()+"', correct_option = '"+question.getCorrect_option()+
				"', explanation = '"+question.getExplanation()+"' WHERE id= '"+question.getId()+"'AND test_id = '"+question.getTest_id()+"'";
		return updateQuestion;
	}
	public static String updateQuestionQueryBuilder(Boolean active, String id, int test_id) {
		String updateQuestion = "UPDATE questions SET active = '"+active+"' WHERE id= '"+id+"'AND test_id = '"+test_id+"'";
		return updateQuestion;
	}
	public static String questionAlreadyExistsQueryBuilder(String id, int test_id) {
		String getquestion = "SELECT * FROM questions WHERE id = '" + id + "'AND test_id = '" + test_id + "'";
		return getquestion;
	}
	
	public static String getTestDetailsQueryBuilder(int categoryId, int subCatId) {
		String getTestDetails = "SELECT * FROM testdetails WHERE cat_id = '" + categoryId + "'AND subcat_id = '" + subCatId + "' ORDER BY last_updated_on DESC";
		return getTestDetails;
	}
	public static String getTestDetailsQueryBuilder() {
		String getTestDetails = "SELECT * FROM testdetails ORDER BY last_updated_on DESC";
		return getTestDetails;
	}
	public static String getTestDetailsQueryBuilder(int categoryId) {
		String getTestDetails = "SELECT * FROM testdetails WHERE cat_id = '" + categoryId + "' ORDER BY last_updated_on DESC";
		return getTestDetails;
	}
	
	public static String getTestDetailsByStatusQueryBuilder(int categoryId, int subCatId) {
		String getTestDetails = "SELECT * FROM testdetails WHERE cat_id = '" + categoryId + "'AND subcat_id = '" + subCatId + "'AND active = 'true' ORDER BY last_updated_on DESC";
		return getTestDetails;
	}
	public static String getTestDetailsByStatusQueryBuilder() {
		String getTestDetails = "SELECT * FROM testdetails WHERE active = 'true' ORDER BY last_updated_on DESC";
		return getTestDetails;
	}
	public static String getTestDetailsByStatusQueryBuilder(int categoryId) {
		String getTestDetails = "SELECT * FROM testdetails WHERE cat_id = '" + categoryId + "'AND active = 'true' ORDER BY last_updated_on DESC";
		return getTestDetails;
	}
	
	public static String getQuestionsQueryBuilder(int test_id) {
		String getTestDetails = "SELECT id, test_id, question_type, paragraph_text, question_text, optionA, optionB, optionC, optionD, correct_option, explanation, last_updated_on FROM questions WHERE test_id = '" + test_id + "' AND active = 'true' ORDER BY last_updated_on ASC";
		return getTestDetails;
	}
	
	public static String getQuestionsShuffleQueryBuilder(int test_id) {
		String getTestDetails = "SELECT id, test_id, question_type, paragraph_text, question_text, optionA, optionB, optionC, optionD, correct_option, explanation, last_updated_on FROM questions WHERE test_id = '" + test_id + "' AND active = 'true'";
		return getTestDetails;
	}
	
	public static String addNewExamCategory(String category, String imagePath) {
		String addCategory = "INSERT into examcategory (category, imagePath) values ('" + category +"','"+imagePath+"')";
		return addCategory;
	}
	public static String existingExamCategory(String category) {
		String existingCategory = "SELECT * FROM examcategory where category = '" + category +"'";
		return existingCategory;
	}
	
	public static String addNewExamSubcategory(int cat_id, String subcategory) {
		String addSubcategory = "INSERT into examsubcategory (cat_id, subcategory) values ('" + cat_id +"', '"+ subcategory+"')";
		return addSubcategory;
	}
	public static String existingExamSubcategory(int cat_id, String subcategory) {
		String existingSubcategory = "SELECT * FROM examsubcategory WHERE cat_id ='" + cat_id +"' AND subcategory = '"+ subcategory+"'";
		return existingSubcategory;
	}
	public static String deleteQuestion(String id, int test_id) {
		String deleteQuestion = "UPDATE questions SET active = 'false' WHERE id = '"+ id +"' AND test_id = '" + test_id+"'";
		return deleteQuestion;
	}
	
	public static String getPublishTestQueryBuilder(int test_id) {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String publishTest = "UPDATE testdetails SET active = 'true', last_updated_on = '" + timeStamp +"' WHERE id = '" + test_id + "'";
		return publishTest;
	}
	
	public static String getUnpublishTestQueryBuilder(int test_id) {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String unpublishTest = "UPDATE testdetails SET active = 'false', last_updated_on = '" + timeStamp +"'  WHERE id = '" + test_id + "'";
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
	public static String getAnswersQueryBuilder(int test_id) {
		String getAnswers = "SELECT id, correct_option, explanation FROM questions WHERE test_id = '" + test_id + "' AND active='true'";
		return getAnswers;
	}
	 
	public static String insertTestReport(TestResultResponse resultResponse, UserDetails userDetails, int no_of_ques) {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String insertTestReport = "INSERT into testreports (test_id, username, emailid, mobile_number, marks_scored, time_taken, rank, questions_attempted, correct_ques, incorrect_ques, total_ques, last_updated_on) values ('"+
					resultResponse.getTest_id() +"' , '" +userDetails.getUsername() + "' , '"+userDetails.getEmail() + "' , '"+userDetails.getMobile() + "' , '"+resultResponse.getMarks_scored() + "' , '"+
					resultResponse.getTime_taken() + "' , '"+resultResponse.getRank() + "' , '"+resultResponse.getQues_attempted()+ "' , '"+resultResponse.getCorrect_ques()+ "' , '"+resultResponse.getIncorrect_ques()+ "' , '"+no_of_ques+ "' , '"+timeStamp + "')";
		return insertTestReport;
	}
	public static String findRank(Double marks_scored, int test_id) {
		String findRank = "SELECT id FROM testReports WHERE marks_scored >= '" + marks_scored + "' AND test_id = '" + test_id + "'";
		return findRank;
	}
	
	public static String manageRankForAllUsers(int rank, int test_id) {
		String manageRank = "UPDATE testreports SET rank = rank+1 where rank >= '" + rank + "' AND test_id = '" + test_id + "' order by rank desc";
		return manageRank;
	}
	
	public static String updateTotalCandidates(int test_id) {
		String updateTotalCandidate = "UPDATE testdetails SET candidate_count = candidate_count+1 where id = '" + test_id + "'";
		return updateTotalCandidate;
	}
	
	public static String getTotalCandidates(int test_id) {
		String getTotalCandidate = "SELECT candidate_count from testdetails where id = '" + test_id + "'";
		return getTotalCandidate;
	}
	public static String getLastInsertIdCategoryQueryBuilder(){
		String last_insert_id = "select last_insert_id() as last_id from categorysubjectwise";
		return last_insert_id;
	}
	
	public static String getLastInsertIdSubcategoryQueryBuilder(){
		String last_insert_id = "select last_insert_id() as last_id from subcategorysubjectwise";
		return last_insert_id;
	}
	public static String getTopPerformers(int test_id){
		String query = "SELECT username,rank,marks_scored, time_taken FROM testreports WHERE test_id = '" + test_id + "' ORDER BY rank ASC";
		return query;
	}
	public static String getAverage(int test_id){
		String query = "SELECT marks_scored, time_taken FROM testreports WHERE test_id = '" + test_id + "'";
		return query;
	}
	
	public static String insertTestQuestionReport(int test_id, String username, QuestionDetail question, int lastReportId) {
		String insertQuestionReport = "INSERT into testquestionreport (test_id, ques_id, user_id, correct, time_spent, correct_option, marked_option, explanation, test_report_id) values ('"+
					test_id +"' , '" +question.getQues_id() + "' , '"+username + "' , '"+question.getCorrect() + "' , '"+question.getTime_spent()+ "' , '"+question.getCorrect_option()+ "' , '"+question.getMarked_option()+ "' , '"+question.getExplanation()+ "' , '"+lastReportId + "')";
		return insertQuestionReport;
	}
	public static String getTestImagePath(int cat_id){
		String query = "SELECT imagePath FROM examcategory WHERE id = '" + cat_id + "'";
		return query;
	}
	public static String checkCategoryExists(String category){
		String query = "SELECT * FROM examcategory WHERE category = '" + category + "'";
		return query;
	}
	public static String checkSubcategoryExists(String subcategory){
		String query = "SELECT * FROM examsubcategory WHERE subcategory = '" + subcategory + "'";
		return query;
	}
	public static String checkAlreadyAttempted(int test_id, String email_id){
		String query = "SELECT * FROM testreports WHERE test_id = '"+ test_id +"' AND emailid = '" + email_id+"'";
		return query;
	}
	public static String getLastInsertReportId(){
		String last_insert_id = "select last_insert_id() as last_id from testreports";
		return last_insert_id;
	}
}
