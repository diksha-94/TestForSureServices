package edu.tests.TestForSure.sql;

import edu.tests.TestForSure.entity.ContactUs;

public class CreateContactUsQueries {
	public static String insertQuery(ContactUs obj){
		String insertQuery = "insert into contactus(name, email, query) values ('" + obj.getName() + "','" + obj.getEmail() + "','" + obj.getQuery() +"')";
		return insertQuery;
	}
}
