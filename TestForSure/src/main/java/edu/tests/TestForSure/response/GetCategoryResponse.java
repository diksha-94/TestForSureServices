package edu.tests.TestForSure.response;

import java.util.ArrayList;
import edu.tests.TestForSure.entity.ExamCategory;

public class GetCategoryResponse {
	ArrayList<ExamCategory> categoryList;
	Boolean status;
	String message;
	public ArrayList<ExamCategory> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(ArrayList<ExamCategory> categoryList) {
		this.categoryList = categoryList;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "GetCategoryResponse [categoryList=" + categoryList + ", status=" + status + ", message="
				+ message + "]";
	}
	public GetCategoryResponse(ArrayList<ExamCategory> categoryList, Boolean status, String message) {
		super();
		this.categoryList = categoryList;
		this.status = status;
		this.message = message;
	}
	public GetCategoryResponse() {
		super();
	}
}

