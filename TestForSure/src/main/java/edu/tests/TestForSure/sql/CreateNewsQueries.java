package edu.tests.TestForSure.sql;


import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import edu.tests.TestForSure.entity.NewsAndNotifications;

public class CreateNewsQueries {
	public static String insertNews(NewsAndNotifications news) {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String insertNews = "INSERT into newsandnotifications (id, headline, detail, active, last_updated_on) values ('"+
				news.getId() + "' , '"+news.getHeadline() + "' , '"+news.getDetail() + "', 'true', '"+timeStamp +"')";
		return insertNews;
	}
	
	public static String getNewsAll(){
		String getNewsAll = "SELECT id, headline, detail, active, last_updated_on FROM newsandnotifications ORDER BY last_updated_on DESC";
		return getNewsAll;
	}
	
	public static String getNews(int id){
		String getNews = "SELECT headline, detail, active, last_updated_on FROM newsandnotifications WHERE id = '"+id +"'  ORDER BY last_updated_on DESC";
		return getNews;
	}
	public static String getNewsByStatus(Boolean active){
		String getNews = "SELECT id, headline, detail, active, last_updated_on FROM newsandnotifications WHERE active = '"+active +"'  ORDER BY last_updated_on DESC";
		return getNews;
	}
	public static String updateNews(NewsAndNotifications news){
		
		String updateNews = "UPDATE newsandnotifications SET headline = '" +news.getHeadline() + "', detail = '"+news.getDetail()+"' WHERE id = '" +news.getId() +"'";
		return updateNews;
	}
	public static String publishNews(int newsId){
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
		String updateNews = "UPDATE newsandnotifications SET active = 'true', last_updated_on = '" +timeStamp+ "' WHERE id = '" +newsId +"'";
		return updateNews;
	}
	public static String unpublishNews(int newsId){
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
		String updateNews = "UPDATE newsandnotifications SET active = 'false', last_updated_on = '" +timeStamp+ "' WHERE id = '" +newsId +"'";
		return updateNews;
	}
	public static String deleteNews(int id){
		String deleteNews = "DELETE FROM newsandnotifications WHERE id = '" +id+"'";
		return deleteNews;
	}
}
