package edu.tests.TestForSure.sql;

import edu.tests.TestForSure.entity.NewsAndNotifications;

public class CreateNewsQueries {
	public static String insertNews(NewsAndNotifications news) {
		String insertNews = "INSERT into newsandnotifications (id, headline, detail) values ('"+
				news.getId() + "' , '"+news.getHeadline() + "' , '"+news.getDetail() + "')";
		return insertNews;
	}
	
	public static String getNewsAll(){
		String getNewsAll = "SELECT id, headline FROM newsandnotifications";
		return getNewsAll;
	}
	
	public static String getNews(int id){
		String getNews = "SELECT headline, detail FROM newsandnotifications WHERE id = '"+id +"'";
		return getNews;
	}
	
	public static String updateNews(NewsAndNotifications news){
		String updateNews = "UPDATE newsandnotifications SET headline = '" +news.getHeadline() + "', detail = '"+news.getDetail()+"' WHERE id = '" +news.getId() +"'";
		return updateNews;
	}
	
	public static String deleteNews(int id){
		String deleteNews = "DELETE FROM newsandnotifications WHERE id = '" +id+"'";
		return deleteNews;
	}
}
