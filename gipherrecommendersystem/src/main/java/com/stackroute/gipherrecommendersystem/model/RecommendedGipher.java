package com.stackroute.gipherrecommendersystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RecommendedGipher {
	@Id
	private String gipherId;
	private String gipherTitle;
	private String gipherURL;
	private int count;
	public RecommendedGipher(String gipherId, String gipherTitle, String gipherURL, int count) {
		super();
		this.gipherId = gipherId;
		this.gipherTitle = gipherTitle;
		this.gipherURL = gipherURL;
		this.count = count;
	}
	public RecommendedGipher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getGipherId() {
		return gipherId;
	}
	public void setGipherId(String gipherId) {
		this.gipherId = gipherId;
	}
	public String getGipherTitle() {
		return gipherTitle;
	}
	public void setGipherTitle(String gipherTitle) {
		this.gipherTitle = gipherTitle;
	}
	public String getGipherURL() {
		return gipherURL;
	}
	public void setGipherURL(String gipherURL) {
		this.gipherURL = gipherURL;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "GipherRecommendationCount [gipherId=" + gipherId + ", gipherTitle=" + gipherTitle + ", gipherURL="
				+ gipherURL + ", count=" + count + "]";
	}
	
	
	

}
