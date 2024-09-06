package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExampleSql {
	public  void createDb() throws ClassNotFoundException, SQLException 
	{
		System.out.println(1);
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println(2);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
		System.out.println(3);
		conn.close();
	}
	public static void main(String[] args)throws Exception
	{
		System.out.println("hii");
		ExampleSql e=new ExampleSql();
		e.createDb();
		
	}
}
