package edu.tests.TestForSure.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import edu.tests.TestForSure.datalayer.TestDAO;
import edu.tests.TestForSure.entity.Question;
import edu.tests.TestForSure.entity.Result;
import edu.tests.TestForSure.entity.TopPerformers;
import edu.tests.TestForSure.entity.UserDetails;
import edu.tests.TestForSure.entity.ViewReportDetails;
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
					question.setTime_spent(result.getTime_spent());
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
	
	public static CommonResponse saveTestReport(TestResultResponse resultResponse, UserDetails userDetails, int no_of_ques){
		System.out.println("Time taken from GEneral functionality: "+resultResponse.getTime_taken());
		CommonResponse response = TestDAO.insertTestReport(resultResponse, userDetails, no_of_ques);
		return response;
	}
	public static int findCandidateRank(Double marks_scored, int test_id){
		int rank = TestDAO.findUserRank(marks_scored, test_id);
		return rank;
	}
	public static CommonResponse manageAllCandidateRank(int rank, int test_id){
		CommonResponse response = TestDAO.manageAllUsersRank(rank, test_id);
		return response;
	}
	
	
	//Send e-mail
	public static void sendEmail(Session session, String toEmail, String subject, String body){
		try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress("bajaj.diksha45@gmail.com", "NoReply-JD"));

	     // msg.setReplyTo(InternetAddress.parse("bajaj.diksha45@gmail.com", false));

	      msg.setSubject(subject, "UTF-8");

	      msg.setText(body, "UTF-8");
	      msg.setContent(body, "text/html; charset=utf-8");
	      msg.setSentDate(new Date());

	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      System.out.println("Message is ready");
    	  Transport.send(msg);  

	      System.out.println("Email Sent Successfully!!");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}
	
	//to find the average score and marks scored for View Report
	public static ViewReportDetails findAverage(ArrayList<TopPerformers> topPerformers, ViewReportDetails details){
		int size = topPerformers.size();
		BigDecimal scoreSum = new BigDecimal(0);
		BigDecimal timeSum = new BigDecimal(0);
		MathContext mc = new MathContext(2, RoundingMode.HALF_UP);
		for(TopPerformers topPerformer : topPerformers){
			scoreSum = scoreSum.add(topPerformer.getMarks_scored());
			timeSum = timeSum.add(topPerformer.getTime_taken());
		}
		details.setAvgScore(scoreSum.divide(new BigDecimal(size), mc));
		details.setAvgTime(timeSum.divide(new BigDecimal(size), mc));
		return details;
	}
	
}
