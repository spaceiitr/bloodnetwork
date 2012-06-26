package com.app.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import authoria.org.json.JSONArray;
import authoria.org.json.JSONObject;

import com.app.bean.UserInfo;
import com.app.bean.WorkHistory;

public class JsonParserUtil {

	public static final UserInfo getUserInfo( JSONObject object)
	{
		if( object == null )
			return null;

		UserInfo userInfo = null;
		try{
			String fbId = object.getString("id");
			String name = object.getString("name");

			userInfo = new UserInfo(fbId, name);
			
			String locationId  = object.getJSONObject("location").getString("id");
			String locationName  = object.getJSONObject("location").getString("name");
			
			userInfo.setLocationId(locationId);
			userInfo.setLocationName(locationName);

			JSONArray workHistories = object.getJSONArray("work");

			for( int i=0 ; i < workHistories.length(); i++ )
			{
				JSONObject work = workHistories.getJSONObject(i);
				String employerId = work.getJSONObject("employer").getString("id");
				String employerName = work.getJSONObject("employer").getString("name");
				WorkHistory history = new WorkHistory(employerId, employerName);

				userInfo.getWorkHistories().add(history);
			}
		}catch (Exception e) {
			throw new RuntimeException();
		}
		return userInfo;
	}

	public static List<UserInfo> getFriends(JSONObject object) {

		if( object == null )
			return Collections.EMPTY_LIST;
		
		List<UserInfo> friends = new ArrayList<UserInfo>();
		
		try{
			JSONArray friendArray = object.getJSONArray("data");
			for( int i=0; i < friendArray.length(); i++ )
			{
				JSONObject friend = friendArray.getJSONObject(i);
				String fbId = friend.getString("id");
				String name = friend.getString("name");
				String locationId = null;
				String locationName = null;
				
				try{
					locationName = friend.getJSONObject("location").getString("name");
					locationId = friend.getJSONObject("location").getString("id");
				}catch (Exception e) {
					//ignore it
				}
				UserInfo friendInfo = new UserInfo(fbId, name);
				
				friendInfo.setLocationId(locationId);
				friendInfo.setLocationName(locationName);
				friends.add( friendInfo );
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return friends;
	}
}
