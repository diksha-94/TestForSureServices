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
	public static String getAttemptedTests(String emailId){
		String attemptedTests = "select t.id as test_id, cat_id, subcat_id, title, no_of_ques, time_limit, correct_ans_marks, wrong_ans_marks, r.id as report_id, r.last_updated_on from testdetails t INNER JOIN testreports r where emailid='"+emailId+"'AND t.id=r.test_id"; 
		return attemptedTests;
	}
}
