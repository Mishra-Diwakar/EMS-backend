package com.clickncash.model;

import java.sql.Timestamp;

public class SearchData {

	private long id;
	private long userId;
	private Timestamp dateFrom;
	private Timestamp dateTo;
	private String status;
	private String serviceType;
	public long getId() {
		return id;
	}
	public long getUserId() {
		return userId;
	}
	public Timestamp getDateFrom() {
		return dateFrom;
	}
	public Timestamp getDateTo() {
		return dateTo;
	}
	
	public String getStatus() {
		return status;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public void setDateFrom(Timestamp dateFrom) {
		this.dateFrom = dateFrom;
	}
	public void setDateTo(Timestamp dateTo) {
		this.dateTo = dateTo;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	
}
