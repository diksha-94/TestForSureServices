package edu.tests.TestForSure.entity;

public class ExamSubcategory {
	private int id;
	private int cat_id;
	private String subcategory;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public ExamSubcategory(int id, int cat_id, String subcategory) {
		super();
		this.id = id;
		this.cat_id = cat_id;
		this.subcategory = subcategory;
	}
	public ExamSubcategory(int cat_id, String subcategory) {
		super();
		this.cat_id = cat_id;
		this.subcategory = subcategory;
	}
	public ExamSubcategory() {
		super();
	}
	@Override
	public String toString() {
		return "ExamSubcategory [id=" + id + ", cat_id=" + cat_id + ", subcategory=" + subcategory + "]";
	}
	
	
	
}
