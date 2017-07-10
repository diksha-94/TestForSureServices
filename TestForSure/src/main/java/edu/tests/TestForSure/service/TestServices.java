package edu.tests.TestForSure.service;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.tests.TestForSure.datalayer.TestDAO;
import edu.tests.TestForSure.entity.TestDetailsRequest;
import edu.tests.TestForSure.entity.ExamCategory;
import edu.tests.TestForSure.entity.ExamSubcategory;
import edu.tests.TestForSure.entity.Question;
import edu.tests.TestForSure.entity.TestDetails;
import edu.tests.TestForSure.response.AddQuestionResponse;
import edu.tests.TestForSure.response.CommonResponse;
import edu.tests.TestForSure.response.CreateTestResponse;
import edu.tests.TestForSure.response.GetCategoryResponse;
import edu.tests.TestForSure.response.GetQuestionsResponse;
import edu.tests.TestForSure.response.GetSubcategoryResponse;
import edu.tests.TestForSure.response.GetTestDetailsResponse;

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
			int question_id = TestDAO.insertUpdateQuestionDAO(question);
			System.out.println("question_id: "+question_id);
			if(question_id == 0){
				System.out.println("Failure in adding/updating ");
				response = new AddQuestionResponse(false, "Error in adding/updating question", 0);
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
			response = TestDAO.addnewCategory(examCategory.getCategory());
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
	
}
