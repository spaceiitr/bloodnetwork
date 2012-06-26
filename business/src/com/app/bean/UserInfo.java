package com.app.bean;

import java.util.ArrayList;
import java.util.List;

public class UserInfo {

	private String fbId;
	
	private String name;
	
	public UserInfo( String fbId, String name )
	{
		this.fbId = fbId;
		this.name = name;
	}
	
	private List<WorkHistory> workHistories = new ArrayList<WorkHistory>();
	private List<UserInfo> friends = new ArrayList<UserInfo>();
	
	public List<UserInfo> getFriends() {
		return friends;
	}

	public void setFriends(List<UserInfo> friends) {
		this.friends = friends;
	}

	private String locationName;
	
	private String locationId;

	public String getFbId() {
		return fbId;
	}

	public void setFbId(String fbId) {
		this.fbId = fbId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WorkHistory> getWorkHistories() {
		return workHistories;
	}

	public void setWorkHistories(List<WorkHistory> workHistories) {
		this.workHistories = workHistories;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public List<String> getFriendIds() {
		List<String> ids = new ArrayList<String>( getFriends().size());
		for( UserInfo friend : getFriends())
		{
			ids.add(friend.getFbId());
		}
		return ids;
	}
}
