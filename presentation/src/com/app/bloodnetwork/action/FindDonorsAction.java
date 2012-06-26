package com.app.bloodnetwork.action;

import java.util.List;

import com.app.bloodnetwork.dao.DomainDaoFactory;
import com.app.bloodnetwork.dao.IRegisteredUserDao;
import com.app.bloodnetwork.entity.DonorInfo;
import com.app.bloodnetwork.enums.BloodGroup;
import com.opensymphony.xwork2.ActionSupport;

public class FindDonorsAction extends FacebookAction {

	private final IRegisteredUserDao userDao;
	private String bloodGroup;
	private List<DonorInfo> donorIds;
	public List<DonorInfo> getDonorIds() {
		return donorIds;
	}
	
	public void setDonorIds(List<DonorInfo> donorIds) {
		this.donorIds = donorIds;
	}
	
	public FindDonorsAction() {
		this.userDao = DomainDaoFactory.getRegisteredUserDao();
	}
	
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String refresh() throws Exception {
		List<String> friendsIds = getUserInfo().getFriendIds();
		donorIds = userDao.findUserByBloodGroup(getBloodGroup(), friendsIds);
		return "refresh";
	}
	
	public String getBloodGroup() {
		return bloodGroup;
	}
	
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	public List<String> getBloodGroups()
	{
		return BloodGroup.getDisplayNames();
	}
}
