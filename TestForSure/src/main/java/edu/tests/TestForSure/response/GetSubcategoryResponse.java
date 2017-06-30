package edu.tests.TestForSure.response;

import java.util.*;

import edu.tests.TestForSure.entity.ExamSubcategory;

public class GetSubcategoryResponse {
	private ArrayList<ExamSubcategory> subcategoryList;
	private Boolean success;
	private String message;
	public ArrayList<ExamSubcategory> getSubcategoryList() {
		return subcategoryList;
	}
	public void setSubcategoryList(ArrayList<ExamSubcategory> subcategoryList) {
		this.subcategoryList = subcategoryList;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "GetSubcategoryResponse [subcategoryList=" + subcategoryList + ", success=" + success + ", message="
				+ message + "]";
	}
	public GetSubcategoryResponse(ArrayList<ExamSubcategory> subcategoryList, Boolean success, String message) {
		super();
		this.subcategoryList = subcategoryList;
		this.success = success;
		this.message = message;
	}
	public GetSubcategoryResponse() {
		super();
	}
	
}
