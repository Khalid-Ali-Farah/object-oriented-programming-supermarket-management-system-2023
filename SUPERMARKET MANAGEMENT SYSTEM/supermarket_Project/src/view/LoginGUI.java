package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;

import controller.UserController;
import database.ShopDatabase;
import model.Staff;
import model.Admin;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textUsername;
	private JPasswordField textPassword;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		
		setTitle("Supermarket Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 500, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LoginLabel = new JLabel("Login");
		LoginLabel.setBounds(194, 21, 290, 31);
		LoginLabel.setForeground(new Color(101, 153, 255));
		LoginLabel.setFont(new Font("KG HAPPY Solid", Font.BOLD, 19));
		LoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(LoginLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(101, 153, 255));
		panel.setBounds(0, 0, 194, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel TitleLabel1 = new JLabel("Supermarket");
		TitleLabel1.setBounds(0, 160, 194, 19);
		panel.add(TitleLabel1);
		TitleLabel1.setForeground(new Color(255, 255, 255));
		TitleLabel1.setFont(new Font("KG HAPPY Solid", Font.BOLD, 12));
		TitleLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel TitleLabel2 = new JLabel("Management System");
		TitleLabel2.setBounds(0, 178, 194, 19);
		panel.add(TitleLabel2);
		TitleLabel2.setForeground(new Color(255, 255, 255));
		TitleLabel2.setFont(new Font("KG HAPPY Solid", Font.BOLD, 12));
		TitleLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbLogo = new JLabel("");
		lbLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbLogo.setIcon(new ImageIcon("C:\\Users\\kkala\\eclipse-workspace\\supermarket_Project\\image\\supermarkets3.png"));
		lbLogo.setBounds(0, 27, 194, 127);
		panel.add(lbLogo);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(new Color(101, 153, 255));
		lblUsername.setFont(new Font("KG HAPPY Solid", Font.BOLD, 12));
		lblUsername.setBounds(204, 92, 100, 19);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(new Color(101, 153, 255));
		lblPassword.setFont(new Font("KG HAPPY Solid", Font.BOLD, 12));
		lblPassword.setBounds(204, 134, 100, 19);
		contentPane.add(lblPassword);
		
		textUsername = new JTextField();
		textUsername.setBounds(303, 92, 154, 20);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JPasswordField();
		textPassword.setColumns(10);
		textPassword.setBounds(303, 134, 154, 20);
		contentPane.add(textPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("KG HAPPY Solid", Font.BOLD, 12));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(101, 153, 255));
		btnLogin.setBounds(236, 194, 100, 23);
		contentPane.add(btnLogin);
		
		//action when user click the "Login" button
		btnLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				int success = -1;
				
				String username = textUsername.getText();
				String password = new String(textPassword.getPassword()).trim();//make the password in * form
				
				Staff staff = new Staff();
				staff.setUsername(username);
				staff.setPassword(password);
				
				Admin admin = new Admin();
				admin.setUsername(username);
				admin.setPassword(password);
				
				UserController adminController = new UserController();
				UserController staffController = new UserController();
				
				
				try
				{
					success = adminController.doLogin(admin);
				}
				catch (ClassNotFoundException | SQLException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(success == 0)
				{
					JOptionPane.showMessageDialog(null, "Login Successful");
					AdminPageGUI frame = new AdminPageGUI();
					frame.setVisible(true);
					dispose();
					
				}
				else
				{
					try {
						success = staffController.doLogin(staff);
					}
					catch (ClassNotFoundException | SQLException e1)
					{
						e1.printStackTrace();
					}
					
					
					if(success == 1)
					{
						JOptionPane.showMessageDialog(null, "Login Successful");
						StaffPageGUI frame = new StaffPageGUI();
						frame.setVisible(true);
						dispose();
					} 
					
					else 
					{
							JOptionPane.showMessageDialog(null, "Wrong Username or Password!");
							textUsername.setText("");
							textPassword.setText("");
					}
				}
			}			
		});
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("KG HAPPY Solid", Font.BOLD, 12));
		btnCancel.setBackground(new Color(101, 153, 255));
		btnCancel.setBounds(357, 195, 100, 23);
		contentPane.add(btnCancel);
		
		//action when user click the "Cancel" button
		btnCancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Object LoginPage = newJFrame("Cancel");
				
				if (JOptionPane.showConfirmDialog((Component) LoginPage, "Confirm to cancel", "Login Page",
				JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);//exit the system
				}
			}

			private Object newJFrame(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		});
	}
}
