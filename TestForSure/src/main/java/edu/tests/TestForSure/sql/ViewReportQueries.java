package edu.tests.TestForSure.sql;

public class ViewReportQueries {

	public static String getQuestions(int report_id, int test_id) {
		String getQues = "SELECT * from testquestionreport t INNER JOIN questions q WHERE t.test_report_id='"+report_id+"' and q.test_id='"+ test_id+"' and t.ques_id=q.id";
		return getQues;
	}
	public static String getGeneralDetails(int report_id) {
		String getGenDetail = "SELECT * from testreports where id='"+report_id+"'";
		return getGenDetail;
	}
	public static String getTestDetail(int test_id) {
		String getTestDetail = "SELECT title, candidate_count, no_of_ques, correct_ans_marks from testdetails where id='"+test_id+"'";
		return getTestDetail;
	}
	
}
