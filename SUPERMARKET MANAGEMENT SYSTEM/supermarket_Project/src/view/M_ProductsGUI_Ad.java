package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;

import controller.UserController;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class M_ProductsGUI_Ad extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textPrice;
	private JTextField textCategory;
	private JTextField textWeight;
	private JTextField textDetails;
	DefaultTableModel model;
	private JTable tableProducts;
	private JTable tableSuppliers;
	private JTextField textQty;
	private JTextField textEXPdate;
	private JTextField textSupID;
	private JTextField textID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					M_ProductsGUI_Ad frame = new M_ProductsGUI_Ad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public M_ProductsGUI_Ad()
	{
		setTitle("Supermarket Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1250, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblManageProduct = new JLabel("Manage Products");
		lblManageProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblManageProduct.setForeground(new Color(101, 153, 255));
		lblManageProduct.setFont(new Font("KG HAPPY Solid", Font.BOLD, 20));
		lblManageProduct.setBounds(0, 0, 1234, 46);
		contentPane.add(lblManageProduct);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Calibri", Font.BOLD, 13));
		lblName.setBounds(624, 134, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblPrice = new JLabel("PRICE (RM)");
		lblPrice.setFont(new Font("Calibri", Font.BOLD, 13));
		lblPrice.setBounds(624, 168, 65, 14);
		contentPane.add(lblPrice);
		
		JLabel lblQuantity = new JLabel("QTY");
		lblQuantity.setFont(new Font("Calibri", Font.BOLD, 13));
		lblQuantity.setBounds(624, 205, 36, 14);
		contentPane.add(lblQuantity);
		
		JLabel lblDetails = new JLabel("DETAILS");
		lblDetails.setFont(new Font("Calibri", Font.BOLD, 13));
		lblDetails.setBounds(919, 97, 64, 14);
		contentPane.add(lblDetails);
		
		JLabel lblWeight = new JLabel("WEIGHT (g)");
		lblWeight.setFont(new Font("Calibri", Font.BOLD, 13));
		lblWeight.setBounds(919, 134, 64, 14);
		contentPane.add(lblWeight);
		
		JLabel lblCategory = new JLabel("CATEGORY");
		lblCategory.setFont(new Font("Calibri", Font.BOLD, 13));
		lblCategory.setBounds(919, 168, 64, 14);
		contentPane.add(lblCategory);
		
		JLabel lblEXPDate = new JLabel("EXP DATE");
		lblEXPDate.setFont(new Font("Calibri", Font.BOLD, 13));
		lblEXPDate.setBounds(919, 205, 56, 14);
		contentPane.add(lblEXPDate);
		
		JLabel lblProductsList = new JLabel("PRODUCTS LIST");
		lblProductsList.setHorizontalAlignment(SwingConstants.LEFT);
		lblProductsList.setForeground(new Color(101, 153, 255));
		lblProductsList.setFont(new Font("Calibri", Font.BOLD, 16));
		lblProductsList.setBounds(30, 275, 799, 28);
		contentPane.add(lblProductsList);
		
		textName = new JTextField();
		textName.setFont(new Font("Calibri", Font.PLAIN, 13));
		textName.setColumns(10);
		textName.setBounds(699, 131, 180, 20);
		contentPane.add(textName);
		
		textSupID = new JTextField();
		textSupID.setFont(new Font("Calibri", Font.PLAIN, 13));
		textSupID.setColumns(10);
		textSupID.setBounds(699, 94, 180, 20);
		contentPane.add(textSupID);
		
		textPrice = new JTextField();
		textPrice.setFont(new Font("Calibri", Font.PLAIN, 13));
		textPrice.setColumns(10);
		textPrice.setBounds(699, 165, 180, 20);
		contentPane.add(textPrice);
		
		textQty = new JTextField();
		textQty.setFont(new Font("Calibri", Font.PLAIN, 13));
		textQty.setColumns(10);
		textQty.setBounds(699, 202, 180, 20);
		contentPane.add(textQty);
		
		textDetails = new JTextField();
		textDetails.setFont(new Font("Calibri", Font.PLAIN, 13));
		textDetails.setColumns(10);
		textDetails.setBounds(1022, 94, 180, 20);
		contentPane.add(textDetails);
		
		textWeight = new JTextField();
		textWeight.setFont(new Font("Calibri", Font.PLAIN, 13));
		textWeight.setColumns(10);
		textWeight.setBounds(1022, 131, 180, 20);
		contentPane.add(textWeight);
		
		textCategory = new JTextField();
		textCategory.setFont(new Font("Calibri", Font.PLAIN, 13));
		textCategory.setColumns(10);
		textCategory.setBounds(1022, 165, 180, 20);
		contentPane.add(textCategory);
		
		textEXPdate = new JTextField();
		textEXPdate.setFont(new Font("Calibri", Font.PLAIN, 13));
		textEXPdate.setColumns(10);
		textEXPdate.setBounds(1021, 202, 180, 20);
		contentPane.add(textEXPdate);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("KG HAPPY Solid", Font.BOLD, 11));
		btnAdd.setBackground(new Color(101, 153, 255));
		btnAdd.setBounds(865, 251, 89, 23);
		contentPane.add(btnAdd);
		
		//action when user click the "ADD" button
		btnAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int success = -1;
				
				Product product = new Product();
				product.setSupplierID(textSupID.getText());
				product.setName(textName.getText());
				product.setPrice(textPrice.getText());
				product.setStock_qty(textQty.getText());
				product.setDetails(textDetails.getText());
				product.setWeight(textWeight.getText());
				product.setCategory(textCategory.getText());
				product.setExpdate(textEXPdate.getText());
				
				UserController productController = new UserController();
					
				try
				{	
					productController.addProduct(product);					
				}
				catch (Exception e1)
				{		
					success = 1;
					System.out.println(e1.getMessage());
				}
				
				if(success < 0)
				{
					JOptionPane.showMessageDialog(null, "Successfully add a new product.");
					M_ProductsGUI_Ad frame = new M_ProductsGUI_Ad();
					frame.setVisible(true);
					dispose();
				}
				else 	
				{
					JOptionPane.showMessageDialog(null, "Please try again.");
					textSupID.setText("");
					textName.setText("");
					textPrice.setText("");
					textQty.setText("");
					textDetails.setText("");
					textWeight.setText("");
					textCategory.setText("");
					textEXPdate.setText("");
				}
			}
		});
		//**********************************************************************
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("KG HAPPY Solid", Font.BOLD, 11));
		btnUpdate.setBackground(new Color(101, 153, 255));
		btnUpdate.setBounds(765, 251, 89, 23);
		contentPane.add(btnUpdate);
		
		//action when user click the "Update" button
		btnUpdate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int success = -1;
				
				Product product = new Product();
				product.setSupplierID(textSupID.getText());
				product.setName(textName.getText());
				product.setPrice(textPrice.getText());
				product.setStock_qty(textQty.getText());
				product.setDetails(textDetails.getText());
				product.setWeight(textWeight.getText());
				product.setCategory(textCategory.getText());
				product.setExpdate(textEXPdate.getText());
				product.setProductID(textID.getText());
				
				UserController productController = new UserController();
					
				try
				{	
					productController.updateProduct(product);					
				}
				catch (Exception e1)
				{		
					success = 1;
					System.out.println(e1.getMessage());
				}
				
				if(success < 0)
				{
					JOptionPane.showMessageDialog(null, "Successfully update a new product.");
					M_ProductsGUI_Ad frame = new M_ProductsGUI_Ad();
					frame.setVisible(true);
					dispose();
				}
				else 	
				{
					JOptionPane.showMessageDialog(null, "Please try again.");
					textSupID.setText("");
					textName.setText("");
					textPrice.setText("");
					textQty.setText("");
					textDetails.setText("");
					textWeight.setText("");
					textCategory.setText("");
					textEXPdate.setText("");
					textID.setText("");
				}
			}
		});
		
		
		//**********************************************************************
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("KG HAPPY Solid", Font.BOLD, 12));
		btnBack.setBackground(new Color(101, 153, 255));
		btnBack.setBounds(1144, 527, 80, 23);
		contentPane.add(btnBack);
		
		//action when user click the "Back" button
		btnBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				AdminPageGUI frame = new AdminPageGUI();
				frame.setVisible(true);
				dispose();
			}
		});
		
		
		JScrollPane scrollPaneProduct = new JScrollPane();
		scrollPaneProduct.setViewportBorder(null);
		scrollPaneProduct.setBounds(30, 304, 883, 207);
		contentPane.add(scrollPaneProduct);
		
		
		tableProducts = new JTable();
		showInfoProduct();
		tableProducts.getColumnModel().getColumn(0).setPreferredWidth(32);
		tableProducts.getColumnModel().getColumn(1).setPreferredWidth(32);
		tableProducts.getColumnModel().getColumn(2).setPreferredWidth(150);
		tableProducts.getColumnModel().getColumn(3).setPreferredWidth(28);
		tableProducts.getColumnModel().getColumn(4).setPreferredWidth(15);
		tableProducts.getColumnModel().getColumn(5).setPreferredWidth(130);
		tableProducts.getColumnModel().getColumn(6).setPreferredWidth(28);
		tableProducts.getColumnModel().getColumn(7).setPreferredWidth(94);
		scrollPaneProduct.setViewportView(tableProducts);
		
		JLabel lblSupplierId = new JLabel("SUPPLIER ID");
		lblSupplierId.setFont(new Font("Calibri", Font.BOLD, 13));
		lblSupplierId.setBounds(624, 97, 80, 14);
		contentPane.add(lblSupplierId);
		
		JScrollPane scrollPaneSupplier = new JScrollPane();
		scrollPaneSupplier.setViewportBorder(null);
		scrollPaneSupplier.setBounds(30, 94, 532, 154);
		contentPane.add(scrollPaneSupplier);
		
		tableSuppliers = new JTable();
		showInfoSupplier();
		tableSuppliers.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableSuppliers.getColumnModel().getColumn(1).setPreferredWidth(160);
		tableSuppliers.getColumnModel().getColumn(2).setPreferredWidth(170);
		tableSuppliers.getColumnModel().getColumn(3).setPreferredWidth(75);
		scrollPaneSupplier.setViewportView(tableSuppliers);
		
		JLabel lblSupplierList = new JLabel("SUPPLIERS LIST");
		lblSupplierList.setHorizontalAlignment(SwingConstants.LEFT);
		lblSupplierList.setForeground(new Color(101, 153, 255));
		lblSupplierList.setFont(new Font("Calibri", Font.BOLD, 16));
		lblSupplierList.setBounds(30, 68, 532, 28);
		contentPane.add(lblSupplierList);
		
		JLabel lblDateFormat = new JLabel("(YYYY-MM-DD)");
		lblDateFormat.setFont(new Font("Calibri", Font.BOLD, 13));
		lblDateFormat.setBounds(919, 218, 89, 14);
		contentPane.add(lblDateFormat);
		
		JLabel lblAddNewProduct = new JLabel("ADD NEW PRODUCT");
		lblAddNewProduct.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddNewProduct.setForeground(new Color(101, 153, 255));
		lblAddNewProduct.setFont(new Font("Calibri", Font.BOLD, 16));
		lblAddNewProduct.setBounds(624, 57, 578, 28);
		contentPane.add(lblAddNewProduct);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("KG HAPPY Solid", Font.BOLD, 11));
		btnDelete.setBackground(new Color(101, 153, 255));
		btnDelete.setBounds(665, 251, 89, 23);
		contentPane.add(btnDelete);
		
		//action when user click the "DELETE" button
		btnDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int success = -1;

				Product productID = new Product();
				productID.setProductID(textID.getText());
				UserController productIDController = new UserController();
				
				try
				{	
					
					productIDController.deleteProduct(productID);					
				}
				catch (Exception e1)
				{		
					success = 1;
					System.out.println(e1.getMessage());
				}
				
				if(success < 0)
				{
					JOptionPane.showMessageDialog(null, "Successfully delete a product.");
					M_ProductsGUI_Ad frame = new M_ProductsGUI_Ad();
					frame.setVisible(true);
					dispose();
				}
				else 	
				{
					JOptionPane.showMessageDialog(null, "Please try again.");
					textID.setText("");
				}
			}
		});
		
		
		
		//************************************************************************
		
		
		
		
		
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("KG HAPPY Solid", Font.BOLD, 11));
		btnSearch.setBackground(new Color(101, 153, 255));
		btnSearch.setBounds(565, 251, 89, 23);
		contentPane.add(btnSearch);
		
		
		//action when user click the "SEARCH" button
		btnSearch.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						
						
						
						int success = -1;
						
						Product productName = new Product();
						productName.setName(textName.getText());
						UserController productNameController = new UserController();
						
						

						try
						{	
							 productNameController.findProduct(productName);
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/supermarket","root","");
							PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("Select * from product");

							ResultSet rs = preparedStatement.executeQuery();
							
							
							
							
							
							 while (rs.next()) {
								
								    
								    textName.setText(rs.getString("Pname"));
				                    textSupID.setText(rs.getString("SupID"));
				 					textPrice.setText(rs.getString("Pprice"));
				 					textQty.setText(rs.getString("PstockQty"));
				 					textDetails.setText(rs.getString("Pdetails"));
				 					textWeight.setText(rs.getString("Pweight"));
				 					textCategory.setText(rs.getString("Pcat"));
				 					textEXPdate.setText(rs.getString("PExpDate"));
								   
								    
								   System.out.println("textName.getText() : " + textName.getText());
								  }
							
							
							
							
												
						}
						catch (Exception e1)
						{		
							success = 1;
							System.out.println(e1.getMessage());
						}
						
						if(success < 0)
						{
							JOptionPane.showMessageDialog(null, "Successfully found a product.");
							M_ProductsGUI_Ad frame = new M_ProductsGUI_Ad();
							frame.setVisible(true);
							dispose();
						}
						else 	
						{
							JOptionPane.showMessageDialog(null, "Please try again.");
							textID.setText("");
						}
					}
				});
      
		
		//************************************************************************
		
		textID = new JTextField();
		textID.setFont(new Font("Calibri", Font.PLAIN, 13));
		textID.setColumns(10);
		textID.setBounds(1022, 343, 180, 20);
		contentPane.add(textID);
		
		JLabel lblProductId = new JLabel("PRODUCT ID");
		lblProductId.setFont(new Font("Calibri", Font.BOLD, 13));
		lblProductId.setBounds(947, 346, 80, 14);
		contentPane.add(lblProductId);
		
		JLabel lblDeleteupdateByProduct = new JLabel("BY PRODUCT ID");
		lblDeleteupdateByProduct.setHorizontalAlignment(SwingConstants.LEFT);
		lblDeleteupdateByProduct.setForeground(new Color(101, 153, 255));
		lblDeleteupdateByProduct.setFont(new Font("Calibri", Font.BOLD, 16));
		lblDeleteupdateByProduct.setBounds(947, 304, 254, 28);
		contentPane.add(lblDeleteupdateByProduct);
	};
	
		//SUPPLIER TABLE
		//get data from the database
		public ArrayList<String[]> getInfoSupplier()
		{
			String[] data = new String[5];
			ArrayList<String[]> supplierInfo = new ArrayList<>();
			try
			{
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/supermarket","root","");
				PreparedStatement select = (PreparedStatement) conn.prepareStatement("Select * from supplier");

				ResultSet result = select.executeQuery();
					   
				while(result.next())
				{
					data[0] = result.getString("SupID");
					data[1] = result.getString("SupName");
					data[2] = result.getString("SupAddress");
					data[3] = result.getString("SupPhone");
							   
					supplierInfo.add(data);
					data = new String [4];
				}
			  }
					 
			  catch (Exception e)
			  {
					System.out.println(e.getMessage());
			  }

			   		return supplierInfo;
		}

		//SUPPLIER LIST
		//show data from the database
		public void showInfoSupplier()
		{
			ArrayList<String[]> supplierList = getInfoSupplier();
			model = (DefaultTableModel) tableSuppliers.getModel();
			
			Object[] column = { "Supplier ID", "Name", "Address", "Phone no."};//title for each column
			final Object[] row = new Object[4];//4 column for each row
			model.setColumnIdentifiers(column);
			tableSuppliers.setModel(model);
			
			//add all data in the ArrayList to the tableSuppliers
			for (int i = 0; i < supplierList.size(); i++)
			{
				row[0] = supplierList.get(i)[0];
				row[1] = supplierList.get(i)[1];
				row[2] = supplierList.get(i)[2];
				row[3] = supplierList.get(i)[3];
							  
				model.addRow(row);
			}	
		}

		
		//PRODUCT TABLE
		//get data from the database
		public ArrayList<String[]> getInfoProduct()
		{
			String[] data = new String[9];
			ArrayList<String[]> productInfo = new ArrayList<>();
			try
			{
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/supermarket","root","");
				PreparedStatement select = (PreparedStatement) conn.prepareStatement("Select * from product");

				ResultSet result = select.executeQuery();
					   
				while(result.next())
				{
					data[0] = result.getString("PID");
					data[1] = result.getString("SupID");
					data[2] = result.getString("Pname");
					data[3] = result.getString("Pprice");
					data[4] = result.getString("PstockQty");
					data[5] = result.getString("Pdetails");
					data[6] = result.getString("Pweight");
					data[7] = result.getString("Pcat");
					data[8] = result.getString("PExpDate");
					
					productInfo.add(data);
					data = new String [9];
				}
			}
					 
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}

				return productInfo;
		}
		
		//PRODUCT LIST
		//show data from the database
		public void showInfoProduct()
		{
			ArrayList<String[]> productList = getInfoProduct();
			model = (DefaultTableModel) tableProducts.getModel();
			
			Object[] column = { "Product ID", "Supplier ID", "Name",  "Price (RM)", "Qty", "Details", "Weight (g)", "Category", "EXPDate"};//title for each column
			final Object[] row = new Object[9];//9 column for each row
			model.setColumnIdentifiers(column);
			tableProducts.setModel(model);
			
			//add all data in the ArrayList to the tableProducts
			for (int i = 0; i < productList.size(); i++)
			{
				row[0] = productList.get(i)[0];
				row[1] = productList.get(i)[1];
				row[2] = productList.get(i)[2];
				row[3] = productList.get(i)[3];
				row[4] = productList.get(i)[4];
				row[5] = productList.get(i)[5];
				row[6] = productList.get(i)[6];
				row[7] = productList.get(i)[7];
				row[8] = productList.get(i)[8];
				
				model.addRow(row);
			}
		}
	}
