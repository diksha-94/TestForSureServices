package edu.tests.TestForSure.service;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.tests.TestForSure.datalayer.TestDAO;
import edu.tests.TestForSure.datalayer.TestReportDAO;
import edu.tests.TestForSure.entity.TestDetailsRequest;
import edu.tests.TestForSure.entity.TopPerformers;
import edu.tests.TestForSure.entity.ExamCategory;
import edu.tests.TestForSure.entity.ExamSubcategory;
import edu.tests.TestForSure.entity.GetTestResultRequest;
import edu.tests.TestForSure.entity.Question;
import edu.tests.TestForSure.entity.TestDetails;
import edu.tests.TestForSure.response.AddQuestionResponse;
import edu.tests.TestForSure.response.CommonResponse;
import edu.tests.TestForSure.response.CreateTestResponse;
import edu.tests.TestForSure.response.GetCategoryResponse;
import edu.tests.TestForSure.response.GetQuestionsResponse;
import edu.tests.TestForSure.response.GetSingleTestDetailsResponse;
import edu.tests.TestForSure.response.GetSubcategoryResponse;
import edu.tests.TestForSure.response.GetTestDetailsResponse;
import edu.tests.TestForSure.response.GetTestReportResponse;
import edu.tests.TestForSure.response.GetTestSoltionResponse;
import edu.tests.TestForSure.response.QuestionDetail;
import edu.tests.TestForSure.response.TestResultResponse;

@CrossOrigin
@RestController
@RequestMapping("/test-for-sure/test")
public class TestServices {

	@RequestMapping(method = {RequestMethod.GET}, value = "/get-category")
	public GetCategoryResponse getAllCategories(){
		System.out.println("Calling get category service");;
		GetCategoryResponse response = null;
		try{
			response = TestDAO.getAllCategoriesDAO();
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.GET}, value = "/get-subcategory")
	public GetSubcategoryResponse getSubcategories( @RequestParam(value = "categoryId", required = true) int categoryId){
		System.out.println("Calling get subcategory service");;
		GetSubcategoryResponse response = null;
		try{
			response = TestDAO.getSubcategoriesDAO(categoryId);
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.POST}, value = "/add-update-test")
	public CreateTestResponse addUpdateTestDetails(@RequestBody TestDetails testDetails){
		CreateTestResponse response = null;
		System.out.println("Calling create test service: "+testDetails);
		try{
			int test_id = TestDAO.insertUpdateTestDetailsDAO(testDetails);
			System.out.println("test_id: "+test_id);
			if(test_id == 0){
				System.out.println("Failure in adding testDetails");
				response = new CreateTestResponse(false, "Error in adding/updating test details", 0);
			}
			else{
				response = new CreateTestResponse(true, "", test_id);
			}
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.POST}, value = "/add-question")
	public AddQuestionResponse addUpdateQuestion(@RequestBody Question question){
		AddQuestionResponse response = null;
		System.out.println("Calling add question service: "+question);
		try{
			String question_id = TestDAO.insertUpdateQuestionDAO(question);
			System.out.println("question_id: "+question_id);
			if(question_id.equals("0")){
				System.out.println("Failure in adding/updating ");
				response = new AddQuestionResponse(false, "Error in adding/updating question", "0");
			}
			else{
				response = new AddQuestionResponse(true, "", question_id);
			}
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.GET}, value = "/get-tests")
	public GetTestDetailsResponse getTestDetails( @RequestParam(value = "categoryId") int categoryId,
												  @RequestParam(value = "subCatId") int subCatId){
		System.out.println("Calling get tests service");
		System.out.println("CategoryId: "+categoryId+"---subCatId: "+subCatId);
		
		GetTestDetailsResponse response = null;
		
		try{
			response = TestDAO.getTestDetails(categoryId, subCatId);
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.GET}, value = "/get-tests-bystatus")
	public GetTestDetailsResponse getTestDetailsByStatus( @RequestParam(value = "categoryId") int categoryId,
												  @RequestParam(value = "subCatId") int subCatId){
		System.out.println("Calling get tests service");
		System.out.println("CategoryId: "+categoryId+"---subCatId: "+subCatId);
		
		GetTestDetailsResponse response = null;
		
		try{
			response = TestDAO.getTestDetailsByStatus(categoryId, subCatId);
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	//get test details by test id
	@RequestMapping(method = {RequestMethod.GET}, value = "/get-testsbyId")
	public GetSingleTestDetailsResponse getTestDetailsByTestId( @RequestParam(value = "testId") int testId){
		System.out.println("Calling get tests service");
		System.out.println("TestId: "+testId);
		
		GetSingleTestDetailsResponse response = null;
		
		try{
			response = TestDAO.getTestDetails(testId);
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.GET}, value = "/get-questions")
	public GetQuestionsResponse getTestDetails( @RequestParam(value = "test_id") int test_id){
		System.out.println("Calling get questions service");
		System.out.println("TestId: "+test_id);
		
		GetQuestionsResponse response = null;
		
		try{
			response = TestDAO.getQuestions(test_id);
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.POST}, value = "/add-category")
	public CommonResponse addNewTestCategory(@RequestBody ExamCategory examCategory){
		System.out.println("Calling get add category service");
		System.out.println("Exam category: "+examCategory);
		
		CommonResponse response = null;
		
		try{
			response = TestDAO.addnewCategory(examCategory.getCategory(), examCategory.getImagePath());
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.POST}, value = "/add-subcategory")
	public CommonResponse addNewTestSubcategory(@RequestBody ExamSubcategory examSubcategory){
		System.out.println("Calling get add category service");
		System.out.println("Exam subcategory: "+examSubcategory);
		
		CommonResponse response = null;
		
		try{
			response = TestDAO.addnewSubcategory(examSubcategory.getCat_id(), examSubcategory.getSubcategory());
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.PUT}, value = "/delete-question")
	public CommonResponse deleteQuestion(@RequestBody Question question){
		System.out.println("Calling delete question service");
		System.out.println("Question: "+question);
		
		CommonResponse response = null;
		
		try{
			response = TestDAO.deleteQuestion(question.getId(), question.getTest_id());
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.PUT}, value = "/publish-test")
	public CommonResponse publishTest(@RequestParam(value="test_id") int test_id){
		System.out.println("Calling publish test service");
		System.out.println("Test_id: "+test_id);
		
		CommonResponse response = null;
		
		try{
			response = TestDAO.publishTest(test_id);
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.PUT}, value = "/unpublish-test")
	public CommonResponse unpublishTest(@RequestParam(value="test_id") int test_id){
		System.out.println("Calling unpublish test service");
		System.out.println("Test_id: "+test_id);
		
		CommonResponse response = null;
		
		try{
			response = TestDAO.unpublishTest(test_id);
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.POST}, value = "/get-test-result")
	public TestResultResponse getTestResult(@RequestBody GetTestResultRequest getTestResult){
		System.out.println("Calling get test result");
		System.out.println("Request Body: "+getTestResult);
		CommonResponse commonResponse = new CommonResponse();
		GetQuestionsResponse questionAnswers = null;
		TestDetails testDetails = null;
		TestResultResponse resultResponse = new TestResultResponse();
		int test_id = getTestResult.getTestDetails().getTest_id();
		int lastReportId = 0;
		try{
			questionAnswers = TestDAO.getAnswers(test_id);
			System.out.println("Question Answers: "+questionAnswers);
			
			testDetails = TestDAO.getTestDetailsByTestId(test_id);
			System.out.println("Test Details: "+testDetails);
			
			
			//Generate Test Report
			resultResponse = GeneralFunctionality.generateTestReport(getTestResult.getResult(), questionAnswers);
			resultResponse.setTime_taken(testDetails.getTime_limit() - getTestResult.getTime_rem());
			System.out.println("Time taken: "+resultResponse.getTime_taken());
			resultResponse.setTest_id(testDetails.getId());
			resultResponse.setTotal_ques(testDetails.getNo_of_ques());
			resultResponse.setTotal_marks(testDetails.getNo_of_ques()*testDetails.getCorrect_ques_marks());
			double marksScored = (resultResponse.getCorrect_ques()*testDetails.getCorrect_ques_marks())-(resultResponse.getIncorrect_ques()*(testDetails.getNegative_marks()).doubleValue());
			resultResponse.setMarks_scored(marksScored);
			//Finding the candidate's rank
			int rank = GeneralFunctionality.findCandidateRank(marksScored, test_id);
			if(rank == 0){
				System.out.println("Error in finding response");
			}
			else{
				//Proceed further
				resultResponse.setRank(rank);
				
				//Manage the rank of all the candidates
				
				CommonResponse response = GeneralFunctionality.manageAllCandidateRank(rank, test_id);
				if(response.getStatus()){
					//If rank successfully updated for all the candidates, add the current candidate's report to the database
					CommonResponse response1 = GeneralFunctionality.saveTestReport(resultResponse, getTestResult.getUserDetails(), testDetails.getNo_of_ques());
					if(response1.getStatus()){
						commonResponse.setStatus(true);
						commonResponse.setMessage("Successfully get the test result and the report has been saved");
						lastReportId = Integer.parseInt(((response1.getMessage()).split("-"))[1]);
					}
					else{
						commonResponse.setStatus(false);
						commonResponse.setMessage("Successfully get the test result but problem in saving the report ");
					}
				}
			}
			int total_candidate = TestDAO.updateTotalCandidateTestDetails(test_id);
			if(total_candidate!=-1){
				System.out.println("Number of candidates updated successfully and the the number of candidates who have attempted the test is: "+total_candidate);
			}
			else{
				System.out.println("Error in updated the total number of candidates");
			}
			resultResponse.setTotal_candidate(total_candidate);
			resultResponse.setUsername(getTestResult.getUserDetails().getUsername());
			
			ArrayList<TopPerformers> list = TestDAO.getTopPerformers(test_id);
			resultResponse.setTopPerformers(list);
			resultResponse.setTopperScore((list.get(0)).getMarks_scored());
			resultResponse.setTopperTime((list.get(0)).getTime_taken());
			TestDAO.getAverage(test_id, resultResponse);
			resultResponse.setCommon_response(commonResponse);
			
			//Send the resultResponse to save all the questions into database
			CommonResponse testResponse = TestDAO.insertTestQuestionsReport(resultResponse, lastReportId);
			System.out.println("Response from adding test questions: "+testResponse);
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
			commonResponse.setStatus(false);
			commonResponse.setMessage(e.getMessage());
			resultResponse.setCommon_response(commonResponse);
		}
		
		return resultResponse;
	}
	
	@RequestMapping(method = {RequestMethod.GET}, value = "/test-already-attempted")
	public CommonResponse alreadyAttempted(@RequestParam(value="test_id") int test_id,
										   @RequestParam(value="email_id") String email_id){
		System.out.println("Calling test already attempted service");
		System.out.println("Test_id: "+test_id);
		System.out.println("Email_id: "+email_id);
		
		CommonResponse response = new CommonResponse();
		
		try{
			Boolean res = TestDAO.checkAlreadyAttempted(test_id, email_id);
			response.setStatus(res);
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
			response.setStatus(false);
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.GET}, value = "/get-all-reports")
	public GetTestReportResponse getAllReports(@RequestParam(value="test_id") int test_id,
										   @RequestParam(value="email_id") String email_id){
		System.out.println("Calling get all reportsservice");
		System.out.println("Test_id: "+test_id);
		System.out.println("Email_id: "+email_id);
		
		GetTestReportResponse response = new GetTestReportResponse();
		
		try{
			response = TestReportDAO.getTestReport(test_id, email_id);
			
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
			
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.GET}, value = "/get-test-solution")
	public GetTestSoltionResponse getTestSolution(@RequestParam(value="test_report_id") int test_report_id){
		System.out.println("Calling get test solution");
		System.out.println("test_report_id: "+test_report_id);
		
		GetTestSoltionResponse response = new GetTestSoltionResponse();
		
		try{
			response = TestReportDAO.getTestSolution(test_report_id);
			
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
			
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.GET}, value = "/send-email")
	public void sendMail(){
		System.out.println("Calling get subcategory service");
		TestEmail.sendSimpleMessage("bajaj.diksha45@gmail.com", "Test Subject", "test message");
		System.out.println("E-mail sent!!");
		
	}
	
}
