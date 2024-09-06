package demoDBMS.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Operations {

	static void CreateConnection()
	{
		String url="jdbc:mysql://localhost:3306";
		String username="root";
		String password="root";
		Connection conn=null;

		try {
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("Connection Established Successfully");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		CreateStatementMethod(conn);

	}

	static void CreateStatementMethod(Connection conn)

	{
		try {
			Statement stm=conn.createStatement();
			String query="create database library";
			stm.execute(query);
			System.out.println("Statement executed Successfully");
			conn.close();
			System.out.println("Connection closed Successfully");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}

	static void CreateTable()
	{
		String url="jdbc:mysql://localhost:3306/library";
		String username="root";
		String password="root";
		Connection conn=null;

		try {
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("Connection Established Successfully");
			Statement stm=conn.createStatement();
			String query="create table book(book_id int primary key,book_name varchar(20),booke_price float) ";
			stm.execute(query);
			System.out.println("Table created Successfully");

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	static void getData()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id: ");
		int book_id=sc.nextInt();
		System.out.println("Enter Book Name: ");
		String book_name=sc.next();
		System.out.println("Enter price: ");
		float book_price=sc.nextFloat();

		InsertStatement(book_id, book_name, book_price);
	}

	static void InsertStatement(int book_id,String book_name,float book_price )
	{
		String url="jdbc:mysql://localhost:3306/library";
		String username="root";
		String password="root";
		Connection conn=null;

		try {
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("Connection Established Successfully");
			Statement stm=conn.createStatement();
			String query="insert into book values(?,?,?); ";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, book_id);
			ps.setString(2, book_name);
			ps.setFloat(3, book_price);
			ps.executeUpdate();
			System.out.println("Data inserted Successfully");
			conn.close();
			System.out.println("Connection closed Successfully");

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	static void ReadData()
	{
		String url="jdbc:mysql://localhost:3306/library";
		String username="root";
		String password="root";
		Connection conn=null;

		try {
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("Connection Established Successfully");

			Statement stm=conn.createStatement();
			String query="Select * from book";

			ResultSet rs=stm.executeQuery(query);
			// Same as datatype provided in table .
			while(rs.next())
			{
				System.out.println(rs.getInt("book_id")+"  "+rs.getString("book_name")+"  "+rs.getFloat("booke_price")+" "+rs.getString("author_name"));
			}
			rs.close();
			System.out.println("Table Shown Successfully");
			conn.close();
			System.out.println("Connection Closed Successfully");

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}

	static void UpdateMethod()
	{
		String url ="jdbc:mysql://localhost:3306/library";
		String user="root";
		String pwd="root";

		try {
			Connection conn=DriverManager.getConnection(url,user,pwd);
			System.out.println("Connection Established");
			Statement stm=conn.createStatement();
			String Query="Update book set author_name=? where book_id=?";
			PreparedStatement ps=conn.prepareStatement(Query);
			ps.setString(1, "Stephnie meyer");
			ps.setInt(2, 103);
			ps.executeUpdate();
			System.out.println("updated...");
			conn.close();
			System.out.println("connection closed");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	static void AlterMethod()
	{
		String url ="jdbc:mysql://localhost:3306/library";
		String user="root";
		String pwd="root";

		try {
			Connection conn=DriverManager.getConnection(url,user,pwd);
			System.out.println("Connection Established");
			Statement stm=conn.createStatement();
			String Query="alter table book add column author_name varchar(20) ";
			stm.execute(Query);
			System.out.println("Table modified successfully...");
			conn.close();
			System.out.println("connection closed");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}
}
