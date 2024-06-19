package model;

public class Product
{
	private String ProductID;
	private String SupplierID;
	private String name;
	private String price;
	private String stock_qty;
	private String details;
	private String weight;
	private String category;
	private String expdate;
	
	public String getProductID() 
	{
		return ProductID;
	}
	
	public void setProductID(String productID)
	{
		ProductID = productID;
	}
	
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
	
	public String getPrice() 
	{
		return price;
	}
	
	public void setPrice(String price)
	{
		this.price = price;
	}
	
	public String getStock_qty() 
	{
		return stock_qty;
	}
	
	public void setStock_qty(String stock_qty) 
	{
		this.stock_qty = stock_qty;
	}
	
	public String getDetails() 
	{
		return details;
	}
	
	public void setDetails(String details) 
	{
		this.details = details;
	}
	
	public String getWeight() 
	{
		return weight;
	}
	
	public void setWeight(String weight) 
	{
		this.weight = weight;
	}
	
	public String getCategory() 
	{
		return category;
	}
	
	public void setCategory(String category) 
	{
		this.category = category;
	}

	public String getExpdate() 
	{
		return expdate;
	}

	public void setExpdate(String expdate) 
	{
		this.expdate = expdate;
	}
}
