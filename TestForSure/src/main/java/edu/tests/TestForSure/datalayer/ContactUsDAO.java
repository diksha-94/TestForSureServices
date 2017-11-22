package edu.tests.TestForSure.datalayer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import edu.tests.TestForSure.common.DBConnection;
import edu.tests.TestForSure.entity.ContactUs;
import edu.tests.TestForSure.response.CommonResponse;
import edu.tests.TestForSure.sql.CreateContactUsQueries;

public class ContactUsDAO {
	public static CommonResponse insertQueryDAO(ContactUs obj){
		System.out.println("Calling insert Contact us query DAO");
		String query = CreateContactUsQueries.insertQuery(obj);
		Connection conn = DBConnection.getDBConnection();
		CommonResponse response = new CommonResponse();
		int result = 0;
		try{
			Statement statement = conn.createStatement();
			result = statement.executeUpdate(query);
			if(result>0){
				response.setStatus(true);
				response.setMessage("Query added successfully");
			}
			else {
				response.setStatus(false);
				response.setMessage("Error in adding query");
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO: "+e.getMessage());
			response.setStatus(false);
			response.setMessage(e.getMessage());
		}
		finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				response.setStatus(false);
				response.setMessage(e.getMessage());
			}
		}
		return response;
	}
}
