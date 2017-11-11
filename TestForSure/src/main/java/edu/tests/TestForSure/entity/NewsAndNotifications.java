package edu.tests.TestForSure.entity;

public class NewsAndNotifications {
	private int id;
	private String headline;
	private String detail;
	private Boolean active;
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
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "NewsAndNotifications [id=" + id + ", headline=" + headline + ", detail=" + detail + ", active=" + active + "]";
	}
	public NewsAndNotifications(int id, String headline, String detail, Boolean active) {
		super();
		this.id = id;
		this.headline = headline;
		this.detail = detail;
		this.active = active;
	}
	public NewsAndNotifications() {
		super();
	}
	
}
