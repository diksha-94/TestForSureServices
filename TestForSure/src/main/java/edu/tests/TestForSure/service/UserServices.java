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

@CrossOrigin
@RestController
@RequestMapping("/test-for-sure/user")
public class UserServices {

	@RequestMapping(method = {RequestMethod.POST}, value = "/register-user")
	public CommonResponse registerUser(@RequestBody RegisterUserRequest request){
		System.out.println("Calling register user service");;
		CommonResponse response = null;
		User user = new User();
		user.setId(request.getUserDetails().getId());
		user.setName(request.getUserDetails().getName());
		user.setEmail(request.getUserDetails().getEmail());
		user.setMobileno(request.getUserDetails().getMobileno());
		
		String encryptedPassword = PasswordEncryption.encryptPassword(request.getPassword());
		if(encryptedPassword.equals("exception")){
			response.setStatus(false);
			response.setMessage("Error in encrypting password");
			return response;
		}
		UserCreds userCreds = new UserCreds();
		userCreds.setUserId(request.getUserDetails().getId());
		userCreds.setPassword(encryptedPassword);
		try{
			response = UserDAO.registerUserDAO(user, userCreds);
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.POST}, value = "/authenticate-user")
	public CommonResponse authenticateUser(@RequestBody AuthenticateUserRequest request){
		System.out.println("Calling authenticate user service");;
		CommonResponse sendResponse = new CommonResponse();
		try{
			CommonResponse response = UserDAO.authenticateUserDAO(request.getEmail());
			System.out.println(response);
			System.out.println("Password: "+(PasswordEncryption.encryptPassword(request.getPassword())));
			String password = (PasswordEncryption.encryptPassword(request.getPassword()));
			if(response.getStatus()){
				if(password.equals(response.getMessage())){
					System.out.println("Inside equal");
					sendResponse.setStatus(true);
					sendResponse.setMessage("User authenticated successfully");
				}
				else{
					System.out.println("Inside not equal");
					sendResponse.setStatus(false);
					sendResponse.setMessage("Email/Password is incorrect");
				}
			}
			else{
				sendResponse.setStatus(false);
				sendResponse.setMessage(response.getMessage());
			}
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return sendResponse;
	}
}
