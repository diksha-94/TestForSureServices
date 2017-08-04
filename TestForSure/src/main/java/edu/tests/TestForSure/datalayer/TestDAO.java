package edu.tests.TestForSure.datalayer;

import java.sql.*;
import java.util.*;
import edu.tests.TestForSure.common.DBConnection;
import edu.tests.TestForSure.entity.ExamCategory;
import edu.tests.TestForSure.entity.ExamSubcategory;
import edu.tests.TestForSure.entity.Question;
import edu.tests.TestForSure.entity.TestDetails;
import edu.tests.TestForSure.entity.UserDetails;
import edu.tests.TestForSure.response.CommonResponse;
import edu.tests.TestForSure.response.GetCategoryResponse;
import edu.tests.TestForSure.response.GetQuestionsResponse;
import edu.tests.TestForSure.response.GetSingleTestDetailsResponse;
import edu.tests.TestForSure.response.GetSubcategoryResponse;
import edu.tests.TestForSure.response.GetTestDetailsResponse;
import edu.tests.TestForSure.response.QuestionDetail;
import edu.tests.TestForSure.response.TestResultResponse;
import edu.tests.TestForSure.sql.CreateTestQueries;

public class TestDAO {

	public static GetCategoryResponse getAllCategoriesDAO(){
		System.out.println("Calling DAO");
		String query = CreateTestQueries.getCategoryQueryBuilder();
		Connection conn = DBConnection.getDBConnection();
		ResultSet examCategory = null;
		GetCategoryResponse response = null;
		ArrayList<ExamCategory> categoryList = new ArrayList<ExamCategory>();
		ExamCategory ec = null;
		try{
			Statement statement = conn.createStatement();
			examCategory = statement.executeQuery(query);
			if(examCategory.isBeforeFirst()){
				while(examCategory.next()){
					ec = new ExamCategory(examCategory.getInt(1), examCategory.getString(2));
					categoryList.add(ec);
				}
				response = new GetCategoryResponse(categoryList, true, "Number of categories fetched: "+categoryList.size());
			}
			else {
				response = new GetCategoryResponse(null, false, "No data found");
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO: "+e.getMessage());
		}
		
		return response;
	}
	
	public static GetSubcategoryResponse getSubcategoriesDAO(int categoryId){
		System.out.println("Calling DAO");
		String query = CreateTestQueries.getSubcategoryQueryBuilder(categoryId);
		Connection conn = DBConnection.getDBConnection();
		ResultSet examSubcategory = null;
		GetSubcategoryResponse response = null;
		ArrayList<ExamSubcategory> subcategoryList = new ArrayList<ExamSubcategory>();
		ExamSubcategory sc = null;
		try{
			Statement statement = conn.createStatement();
			examSubcategory = statement.executeQuery(query);
			if(examSubcategory.isBeforeFirst()){
				while(examSubcategory.next()){
					sc = new ExamSubcategory(examSubcategory.getInt(1), categoryId, examSubcategory.getString(2));
					subcategoryList.add(sc);
				}
				response = new GetSubcategoryResponse(subcategoryList, true, "Number of subcategories fetched: "+subcategoryList.size());
			}
			else {
				response = new GetSubcategoryResponse(null, false, "No data found");
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO: "+e.getMessage());
		}
		
		return response;
	}
	
	public static int insertUpdateTestDetailsDAO(TestDetails testDetails){
		System.out.println("Calling DAO");
		Connection conn = DBConnection.getDBConnection();
		String query = CreateTestQueries.testAlreadyExistsQueryBuilder(testDetails.getId());
		System.out.println("Query: "+query);
		ResultSet rs = null;
		int result = 0;
		try{
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(query);
			if(rs.isBeforeFirst()){
				System.out.println("Inside update");
				//update
				String updateQuery = CreateTestQueries.updateTestDetailsQueryBuilder(testDetails);
				System.out.println("Update Query: "+updateQuery);
				result = statement.executeUpdate(updateQuery);
			}
			else{
				System.out.println("Inside insert");
				//insert
				String insertQuery = CreateTestQueries.insertTestDetailsQueryBuilder(testDetails);
				System.out.println("Insert Query: "+insertQuery);
				
				result = statement.executeUpdate(insertQuery);
			}
			if(result > 0){
				return testDetails.getId();
			}
			else{
				return 0;
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO : "+e.getMessage());
			return 0;
		}
	}
	
	public static int insertUpdateQuestionDAO(Question question){
		System.out.println("Calling DAO");
		Connection conn = DBConnection.getDBConnection();
		String query = CreateTestQueries.questionAlreadyExistsQueryBuilder(question.getId(), question.getTest_id());
		System.out.println("Query: "+query);
		ResultSet rs = null;
		int result = 0;
		try{
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(query);
			if(rs.isBeforeFirst()){
				System.out.println("Inside update");
				//update
				String updateQuery = CreateTestQueries.updateQuestionQueryBuilder(question);
				System.out.println("Update Query: "+updateQuery);
				result = statement.executeUpdate(updateQuery);
			}
			else{
				System.out.println("Inside insert");
				//insert
				String insertQuery = CreateTestQueries.insertQuestionQueryBuilder(question);
				System.out.println("Insert Query: "+insertQuery);
				
				result = statement.executeUpdate(insertQuery);
			}
			if(result > 0){
				return question.getId();
			}
			else{
				return 0;
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO : "+e.getMessage());
			return 0;
		}
	}
	
	public static GetTestDetailsResponse getTestDetails(int categoryId, int subCatId){
		System.out.println("Calling DAO");
		GetTestDetailsResponse response = new GetTestDetailsResponse();
		Connection conn = DBConnection.getDBConnection();
		String query = "";
		if(categoryId == 0) {
			if(subCatId!=0) {
				response.setStatus(false);
				response.setMessage("Please select the test category as well when subcategory is specified");
				return response;
			}
			else if(subCatId==0){
				query = CreateTestQueries.getTestDetailsQueryBuilder();
			}
		}
		else if(categoryId != 0){
			if(subCatId == 0){
				query = CreateTestQueries.getTestDetailsQueryBuilder(categoryId);
			}
			else if(subCatId != 0){
				query = CreateTestQueries.getTestDetailsQueryBuilder(categoryId, subCatId);
			}
		}
		
		System.out.println("Query: "+query);
		ResultSet rs = null;
		ArrayList<TestDetails> list = new ArrayList<TestDetails>();
		try{
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(query);
			if(rs.isBeforeFirst()){
				while(rs.next()){
					TestDetails testDetails = new TestDetails();
					testDetails.setId(rs.getInt(1));
					testDetails.setCat_id(rs.getInt(2));
					testDetails.setSubcat_id(rs.getInt(3));
					testDetails.setTestTitle(rs.getString(4));
					testDetails.setNo_of_ques(rs.getInt(5));
					testDetails.setTime_limit(rs.getInt(6));
					testDetails.setCorrect_ques_marks(rs.getInt(7));
					testDetails.setNegative_marks(rs.getInt(8));
					testDetails.setActive(rs.getBoolean(9));
					list.add(testDetails);
				}
				response.setTestDetails(list);
				response.setStatus(true);
				response.setMessage("");
			}
			else{
				response.setStatus(false);
				response.setMessage("No tests found");
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO : "+e.getMessage());
		}
		return response;
	}
	
	public static GetTestDetailsResponse getTestDetailsByStatus(int categoryId, int subCatId){
		System.out.println("Calling DAO");
		GetTestDetailsResponse response = new GetTestDetailsResponse();
		Connection conn = DBConnection.getDBConnection();
		String query = "";
		if(categoryId == 0) {
			if(subCatId!=0) {
				response.setStatus(false);
				response.setMessage("Please select the test category as well when subcategory is specified");
				return response;
			}
			else if(subCatId==0){
				query = CreateTestQueries.getTestDetailsByStatusQueryBuilder();
			}
		}
		else if(categoryId != 0){
			if(subCatId == 0){
				query = CreateTestQueries.getTestDetailsByStatusQueryBuilder(categoryId);
			}
			else if(subCatId != 0){
				query = CreateTestQueries.getTestDetailsByStatusQueryBuilder(categoryId, subCatId);
			}
		}
		
		System.out.println("Query: "+query);
		ResultSet rs = null;
		ArrayList<TestDetails> list = new ArrayList<TestDetails>();
		try{
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(query);
			if(rs.isBeforeFirst()){
				while(rs.next()){
					TestDetails testDetails = new TestDetails();
					testDetails.setId(rs.getInt(1));
					testDetails.setCat_id(rs.getInt(2));
					testDetails.setSubcat_id(rs.getInt(3));
					testDetails.setTestTitle(rs.getString(4));
					testDetails.setNo_of_ques(rs.getInt(5));
					testDetails.setTime_limit(rs.getInt(6));
					testDetails.setCorrect_ques_marks(rs.getInt(7));
					testDetails.setNegative_marks(rs.getInt(8));
					
					list.add(testDetails);
				}
				response.setTestDetails(list);
				response.setStatus(true);
				response.setMessage("");
			}
			else{
				response.setStatus(false);
				response.setMessage("No tests found");
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO : "+e.getMessage());
		}
		return response;
	}
	
	public static GetSingleTestDetailsResponse getTestDetails(int testId){
		System.out.println("Calling DAO");
		Connection conn = DBConnection.getDBConnection();
		String query = CreateTestQueries.getTestDetailsByTestIdQueryBuilder(testId);
		int cat_id = 0;
		int subcat_id = 0;
		System.out.println("Query: "+query);
		ResultSet rs = null;
		GetSingleTestDetailsResponse response = new GetSingleTestDetailsResponse();
		TestDetails testDetails = new TestDetails();
		try{
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(query);
			if(rs.isBeforeFirst()){
				while(rs.next()){
					testDetails.setId(rs.getInt(1));
					cat_id = rs.getInt(2);
					subcat_id = rs.getInt(3);
					testDetails.setTestTitle(rs.getString(4));
					testDetails.setNo_of_ques(rs.getInt(5));
					testDetails.setTime_limit(rs.getInt(6));
					testDetails.setCorrect_ques_marks(rs.getInt(7));
					testDetails.setNegative_marks(rs.getInt(8));
				}
				response.setTestDetails(testDetails);
				query = CreateTestQueries.getCategoryByIdQueryBuilder(cat_id);
				ResultSet category = statement.executeQuery(query);
				if(category.isBeforeFirst()){
					while(category.next()){
						response.setCategory(category.getString(1));
					}
				}
				
				query = CreateTestQueries.getSubcategoryByIdQueryBuilder(subcat_id);
				ResultSet subcategory = statement.executeQuery(query);
				if(subcategory.isBeforeFirst()){
					while(subcategory.next()){
						response.setSubcategory(subcategory.getString(1));
					}
				}
				
				response.setStatus(true);
				response.setMessage("");
			}
			else{
				response.setStatus(false);
				response.setMessage("No test found with test id: "+testId);
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO : "+e.getMessage());
		}
		return response;
	}
	
	
	public static GetQuestionsResponse getQuestions(int test_id){
		System.out.println("Calling DAO");
		GetQuestionsResponse response = new GetQuestionsResponse();
		Connection conn = DBConnection.getDBConnection();
		String query = CreateTestQueries.getQuestionsQueryBuilder(test_id);
		
		System.out.println("Query: "+query);
		ResultSet rs = null;
		ArrayList<Question> list = new ArrayList<Question>();
		try{
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(query);
			if(rs.isBeforeFirst()){
				while(rs.next()){
					Question question = new Question();
					question.setId(rs.getInt(1));
					question.setTest_id(rs.getInt(2));
					question.setQues_type(rs.getString(3));
					question.setParagraph_text(rs.getString(4));
					question.setQues_text(rs.getString(5));
					question.setOptionA(rs.getString(6));
					question.setOptionB(rs.getString(7));
					question.setOptionC(rs.getString(8));
					question.setOptionD(rs.getString(9));
					
					
					list.add(question);
				}
				response.setQuestion(list);
				response.setStatus(true);
				response.setMessage("");
			}
			else{
				response.setStatus(false);
				response.setMessage("No questions found");
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO : "+e.getMessage());
		}
		return response;
	}
	
	public static CommonResponse addnewCategory(String category){
		System.out.println("Calling DAO");
		CommonResponse response = new CommonResponse();
		Connection conn = DBConnection.getDBConnection();
		String query = CreateTestQueries.addNewExamCategory(category);
		
		System.out.println("Query: "+query);
		int result = 0;
		try{
			Statement statement = conn.createStatement();
			result = statement.executeUpdate(query);
			if(result>0){
				response.setStatus(true);
				response.setMessage("New Exam Category added successfully");
			}
			else{
				response.setStatus(false);
				response.setMessage("Error in adding exam category");
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO : "+e.getMessage());
			response.setStatus(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	public static CommonResponse addnewSubcategory(int cat_id, String subcategory){
		System.out.println("Calling DAO");
		CommonResponse response = new CommonResponse();
		Connection conn = DBConnection.getDBConnection();
		String query = CreateTestQueries.addNewExamSubcategory(cat_id, subcategory);
		
		System.out.println("Query: "+query);
		int result = 0;
		try{
			Statement statement = conn.createStatement();
			result = statement.executeUpdate(query);
			if(result>0){
				response.setStatus(true);
				response.setMessage("New Exam Subcategory added successfully");
			}
			else{
				response.setStatus(false);
				response.setMessage("Error in adding exam subcategory");
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO : "+e.getMessage());
			response.setStatus(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	public static CommonResponse deleteQuestion(int id, int test_id){
		System.out.println("Calling DAO");
		CommonResponse response = new CommonResponse();
		Connection conn = DBConnection.getDBConnection();
		String query = CreateTestQueries.deleteQuestion(id, test_id);
		
		System.out.println("Query: "+query);
		int result = 0;
		try{
			Statement statement = conn.createStatement();
			result = statement.executeUpdate(query);
			if(result>0){
				response.setStatus(true);
				response.setMessage("Question deleted successfully");
			}
			else{
				response.setStatus(false);
				response.setMessage("Error in deleting Question");
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO : "+e.getMessage());
			response.setStatus(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	public static CommonResponse publishTest(int test_id){
		System.out.println("Calling DAO");
		CommonResponse response = new CommonResponse();
		Connection conn = DBConnection.getDBConnection();
		String query = CreateTestQueries.getPublishTestQueryBuilder(test_id);
		
		System.out.println("Query: "+query);
		int result = 0;
		try{
			Statement statement = conn.createStatement();
			result = statement.executeUpdate(query);
			if(result>0){
				response.setStatus(true);
				response.setMessage("Test published successfully");
			}
			else{
				response.setStatus(false);
				response.setMessage("Error in publishing test");
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO : "+e.getMessage());
			response.setStatus(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	public static CommonResponse unpublishTest(int test_id){
		System.out.println("Calling DAO");
		CommonResponse response = new CommonResponse();
		Connection conn = DBConnection.getDBConnection();
		String query = CreateTestQueries.getUnpublishTestQueryBuilder(test_id);
		
		System.out.println("Query: "+query);
		int result = 0;
		try{
			Statement statement = conn.createStatement();
			result = statement.executeUpdate(query);
			if(result>0){
				response.setStatus(true);
				response.setMessage("Test unpublished successfully");
			}
			else{
				response.setStatus(false);
				response.setMessage("Error in unpublishing test");
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO : "+e.getMessage());
			response.setStatus(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	public static GetQuestionsResponse getAnswers(int test_id){
		System.out.println("Calling DAO");
		GetQuestionsResponse response = new GetQuestionsResponse();
		Connection conn = DBConnection.getDBConnection();
		String query = CreateTestQueries.getAnswersQueryBuilder(test_id);
		ArrayList<Question> questionList = new ArrayList<Question>();
		System.out.println("Query: "+query);
		ResultSet rs = null;
		try{
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(query);
			if(rs.isBeforeFirst()){
				while(rs.next()){
					Question question = new Question();
					question.setId(rs.getInt(1));
					question.setCorrect_option(rs.getString(2));
					question.setExplanation(rs.getString(3));
					questionList.add(question);
				}
				response.setQuestion(questionList);
				response.setStatus(true);
				response.setMessage("Success");
			}
			else{
				response.setStatus(false);
				response.setMessage("Not found");
			}
			
		}
		catch(Exception e){
			System.out.println("Exception from DAO : "+e.getMessage());
			response.setStatus(false);
			response.setMessage(e.getMessage());
			
		}
		return response;
	}
	
	public static TestDetails getTestDetailsByTestId(int testId){
		System.out.println("Calling DAO");
		GetTestDetailsResponse response = new GetTestDetailsResponse();
		Connection conn = DBConnection.getDBConnection();
		String query = "";
		query = CreateTestQueries.testAlreadyExistsQueryBuilder(testId);
		System.out.println("Query: "+query);
		ResultSet rs = null;
		TestDetails testDetails = new TestDetails();
		try{
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(query);
			if(rs.isBeforeFirst()){
				while(rs.next()){
					testDetails.setId(rs.getInt(1));
					testDetails.setCat_id(rs.getInt(2));
					testDetails.setSubcat_id(rs.getInt(3));
					testDetails.setTestTitle(rs.getString(4));
					testDetails.setNo_of_ques(rs.getInt(5));
					testDetails.setTime_limit(rs.getInt(6));
					testDetails.setCorrect_ques_marks(rs.getInt(7));
					testDetails.setNegative_marks(rs.getInt(8));
					testDetails.setActive(rs.getBoolean(9));
				}
			}
			else{
				System.out.println("No test found");
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO : "+e.getMessage());
		}
		return testDetails;
	}
	
	public static CommonResponse insertTestReport(TestResultResponse resultResponse, UserDetails userDetails){
		System.out.println("Calling DAO");
		CommonResponse response = new CommonResponse();
		Connection conn = DBConnection.getDBConnection();
		String query = "";
		query = CreateTestQueries.insertTestReport(resultResponse, userDetails);
		System.out.println("Query: "+query);
		int result = 0;
		try{
			Statement statement = conn.createStatement();
			result = statement.executeUpdate(query);
			if(result>0){
				response.setStatus(true);
				response.setMessage("Test report for user "+userDetails.getUsername()+" added successfully");
			}
			else{
				response.setStatus(false);
				response.setMessage("Test report can't be added for the user "+userDetails.getUsername());
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO : "+e.getMessage());
			response.setStatus(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	public static int findUserRank(int marks_scored, int test_id){
		System.out.println("Calling DAO");
		Connection conn = DBConnection.getDBConnection();
		String query = "";
		query = CreateTestQueries.findRank(marks_scored, test_id);
		System.out.println("Query: "+query);
		ResultSet rs = null;
		int rank = 0;
		try{
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(query);
			if(rs.isBeforeFirst()){
				while(rs.next()){
					rank++;
				}
				rank++;
			}
			else
			{
				rank = 1;
			}
			
		}
		catch(Exception e){
			System.out.println("Exception from DAO : "+e.getMessage());
			rank = 0;
		}
		return rank;
	}
	
	public static CommonResponse manageAllUsersRank(int rank, int test_id){
		System.out.println("Calling DAO");
		Connection conn = DBConnection.getDBConnection();
		String query = "";
		query = CreateTestQueries.manageRankForAllUsers(rank, test_id);
		System.out.println("Query: "+query);
		int result = 0;
		CommonResponse response = new CommonResponse();
		try{
			Statement statement = conn.createStatement();
			result = statement.executeUpdate(query);
			if(result > 0){
				response.setStatus(true);
				response.setMessage("Rank of all the candidates updated successfully");
			}
			response.setStatus(true);
			response.setMessage("No need to update the rank");
		}
		catch(Exception e){
			System.out.println("Exception from DAO : "+e.getMessage());
			response.setStatus(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	public static int updateTotalCandidateTestDetails(int testId){
		System.out.println("Calling DAO");
		Connection conn = DBConnection.getDBConnection();
		String query = "";
		query = CreateTestQueries.updateTotalCandidates(testId);
		System.out.println("Query: "+query);
		int result = 0;
		int total_candidate = -1;
		ResultSet rs = null;
		try{
			Statement statement = conn.createStatement();
			result = statement.executeUpdate(query);
			if(result>0){
				System.out.println("Total number of candidates attempted test with test id: "+testId+" updated successfully");
				//If updated successfully, get the total number of candidates and return to service
				query = CreateTestQueries.getTotalCandidates(testId);
				rs = statement.executeQuery(query);
				if(rs.isBeforeFirst()){
					while(rs.next()){
						total_candidate = rs.getInt(1);
					}
				}
			}
			else{
				System.out.println("Error in updating the total number of candidates who attempted the test");
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO : "+e.getMessage());
			
		}
		return total_candidate;
	}
	
}
