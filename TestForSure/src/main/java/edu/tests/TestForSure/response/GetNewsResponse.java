package edu.tests.TestForSure.response;
import java.util.*;

import edu.tests.TestForSure.entity.NewsAndNotifications;

public class GetNewsResponse {
	private ArrayList<NewsAndNotifications> news;
	private CommonResponse response;
	public ArrayList<NewsAndNotifications> getNews() {
		return news;
	}
	public void setNews(ArrayList<NewsAndNotifications> news) {
		this.news = news;
	}
	public CommonResponse getResponse() {
		return response;
	}
	public void setResponse(CommonResponse response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "GetNewsResponse [news=" + news + ", response=" + response + "]";
	}
	public GetNewsResponse(ArrayList<NewsAndNotifications> news, CommonResponse response) {
		super();
		this.news = news;
		this.response = response;
	}
	public GetNewsResponse() {
		super();
	}
}
