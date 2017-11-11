package edu.tests.TestForSure.service;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.tests.TestForSure.datalayer.NewsDAO;
import edu.tests.TestForSure.entity.NewsAndNotifications;
import edu.tests.TestForSure.response.CommonResponse;
import edu.tests.TestForSure.response.GetNewsResponse;

@CrossOrigin
@RestController
@RequestMapping("/test-for-sure/news-notifications")
public class NewsServices {
	
	@RequestMapping(method = {RequestMethod.GET}, value = "/get-all-news")
	public GetNewsResponse getAllNews(){
		System.out.println("Calling get all news service");
		GetNewsResponse response = null;
		try{
			response = NewsDAO.getAllNews();
		}
		catch(Exception e){
			System.out.println("Exception in getAllNews service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.GET}, value = "/get-news-bySatatus")
	public GetNewsResponse getNewsByStatus(@RequestParam(value = "newsStatus", required = true) Boolean newsStatus){
		System.out.println("Calling get news by status service");
		GetNewsResponse response = null;
		try{
			response = NewsDAO.getNewsByStatus(newsStatus);
		}
		catch(Exception e){
			System.out.println("Exception in getNewsByStatus service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.PUT}, value = "/publish-news")
	public CommonResponse publishNews(@RequestParam(value = "newsId", required = true) int newsId){
		System.out.println("Calling publish news service");
		CommonResponse response = null;
		try{
			response = NewsDAO.publishNews(newsId);
		}
		catch(Exception e){
			System.out.println("Exception in getNewsByStatus service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.PUT}, value = "/unpublish-news")
	public CommonResponse unpublishNews(@RequestParam(value = "newsId", required = true) int newsId){
		System.out.println("Calling unpublish news service");
		CommonResponse response = null;
		try{
			response = NewsDAO.unpublishNews(newsId);
		}
		catch(Exception e){
			System.out.println("Exception in getNewsByStatus service: "+e.getMessage());
		}
		return response;
	}
	@RequestMapping(method = {RequestMethod.GET}, value = "/get-news")
	public GetNewsResponse getNews(@RequestParam(value = "newsId", required = true) int newsId){
		System.out.println("Calling get news by id service");;
		GetNewsResponse response = null;
		try{
			response = NewsDAO.getNews(newsId);
		}
		catch(Exception e){
			System.out.println("Exception in getNewsById service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.PUT}, value = "/delete-news")
	public CommonResponse deleteNews(@RequestParam(value = "newsId", required = true) int newsId){
		System.out.println("Calling delete news by id service");;
		CommonResponse response = null;
		try{
			response = NewsDAO.deleteNews(newsId);
		}
		catch(Exception e){
			System.out.println("Exception in deleteNewsById service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.POST}, value = "/insert-news")
	public CommonResponse deleteNews(@RequestBody NewsAndNotifications news){
		System.out.println("Calling insert news service");;
		CommonResponse response = null;
		try{
			response = NewsDAO.insertNews(news);
		}
		catch(Exception e){
			System.out.println("Exception in insertNews service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.PUT}, value = "/update-news")
	public CommonResponse updateNews(@RequestBody NewsAndNotifications news){
		System.out.println("Calling update news service: "+news);
		CommonResponse response = null;
		try{
			response = NewsDAO.updateNews(news);
		}
		catch(Exception e){
			System.out.println("Exception in updateNews service: "+e.getMessage());
		}
		return response;
	}
}
