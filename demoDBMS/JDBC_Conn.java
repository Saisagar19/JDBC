package demoDBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Conn {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306";
		String username = "root";
		String password = "root";

		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stm = conn.createStatement();
			System.out.println("Connection Established Successfully");
			String query = "create database JDBCdatabase";
			stm.execute(query);
			System.out.println("Database created Successfully");
			conn.close();
			System.out.println("Connection closed Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
