package com.stackroute.gipherrecommendersystem.model;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"_id",
	"gipherId",
	"gipherTitle",
	"gipherUrl",
	"createdDate",
	"addedBy"
})

public class GipherRecommendation {
	
	@JsonProperty("_id")
	private ObjectIdGipher id;
	@JsonProperty("gipherId")
	private String gipherId;
	@JsonProperty("gipherTitle")
	private String gipherTitle;
	@JsonProperty("gipherUrl")
	private String gipherUrl;
	@JsonProperty("createdDate")
	private String createdDate;
	@JsonProperty("addedBy")
	private String addedBy;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("_id")
	public ObjectIdGipher getId() {
	return id;
	}

	@JsonProperty("_id")
	public void setId(ObjectIdGipher id) {
	this.id = id;
	}

	@JsonProperty("gipherId")
	public String getGipherId() {
	return gipherId;
	}

	@JsonProperty("gipherId")
	public void setGipherId(String gipherId) {
	this.gipherId = gipherId;
	}

	@JsonProperty("gipherTitle")
	public String getGipherTitle() {
	return gipherTitle;
	}

	@JsonProperty("gipherTitle")
	public void setGipherTitle(String gipherTitle) {
	this.gipherTitle = gipherTitle;
	}

	@JsonProperty("gipherUrl")
	public String getGipherUrl() {
	return gipherUrl;
	}

	@JsonProperty("gipherUrl")
	public void setGipherUrl(String gipherUrl) {
	this.gipherUrl = gipherUrl;
	}

	@JsonProperty("createdDate")
	public String getCreatedDate() {
	return createdDate;
	}

	@JsonProperty("createdDate")
	public void setCreatedDate(String createdDate) {
	this.createdDate = createdDate;
	}

	@JsonProperty("addedBy")
	public String getAddedBy() {
	return addedBy;
	}

	@JsonProperty("addedBy")
	public void setAddedBy(String addedBy) {
	this.addedBy = addedBy;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}

	}