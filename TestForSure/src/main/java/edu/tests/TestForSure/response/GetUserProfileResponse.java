package edu.tests.TestForSure.response;

import edu.tests.TestForSure.entity.UserDetails;

public class GetUserProfileResponse {
	private UserDetails userDetails;
	private CommonResponse response;
	public GetUserProfileResponse(UserDetails userDetails, CommonResponse response) {
		super();
		this.userDetails = userDetails;
		this.response = response;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public CommonResponse getResponse() {
		return response;
	}
	public void setResponse(CommonResponse response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "GetUserProfileResponse [userDetails=" + userDetails + ", response=" + response + "]";
	}
	public GetUserProfileResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
}
