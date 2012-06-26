package com.app.bloodnetwork.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.app.bloodnetwork.connection.ConnectionFactory;

public class BaseDaoImpl {

	public final Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
}
