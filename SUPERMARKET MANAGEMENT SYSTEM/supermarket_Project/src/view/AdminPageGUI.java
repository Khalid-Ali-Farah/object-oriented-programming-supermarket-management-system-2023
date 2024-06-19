package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPageGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try 
				{
					AdminPageGUI frame = new AdminPageGUI();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminPageGUI()
	{	
		setTitle("Supermarket Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(380, 100, 730, 525);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblManageProduct = new JLabel("Welcome to");
		lblManageProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblManageProduct.setForeground(new Color(101, 153, 255));
		lblManageProduct.setFont(new Font("KG HAPPY Solid", Font.BOLD, 28));
		lblManageProduct.setBounds(0, 25, 714, 31);
		contentPane.add(lblManageProduct);
		
		JLabel lblSupermarketManagement = new JLabel("Supermarket Management System");
		lblSupermarketManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupermarketManagement.setForeground(new Color(101, 153, 255));
		lblSupermarketManagement.setFont(new Font("KG HAPPY Solid", Font.BOLD, 28));
		lblSupermarketManagement.setBounds(0, 67, 714, 31);
		contentPane.add(lblSupermarketManagement);
		
		JLabel lblShop = new JLabel("");
		lblShop.setHorizontalAlignment(SwingConstants.CENTER);
		lblShop.setIcon(new ImageIcon("C:\\Users\\kkala\\eclipse-workspace\\supermarket_Project\\image\\cart.png"));
		lblShop.setBounds(0, 132, 446, 308);
		contentPane.add(lblShop);
		
		JButton btnProduct = new JButton("Product");
		btnProduct.setForeground(Color.WHITE);
		btnProduct.setFont(new Font("KG HAPPY Solid", Font.BOLD, 18));
		btnProduct.setBackground(new Color(101, 153, 255));
		btnProduct.setBounds(446, 186, 183, 37);
		contentPane.add(btnProduct);
		
		//action when user click the "Product" button
		btnProduct.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				M_ProductsGUI_Ad frame = new M_ProductsGUI_Ad();
				frame.setVisible(true);
				dispose();
			}
		});
		
		
		JButton btnStaff = new JButton("Staff");
		btnStaff.setForeground(Color.WHITE);
		btnStaff.setFont(new Font("KG HAPPY Solid", Font.BOLD, 18));
		btnStaff.setBackground(new Color(101, 153, 255));
		btnStaff.setBounds(446, 243, 183, 37);
		contentPane.add(btnStaff);
		
		//action when user click the "Staff" button
		btnStaff.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				M_StaffsGUI frame = new M_StaffsGUI();
				frame.setVisible(true);
				dispose();
			}
		});
		
		
		JButton btnSupplier = new JButton("Supplier");
		btnSupplier.setForeground(Color.WHITE);
		btnSupplier.setFont(new Font("KG HAPPY Solid", Font.BOLD, 18));
		btnSupplier.setBackground(new Color(101, 153, 255));
		btnSupplier.setBounds(446, 307, 183, 37);
		contentPane.add(btnSupplier);
		
		//action when user click the "Supplier" button
		btnSupplier.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				M_SuppliersGUI_Ad frame = new M_SuppliersGUI_Ad();
				frame.setVisible(true);
				dispose();
			}
		});
		
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("KG HAPPY Solid", Font.BOLD, 18));
		btnLogout.setBackground(new Color(101, 153, 255));
		btnLogout.setBounds(446, 365, 183, 37);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("- ADMIN PAGE -");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("KG HAPPY Solid", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 119, 714, 14);
		contentPane.add(lblNewLabel);
		
		//action when user click the "Logout" button
		btnLogout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				LoginGUI frame = new LoginGUI();
				frame.setVisible(true);
				dispose();
			}
		});
	}
}
