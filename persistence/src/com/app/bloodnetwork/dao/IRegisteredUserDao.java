package com.app.bloodnetwork.dao;

import java.util.List;

import com.app.bean.UserInfo;
import com.app.bloodnetwork.entity.DonorInfo;
import com.app.bloodnetwork.entity.RegisteredUser;

public interface IRegisteredUserDao {
	
	String INSERT = "INSERT INTO REGISTERED_USERS(FB_ID, BLOOD_GRP, AVAILABILITY) VALUES(?,?,?)";
	
	String UPDATE= "UPDATE REGISTERED_USERS SET BLOOD_GRP=?,AVAILABILITY=? WHERE FB_ID=?";
	
	String SELECT_BY_IDS = "SELECT FB_ID,BLOOD_GRP,AVAILABILITY FROM REGISTERED_USERS where FB_ID in ( %s )";
	
	String SELECT_IDS_BY_BLOODGRP = "SELECT u.FB_ID, u.AVAILABILITY, l.location FROM REGISTERED_USERS u, LOCATION l where l.FACEBOOK_ID = u.FB_ID AND BLOOD_GRP = ? AND FB_ID IN (%s) ORDER BY l.location";
	
	
	String DELETE = "DELETE FROM REGISTERED_USERS WHERE FB_ID=?";
	
	String INSERT_LOCATION = "INSERT INTO LOCATION ( FACEBOOK_ID, LOCATION_ID, LOCATION) VALUES (?,?,?)";
	
	String UPDATE_LOCATION = "UPDATE LOCATION SET LOCATION_ID=?,LOCATION=? WHERE FACEBOOK_ID=?";
	
	String INSERT_EMPLOYER = "INSERT INTO EMPLOYER ( FACEBOOK_ID, EMPLOYER_ID, EMPLOYER_NAME) VALUES(?,?,?)";
	
	String SELECT_LOCATION = "SELECT FACEBOOK_ID FROM LOCATION WHERE FACEBOOK_ID=?";
	
	public void deleteById(int fbId);
	
	public RegisteredUser findUserById( String fbId);
	
	public List<RegisteredUser> findUsersByIds( List<String> fbIds);
	
	
	public void addOrUpdateUser( RegisteredUser user);
	
	public List<DonorInfo> findUserByBloodGroup( String bloodGroup, List<String> friendsIds );
	
	public void addUserInfo( UserInfo userInfo, RegisteredUser user);
	
}
