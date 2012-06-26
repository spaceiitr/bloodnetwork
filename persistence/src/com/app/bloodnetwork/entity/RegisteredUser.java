package com.app.bloodnetwork.entity;

public class RegisteredUser {

	private String facebook_id;
	private String bloodGroup;
	private String availibility;
	
	public RegisteredUser ( String facebook_id, String bloodGroup, String availiblity)
	{
		this.facebook_id = facebook_id;
		this.availibility = availiblity;
		this.bloodGroup = bloodGroup;
	}

	public String getFacebook_id() {
		return facebook_id;
	}

	public void setFacebook_id(String facebook_id) {
		this.facebook_id = facebook_id;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getAvailibility() {
		return availibility;
	}

	public void setAvailibility(String availibility) {
		this.availibility = availibility;
	}
	
}
