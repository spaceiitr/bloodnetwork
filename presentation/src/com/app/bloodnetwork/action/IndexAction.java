package com.app.bloodnetwork.action;

import org.apache.log4j.Logger;

import com.app.bloodnetwork.dao.DomainDaoFactory;
import com.app.bloodnetwork.dao.IRegisteredUserDao;
import com.app.bloodnetwork.entity.RegisteredUser;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends FacebookAction {

	private final IRegisteredUserDao userDao;
	private static final Logger log = Logger.getLogger(IndexAction.class);
	private RegisteredUser user;
	
	public IndexAction() {
		userDao = DomainDaoFactory.getRegisteredUserDao();
	}
	
	@Override
	public String execute() throws Exception {
		
		if( getFbId() == null )
		{
			log.error("No facebook Id is found");
			return ERROR;
		}
		
		RegisteredUser user = userDao.findUserById(getFbId());
		
		if( user == null )
		{
			log.warn("User does not exist with given facebook id:" + getFbId());
			return INPUT;
		}
		
		else{
			return "search";
		}
	}
	
	
	public RegisteredUser getUser() {
		return user;
	}
	
	public void setUser(RegisteredUser user) {
		this.user = user;
	}
}
