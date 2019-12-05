package com.stackroute.giphermanager.model;

import java.math.BigInteger;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document
public class Favourite {
	@Id
	private ObjectId _id;
	private String gipherId;
	private String gipherTitle;
	private String gipherUrl;
	private Date createdDate;
	private String addedBy;
	
	
	public Favourite(String gipherId, String gipherTitle, String gipherUrl, Date createdDate, String addedBy) {
		super();
		
		this.gipherId = gipherId;
		this.gipherTitle = gipherTitle;
		this.gipherUrl = gipherUrl;
		this.createdDate = createdDate;
		this.addedBy = addedBy;
	}
	
	public Favourite() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
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
	public String getGipherUrl() {
		return gipherUrl;
	}
	public void setGipherUrl(String gipherUrl) {
		this.gipherUrl = gipherUrl;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	@Override
	public String toString() {
		return "Favourite [gipherId=" + gipherId + ", gipherTitle=" + gipherTitle + ", gipherUrl=" + gipherUrl
				+ ", createdDate=" + createdDate + ", createdBy=" + addedBy + "]";
	}
	
	
	

}
