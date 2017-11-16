package edu.tests.TestForSure.datalayer;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.tests.TestForSure.common.DBConnection;
import edu.tests.TestForSure.entity.ViewReportDetails;
import edu.tests.TestForSure.entity.ViewReportQuestions;
import edu.tests.TestForSure.sql.ViewReportQueries;

public class ViewReportDAO {

	public static ArrayList<ViewReportQuestions> getQuestionsDAO(int report_id, int test_id){
		System.out.println("Calling getQuestionsDAO");
		String query = ViewReportQueries.getQuestions(report_id, test_id);
		Connection conn = DBConnection.getDBConnection();
		ResultSet rs = null;
		ArrayList<ViewReportQuestions> response = new ArrayList<ViewReportQuestions>();
		
		ViewReportQuestions ques = null;
		try{
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(query);
			if(rs.isBeforeFirst()){
				while(rs.next()){
					ques = new ViewReportQuestions();
					ques.setQuesId(rs.getString(3));
					ques.setCorrect(rs.getBoolean(5));
					ques.setTimeSpent(rs.getBigDecimal(6));
					ques.setCorrectOption(rs.getString(7));
					ques.setMarkedOption(rs.getString(8));
					ques.setQuestionType(rs.getString(13));
					ques.setParagraphText(rs.getString(14));
					ques.setQuestionText(rs.getString(15));
					ques.setOptionA(rs.getString(16));
					ques.setOptionB(rs.getString(17));
					ques.setOptionC(rs.getString(18));
					ques.setOptionD(rs.getString(19));
					ques.setExplanation(rs.getString(9));
					response.add(ques);
				}
			}
			else {
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO: "+e.getMessage());
		}finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return response;
	}
	
	public static ViewReportDetails getGeneralDetailsDAO(int report_id){
		System.out.println("Calling getGeneralDetailsDAO");
		String query = ViewReportQueries.getGeneralDetails(report_id);
		Connection conn = DBConnection.getDBConnection();
		ResultSet rs = null;
		ViewReportDetails response = new ViewReportDetails();
		
		try{
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(query);
			if(rs.isBeforeFirst()){
				while(rs.next()){
					response.setUsername(rs.getString(3));
					response.setRank(rs.getInt(8));
					response.setMarksScored(rs.getBigDecimal(6));
					response.setTotalQuestions(rs.getInt(12));
					response.setQuestionsAttempted(rs.getInt(9));
					response.setCorrectQues(rs.getInt(10));
					response.setIncorrectQues(rs.getInt(11));
					response.setTimeTaken(rs.getBigDecimal(7));
				}
			}
			else {
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO: "+e.getMessage());
		}finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return response;
	}
	
	
	public static ViewReportDetails getTestDetailsDAO(int test_id, ViewReportDetails details){
		System.out.println("Calling getTestDetailsDAO");
		String query = ViewReportQueries.getTestDetail(test_id);
		Connection conn = DBConnection.getDBConnection();
		ResultSet rs = null;
		
		try{
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(query);
			if(rs.isBeforeFirst()){
				while(rs.next()){
					details.setTestTitle(rs.getString(1));
					details.setTotalCandidates(rs.getInt(2));
					details.setTotalMarks(new BigDecimal(rs.getInt(3)*rs.getInt(4)));
				}
			}
			else {
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO: "+e.getMessage());
		}finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return details;
	}
	
	//getTopPerformers int TestDAO
	//Average needs to be created
	//Using getPerformers response, topper and average score & time_taken can be found
}
