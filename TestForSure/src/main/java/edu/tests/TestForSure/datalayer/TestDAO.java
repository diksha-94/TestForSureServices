package edu.tests.TestForSure.datalayer;

import java.sql.*;
import java.util.*;
import edu.tests.TestForSure.common.DBConnection;
import edu.tests.TestForSure.entity.ExamCategory;
import edu.tests.TestForSure.entity.ExamSubcategory;
import edu.tests.TestForSure.entity.Question;
import edu.tests.TestForSure.entity.TestDetails;
import edu.tests.TestForSure.response.GetCategoryResponse;
import edu.tests.TestForSure.response.GetSubcategoryResponse;
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
					sc = new ExamSubcategory(examSubcategory.getInt(1), examSubcategory.getString(2));
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
	
}
