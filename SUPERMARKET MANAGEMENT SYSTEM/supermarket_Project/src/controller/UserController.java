package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import database.ShopDatabase;
import model.Staff;
import model.Supplier;
import model.Product;
import model.Admin;

public class UserController
{
	//Staff Login
	public static int doLogin(Staff staff) throws ClassNotFoundException, SQLException
	{
		int success = 1;	
		
		//select staff's username & password from the database
		String sql = "select StaUsername, StaPass from staff where StaUsername = ? and StaPass = ?";
		
		//1. Connection 
		Connection conn = ShopDatabase.doConnection();
		
		//2. PreparedStatement
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, staff.getUsername());//get the 1st string as username
		preparedStatement.setString(2, staff.getPassword());//get the 2nd string as password
			
		//3. View or insert/update
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next())
		{
			staff.setUsername(resultSet.getString(1));//set the result as username 
		}
		else
		{
			success = -1;
		}
			
		//4. Must close the connection
		conn.close();	
		return success;
	}	
	
	
	//Admin Login
	public int doLogin(Admin admin) throws ClassNotFoundException, SQLException
	{
		int success = 0;
				
		//select admin's username & password from the database
		String sql = "select AdUsername, AdPass from admin where AdUsername = ? and AdPass = ?";
		
		//1. Connection 
		Connection conn = ShopDatabase.doConnection();
		
		//2. PreparedStatement
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, admin.getUsername());//get the 1st string as username
		preparedStatement.setString(2, admin.getPassword());//get the 2nd string as password
			
		//3. View or insert/update
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next())
		{
			admin.setUsername(resultSet.getString(1));//set the result as username 
		} else
		{
			success = -1;
		}
			
		//4. Must close the connection
		conn.close();
			
		return success;
	}
	
	
	//insert staff details into database
	public int addStaff (Staff staff) throws ClassNotFoundException, SQLException
	{
		//insert all details to add a new staff into the database
		String sql = "insert into staff (StaUsername, StaAge, StaPhone, StaPass, StaEmail) values (?,?,?,?,?)";
	
		Connection conn=ShopDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, staff.getUsername());
		preparedStatement.setString(2, staff.getAge());
		preparedStatement.setString(3, staff.getPhoneno());
		preparedStatement.setString(4, staff.getPassword());
		preparedStatement.setString(5, staff.getEmail());
		int success = preparedStatement.executeUpdate();
		
		conn.close();
		
		return success;
	}
	
	
	//delete staff from database
	public int deleteStaff (Staff staff) throws ClassNotFoundException, SQLException
	{
		//delete record in the staff table based on Staff ID
		String sql = "delete from staff where StaID = ?";
		
		Connection conn=ShopDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, staff.getStaffID());
		int success = preparedStatement.executeUpdate();
			
		conn.close();
			
		return success;
	}
	
	
	//To view staff list
	public ArrayList<Staff> viewStaffList() throws ClassNotFoundException, SQLException
	{
		ArrayList<Staff> staffs = new ArrayList<Staff>();//create new object named staffs
		//select all details from the table staff
		String sql = "Select * from staff";
		Connection conn = ShopDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			
		ResultSet resultSet = preparedStatement.executeQuery();
			
		while(resultSet.next())
		{
			Staff staff = new Staff();
			staff.setUsername(resultSet.getString(1));
			staff.setAge(resultSet.getString(2));
			staff.setPhoneno(resultSet.getString(3));
			staff.setPassword(resultSet.getString(4));
			staff.setEmail(resultSet.getString(5));
			staffs.add(staff);
		}
			
		conn.close();

		return staffs; 
	}
	
	
	//insert product details into database
	public int addProduct (Product product) throws ClassNotFoundException, SQLException
	{
		//insert all details to add a new product into the database
		String sql = "insert into product (SupID, Pname, Pprice, PstockQty, Pdetails, Pweight, Pcat, PExpDate) values (?,?,?,?,?,?,?,?)";
	
		Connection conn=ShopDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, product.getSupplierID());
		preparedStatement.setString(2, product.getName());
		preparedStatement.setString(3, product.getPrice());
		preparedStatement.setString(4, product.getStock_qty());
		preparedStatement.setString(5, product.getDetails());
		preparedStatement.setString(6, product.getWeight());
		preparedStatement.setString(7, product.getCategory());
		preparedStatement.setString(8, product.getExpdate());
		int success = preparedStatement.executeUpdate();
				
		conn.close();
				
		return success;
	}
	
	//**********************************************************************************//
		//update product details into database
			public int updateProduct (Product product) throws ClassNotFoundException, SQLException
			{
				//insert all details to add a new product into the database
				String sql = "update  product set  Pname=?, Pprice=?, PstockQty=?, Pdetails=?, Pweight=?, Pcat=?, PExpDate=? where SupID=?";
			
				Connection conn=ShopDatabase.doConnection();
				PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
				
				preparedStatement.setString(1, product.getName());
				preparedStatement.setString(2, product.getPrice());
				preparedStatement.setString(3, product.getStock_qty());
				preparedStatement.setString(4, product.getDetails());
				preparedStatement.setString(5, product.getWeight());
				preparedStatement.setString(6, product.getCategory());
				preparedStatement.setString(7, product.getExpdate());
				preparedStatement.setString(8, product.getSupplierID());
				//preparedStatement.setString(9, product.getProductID());

				int success = preparedStatement.executeUpdate();
						
				conn.close();
						
				return success;
			}
		//**********************************************************************************//
			public ResultSet findProduct(Product product) throws SQLException, ClassNotFoundException
			{
				String findProduct = "select * from product where pname like CONCAT ('%',?,'%')";
				Connection conn = ShopDatabase.doConnection();
				PreparedStatement preparedStatement = (PreparedStatement)conn.prepareStatement(findProduct);
				preparedStatement.setString(1, product.getName());
				
				ResultSet resultSet = preparedStatement.executeQuery();
						
				return resultSet;
				
			}
			
			//**********************************************************************************//

		
			

	
	//delete product by product ID from database
	public int deleteProduct (Product product) throws ClassNotFoundException, SQLException
	{
		//delete record in the product table based on Product ID
		String sql = "delete from product where PID = ?";
			
		Connection conn=ShopDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, product.getProductID());
		int success = preparedStatement.executeUpdate();
				
		conn.close();
				
		return success;
	}
	
	
	//delete product by supplier ID from database
	public int deleteProductbySupID (Supplier supplier) throws ClassNotFoundException, SQLException
	{
		//delete record in the product table based on Supplier ID
		String sql = "delete from product where SupID = ?";
				
		Connection conn=ShopDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, supplier.getSupplierID());
		int success = preparedStatement.executeUpdate();
					
		conn.close();
					
		return success;
		}
	
	
	//To view product list
	public ArrayList<Product> viewProductList() throws ClassNotFoundException, SQLException
	{
		ArrayList<Product> products = new ArrayList<Product>();//create new object named products
		//select all details from the table product
		String sql = "Select * from product";
		Connection conn = ShopDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
					
		ResultSet resultSet = preparedStatement.executeQuery();
					
		while(resultSet.next())
		{
			Product product = new Product();
			product.setSupplierID(resultSet.getString(1));
			product.setName(resultSet.getString(2));
			product.setPrice(resultSet.getString(3));
			product.setStock_qty(resultSet.getString(4));
			product.setDetails(resultSet.getString(5));
			product.setWeight(resultSet.getString(6));
			product.setCategory(resultSet.getString(7));
			product.setExpdate(resultSet.getString(8));
		}
					
		conn.close();

		return products; 
	}
	
	
	//insert supplier details into database
	public int addSupplier (Supplier supplier) throws ClassNotFoundException, SQLException
	{
		//insert all details to add a new supplier into the database
		String sql = "insert into supplier (SupName, SupAddress, SupPhone) values (?,?,?)";
		
		Connection conn=ShopDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, supplier.getName());
		preparedStatement.setString(2, supplier.getAddress());
		preparedStatement.setString(3, supplier.getPhoneno());
		int success = preparedStatement.executeUpdate();
			
		conn.close();
			
		return success;
	}
	
	
	//delete supplier from database
	public int deleteSupplier (Supplier supplier) throws ClassNotFoundException, SQLException
	{
		//delete record from table supplier where SupID = entered text
		String sql = "delete from supplier where SupID = ?";
				
		Connection conn=ShopDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, supplier.getSupplierID());
		int success = preparedStatement.executeUpdate();
					
		conn.close();
					
		return success;
	}
	
	
	//To view supplier list
	public ArrayList<Supplier> viewSupplierList() throws ClassNotFoundException, SQLException
	{
		ArrayList<Supplier> suppliers = new ArrayList<Supplier>();//create new object named suppliers
		
		//select all details from the table suppliers
		String sql = "Select * from supplier";
		Connection conn = ShopDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
				
		ResultSet resultSet = preparedStatement.executeQuery();
				
		while(resultSet.next())
		{
			Supplier supplier = new Supplier();
			supplier.setName(resultSet.getString(1));
			supplier.setAddress(resultSet.getString(2));
			supplier.setPhoneno(resultSet.getString(3));
		}
				
		conn.close();

		return suppliers; 
	}
	
}
