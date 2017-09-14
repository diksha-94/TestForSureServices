package edu.tests.TestForSure.service;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.tests.TestForSure.datalayer.TestDAO;
import edu.tests.TestForSure.datalayer.UserDAO;
import edu.tests.TestForSure.entity.AuthenticateUserRequest;
import edu.tests.TestForSure.entity.RegisterUserRequest;
import edu.tests.TestForSure.entity.User;
import edu.tests.TestForSure.entity.UserCreds;
import edu.tests.TestForSure.response.CommonResponse;
import edu.tests.TestForSure.response.LoginUserResponse;

@CrossOrigin
@RestController
@RequestMapping("/test-for-sure/user")
public class UserServices {

	@RequestMapping(method = {RequestMethod.POST}, value = "/register-user")
	public LoginUserResponse registerUser(@RequestBody RegisterUserRequest request){
		System.out.println("Calling register user service");;
		LoginUserResponse response = new LoginUserResponse();
		CommonResponse res = null;
		User user = new User();
		user.setId(request.getUserDetails().getId());
		user.setName(request.getUserDetails().getName());
		user.setEmail(request.getUserDetails().getEmail());
		user.setMobileno(request.getUserDetails().getMobileno());
		
		String encryptedPassword = PasswordEncryption.encryptPassword(request.getPassword());
		if(encryptedPassword.equals("exception")){
			res = new CommonResponse(false, "Error in encrypting password");
			response.setResponse(res);
			return response;
		}
		UserCreds userCreds = new UserCreds();
		userCreds.setUserId(request.getUserDetails().getId());
		userCreds.setPassword(encryptedPassword);
		try{
			response = UserDAO.registerUserDAO(user, userCreds);
			response.setUsername(user.getName());
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.POST}, value = "/authenticate-user")
	public LoginUserResponse authenticateUser(@RequestBody AuthenticateUserRequest request){
		System.out.println("Calling authenticate user service");;
		LoginUserResponse sendResponse = new LoginUserResponse();
		CommonResponse res = null;
		try{
			LoginUserResponse response = UserDAO.authenticateUserDAO(request.getEmail());
			sendResponse.setUsername(response.getUsername());
			System.out.println(response);
			System.out.println("Password: "+(PasswordEncryption.encryptPassword(request.getPassword())));
			String password = (PasswordEncryption.encryptPassword(request.getPassword()));
			if(response.getResponse().getStatus()){
				if(password.equals(response.getPassword())){
					System.out.println("Inside equals");
					res = new CommonResponse(true, "User authenticated successfully");
					sendResponse.setResponse(res);
				}
				else{
					System.out.println("Inside not equal");
					res = new CommonResponse(false, "Email/Password is incorrect");
					sendResponse.setResponse(res);
				}
			}
			else{
				sendResponse = response;
			}
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return sendResponse;
	}
}
