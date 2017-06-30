package edu.tests.TestForSure.entity;

public class ExamSubcategory {
	private int id;
	private String subcategory;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	@Override
	public String toString() {
		return "ExamSubcategory [id=" + id + ", subcategory=" + subcategory + "]";
	}
	public ExamSubcategory(int id, String subcategory) {
		super();
		this.id = id;
		this.subcategory = subcategory;
	}
	public ExamSubcategory() {
		super();
	}
	
	
	
}
