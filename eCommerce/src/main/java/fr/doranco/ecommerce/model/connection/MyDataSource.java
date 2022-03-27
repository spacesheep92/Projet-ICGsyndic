package fr.doranco.ecommerce.model.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public final class MyDataSource {

	private static MyDataSource instance;
	
	private MyDataSource() {

	}

	public static MyDataSource getInstance() {
		if (instance == null) {
			instance = new MyDataSource();
		}
		return instance;
	}
	
	public Connection getConnection() throws Exception {

		String login = "space";
		String password = "admin";
		String url = "jdbc:mysql://127.0.0.1:3306/ecommerce_db";

		
		return DriverManager.getConnection(url, login, password);
	}
}
