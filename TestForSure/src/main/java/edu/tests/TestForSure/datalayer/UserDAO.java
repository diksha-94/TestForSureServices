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
import edu.tests.TestForSure.response.LoginUserResponse;
import edu.tests.TestForSure.sql.CreateUserQueries;

public class UserDAO {

	public static LoginUserResponse registerUserDAO(User user, UserCreds userCreds){
		System.out.println("Calling Register User DAO");
		LoginUserResponse response = new LoginUserResponse();
		CommonResponse res = null;
		
		String testEmailExistsQuery = CreateUserQueries.testEmailIdExists(user.getEmail());
		String userDetailsQuery = "";
		String userCredsQuery = "";
		int userDetails = 0;
		int creds = 0;
		Connection conn = null;
		try{
			conn = DBConnection.getDBConnection();
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(testEmailExistsQuery);
			if(rs.isBeforeFirst()){
				while(rs.next()){
					res = new CommonResponse(false, "This email is already registered");
					response.setResponse(res);
				}
			}
			else{
				userDetailsQuery = CreateUserQueries.insertUserDetailsQueryBuilder(user);
				userCredsQuery = CreateUserQueries.insertUserCredsQueryBuilder(userCreds);
				//set auto commit to false
				conn.setAutoCommit(false);

				statement = conn.createStatement();
				userDetails = statement.executeUpdate(userDetailsQuery);
				
				creds = statement.executeUpdate(userCredsQuery);
				
				//now commit transaction
				conn.commit();
				
				System.out.println("UserDetails: "+userDetails);
				System.out.println("creds: "+creds);
				res = new CommonResponse(true, "User registered successfully");
				response.setResponse(res);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			res = new CommonResponse(false, e.getMessage());
			response.setResponse(res);
			try {
				conn.rollback();
				System.out.println("JDBC Transaction rolled back successfully");
			} catch (SQLException e1) {
				System.out.println("SQLException in rollback"+e.getMessage());
				res = new CommonResponse(false, e.getMessage());
				response.setResponse(res);
			}
		}
		finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				res = new CommonResponse(false, e.getMessage());
				response.setResponse(res);
			}
		}
		return response;
	}
	
	public static LoginUserResponse authenticateUserDAO(String email){
		System.out.println("Calling Authenticate User DAO");
		LoginUserResponse response = new LoginUserResponse();
		String userIdQuery = CreateUserQueries.getUserIdQueryBuilder(email);
		//String passwordQuery = CreateUserQueries.getPasswordQueryBuilder(userCreds);
		Connection conn = null;
		String password = "";
		CommonResponse commonResponse = null;
		try {
			conn = DBConnection.getDBConnection();
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(userIdQuery);
			String userId = "";
			if(rs.isBeforeFirst()){
				while(rs.next()){
					userId = rs.getString(1);
					response.setUsername(rs.getString(2));
				}
				System.out.println(userId);
				String passwordQuery = CreateUserQueries.getPasswordQueryBuilder(userId);
				rs = statement.executeQuery(passwordQuery);
				if(rs.isBeforeFirst()){
					while(rs.next()){
						password = rs.getString(1);
					}
					commonResponse = new CommonResponse(true, "User exists");
					response.setResponse(commonResponse);
					response.setPassword(password);
				}
			}
			else{
				commonResponse = new CommonResponse(false, "User doesn't exist.");
				response.setResponse(commonResponse);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL exception: "+e.getMessage());
			commonResponse = new CommonResponse(false, e.getMessage());
			response.setResponse(commonResponse);
		}
		finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				commonResponse = new CommonResponse(false, e.getMessage());
				response.setResponse(commonResponse);
			}
		}
		return response;
	}
}
