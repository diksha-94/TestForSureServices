package edu.tests.TestForSure.entity;

public class NewsAndNotifications {
	private int id;
	private String headline;
	private String detail;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "NewsAndNotifications [id=" + id + ", headline=" + headline + ", detail=" + detail + "]";
	}
	public NewsAndNotifications(int id, String headline, String detail) {
		super();
		this.id = id;
		this.headline = headline;
		this.detail = detail;
	}
	public NewsAndNotifications() {
		super();
	}
	
}
