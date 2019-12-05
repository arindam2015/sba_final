package com.stackroute.gipherrecommendersystem.model;



	
	import java.util.HashMap;
	import java.util.Map;
	import com.fasterxml.jackson.annotation.JsonAnyGetter;
	import com.fasterxml.jackson.annotation.JsonAnySetter;
	import com.fasterxml.jackson.annotation.JsonIgnore;
	import com.fasterxml.jackson.annotation.JsonInclude;
	import com.fasterxml.jackson.annotation.JsonProperty;
	import com.fasterxml.jackson.annotation.JsonPropertyOrder;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"timestamp",
	"machineIdentifier",
	"processIdentifier",
	"counter",
	"date",
	"time",
	"timeSecond"
	})
	public class ObjectIdGipher {

	@JsonProperty("timestamp")
	private Long timestamp;
	@JsonProperty("machineIdentifier")
	private Long machineIdentifier;
	@JsonProperty("processIdentifier")
	private Long processIdentifier;
	@JsonProperty("counter")
	private Long counter;
	@JsonProperty("date")
	private String date;
	@JsonProperty("time")
	private Long time;
	@JsonProperty("timeSecond")
	private Long timeSecond;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("timestamp")
	public Long getTimestamp() {
	return timestamp;
	}

	@JsonProperty("timestamp")
	public void setTimestamp(Long timestamp) {
	this.timestamp = timestamp;
	}

	@JsonProperty("machineIdentifier")
	public Long getMachineIdentifier() {
	return machineIdentifier;
	}

	@JsonProperty("machineIdentifier")
	public void setMachineIdentifier(Long machineIdentifier) {
	this.machineIdentifier = machineIdentifier;
	}

	@JsonProperty("processIdentifier")
	public Long getProcessIdentifier() {
	return processIdentifier;
	}

	@JsonProperty("processIdentifier")
	public void setProcessIdentifier(Long processIdentifier) {
	this.processIdentifier = processIdentifier;
	}

	@JsonProperty("counter")
	public Long getCounter() {
	return counter;
	}

	@JsonProperty("counter")
	public void setCounter(Long counter) {
	this.counter = counter;
	}

	@JsonProperty("date")
	public String getDate() {
	return date;
	}

	@JsonProperty("date")
	public void setDate(String date) {
	this.date = date;
	}

	@JsonProperty("time")
	public Long getTime() {
	return time;
	}

	@JsonProperty("time")
	public void setTime(Long time) {
	this.time = time;
	}

	@JsonProperty("timeSecond")
	public Long getTimeSecond() {
	return timeSecond;
	}

	@JsonProperty("timeSecond")
	public void setTimeSecond(Long timeSecond) {
	this.timeSecond = timeSecond;
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
