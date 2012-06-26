package com.app.bloodnetwork.action;

import com.app.bean.UserInfo;
import com.app.bloodnetwork.dao.DomainDaoFactory;
import com.app.bloodnetwork.dao.IRegisteredUserDao;
import com.app.bloodnetwork.entity.RegisteredUser;

public class TestAction extends FacebookAction{

	private final IRegisteredUserDao userDao;
	public TestAction() {
		userDao = DomainDaoFactory.getRegisteredUserDao();
	}
	
	@Override
	public String execute() throws Exception {
		for( UserInfo info : getUserInfo().getFriends())
		{
			RegisteredUser user = new RegisteredUser(info.getFbId(), "AB+", "OK");
			userDao.addUserInfo(info, user);
		}
		
		return SUCCESS;
	}
}
