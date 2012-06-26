package com.app.bloodnetwork.action;

import java.util.Map;

import com.app.bean.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FacebookAction extends ActionSupport {

	public String getFbId(){
		return getUserInfo().getFbId();
	}
	
	public Map getSessionMap(){
		return ActionContext.getContext().getSession();
	}
	
	public UserInfo getUserInfo()
	{
		return ((UserInfo)getSessionMap().get("user"));
	}
}
