package edu.tests.TestForSure.datalayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import edu.tests.TestForSure.common.DBConnection;
import edu.tests.TestForSure.entity.AddQuestionsFromBankRequest;
import edu.tests.TestForSure.entity.ExamCategory;
import edu.tests.TestForSure.entity.ExamSubcategory;
import edu.tests.TestForSure.entity.QuestionBank;
import edu.tests.TestForSure.response.AddQuestionResponse;
import edu.tests.TestForSure.response.CommonResponse;
import edu.tests.TestForSure.response.GetCategoryResponse;
import edu.tests.TestForSure.response.GetQuestionsBankResponse;
import edu.tests.TestForSure.response.GetSubcategoryResponse;
import edu.tests.TestForSure.sql.CreateQuestionBankQueries;
import edu.tests.TestForSure.sql.CreateTestQueries;

public class QuestionBankDAO {
	
	public static GetCategoryResponse getAllSubjectCategoriesDAO(){
		System.out.println("Calling DAO");
		String query = CreateQuestionBankQueries.getCategoryQueryBuilder();
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
	
	public static GetSubcategoryResponse getSubjectSubcategoriesDAO(int categoryId){
		System.out.println("Calling DAO");
		String query = CreateQuestionBankQueries.getSubcategoryQueryBuilder(categoryId);
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
	
	public static CommonResponse addnewSubjectCategory(String category){
		System.out.println("Calling DAO");
		CommonResponse response = new CommonResponse();
		Connection conn = DBConnection.getDBConnection();
		String query = CreateQuestionBankQueries.addNewSubjectCategory(category);
		
		System.out.println("Query: "+query);
		int result = 0;
		try{
			Statement statement = conn.createStatement();
			result = statement.executeUpdate(query);
			if(result>0){
				response.setStatus(true);
				
				query = CreateQuestionBankQueries.getLastInsertIdCategoryQueryBuilder();
				ResultSet rs = statement.executeQuery(query);
				int id = 0;
				if(rs.isBeforeFirst()){
					while(rs.next()){
						id = rs.getInt(1);
					}
				}
				
				response.setMessage("New subject Category added successfully-"+id);
			}
			else{
				response.setStatus(false);
				response.setMessage("Error in adding subject category");
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO : "+e.getMessage());
			response.setStatus(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	public static CommonResponse addnewSubjectSubcategory(int cat_id, String subcategory){
		System.out.println("Calling DAO");
		CommonResponse response = new CommonResponse();
		Connection conn = DBConnection.getDBConnection();
		String query = CreateQuestionBankQueries.addNewSubjectSubcategory(cat_id, subcategory);
		
		System.out.println("Query: "+query);
		int result = 0;
		try{
			Statement statement = conn.createStatement();
			result = statement.executeUpdate(query);
			if(result>0){
				response.setStatus(true);
				query = CreateQuestionBankQueries.getLastInsertIdCategoryQueryBuilder();
				ResultSet rs = statement.executeQuery(query);
				int id = 0;
				if(rs.isBeforeFirst()){
					while(rs.next()){
						id = rs.getInt(1);
					}
				}
				response.setMessage("New Subject Subcategory added successfully-"+id);
			}
			else{
				response.setStatus(false);
				response.setMessage("Error in adding Subject subcategory");
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO : "+e.getMessage());
			response.setStatus(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	public static GetQuestionsBankResponse getQuestions(int categoryId, int subCatId){
		System.out.println("Calling Get questions from Question Bank DAO");
		GetQuestionsBankResponse response = new GetQuestionsBankResponse();
		Connection conn = DBConnection.getDBConnection();
		String query = "";
		if(categoryId == 0) {
			if(subCatId!=0) {
				response.setStatus(false);
				response.setMessage("Please select the test category as well when subcategory is specified");
				return response;
			}
			else if(subCatId==0){
				query = CreateQuestionBankQueries.getQuestionsQueryBuilder();
			}
		}
		else if(categoryId != 0){
			if(subCatId == 0){
				query = CreateQuestionBankQueries.getQuestionsQueryBuilder(categoryId);
			}
			else if(subCatId != 0){
				query = CreateQuestionBankQueries.getQuestionsQueryBuilder(categoryId, subCatId);
			}
		}
		
		System.out.println("Query: "+query);
		ResultSet rs = null;
		ArrayList<QuestionBank> list = new ArrayList<QuestionBank>();
		try{
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(query);
			if(rs.isBeforeFirst()){
				while(rs.next()){
					QuestionBank question = new QuestionBank();
					question.setId(rs.getInt(1));
					question.setTest_id(rs.getString(2));
					question.setQuestion_type(rs.getString(3));
					question.setParagraph_text(rs.getString(4));
					question.setQuestion_text(rs.getString(5));
					question.setOptionA(rs.getString(6));
					question.setOptionB(rs.getString(7));
					question.setOptionC(rs.getString(8));
					question.setOptionD(rs.getString(9));
					question.setCorrect_option(rs.getString(10));
					question.setExplanation(rs.getString(11));
					question.setCategory_id(rs.getInt(12));
					question.setSubcategory_id(rs.getInt(13));
					list.add(question);
				}
				response.setQuestions(list);
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
	
	public static AddQuestionResponse addQuestionToQuestionBank(QuestionBank question){
		System.out.println("Calling Add question to Question Bank DAO");
		AddQuestionResponse response = new AddQuestionResponse();
		Connection conn = DBConnection.getDBConnection();
		String query = CreateQuestionBankQueries.insertQuestionBankQueryBuilder(question);
		
		System.out.println("Query: "+query);
		int result = 0;
		try{
			Statement statement = conn.createStatement();
			result = statement.executeUpdate(query);
			if(result>0){
				System.out.println("Question added successfully");
				response.setStatus(true);
				response.setMessage("Question added succefully to question bank");
				query = CreateQuestionBankQueries.getLastInsertIdQuestionQueryBuilder();
				ResultSet question_id = statement.executeQuery(query);
				response.setQuestion_id(question_id.getInt(1));
			}
			else{
				response.setStatus(false);
				response.setMessage("Error in adding question to question bank");
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO : "+e.getMessage());
		}
		return response;
	}
	
	public static AddQuestionResponse updateQuestionToQuestionBank(QuestionBank question){
		System.out.println("Calling Update question to Question Bank DAO");
		AddQuestionResponse response = new AddQuestionResponse();
		Connection conn = DBConnection.getDBConnection();
		String query = CreateQuestionBankQueries.updateQuestionBankQueryBuilder(question);
		
		System.out.println("Query: "+query);
		int result = 0;
		try{
			Statement statement = conn.createStatement();
			result = statement.executeUpdate(query);
			if(result>0){
				System.out.println("Question updated successfully");
				response.setStatus(true);
				response.setMessage("Question updated successfully in question bank");
			}
			else{
				response.setStatus(false);
				response.setMessage("Error in updating question in question bank");
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO : "+e.getMessage());
		}
		return response;
	}
	
	public static CommonResponse deleteQuestionFromQuestionBank(int id){
		System.out.println("Calling delete question from question bank DAO");
		CommonResponse response = new CommonResponse();
		Connection conn = DBConnection.getDBConnection();
		String query = CreateQuestionBankQueries.deleteQuestionQueryBuilder(id);
		
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
	
	public static CommonResponse addQuestionsFromQuestionBank(AddQuestionsFromBankRequest request){
		System.out.println("Calling add questions from question bank DAO");
		CommonResponse response = new CommonResponse();
		Connection conn = DBConnection.getDBConnection();
		
		//Loop through all the question_id, first update the test_id in questionbank and then add question to questions from questionbank
		
		for(Integer i : request.getQuestion_id()){
			String query = CreateQuestionBankQueries.updateTestIdToQuestionBank(request.getTest_id(), i);
			
			System.out.println("Query: "+query);
			int result = 0;
			try{
				Statement statement = conn.createStatement();
				result = statement.executeUpdate(query);
				if(result>0){
					query = CreateQuestionBankQueries.insertQuestionFromQuestionBank(i);
					System.out.println("Query: "+query);
					result = statement.executeUpdate(query);
					if(result>0){
						response.setStatus(true);
						response.setMessage("Successfully added question with question_id: "+i);
					}
					else{
						response.setStatus(false);
						response.setMessage("Error in adding Question");
					}
				}
				else{
					response.setStatus(false);
					response.setMessage("Error in adding Question");
				}
			}
			catch(Exception e){
				System.out.println("Exception from DAO : "+e.getMessage());
				response.setStatus(false);
				response.setMessage(e.getMessage());
			}
		}
		
		return response;
	}
	
	
}
