package edu.tests.TestForSure.response;

import java.util.*;

import edu.tests.TestForSure.entity.TestSolution;

public class GetTestSoltionResponse {
	private ArrayList<TestSolution> solution;
	private Boolean status;
	private String message;
	public ArrayList<TestSolution> getSolution() {
		return solution;
	}
	public void setSolution(ArrayList<TestSolution> solution) {
		this.solution = solution;
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
	public GetTestSoltionResponse(ArrayList<TestSolution> solution, Boolean status, String message) {
		super();
		this.solution = solution;
		this.status = status;
		this.message = message;
	}
	public GetTestSoltionResponse() {
		super();
	}
	@Override
	public String toString() {
		return "GetTestSoltionResponse [solution=" + solution + ", status=" + status + ", message=" + message + "]";
	}
}
