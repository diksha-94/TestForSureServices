package edu.tests.TestForSure.sql;

public class CreateTestReportQueries {
	public static String getTestSolution(int id) {
		String getSolution = "SELECT * FROM testquestionreport WHERE test_report_id = '" + id + "'";
		return getSolution;
	}
}
