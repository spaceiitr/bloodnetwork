package com.app.bloodnetwork.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.app.loader.PropertyFileLoader;

public class ConnectionFactory {

	private final String driverClassName ;
	private final String connectionUrl ;
	private final String dbUser;
	private final String dbPwd ;

	private static ConnectionFactory connectionFactory = null;

	private ConnectionFactory() {
		driverClassName = PropertyFileLoader.getProperty("db.driver.name");
		connectionUrl = PropertyFileLoader.getProperty("db.connection.url");
		dbUser = PropertyFileLoader.getProperty("db.user");
		dbPwd = PropertyFileLoader.getProperty("db.passworrd");
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		return conn;
	}

	public static ConnectionFactory getInstance() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
}
