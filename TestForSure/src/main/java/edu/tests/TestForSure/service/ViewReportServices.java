package edu.tests.TestForSure.service;

import java.util.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.tests.TestForSure.datalayer.TestDAO;
import edu.tests.TestForSure.datalayer.ViewReportDAO;
import edu.tests.TestForSure.entity.TopPerformers;
import edu.tests.TestForSure.entity.ViewReportDetails;
import edu.tests.TestForSure.entity.ViewReportQuestions;
import edu.tests.TestForSure.response.ViewReportResponse;

@CrossOrigin
@RestController
@RequestMapping("/test-for-sure/view-report")
public class ViewReportServices {

	@RequestMapping(method = {RequestMethod.GET}, value = "/get-report")
	public ViewReportResponse getSubcategories( @RequestParam(value = "report_id", required = true) int report_id,
												@RequestParam(value = "test_id", required = true) int test_id){
		System.out.println("Calling get report service");
		ViewReportResponse response = new ViewReportResponse();
		try{
			ArrayList<ViewReportQuestions> questions = ViewReportDAO.getQuestionsDAO(report_id, test_id);
			if(questions.size() > 0){
				response.setQuestions(questions);
				
				ViewReportDetails details = ViewReportDAO.getGeneralDetailsDAO(report_id);
				
				details  = ViewReportDAO.getTestDetailsDAO(test_id, details);
				
				ArrayList<TopPerformers> topPerformers = TestDAO.getTopPerformers(test_id);
				response.setTopPerformers(topPerformers);
				
				details.setToppersScore(topPerformers.get(0).getMarks_scored());
				details.setToppersTime(topPerformers.get(0).getTime_taken());
				
				details = GeneralFunctionality.findAverage(topPerformers, details);
				response.setDetails(details);
				response.setStatus(true);
				response.setMessage("Successfully got the test result data");
			}
			else{
				response.setStatus(false);
				response.setMessage("Error in getting question solutions for the test report");
			}
			
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
			response.setStatus(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
}
