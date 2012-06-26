package com.app.bloodnetwork.dao;

import com.app.bloodnetwork.dao.impl.RegisteredUserDaoImpl;

public class DomainDaoFactory {

	
	public static IRegisteredUserDao getRegisteredUserDao()
	{
		return new RegisteredUserDaoImpl();
	}
}
