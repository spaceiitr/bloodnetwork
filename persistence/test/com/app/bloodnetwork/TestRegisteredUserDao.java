package com.app.bloodnetwork;

import com.app.bloodnetwork.dao.DomainDaoFactory;
import com.app.bloodnetwork.dao.IRegisteredUserDao;
import com.app.bloodnetwork.entity.RegisteredUser;

import junit.framework.TestCase;


public class TestRegisteredUserDao extends TestCase {

	private IRegisteredUserDao userDao;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		userDao = DomainDaoFactory.getRegisteredUserDao();
	}
	
	public void testDelete()
	{
		userDao.deleteById(11);
	}
	
	public void testAdd()
	{
		RegisteredUser user = new RegisteredUser("11", "O+", "none");
		//userDao.add(user);
		
		RegisteredUser addedUser = userDao.findUserById(String.valueOf(11));
		
		assertEquals(user.getFacebook_id(), addedUser.getFacebook_id());
		assertEquals(user.getBloodGroup(), addedUser.getBloodGroup());
		assertEquals(user.getAvailibility(), addedUser.getAvailibility());
	}
	
	public void testUpdate()
	{
		RegisteredUser user = userDao.findUserById(String.valueOf(11));
		user.setAvailibility("high");
		
		//userDao.update(user);
		
		//userDao.update(user);
		
		RegisteredUser updatedUser = userDao.findUserById(String.valueOf(11));
		
		assertEquals("high", updatedUser.getAvailibility());
	}
}
