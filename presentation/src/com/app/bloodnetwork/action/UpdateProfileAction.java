package com.app.bloodnetwork.action;

import java.util.List;

import com.app.bean.UserInfo;
import com.app.bloodnetwork.dao.DomainDaoFactory;
import com.app.bloodnetwork.dao.IRegisteredUserDao;
import com.app.bloodnetwork.entity.RegisteredUser;
import com.app.bloodnetwork.enums.Availibility;
import com.app.bloodnetwork.enums.BloodGroup;

public class UpdateProfileAction extends FacebookAction {

	private final IRegisteredUserDao userDao;
	private String bloodGroup;
	private String availibility;
	
	public UpdateProfileAction() {
		userDao = DomainDaoFactory.getRegisteredUserDao();
	}
	
	@Override
	public String execute() throws Exception {
		if( getFbId() == null)
			return ERROR;
		
		RegisteredUser user = userDao.findUserById(getFbId());
		if( user != null )
		{
			bloodGroup = user.getBloodGroup();
			availibility = user.getAvailibility();
		}
		
		return INPUT;
	}
	
	public String updateUser() throws Exception
	{
		if( getFbId() == null )
		{
			return null;
		}
		
		RegisteredUser user = new RegisteredUser(getFbId(), getBloodGroup(), getAvailibility());
		UserInfo userInfo = (UserInfo) getSessionMap().get("user");
		userDao.addUserInfo(userInfo, user);
		addActionMessage("Your profile got updated successfully");
		return SUCCESS;
	}
	
	public List<String> getAvailibilityOptions()
	{
		return Availibility.getDisplayNames();
	}
	
	public List<String> getBloodGroups()
	{
		return BloodGroup.getDisplayNames();
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
