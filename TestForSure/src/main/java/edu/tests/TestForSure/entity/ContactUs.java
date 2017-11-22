package edu.tests.TestForSure.entity;

public class ContactUs {
	private int id;
	private String name;
	private String email;
	private String query;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	@Override
	public String toString() {
		return "ContactUs [id=" + id + ", name=" + name + ", email=" + email + ", query=" + query + "]";
	}
	public ContactUs(int id, String name, String email, String query) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.query = query;
	}
	public ContactUs() {
		super();
		// TODO Auto-generated constructor stub
	}
}
