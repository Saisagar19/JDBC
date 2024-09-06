package demoDBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Scanner;

public class MyMainClass {

	static void CreateDataBase()
	{
		String url = "jdbc:mysql://localhost:3306";
		String username = "root";
		String password = "root";

		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stm = conn.createStatement();
			System.out.println("Connection Established Successfully");
			String query = "create database JDBCdata";
			stm.execute(query);
			System.out.println("Database created Successfully");
			conn.close();
			System.out.println("Connection closed Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void CreateTable()
	{

		String url = "jdbc:mysql://localhost:3306/JDBCdata";
		String username = "root";
		String password = "root";

		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stm = conn.createStatement();
			System.out.println("Connection Established Successfully");
			String query = "create table Student(Stud_id int primary key,name varchar(20),age int)";
			stm.execute(query);
			System.out.println("Table created Successfully");
			conn.close();
			System.out.println("Connection closed Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void insetvalue()

	{
		String url="jdbc:mysql://localhost:3306/jdbcdata";
		String username="root";
		String password="root";

		try {
			Connection conn=DriverManager.getConnection(url,username,password);
			Statement stm= conn.createStatement();
			System.out.println("Connection Established successfully");
			String query= "insert into Student values (101,'sagar',25);";
			stm.execute(query);
			System.out.println("value inserted Successfully");
			conn.close();
			System.out.println("Connection closed successfully");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}

	static void altervalue()

	{
		String url="jdbc:mysql://localhost:3306/jdbcdata";
		String username="root";
		String password="root";

		try {
			Connection conn=DriverManager.getConnection(url,username,password);
			Statement stm= conn.createStatement();
			System.out.println("Connection Established successfully");
			String query= "alter table student add column grade char;";
			stm.execute(query);
			System.out.println("Table has been modified Successfully");
			conn.close();
			System.out.println("Connection closed successfully");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}

	static void Updatevalue()

	{
		String url="jdbc:mysql://localhost:3306/jdbcdata";
		String username="root";
		String password="root";

		try {
			Connection conn=DriverManager.getConnection(url,username,password);
			Statement stm= conn.createStatement();
			System.out.println("Connection Established successfully");
			String query= "update student set grade='A' where stud_id=101;";
			stm.execute(query);
			System.out.println("Table has been updated Successfully");
			conn.close();
			System.out.println("Connection closed successfully");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	static void manual()
	{
		Scanner sc= new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/jdbcdata";
		String username="root";
		String password="root";

		String query;


		try {
			Connection conn=DriverManager.getConnection(url,username,password);
			Statement stm= conn.createStatement();
			System.out.println("Connection Established successfully");
			System.out.println("Enter Query: ");

			System.out.println("Query: ");
			query=sc.nextLine();
			stm.execute(query);

			System.out.println("updated Successfully");
			conn.close();
			System.out.println("Connection closed successfully");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {

		//MyMainClass.CreateDataBase();
		//MyMainClass.CreateTable();
		//MyMainClass.insetvalue();
		//MyMainClass.altervalue();
		//MyMainClass.Updatevalue();
		MyMainClass.manual();
	}

}
