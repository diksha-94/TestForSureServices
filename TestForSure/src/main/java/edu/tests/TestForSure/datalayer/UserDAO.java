package edu.tests.TestForSure.datalayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.tests.TestForSure.common.DBConnection;
import edu.tests.TestForSure.entity.AuthenticateUserRequest;
import edu.tests.TestForSure.entity.User;
import edu.tests.TestForSure.entity.UserCreds;
import edu.tests.TestForSure.entity.UserDetails;
import edu.tests.TestForSure.response.CommonResponse;
import edu.tests.TestForSure.response.GetUserProfileResponse;
import edu.tests.TestForSure.response.LoginUserResponse;
import edu.tests.TestForSure.service.PasswordEncryption;
import edu.tests.TestForSure.sql.CreateUserQueries;

public class UserDAO {

	public static LoginUserResponse registerUserDAO(User user, UserCreds userCreds, String randomString){
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
				userDetailsQuery = CreateUserQueries.insertUserDetailsQueryBuilder(user, randomString);
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
				//User exists, now check if user has verified his/her email
				String isUserVerified = CreateUserQueries.checkUserVerified(email);
				statement = conn.createStatement();
				ResultSet res = statement.executeQuery(isUserVerified);
				Boolean userVerified = false;
				if(res.isBeforeFirst()){
					userVerified = true;
				}
				System.out.println(userId);
				if(userVerified){
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
					commonResponse = new CommonResponse(false, "You haven't yet verified your email. Please verify with the verification link sent.");
					response.setResponse(commonResponse);
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
	
	public static CommonResponse checkEmailExists(String email){
		System.out.println("Calling Check email exists or not DAO");
		CommonResponse response = new CommonResponse();
		String checkEmailQuery = CreateUserQueries.testEmailIdExists(email);
		
		Connection conn = null;
		try {
			conn = DBConnection.getDBConnection();
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(checkEmailQuery);
			String userId = "";
			if(rs.isBeforeFirst()){
				while(rs.next()){
					userId = rs.getString(1);
				}
				System.out.println(userId);
				response.setStatus(true);
				response.setMessage(userId);
			}
			else{
				response.setStatus(false);
				response.setMessage("Entered email is not registered");
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
	
	public static CommonResponse updatePassword(String id, String password){
		System.out.println("Calling update password DAO");
		CommonResponse response = new CommonResponse();
		String updatePasswordQuery = CreateUserQueries.updatePasswordQueryBuilder(id, password);
		
		Connection conn = null;
		try {
			conn = DBConnection.getDBConnection();
			
			Statement statement = conn.createStatement();
			int rs = statement.executeUpdate(updatePasswordQuery);
			if(rs>0){
				response.setStatus(true);
				response.setMessage("Password updated successfully");
			}
			else{
				response.setStatus(false);
				response.setMessage("Error in updating password");
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
	
	public static CommonResponse checkIfPasswordIsSame(String id, String password){
		System.out.println("Calling check password is same DAO");
		CommonResponse response = new CommonResponse();
		String checkPasswordQuery = CreateUserQueries.checkIfPasswordIsSame(id, password);
		
		Connection conn = null;
		try {
			conn = DBConnection.getDBConnection();
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(checkPasswordQuery);
			if(rs.isBeforeFirst()){
				while(rs.next()){
					response.setStatus(false);
					response.setMessage("New Password must be different from the old password");
				}
			}
			else{
				response.setStatus(true);
				response.setMessage("Password is different");
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
	
	public static CommonResponse getCurretPassword(String id){
		System.out.println("Calling get current password DAO");
		CommonResponse response = new CommonResponse();
		String getCurrentPassword = CreateUserQueries.getCurrentPassword(id);
		System.out.println("Get Password query: "+getCurrentPassword);
		Connection conn = null;
		try {
			conn = DBConnection.getDBConnection();
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(getCurrentPassword);
			if(rs.isBeforeFirst()){
				while(rs.next()){
					response.setStatus(true);
					response.setMessage(rs.getString(1));
				}
			}
			else{
				response.setStatus(false);
				response.setMessage("Error in getting Current Password");
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
	
	public static CommonResponse verifyEmailLink(String emailId, String uniqueId){
		System.out.println("Calling get current passwordverify email link DAO");
		CommonResponse response = new CommonResponse();
		String verifyEmailQuery = CreateUserQueries.verifyEmailLink(emailId, uniqueId);
		System.out.println("Verify email query: "+verifyEmailQuery);
		Connection conn = null;
		try {
			conn = DBConnection.getDBConnection();
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(verifyEmailQuery);
			if(rs.isBeforeFirst()){
				String updateUserQuery = CreateUserQueries.updateVerified(emailId);
				statement = conn.createStatement();
				int result = statement.executeUpdate(updateUserQuery);
				if(result>0){
					response.setStatus(true);
					response.setMessage("Successfully verified e-mail address");
				}
				else{
					response.setStatus(false);
					response.setMessage("Error in verifying e-mail address");
				}
			}
			else{
				response.setStatus(false);
				response.setMessage("Link is not valid");
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
	
	public static CommonResponse sendVerificationEmailAgain(String emailId, String uniqueId){
		System.out.println("Calling send verification email link again DAO");
		CommonResponse response = new CommonResponse();
		String testEmailExists = CreateUserQueries.testEmailIdExists(emailId);
		System.out.println("Verify email query: "+testEmailExists);
		Connection conn = null;
		try {
			conn = DBConnection.getDBConnection();
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(testEmailExists);
			if(rs.isBeforeFirst()){
				//Email id exists, now check if User has already verified the email id or not
				String emailVerified = CreateUserQueries.emailAlreadyVerified(emailId);
				statement = conn.createStatement();
				ResultSet result = statement.executeQuery(emailVerified);
				System.out.println("EmailVerified Query: "+emailVerified);
				String verified = "false";
				if(result.isBeforeFirst()){
					while(result.next()){
						verified = result.getString(1);
					}
					System.out.println("Verified: "+verified);
					if(verified.equals("true")){
						//Already verified
						response.setStatus(false);
						response.setMessage("Your e-mail is already verified. You can log in.");
					}
					else{
						//Need to sed the verification e-mail again
						String updateUniqueId = CreateUserQueries.sendVerificationLinkAgain(emailId, uniqueId);
						statement = conn.createStatement();
						int res = statement.executeUpdate(updateUniqueId);
						if(res>0){
							response.setStatus(true);
							response.setMessage("Unique id updated");
						}
						else{
							response.setStatus(false);
							response.setMessage("Error in updating unique id");
						}
					}
					
				}
				
			}
			else{
				response.setStatus(false);
				response.setMessage("You didn't register with this e-mail id. Please check the e-mail id or register again with this e-mail id.");
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
	
	public static GetUserProfileResponse getUserProfile(String emailId){
		System.out.println("Calling get user profile DAO");
		GetUserProfileResponse response = new GetUserProfileResponse();
		String getUserProfile = CreateUserQueries.getUserDetails(emailId);
		System.out.println("Get User Details query: "+getUserProfile);
		Connection conn = null;
		UserDetails userDetails = null;
		try {
			conn = DBConnection.getDBConnection();
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(getUserProfile);
			if(rs.isBeforeFirst()){
				while(rs.next()){
					response.setResponse(new CommonResponse(true, "Successfully got user details"));
					userDetails = new UserDetails();
					userDetails.setUsername(rs.getString(2));
					userDetails.setEmail(rs.getString(3));
					userDetails.setMobile(rs.getLong(4));
					response.setUserDetails(userDetails);
				}
			}
			else{
				response.setResponse(new CommonResponse(false, "Error in getting user details"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL exception: "+e.getMessage());
			response.setResponse(new CommonResponse(false, e.getMessage()));
		}
		finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				response.setResponse(new CommonResponse(false, e.getMessage()));
			}
		}
		return response;
	}
	
	public static CommonResponse updateUserProfile(UserDetails user){
		System.out.println("Calling update user profile DAO");
		CommonResponse response = new CommonResponse();
		String updateUserProfile = CreateUserQueries.updateUserDetails(user);
		System.out.println("Get User Details query: "+updateUserProfile);
		Connection conn = null;
		try {
			conn = DBConnection.getDBConnection();
			
			Statement statement = conn.createStatement();
			int rs = statement.executeUpdate(updateUserProfile);
			if(rs>0){
				response.setStatus(true);
				response.setMessage("User profile updated successfully");
			}
			else{
				response.setStatus(false);
				response.setMessage("Error in updating user profile");
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
	
	public static CommonResponse updateCurrentPassword(String emailId, String oldPassword, String newPassword){
		System.out.println("Calling update current password DAO");
		CommonResponse response = new CommonResponse();
		String getUserId = CreateUserQueries.testEmailIdExists(emailId);
		System.out.println("Get UserId query: "+getUserId);
		Connection conn = null;
		try {
			conn = DBConnection.getDBConnection();
			String userId = "";
			String currentPassword = "";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(getUserId);
			if(rs.isBeforeFirst()){
				while(rs.next()){
					userId = rs.getString(1);
				}
				String getCurrentPassword = CreateUserQueries.getCurrentPassword(userId); 
				statement = conn.createStatement();
				ResultSet rs1 = statement.executeQuery(getCurrentPassword);
				if(rs1.isBeforeFirst()){
					while(rs1.next()){
						currentPassword = rs1.getString(1);
					}
					String encryptedOldPassword = PasswordEncryption.encryptPassword(oldPassword);
					if(encryptedOldPassword.equals("exception")){
						response = new CommonResponse(false, "Error in encrypting password");
					}
					else{
						if(currentPassword.equals(encryptedOldPassword)){
							//means the current password match is success, update password now
							String encryptedNewPassword = PasswordEncryption.encryptPassword(newPassword);
							if(encryptedNewPassword.equals("exception")){
								response = new CommonResponse(false, "Error in encrypting password");
							}
							String updatePassword = CreateUserQueries.updatePasswordQueryBuilder(userId, encryptedNewPassword);
							statement = conn.createStatement();
							int rs2 = statement.executeUpdate(updatePassword);
							if(rs2>0){
								response = new CommonResponse(true, "Password updated successfully !!");
							}
							else{
								response = new CommonResponse(false, "Error in updating password");
							}
						}
						else{
							response = new CommonResponse(false, "Please enter your current password correctly.");
						}
					}
				}
				else{
					response.setStatus(false);
					response.setMessage("Error in getting Current Password");
				}
			}
			else{
				response.setStatus(false);
				response.setMessage("Error in getting Current Password");
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
