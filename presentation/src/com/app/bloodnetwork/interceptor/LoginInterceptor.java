package com.app.bloodnetwork.interceptor;

import java.util.Map;

import com.app.bean.UserInfo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		boolean isLoggedIn = isUserLoggedIn(invocation);
		if( isLoggedIn ){
			return invocation.invoke();
		}
		else{
			return Action.LOGIN;
		}
	}

	private boolean isUserLoggedIn(ActionInvocation invocation) {
		if( getSessionMap() != null && getSessionMap().get("user") != null)
				return true;
		return false;
	}
	
	public Map getSessionMap(){
		return ActionContext.getContext().getSession();
	}
	
	public UserInfo getUserInfo()
	{
		return ((UserInfo)getSessionMap().get("user"));
	}
}
