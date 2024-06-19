package model;

public class Supplier
{
	private String SupplierID;
	private String name;
	private String address;
	private String phoneno;

	public String getSupplierID()
	{
		return SupplierID;
	}
	
	public void setSupplierID(String supplierID) 
	{
		SupplierID = supplierID;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getAddress() 
	{
		return address;
	}
	
	public void setAddress(String address) 
	{
		this.address = address;
	}
	
	public String getPhoneno() 
	{
		return phoneno;
	}
	
	public void setPhoneno(String phoneno)
	{
		this.phoneno = phoneno;
	}

	
}
