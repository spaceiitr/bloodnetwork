package com.app.bloodnetwork.action;

import java.util.List;
import java.util.Map;

import authoria.org.json.JSONObject;

import com.app.bean.UserInfo;
import com.app.util.JsonParserUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InitializeAction extends ActionSupport {

	private String meJsonString;
	private String friendJsonString;
	
	
	@Override
	public String execute() throws Exception {
		JSONObject meJson = new JSONObject(meJsonString);
		UserInfo userInfo = JsonParserUtil.getUserInfo(meJson);
		
		getSessionMap().put("user", userInfo);
		return null;
	}
	
	public String addFriends() throws Exception {
		try{
			JSONObject jsonObject = new JSONObject( friendJsonString);
			if( getSessionMap().containsKey("user"))
			{
				UserInfo userInfo = (UserInfo) getSessionMap().get("user");
				List<UserInfo> friends = JsonParserUtil.getFriends( jsonObject);
				userInfo.getFriends().addAll(friends);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	public String getMeJsonString() {
		return meJsonString;
	}
	
	public void setMeJsonString(String meJsonString) {
		this.meJsonString = meJsonString;
	}
	
	public String getFriendJsonString() {
		return friendJsonString;
	}
	
	
	public void setFriendJsonString(String friendJsonString) {
		this.friendJsonString = friendJsonString;
	}
	
	public Map getSessionMap(){
		return ActionContext.getContext().getSession();
	}
}
