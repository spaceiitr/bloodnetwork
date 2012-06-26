package com.app.bloodnetwork.entity;

public class DonorInfo {

	private final String availability;
	
	private final String fbId;
	
	private final String location;
	
	public String getLocation() {
		return location;
	}
	
	
	public String getAvailability() {
		return availability;
	}

	public String getFbId() {
		return fbId;
	}

	public DonorInfo( String availability, String fbId, String location)
	{
		this.availability = availability;
		this.fbId = fbId;
		this.location = location;
	}
}
