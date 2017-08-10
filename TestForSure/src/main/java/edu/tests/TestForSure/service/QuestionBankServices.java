package edu.tests.TestForSure.service;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.tests.TestForSure.datalayer.QuestionBankDAO;
import edu.tests.TestForSure.datalayer.TestDAO;
import edu.tests.TestForSure.entity.AddQuestionsFromBankRequest;
import edu.tests.TestForSure.entity.ExamCategory;
import edu.tests.TestForSure.entity.ExamSubcategory;
import edu.tests.TestForSure.entity.Question;
import edu.tests.TestForSure.entity.QuestionBank;
import edu.tests.TestForSure.response.AddQuestionResponse;
import edu.tests.TestForSure.response.CommonResponse;
import edu.tests.TestForSure.response.GetCategoryResponse;
import edu.tests.TestForSure.response.GetQuestionsBankResponse;
import edu.tests.TestForSure.response.GetSubcategoryResponse;

@CrossOrigin
@RestController
@RequestMapping("/test-for-sure/question-bank")
public class QuestionBankServices {
	
	@RequestMapping(method = {RequestMethod.GET}, value = "/get-subject-category")
	public GetCategoryResponse getAllSubjectCategories(){
		System.out.println("Calling get category service");;
		GetCategoryResponse response = null;
		try{
			response = QuestionBankDAO.getAllSubjectCategoriesDAO();
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.GET}, value = "/get-subject-subcategory")
	public GetSubcategoryResponse getSubjectSubcategories( @RequestParam(value = "categoryId", required = true) int categoryId){
		System.out.println("Calling get subcategory service");;
		GetSubcategoryResponse response = null;
		try{
			response = QuestionBankDAO.getSubjectSubcategoriesDAO(categoryId);
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.POST}, value = "/add-subject-category")
	public CommonResponse addNewSubjectCategory(@RequestBody ExamCategory examCategory){
		System.out.println("Calling add category service");
		System.out.println("Exam category: "+examCategory);
		
		CommonResponse response = null;
		
		try{
			response = QuestionBankDAO.addnewSubjectCategory(examCategory.getCategory());
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.POST}, value = "/add-subject-subcategory")
	public CommonResponse addNewSubjectSubcategory(@RequestBody ExamSubcategory examSubcategory){
		System.out.println("Calling add subcategory service");
		System.out.println("Exam subcategory: "+examSubcategory);
		
		CommonResponse response = null;
		
		try{
			response = QuestionBankDAO.addnewSubjectSubcategory(examSubcategory.getCat_id(), examSubcategory.getSubcategory());
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.GET}, value = "/get-questions")
	public GetQuestionsBankResponse getQuestionsBank( @RequestParam(value = "categoryId", required = true) int categoryId,
												@RequestParam(value = "subcategoryId", required = false) int subcategoryId){
		System.out.println("Calling get questions from question bank service");;
		GetQuestionsBankResponse response = null;
		try{
			response = QuestionBankDAO.getQuestions(categoryId, subcategoryId);
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.POST}, value = "/add-question")
	public AddQuestionResponse addQuestionsBank( @RequestBody QuestionBank question){
		System.out.println("Calling add question to question bank service");
		AddQuestionResponse response = null;
		try{
			//CommonResponse addCategoryResponse = QuestionBankDAO.addnewSubjectCategory(category)
			response = QuestionBankDAO.addQuestionToQuestionBank(question);
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.POST}, value = "/update-question")
	public AddQuestionResponse updateQuestionsBank( @RequestBody QuestionBank question){
		System.out.println("Calling update question to question bank service");
		AddQuestionResponse response = null;
		try{
			//CommonResponse addCategoryResponse = QuestionBankDAO.addnewSubjectCategory(category)
			response = QuestionBankDAO.updateQuestionToQuestionBank(question);
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
			response = QuestionBankDAO.deleteQuestionFromQuestionBank(question.getId());
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.POST}, value = "/add-questions-to-test")
	public CommonResponse addQuestionToQuestionBank(@RequestBody AddQuestionsFromBankRequest request){
		System.out.println("Calling add questions to test from question bank service");
		System.out.println("Request: "+request);
		
		CommonResponse response = null;
		
		try{
			response = QuestionBankDAO.addQuestionsFromQuestionBank(request);
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
}
