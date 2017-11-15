package edu.tests.TestForSure.entity;

import java.util.Date;

public class NewsAndNotifications {
	private int id;
	private String headline;
	private String detail;
	private Boolean active;
	private Date last_updated_on;
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
	public Date getLast_updated_on() {
		return last_updated_on;
	}
	public void setLast_updated_on(Date last_updated_on) {
		this.last_updated_on = last_updated_on;
	}
	@Override
	public String toString() {
		return "NewsAndNotifications [id=" + id + ", headline=" + headline + ", detail=" + detail + ", active=" + active  + ", last_updated_on=" + last_updated_on + "]";
	}
	public NewsAndNotifications(int id, String headline, String detail, Boolean active, Date last_updated_on) {
		super();
		this.id = id;
		this.headline = headline;
		this.detail = detail;
		this.active = active;
		this.last_updated_on = last_updated_on;
	}
	public NewsAndNotifications() {
		super();
	}
	
}
