package com.app.bloodnetwork.dao.impl;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.support.JdbcUtils;

import com.app.bean.UserInfo;
import com.app.bloodnetwork.dao.IRegisteredUserDao;
import com.app.bloodnetwork.entity.DonorInfo;
import com.app.bloodnetwork.entity.RegisteredUser;
import com.opensymphony.xwork2.inject.Scope.Strategy;

public class RegisteredUserDaoImpl extends BaseDaoImpl implements IRegisteredUserDao{

	private static final Logger log = Logger.getLogger(RegisteredUserDaoImpl.class);
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	public void add(RegisteredUser user, Connection connection) throws Exception{
		try {
			String queryString = INSERT;
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, user.getFacebook_id());
			ptmt.setString(2, user.getBloodGroup());
			ptmt.setString(3, user.getAvailibility());
			ptmt.executeUpdate();
			log.info("Data added successfully for fb_id : " + user.getFacebook_id());
		} finally {
			JdbcUtils.closeStatement(ptmt);
		}
	}

	public void update( RegisteredUser user, Connection connection) throws Exception{
		try {
			String queryString = UPDATE;
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, user.getBloodGroup());
			ptmt.setString(2, user.getAvailibility());
			ptmt.setString(3, user.getFacebook_id());
			ptmt.executeUpdate();
			log.info("Data updated successfully for fb_id : " + user.getFacebook_id());
		}  finally {
			JdbcUtils.closeStatement(ptmt);
		}
	}

	public List<RegisteredUser> findUsersByIds( List<String> fbIds) {
		if( fbIds == null || fbIds.isEmpty())
		{
			return new ArrayList<RegisteredUser>();
		}
		List<RegisteredUser> users = new ArrayList<RegisteredUser>(fbIds.size());
		try {
			String queryString = SELECT_BY_IDS;
			queryString = String.format(queryString, preparePlaceHolders(fbIds.size()));
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			setValues(ptmt, 0, fbIds.toArray());
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				String facebook_id = resultSet.getString(1);
				String bloodGroup  =resultSet.getString(2);
				String availiblity = resultSet.getString(3);
				RegisteredUser user = new RegisteredUser(facebook_id, bloodGroup, availiblity);
				users.add(user);
			}
		} catch (Exception e) {
			log.error("Some error has ocurred", e);
		} finally {
			JdbcUtils.closeResultSet(resultSet);
			JdbcUtils.closeStatement(ptmt);
			JdbcUtils.closeConnection(connection);
		}
		return users;
	}

	public RegisteredUser findUserById( String fbId)
	{
		List<String> fbIds = new ArrayList<String>();
		fbIds.add(fbId);

		List<RegisteredUser> users = findUsersByIds(fbIds);

		if( users.size() > 1)
		{
			System.err.print("Too many for records for one FB_Id" + fbId );
		}

		if( !users.isEmpty())
		{
			return users.get(0);
		}

		return null;

	}

	public void deleteById(int fbId) {

		try {
			String queryString = DELETE;
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, fbId);
			ptmt.executeUpdate();
			log.info("Data deleted successfully for fb_id " + fbId);
		} catch (Exception e) {
			log.error("Some error has ocurred", e);
		} finally {
			JdbcUtils.closeStatement(ptmt);
			JdbcUtils.closeConnection(connection);
		}

	}
	
	public void addOrUpdateUser( RegisteredUser user){
		String fbId = user.getFacebook_id();
		Connection connection = null;
		try{
			connection = getConnection();
			RegisteredUser existedUser = findUserById(fbId, connection);
			if( existedUser ==  null )
				add(user, connection);
			else
				update(user, connection);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeConnection(connection);
		}
	}
	
	
	private void addOrUpdateUser( RegisteredUser user, Connection connection) throws Exception{
		String fbId = user.getFacebook_id();
		RegisteredUser existedUser = findUserById(fbId, connection);
		if( existedUser ==  null )
			add(user, connection);
		else
			update(user, connection);
	}

	private RegisteredUser findUserById(String fbId, Connection connection) throws Exception {
		List<String> fbIds = new ArrayList<String>();
		fbIds.add(fbId);

		List<RegisteredUser> users = findUsersByIds(fbIds, connection);

		if( users.size() > 1)
		{
			System.err.print("Too many for records for one FB_Id" + fbId );
		}
		
		if( !users.isEmpty())
		{
			return users.get(0);
		}

		return null;
	}

	private List<RegisteredUser> findUsersByIds(List<String> fbIds, Connection connection) throws Exception {
		List<RegisteredUser> users = new ArrayList<RegisteredUser>(fbIds.size());
		try {
			String queryString = SELECT_BY_IDS;
			queryString = String.format(queryString, preparePlaceHolders(fbIds.size()));
			String innerQuery = getCommaSeparatedIds(fbIds);
			ptmt = connection.prepareStatement(queryString);
			setValues(ptmt, 0, fbIds.toArray());
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				String facebook_id = resultSet.getString(1);
				String bloodGroup  =resultSet.getString(2);
				String availiblity = resultSet.getString(3);
				RegisteredUser user = new RegisteredUser(facebook_id, bloodGroup, availiblity);
				users.add(user);
			}
		} finally {
			JdbcUtils.closeResultSet(resultSet);
			JdbcUtils.closeStatement(ptmt);
		}
		return users;
	}

	private String getCommaSeparatedIds(List<String> fbIds) {
		StringBuilder builder = new StringBuilder();
		for( int i=0; i< fbIds.size(); i++ )
		{
			if( i !=0 )
				builder.append("'");
			
			builder.append(fbIds.get(i));
			
			if( i != fbIds.size()-1)
			{
				builder.append("'");
				builder.append(",");
			}
		}

		String innerQuery = builder.toString();
		return innerQuery;
	}

	public static String preparePlaceHolders(int length) {
	    StringBuilder builder = new StringBuilder();
	    for (int i = 0; i < length;) {
	        builder.append("?");
	        if (++i < length) {
	            builder.append(",");
	        }
	    }
	    return builder.toString();
	}

	public static void setValues(PreparedStatement preparedStatement,int startIndex, Object... values) throws SQLException {
	    for (int i = 0; i < values.length; i++) {
	        preparedStatement.setObject(startIndex +i + 1, values[i]);
	    }
	}
	
	@Override
	public List<DonorInfo> findUserByBloodGroup(String bloodGroup, List<String> friendIds) {
		
		List<DonorInfo> donors = new ArrayList<DonorInfo>();
		try {
			String queryString = SELECT_IDS_BY_BLOODGRP;
			queryString = String.format(queryString, preparePlaceHolders(friendIds.size()));
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			setValues(ptmt, 1, friendIds.toArray());
			ptmt.setString(1, bloodGroup);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				String facebook_id = resultSet.getString(1);
				String availability = resultSet.getString(2);
				String location = resultSet.getString(3);
				donors.add(new DonorInfo(availability, facebook_id, location));
			}
		} catch (Exception e) {
			log.error("Some error has ocurred", e);
		} finally {
			JdbcUtils.closeResultSet(resultSet);
			JdbcUtils.closeStatement(ptmt);
			JdbcUtils.closeConnection(connection);
		}
		return donors;
	}
	
	public void addUserInfo( UserInfo userInfo, RegisteredUser user)
	{
		if( user == null || userInfo == null )
			throw new IllegalArgumentException("User info is null");
		
		Connection connection = null;
		PreparedStatement userPstmt = null;
		PreparedStatement locationPstsmt = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			addOrUpdateUser(user, connection);
			// Add location information
			String sqlQuery = null;
			if( userInfo.getLocationId() != null )
			{
				if(isLocationForuserExists(userInfo.getFbId(), connection))
				{
					sqlQuery = UPDATE_LOCATION;
					locationPstsmt = connection.prepareStatement(sqlQuery);
					locationPstsmt.setString(3, userInfo.getFbId());
					locationPstsmt.setString(1, userInfo.getLocationId());
					locationPstsmt.setString(2, userInfo.getLocationName());
				}else{
					sqlQuery = INSERT_LOCATION;
					locationPstsmt = connection.prepareStatement(sqlQuery);
					locationPstsmt.setString(1, userInfo.getFbId());
					locationPstsmt.setString(2, userInfo.getLocationId());
					locationPstsmt.setString(3, userInfo.getLocationName());
				}
				
				locationPstsmt.execute();
			}
			connection.commit();
			log.info("Data added successfully for fb_id : " + user.getFacebook_id());
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new RuntimeException(e);
			}
			log.error("Some error has ocurred", e);
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			JdbcUtils.closeStatement(userPstmt);
			JdbcUtils.closeConnection(connection);

		}
		
		
	}
	
	private boolean isLocationForuserExists( String fbId, Connection connection) throws SQLException
	{
		PreparedStatement statement = connection.prepareStatement(SELECT_LOCATION);
		statement.setString(1, fbId);
		
		ResultSet resultSet = statement.executeQuery();
		
		while( resultSet.next() )
		{
			return true;
		}
		return false;
	}
}
