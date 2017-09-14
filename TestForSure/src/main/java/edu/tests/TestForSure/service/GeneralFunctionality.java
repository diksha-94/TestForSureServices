package edu.tests.TestForSure.service;

import java.util.*;

import edu.tests.TestForSure.datalayer.TestDAO;
import edu.tests.TestForSure.entity.Question;
import edu.tests.TestForSure.entity.Result;
import edu.tests.TestForSure.entity.UserDetails;
import edu.tests.TestForSure.response.CommonResponse;
import edu.tests.TestForSure.response.GetQuestionsResponse;
import edu.tests.TestForSure.response.QuestionDetail;
import edu.tests.TestForSure.response.TestResultResponse;

public class GeneralFunctionality {
	
	public static TestResultResponse generateTestReport(ArrayList<Result> candidateResponse, GetQuestionsResponse actualResponse){
		System.out.println("Candidate Response: "+candidateResponse);
		System.out.println("Actual Response: "+actualResponse);
		int correctCount = 0;
		int questionAttempted = 0;
		int incorrectQuestions = 0;
		TestResultResponse response = new TestResultResponse();
		for(Result result : candidateResponse){
			for(Question actual : actualResponse.getQuestion()){
				if((result.getQuestion_id()).equals(actual.getId())){
					if(result.getMarked_option()!=null){
						questionAttempted++;
						if((result.getMarked_option()).equalsIgnoreCase(actual.getCorrect_option())){
							correctCount++;
						}
					}
					break;
				}
			}
		}
		incorrectQuestions = questionAttempted - correctCount;
		System.out.println("Correct Questions: "+correctCount);
		System.out.println("Questions Attempted: "+questionAttempted);
		System.out.println("Incorrect Questions: "+incorrectQuestions);
		response.setCorrect_ques(correctCount);
		response.setQues_attempted(questionAttempted);
		response.setIncorrect_ques(incorrectQuestions);
		
		//Calling generate QuestionsReport
		ArrayList<QuestionDetail> list = generateQuestionsReport(candidateResponse, actualResponse);
		response.setQuestion_details(list);
		return response;
	}
	
	public static ArrayList<QuestionDetail> generateQuestionsReport(ArrayList<Result> candidateResponse, GetQuestionsResponse actualResponse){
		ArrayList<QuestionDetail> list = new ArrayList<QuestionDetail>();
		System.out.println("candidate response: "+candidateResponse);
		System.out.println("actual response: "+actualResponse);
		for(Question actual : actualResponse.getQuestion()){
			QuestionDetail question = new QuestionDetail();
			question.setQues_id(actual.getId());
			question.setCorrect_option(actual.getCorrect_option());
			question.setExplanation(actual.getExplanation());
			for(Result result : candidateResponse){
				if(actual.getId().equals(result.getQuestion_id())){
					if(result.getMarked_option()!=null){
						question.setMarked_option(result.getMarked_option());
						if((result.getMarked_option()).equalsIgnoreCase(actual.getCorrect_option())){
							question.setCorrect(true);
						}
						else{
							question.setCorrect(false);
						}
					}
					else{
						question.setMarked_option(null);
						question.setCorrect(false);
					}
					break;
				}
			}
			list.add(question);
		}
		return list;
	}
	
	public static CommonResponse saveTestReport(TestResultResponse resultResponse, UserDetails userDetails){
		System.out.println("Time taken from GEneral functionality: "+resultResponse.getTime_taken());
		CommonResponse response = TestDAO.insertTestReport(resultResponse, userDetails);
		return response;
	}
	public static int findCandidateRank(int marks_scored, int test_id){
		int rank = TestDAO.findUserRank(marks_scored, test_id);
		return rank;
	}
	public static CommonResponse manageAllCandidateRank(int rank, int test_id){
		CommonResponse response = TestDAO.manageAllUsersRank(rank, test_id);
		return response;
	}
	
	
}
