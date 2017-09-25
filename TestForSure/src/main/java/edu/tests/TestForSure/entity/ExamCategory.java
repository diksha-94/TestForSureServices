package edu.tests.TestForSure.entity;

public class ExamCategory {
	private int id;
	private String category;
	private String imagePath;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	@Override
	public String toString() {
		return "ExamCategory [id=" + id + ", category=" + category + ",imagePath=" + imagePath + "]";
	}
	public ExamCategory(int id, String category, String imagePath) {
		super();
		this.id = id;
		this.category = category;
		this.imagePath = imagePath;
	}
	public ExamCategory(String category) {
		super();
		this.category = category;
	}
	public ExamCategory(int id, String category) {
		super();
		this.id = id;
		this.category = category;
	}
	public ExamCategory() {
		super();
	}
}
