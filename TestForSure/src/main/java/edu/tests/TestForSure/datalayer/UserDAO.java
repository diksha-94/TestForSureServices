package edu.tests.TestForSure.datalayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.tests.TestForSure.common.DBConnection;
import edu.tests.TestForSure.entity.AuthenticateUserRequest;
import edu.tests.TestForSure.entity.User;
import edu.tests.TestForSure.entity.UserCreds;
import edu.tests.TestForSure.response.CommonResponse;
import edu.tests.TestForSure.sql.CreateUserQueries;

public class UserDAO {

	public static CommonResponse registerUserDAO(User user, UserCreds userCreds){
		System.out.println("Calling Register User DAO");
		CommonResponse response = new CommonResponse();
		String userDetailsQuery = CreateUserQueries.insertUserDetailsQueryBuilder(user);
		String userCredsQuery = CreateUserQueries.insertUserCredsQueryBuilder(userCreds);
		Connection conn = null;
		int userDetails = 0;
		int creds = 0;
		try {
			conn = DBConnection.getDBConnection();
			
			//set auto commit to false
			conn.setAutoCommit(false);

			Statement statement = conn.createStatement();
			userDetails = statement.executeUpdate(userDetailsQuery);
			
			creds = statement.executeUpdate(userCredsQuery);
			
			//now commit transaction
			conn.commit();
			
			System.out.println("UserDetails: "+userDetails);
			System.out.println("creds: "+creds);
			response.setStatus(true);
			response.setMessage("User registered successfully");
		} catch (SQLException e) {
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage(e.getMessage());
			try {
				conn.rollback();
				System.out.println("JDBC Transaction rolled back successfully");
			} catch (SQLException e1) {
				System.out.println("SQLException in rollback"+e.getMessage());
				response.setStatus(false);
				response.setMessage(e.getMessage());
			}
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
	
	public static CommonResponse authenticateUserDAO(String email){
		System.out.println("Calling Authenticate User DAO");
		CommonResponse response = new CommonResponse();
		String userIdQuery = CreateUserQueries.getUserIdQueryBuilder(email);
		//String passwordQuery = CreateUserQueries.getPasswordQueryBuilder(userCreds);
		Connection conn = null;
		String password = "";
		try {
			conn = DBConnection.getDBConnection();
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(userIdQuery);
			String userId = "";
			if(rs.isBeforeFirst()){
				while(rs.next()){
					userId = rs.getString(1);
				}
				System.out.println(userId);
				String passwordQuery = CreateUserQueries.getPasswordQueryBuilder(userId);
				rs = statement.executeQuery(passwordQuery);
				if(rs.isBeforeFirst()){
					while(rs.next()){
						password = rs.getString(1);
					}
					response.setStatus(true);
					response.setMessage(password);
				}
			}
			else{
				response.setStatus(false);
				response.setMessage("User doesn't exist.");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL exception: "+e.getMessage());
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
