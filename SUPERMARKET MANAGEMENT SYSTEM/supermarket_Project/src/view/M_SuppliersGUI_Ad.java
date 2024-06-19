package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import database.ShopDatabase;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controller.UserController;

public class M_SuppliersGUI_Ad extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textAddress;
	private JTextField textPhoneNo;
	private JTable tableSuppliers;
	DefaultTableModel model;
	private JTextField textID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					M_SuppliersGUI_Ad frame = new M_SuppliersGUI_Ad();
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
	public M_SuppliersGUI_Ad()
	{
		setTitle("Pet Shop Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 730, 525);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Calibri", Font.BOLD, 13));
		lblName.setBounds(31, 96, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Calibri", Font.BOLD, 13));
		lblAddress.setBounds(31, 127, 64, 14);
		contentPane.add(lblAddress);
		
		JLabel lblPhoneNo = new JLabel("PHONE NO.");
		lblPhoneNo.setFont(new Font("Calibri", Font.BOLD, 13));
		lblPhoneNo.setBounds(31, 157, 64, 14);
		contentPane.add(lblPhoneNo);
		
		JLabel lblStaffsList = new JLabel("SUPPLIERS LIST");
		lblStaffsList.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaffsList.setForeground(new Color(101, 153, 255));
		lblStaffsList.setFont(new Font("Calibri", Font.BOLD, 16));
		lblStaffsList.setBounds(31, 224, 650, 28);
		contentPane.add(lblStaffsList);
		
		textName = new JTextField();
		textName.setFont(new Font("Calibri", Font.PLAIN, 13));
		textName.setColumns(10);
		textName.setBounds(105, 93, 230, 20);
		contentPane.add(textName);
		
		textAddress = new JTextField();
		textAddress.setFont(new Font("Calibri", Font.PLAIN, 13));
		textAddress.setColumns(10);
		textAddress.setBounds(105, 124, 230, 20);
		contentPane.add(textAddress);
		
		textPhoneNo = new JTextField();
		textPhoneNo.setFont(new Font("Calibri", Font.PLAIN, 13));
		textPhoneNo.setColumns(10);
		textPhoneNo.setBounds(105, 154, 230, 20);
		contentPane.add(textPhoneNo);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("KG HAPPY Solid", Font.BOLD, 12));
		btnBack.setBackground(new Color(101, 153, 255));
		btnBack.setBounds(624, 456, 80, 23);
		contentPane.add(btnBack);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("KG HAPPY Solid", Font.BOLD, 11));
		btnAdd.setBackground(new Color(101, 153, 255));
		btnAdd.setBounds(172, 186, 89, 23);
		contentPane.add(btnAdd);
		
		//action when user click the "ADD" button
		btnAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int success = -1;

				Supplier supplier = new Supplier();
				supplier.setName(textName.getText());
				supplier.setAddress(textAddress.getText());
				supplier.setPhoneno(textPhoneNo.getText());
				UserController supplierController = new UserController();
					
				try
				{	
					supplierController.addSupplier(supplier);					
				}
				catch (Exception e1)
				{		
					success = 1;
					System.out.println(e1.getMessage());
				}
				
				if(success < 0)
				{
					JOptionPane.showMessageDialog(null, "Successfully add a new supplier.");
					M_SuppliersGUI_Ad frame = new M_SuppliersGUI_Ad();
					frame.setVisible(true);
					dispose();
				}
				else 	
				{
					JOptionPane.showMessageDialog(null, "Please try again.");
					textName.setText("");
					textAddress.setText("");
					textPhoneNo.setText("");
				}
			}
		});
		
		JLabel lblManageSuppliers = new JLabel("Manage Suppliers");
		lblManageSuppliers.setHorizontalAlignment(SwingConstants.CENTER);
		lblManageSuppliers.setForeground(new Color(101, 153, 255));
		lblManageSuppliers.setFont(new Font("KG HAPPY Solid", Font.BOLD, 20));
		lblManageSuppliers.setBounds(0, 0, 714, 46);
		contentPane.add(lblManageSuppliers);
		
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
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(31, 253, 650, 192);
		contentPane.add(scrollPane);
		
		tableSuppliers = new JTable();
		showInfo();
		tableSuppliers.getColumnModel().getColumn(0).setPreferredWidth(40);
		tableSuppliers.getColumnModel().getColumn(1).setPreferredWidth(160);
		tableSuppliers.getColumnModel().getColumn(2).setPreferredWidth(170);
		tableSuppliers.getColumnModel().getColumn(3).setPreferredWidth(75);
		scrollPane.setViewportView(tableSuppliers);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("KG HAPPY Solid", Font.BOLD, 11));
		btnDelete.setBackground(new Color(101, 153, 255));
		btnDelete.setBounds(508, 138, 89, 23);
		contentPane.add(btnDelete);
		
		//action when user click the "DELETE" button
		btnDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int success = -1;

				Supplier supplierID = new Supplier();
				supplierID.setSupplierID(textID.getText());
				UserController supplierIDController1 = new UserController();
				UserController supplierIDController2 = new UserController();
				
				try
				{	
					
					supplierIDController1.deleteSupplier(supplierID);	
					supplierIDController2.deleteProductbySupID(supplierID);
					
				}
				catch (Exception e1)
				{		
					success = 1;
					System.out.println(e1.getMessage());
				}
				
				if(success < 0)
				{
					JOptionPane.showMessageDialog(null, "Successfully delete a supplier.");
					M_SuppliersGUI_Ad frame = new M_SuppliersGUI_Ad();
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
		
		
		textID = new JTextField();
		textID.setFont(new Font("Calibri", Font.PLAIN, 13));
		textID.setColumns(10);
		textID.setBounds(451, 96, 230, 20);
		contentPane.add(textID);
		
		JLabel lblSupplierId = new JLabel("SUPPLIER ID");
		lblSupplierId.setFont(new Font("Calibri", Font.BOLD, 13));
		lblSupplierId.setBounds(376, 99, 80, 14);
		contentPane.add(lblSupplierId);
		
		JLabel lblDeleteBySupplierID = new JLabel("DELETE BY SUPPLIER ID");
		lblDeleteBySupplierID.setHorizontalAlignment(SwingConstants.LEFT);
		lblDeleteBySupplierID.setForeground(new Color(101, 153, 255));
		lblDeleteBySupplierID.setFont(new Font("Calibri", Font.BOLD, 16));
		lblDeleteBySupplierID.setBounds(376, 57, 254, 28);
		contentPane.add(lblDeleteBySupplierID);
		
		JLabel lblAddNewSupplier = new JLabel("ADD NEW SUPPLIER");
		lblAddNewSupplier.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddNewSupplier.setForeground(new Color(101, 153, 255));
		lblAddNewSupplier.setFont(new Font("Calibri", Font.BOLD, 16));
		lblAddNewSupplier.setBounds(31, 57, 305, 28);
		contentPane.add(lblAddNewSupplier);
	};
					
		
		//get data from the database
		public ArrayList<String[]> getInfo()
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

		//show data from the database
		public void showInfo()
		{
			ArrayList<String[]> supplierList = getInfo();
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
}
