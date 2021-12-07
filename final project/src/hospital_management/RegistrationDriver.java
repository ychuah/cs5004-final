package hospital_management;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.border.BevelBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class RegistrationDriver extends JFrame{

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	private String[] userRole = {"Doctor/Nurse", "Adminstrator", "Patient"};
	private String[] hospitalName = {"Test Hospital"};
	
	/**
	 * Create the application.
	 */
	public RegistrationDriver() {
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 416, 243);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_loginPage = new JLabel("Login Page");
		lbl_loginPage.setFont(new Font("Lucida Bright", Font.BOLD, 16));
		lbl_loginPage.setBounds(160, 10, 100, 20);
		panel.add(lbl_loginPage);
		
		JLabel lbl_userRole = new JLabel("User Role: ");
		lbl_userRole.setBounds(97, 80, 69, 13);
		panel.add(lbl_userRole);
		
		JLabel lbl_userID = new JLabel("user ID* :");
		lbl_userID.setBounds(97, 103, 60, 13);
		panel.add(lbl_userID);
		
		JLabel lbl_note = new JLabel("*For healthcare employees only");
		lbl_note.setBounds(126, 206, 181, 13);
		panel.add(lbl_note);
		
		JLabel lbl_password = new JLabel("Password:");
		lbl_password.setBounds(97, 129, 60, 13);
		panel.add(lbl_password);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(176, 126, 110, 19);
		panel.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(176, 100, 110, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JComboBox<String> combo_userRole = new JComboBox<String>();
		for (int i = 0; i < userRole.length; i++) {
			combo_userRole.addItem(userRole[i]);
		}
		
		combo_userRole.setEditable(false);
		//comboBox.addActionListener(new ActionListener())
		combo_userRole.setBounds(176, 76, 110, 21);
		panel.add(combo_userRole);
		
		JButton btn_login = new JButton("Log-In");
		btn_login.setBounds(157, 156, 85, 21);
		panel.add(btn_login);
		
		JLabel lbl_hospitalName = new JLabel("Hospital:");
		lbl_hospitalName.setBounds(97, 57, 45, 13);
		panel.add(lbl_hospitalName);
		
		JComboBox<String> combo_hospitalName = new JComboBox<String>();
		for (int i = 0; i < hospitalName.length; i++) {
			combo_hospitalName.addItem(hospitalName[i]);
		}
		
		combo_hospitalName.setEditable(false);
		combo_hospitalName.setBounds(176, 53, 110, 21);
		panel.add(combo_hospitalName);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static void main(String[] args) {
		RegistrationDriver frame = new RegistrationDriver();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
