package model;

public class Admin
{

	private int AdminID;
	private String username;
	private String age;
	private String phoneno;
	private String password;
	private String email;
	
	public int getAdminID() 
	{
		return AdminID;
	}
	
	public void setAdminID(int adminID) 
	{
		AdminID = adminID;
	}
	
	public String getUsername() 
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	public String getAge() 
	{
		return age;
	}
	
	public void setAge(String age) 
	{
		this.age = age;
	}
	
	public String getPhoneno() 
	{
		return phoneno;
	}
	
	public void setPhoneno(String phoneno) 
	{
		this.phoneno = phoneno;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
}
