package edu.tests.TestForSure.datalayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.tests.TestForSure.common.DBConnection;
import edu.tests.TestForSure.entity.NewsAndNotifications;
import edu.tests.TestForSure.response.CommonResponse;
import edu.tests.TestForSure.response.GetNewsResponse;
import edu.tests.TestForSure.sql.CreateNewsQueries;

public class NewsDAO {
	public static CommonResponse insertNews(NewsAndNotifications news){
		System.out.println("Calling DAO");
		String query = CreateNewsQueries.insertNews(news);
		Connection conn = DBConnection.getDBConnection();
		CommonResponse response = new CommonResponse();
		int result = 0;
		try{
			Statement statement = conn.createStatement();
			result = statement.executeUpdate(query);
			if(result>0){
				response.setStatus(true);
				response.setMessage("News/Notification added successfully");
			}
			else {
				response.setStatus(false);
				response.setMessage("Error in adding News/Notification");
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO: "+e.getMessage());
			response.setStatus(false);
			response.setMessage(e.getMessage());
		}
		finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				response.setStatus(false);
				response.setMessage(e.getMessage());
			}
		}
		return response;
	}
	
	public static CommonResponse updateNews(NewsAndNotifications news){
		System.out.println("Calling DAO");
		String query = CreateNewsQueries.updateNews(news);
		Connection conn = DBConnection.getDBConnection();
		CommonResponse response = new CommonResponse();
		int result = 0;
		try{
			Statement statement = conn.createStatement();
			result = statement.executeUpdate(query);
			if(result>0){
				response.setStatus(true);
				response.setMessage("News/Notification updated successfully");
			}
			else {
				response.setStatus(false);
				response.setMessage("Error in updating News/Notification");
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO: "+e.getMessage());
			response.setStatus(false);
			response.setMessage(e.getMessage());
		}
		finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				response.setStatus(false);
				response.setMessage(e.getMessage());
			}
		}
		return response;
	}
	
	public static CommonResponse deleteNews(int id){
		System.out.println("Calling DAO");
		String query = CreateNewsQueries.deleteNews(id);
		Connection conn = DBConnection.getDBConnection();
		CommonResponse response = new CommonResponse();
		int result = 0;
		try{
			Statement statement = conn.createStatement();
			result = statement.executeUpdate(query);
			if(result>0){
				response.setStatus(true);
				response.setMessage("News/Notification deleted successfully");
			}
			else {
				response.setStatus(false);
				response.setMessage("Error in deleting News/Notification");
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO: "+e.getMessage());
			response.setStatus(false);
			response.setMessage(e.getMessage());
		}finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				response.setStatus(false);
				response.setMessage(e.getMessage());
			}
		}
		
		return response;
	}
	
	public static GetNewsResponse getNews(int id){
		System.out.println("Calling DAO");
		String query = CreateNewsQueries.getNews(id);
		Connection conn = DBConnection.getDBConnection();
		NewsAndNotifications news = new NewsAndNotifications();
		ArrayList<NewsAndNotifications> list = new ArrayList<NewsAndNotifications>();
		GetNewsResponse response = new GetNewsResponse();
		ResultSet result = null;
		try{
			Statement statement = conn.createStatement();
			result = statement.executeQuery(query);
			if(result.isBeforeFirst()){
				while(result.next()){
					news.setHeadline(result.getString(1));
					news.setDetail(result.getString(2));
					list.add(news);
				}
				
				response.setNews(list);
				response.setResponse(new CommonResponse(true, ""));
			}
			else {
				response.setResponse(new CommonResponse(false, "Error in getting news/notification"));
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO: "+e.getMessage());
			response.setResponse(new CommonResponse(false, e.getMessage()));
		}finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				response.setResponse(new CommonResponse(false, e.getMessage()));
			}
		}
		
		return response;
	}
	
	public static GetNewsResponse getAllNews(){
		System.out.println("Calling DAO");
		String query = CreateNewsQueries.getNewsAll();
		Connection conn = DBConnection.getDBConnection();
		NewsAndNotifications news = new NewsAndNotifications();
		ArrayList<NewsAndNotifications> list = new ArrayList<NewsAndNotifications>();
		GetNewsResponse response = new GetNewsResponse();
		ResultSet result = null;
		try{
			Statement statement = conn.createStatement();
			result = statement.executeQuery(query);
			if(result.isBeforeFirst()){
				while(result.next()){
					news = new NewsAndNotifications();
					news.setId(result.getInt(1));
					news.setHeadline(result.getString(2));
					news.setDetail(result.getString(3));
					list.add(news);
				}
				
				response.setNews(list);
				response.setResponse(new CommonResponse(true, ""));
			}
			else {
				response.setResponse(new CommonResponse(false, "Error in getting news/notification"));
			}
		}
		catch(Exception e){
			System.out.println("Exception from DAO: "+e.getMessage());
			response.setResponse(new CommonResponse(false, e.getMessage()));
		}finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				response.setResponse(new CommonResponse(false, e.getMessage()));
			}
		}
		
		return response;
	}
}
