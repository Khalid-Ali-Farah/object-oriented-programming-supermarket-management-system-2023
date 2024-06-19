package database;
import java.sql.*;

public class ShopDatabase
{
	static Connection conn = null;
	public static Connection doConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/supermarket","root","");
		return conn;
	}
	
	public static void main (String[] args)
	{
		try
		{
			System.out.println(ShopDatabase.doConnection());
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
}
