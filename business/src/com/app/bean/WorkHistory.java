package com.app.bean;

public class WorkHistory {

	private String employerId;
	
	private String employerName;
	
	public WorkHistory(String employerId, String employerName )
	{
		this.employerId = employerId;
		this.employerName = employerName ;
	}

	public String getEmployerId() {
		return employerId;
	}

	public void setEmployerId(String employerId) {
		this.employerId = employerId;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	
}
