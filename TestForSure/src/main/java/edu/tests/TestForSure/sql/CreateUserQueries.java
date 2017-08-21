package edu.tests.TestForSure.sql;

import edu.tests.TestForSure.entity.User;
import edu.tests.TestForSure.entity.UserCreds;

public class CreateUserQueries {
	
	public static String insertUserDetailsQueryBuilder(User user) {
		String insertUserDetails = "INSERT into userdetails (id, name, email, mobileno) values ('"+
					user.getId()+"','"+ user.getName() +"' , '" +user.getEmail() + "' , '"+user.getMobileno() + "')";
		return insertUserDetails;
	}
	
	public static String insertUserCredsQueryBuilder(UserCreds userCreds) {
		String insertUserCreds = "INSERT into usercreds (user_id, password) values ('"+
				userCreds.getUserId() +"' , '" +userCreds.getPassword() + "')";
		return insertUserCreds;
	}
	
	public static String getUserIdQueryBuilder(String email) {
		String getUserId = "SELECT id from userdetails WHERE email = '"+ email +"'";
		return getUserId;
	}
	
	public static String getPasswordQueryBuilder(String userId) {
		String getPassword = "SELECT password from usercreds WHERE user_id = '"+ userId +"'";
		return getPassword;
	}
}
