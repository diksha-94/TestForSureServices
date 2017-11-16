package edu.tests.TestForSure.response;

import java.util.ArrayList;

import edu.tests.TestForSure.entity.TopPerformers;
import edu.tests.TestForSure.entity.ViewReportDetails;
import edu.tests.TestForSure.entity.ViewReportQuestions;

public class ViewReportResponse {
	private ArrayList<ViewReportQuestions> questions;
	private ViewReportDetails details;
	private ArrayList<TopPerformers> topPerformers;
	private Boolean status;
	private String message;
	public ArrayList<ViewReportQuestions> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<ViewReportQuestions> questions) {
		this.questions = questions;
	}
	public ViewReportDetails getDetails() {
		return details;
	}
	public void setDetails(ViewReportDetails details) {
		this.details = details;
	}
	public ArrayList<TopPerformers> getTopPerformers() {
		return topPerformers;
	}
	public void setTopPerformers(ArrayList<TopPerformers> topPerformers) {
		this.topPerformers = topPerformers;
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
		return "ViewReportResponse [questions=" + questions + ", details=" + details + ", topPerformers="
				+ topPerformers + ", status=" + status + ", message=" + message + "]";
	}
	public ViewReportResponse(ArrayList<ViewReportQuestions> questions, ViewReportDetails details,
			ArrayList<TopPerformers> topPerformers, Boolean status, String message) {
		super();
		this.questions = questions;
		this.details = details;
		this.topPerformers = topPerformers;
		this.status = status;
		this.message = message;
	}
	public ViewReportResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
}
