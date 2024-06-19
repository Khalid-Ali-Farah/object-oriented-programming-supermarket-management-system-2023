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
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;
import database.ShopDatabase;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controller.UserController;

public class M_StaffsGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textUsername;
	private JTextField textAge;
	private JTextField textPhoneNo;
	private JPasswordField textPassword;
	private JTable tableStaffs;
	DefaultTableModel model;
	private JTextField textEmail;
	private JTextField textID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					M_StaffsGUI frame = new M_StaffsGUI();
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
	public M_StaffsGUI()
	{
		setTitle("Pet Shop Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 75, 749, 611);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 13));
		lblUsername.setBounds(393, 94, 64, 14);
		contentPane.add(lblUsername);
		
		JLabel lblAge = new JLabel("AGE");
		lblAge.setFont(new Font("Calibri", Font.BOLD, 13));
		lblAge.setBounds(393, 131, 46, 14);
		contentPane.add(lblAge);
		
		JLabel lblPhoneNo = new JLabel("PHONE NO.");
		lblPhoneNo.setFont(new Font("Calibri", Font.BOLD, 13));
		lblPhoneNo.setBounds(393, 170, 64, 14);
		contentPane.add(lblPhoneNo);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Calibri", Font.BOLD, 13));
		lblEmail.setBounds(393, 245, 64, 14);
		contentPane.add(lblEmail);
		
		JLabel lblStaffsList = new JLabel("STAFFS LIST");
		lblStaffsList.setHorizontalAlignment(SwingConstants.LEFT);
		lblStaffsList.setForeground(new Color(101, 153, 255));
		lblStaffsList.setFont(new Font("Calibri", Font.BOLD, 16));
		lblStaffsList.setBounds(24, 309, 677, 28);
		contentPane.add(lblStaffsList);
		
		textUsername = new JTextField();
		textUsername.setFont(new Font("Calibri", Font.PLAIN, 13));
		textUsername.setColumns(10);
		textUsername.setBounds(467, 91, 234, 20);
		contentPane.add(textUsername);
		
		textAge = new JTextField();
		textAge.setFont(new Font("Calibri", Font.PLAIN, 13));
		textAge.setColumns(10);
		textAge.setBounds(467, 128, 234, 20);
		contentPane.add(textAge);
		
		textPhoneNo = new JTextField();
		textPhoneNo.setFont(new Font("Calibri", Font.PLAIN, 13));
		textPhoneNo.setColumns(10);
		textPhoneNo.setBounds(467, 167, 234, 20);
		contentPane.add(textPhoneNo);
		
		textPassword = new JPasswordField();
		textPassword.setFont(new Font("Calibri", Font.PLAIN, 13));
		textPassword.setColumns(10);
		textPassword.setBounds(467, 205, 234, 20);
		contentPane.add(textPassword);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Calibri", Font.PLAIN, 13));
		textEmail.setColumns(10);
		textEmail.setBounds(467, 240, 234, 20);
		contentPane.add(textEmail);		
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("KG HAPPY Solid", Font.BOLD, 11));
		btnAdd.setBackground(new Color(101, 153, 255));
		btnAdd.setBounds(537, 275, 89, 23);
		contentPane.add(btnAdd);
		
		//action when user click the "ADD" button
		btnAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int success = -1;

				Staff staff = new Staff();
				staff.setUsername(textUsername.getText());
				staff.setAge(textAge.getText());
				staff.setPhoneno(textPhoneNo.getText());
				String password = new String(textPassword.getPassword()).trim();
				staff.setPassword(password);
				staff.setEmail(textEmail.getText());
				UserController staffController = new UserController();
					
				try
				{	
					staffController.addStaff(staff);					
				}
				catch (Exception e1)
				{		
					success = 1;
					System.out.println(e1.getMessage());
				}
				
				if(success < 0)
				{
					JOptionPane.showMessageDialog(null, "Successfully add a new staff.");
					M_StaffsGUI frame = new M_StaffsGUI();
					frame.setVisible(true);
					dispose();

				}
				else 	
				{
					JOptionPane.showMessageDialog(null, "Please try again.");
					textUsername.setText("");
					textAge.setText("");
					textPhoneNo.setText("");
					textPassword.setText("");
					textEmail.setText("");
				}
			}
		});
		
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("KG HAPPY Solid", Font.BOLD, 11));
		btnDelete.setBackground(new Color(101, 153, 255));
		btnDelete.setBounds(159, 125, 89, 23);
		contentPane.add(btnDelete);
		
		
		//action when user click the "DELETE" button
		btnDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int success = -1;

				Staff staffID = new Staff();
				staffID.setStaffID(textID.getText());
				UserController staffIDController = new UserController();
				
				try
				{	
					
					staffIDController.deleteStaff(staffID);					
				}
				catch (Exception e1)
				{		
					success = 1;
					System.out.println(e1.getMessage());
				}
				
				if(success < 0)
				{
					JOptionPane.showMessageDialog(null, "Successfully delete a staff.");
					M_StaffsGUI frame = new M_StaffsGUI();
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
		
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 13));
		lblPassword.setBounds(393, 208, 64, 14);
		contentPane.add(lblPassword);
		
		
		
		JLabel lblManageStaffs = new JLabel("Manage Staffs");
		lblManageStaffs.setHorizontalAlignment(SwingConstants.CENTER);
		lblManageStaffs.setForeground(new Color(101, 153, 255));
		lblManageStaffs.setFont(new Font("KG HAPPY Solid", Font.BOLD, 20));
		lblManageStaffs.setBounds(0, 0, 733, 46);
		contentPane.add(lblManageStaffs);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("KG HAPPY Solid", Font.BOLD, 12));
		btnBack.setBackground(new Color(101, 153, 255));
		btnBack.setBounds(643, 542, 80, 23);
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
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(24, 337, 677, 194);
		contentPane.add(scrollPane);
		
		tableStaffs = new JTable();
		showInfo();
		tableStaffs.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableStaffs.getColumnModel().getColumn(1).setPreferredWidth(95);
		tableStaffs.getColumnModel().getColumn(2).setPreferredWidth(32);
		tableStaffs.getColumnModel().getColumn(3).setPreferredWidth(102);
		tableStaffs.getColumnModel().getColumn(4).setPreferredWidth(70);
		tableStaffs.getColumnModel().getColumn(5).setPreferredWidth(100);
		scrollPane.setViewportView(tableStaffs);
		
		textID = new JTextField();
		textID.setFont(new Font("Calibri", Font.PLAIN, 13));
		textID.setColumns(10);
		textID.setBounds(99, 91, 234, 20);
		contentPane.add(textID);
		
		JLabel lblStaffId = new JLabel("STAFF ID");
		lblStaffId.setFont(new Font("Calibri", Font.BOLD, 13));
		lblStaffId.setBounds(24, 94, 80, 14);
		contentPane.add(lblStaffId);
		
		JLabel lblDeleteupdateBy = new JLabel("DELETE BY STAFF ID");
		lblDeleteupdateBy.setHorizontalAlignment(SwingConstants.LEFT);
		lblDeleteupdateBy.setForeground(new Color(101, 153, 255));
		lblDeleteupdateBy.setFont(new Font("Calibri", Font.BOLD, 16));
		lblDeleteupdateBy.setBounds(24, 56, 310, 28);
		contentPane.add(lblDeleteupdateBy);
		
		JLabel lblAddNewStaff = new JLabel("ADD NEW STAFF");
		lblAddNewStaff.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddNewStaff.setForeground(new Color(101, 153, 255));
		lblAddNewStaff.setFont(new Font("Calibri", Font.BOLD, 16));
		lblAddNewStaff.setBounds(391, 56, 310, 28);
		contentPane.add(lblAddNewStaff);
		};
		
		
		//get data from the database
		public ArrayList<String[]> getInfo()
		{
			 String[] data = new String[6];
			 ArrayList<String[]> staffInfo = new ArrayList<>();
			 try
			 {
				 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/supermarket","root","");
				 PreparedStatement select = (PreparedStatement) conn.prepareStatement("Select * from staff");

			     ResultSet result = select.executeQuery();
			   
				  while(result.next())
				  {
					   data[0] = result.getString("StaID");
					   data[1] = result.getString("StaUsername");
					   data[2] = result.getString("StaAge");
					   data[3] = result.getString("StaPhone");
					   data[4] = result.getString("StaPass");
					   data[5] = result.getString("StaEmail");
					   
					   staffInfo.add(data);
					   data = new String [6];
				  }
			 }
			 
			 catch (Exception e)
			 {
				 System.out.println(e.getMessage());
			 }

			 return staffInfo;
	   }

			public void showInfo()
			{
				 ArrayList<String[]> staffList = getInfo();
				 model = (DefaultTableModel) tableStaffs.getModel();
	
				 Object[] column = { "Staff ID", "Username", "Age", "Phone no.", "Password", "Email"};//title for each column
				 final Object[] row = new Object[6];//6 column for each row
				 model.setColumnIdentifiers(column);
				 tableStaffs.setModel(model);
	
				 //add all data in the ArrayList to the tableStaffs
				 for (int i = 0; i < staffList.size(); i++)
				 {
					  row[0] = staffList.get(i)[0];
					  row[1] = staffList.get(i)[1];
					  row[2] = staffList.get(i)[2];
					  row[3] = staffList.get(i)[3];
					  row[4] = staffList.get(i)[4];
					  row[5] = staffList.get(i)[5];
					  
					  model.addRow(row);
				 }
		}
}
