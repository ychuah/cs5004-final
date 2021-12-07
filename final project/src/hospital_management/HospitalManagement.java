package hospital_management;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

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
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

public class HospitalManagement extends JFrame {
	private JFrame frame;

	public HospitalManagement() {
		setTitle("Hospital Management System (for Administrators only)");
		
		getContentPane().setLayout(null);
		
		JPanel panel_hospital = new JPanel();
		panel_hospital.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, null, null));
		panel_hospital.setBounds(10, 10, 526, 231);
		getContentPane().add(panel_hospital);
		panel_hospital.setLayout(null);
		
		JLabel lbl_hospitalTitle = new JLabel("Hospital General Setting");
		lbl_hospitalTitle.setFont(new Font("Dubai Medium", Font.PLAIN, 16));
		lbl_hospitalTitle.setBounds(151, 10, 224, 25);
		panel_hospital.add(lbl_hospitalTitle);
				
		JRadioButton rdbtn_Yes = new JRadioButton("Yes");
		rdbtn_Yes.setSelected(true);
		rdbtn_Yes.setBounds(23, 62, 103, 21);
		panel_hospital.add(rdbtn_Yes);
		
		JRadioButton rdbtn_No = new JRadioButton("No");
		rdbtn_No.setBounds(23, 85, 103, 21);
		panel_hospital.add(rdbtn_No);
		
		ButtonGroup buttonGroupYN = new ButtonGroup();
		buttonGroupYN.add(rdbtn_Yes);
		buttonGroupYN.add(rdbtn_No);
		
		JLabel lbl_hospitalType = new JLabel("Hospital Type:");
		lbl_hospitalType.setBounds(22, 128, 149, 13);
		panel_hospital.add(lbl_hospitalType);
		
		JRadioButton rdbtn_government = new JRadioButton("Government Hospital");
		rdbtn_government.setSelected(true);
		rdbtn_government.setBounds(23, 147, 148, 21);
		panel_hospital.add(rdbtn_government);
		
		JRadioButton rdbtn_private = new JRadioButton("Private Hospital");
		rdbtn_private.setBounds(23, 170, 148, 21);
		panel_hospital.add(rdbtn_private);
		
		ButtonGroup buttonGrpType = new ButtonGroup();
		buttonGrpType.add(rdbtn_government);
		buttonGrpType.add(rdbtn_private);
		
		JLabel lbl_location = new JLabel("Location:");
		lbl_location.setBounds(290, 45, 64, 13);
		panel_hospital.add(lbl_location);
		
		JButton btn_update = new JButton("Update Hospital Status");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_update.setBounds(168, 200, 186, 21);
		panel_hospital.add(btn_update);
		
		JLabel lbl_covid = new JLabel("Accepting covid-related cases?");
		lbl_covid.setBounds(22, 45, 199, 13);
		panel_hospital.add(lbl_covid);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 248, 526, 318);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_hospitalCap = new JLabel("Hospital Capacity Management");
		lbl_hospitalCap.setBounds(150, 10, 200, 28);
		lbl_hospitalCap.setFont(new Font("Dubai", Font.PLAIN, 16));
		panel.add(lbl_hospitalCap);
		
		JLabel lbl_o2Tank = new JLabel("Oxygen Tanks Available:");
		lbl_o2Tank.setBounds(10, 195, 141, 13);
		panel.add(lbl_o2Tank);
		
		JButton btn_currentO2 = new JButton("Current # O2 Tanks");
		btn_currentO2.setBackground(UIManager.getColor("Button.highlight"));
		btn_currentO2.setBounds(27, 219, 154, 21);
		panel.add(btn_currentO2);
		
		JButton btn_addTank = new JButton("Add O2 Tank");
		btn_addTank.setBackground(UIManager.getColor("Button.highlight"));
		btn_addTank.setBounds(27, 243, 154, 21);
		panel.add(btn_addTank);
		
		JButton btnNewButton_2 = new JButton("Remove O2 Tank");
		btnNewButton_2.setBackground(UIManager.getColor("Button.highlight"));
		btnNewButton_2.setBounds(27, 268, 154, 21);
		panel.add(btnNewButton_2);
		
		JTextArea textArea_o2Tank = new JTextArea();
		textArea_o2Tank.setBackground(Color.PINK);
		textArea_o2Tank.setBounds(165, 195, 60, 15);
		panel.add(textArea_o2Tank);
		
		JLabel lbl_patientNum = new JLabel("Current number of patients: ");
		lbl_patientNum.setBounds(261, 195, 161, 13);
		panel.add(lbl_patientNum);
		
		JTextArea textArea_patientNum = new JTextArea();
		textArea_patientNum.setBackground(Color.PINK);
		textArea_patientNum.setBounds(432, 195, 60, 15);
		panel.add(textArea_patientNum);
		
		JButton btn_patients = new JButton("View/Edit List of Patients");
		btn_patients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientInfo pi = new PatientInfo();
				pi.setBounds(100, 100, 1200, 600);
				pi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				pi.setVisible(true);
			}
		});
		btn_patients.setBackground(UIManager.getColor("Button.highlight"));
		btn_patients.setBounds(271, 218, 171, 21);
		panel.add(btn_patients);
		
		JButton btn_removeDoctor = new JButton("remove doctor on shift");
		btn_removeDoctor.setBackground(UIManager.getColor("Button.highlight"));
		btn_removeDoctor.setBounds(70, 120, 171, 21);
		panel.add(btn_removeDoctor);
		
		JButton btn_addDoctor = new JButton("add doctor on shift");
		btn_addDoctor.setBackground(UIManager.getColor("Button.highlight"));
		btn_addDoctor.setBounds(70, 95, 171, 21);
		panel.add(btn_addDoctor);
		
		JButton btn_viewDocNurse = new JButton("View List of Doctors and Nurses");
		btn_viewDocNurse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				}
			});
		
		btn_viewDocNurse.setBackground(UIManager.getColor("Button.shadow"));
		btn_viewDocNurse.setBounds(126, 148, 245, 21);
		panel.add(btn_viewDocNurse);
		
		JLabel lbl_doctorNum = new JLabel("Number of doctors on shift:");
		lbl_doctorNum.setBounds(126, 48, 161, 13);
		panel.add(lbl_doctorNum);
		
		JTextArea textArea_doctorNum = new JTextArea();
		textArea_doctorNum.setBackground(Color.PINK);
		textArea_doctorNum.setBounds(290, 48, 60, 15);
		panel.add(textArea_doctorNum);
		
		JTextArea textArea_nurseNum = new JTextArea();
		textArea_nurseNum.setBackground(Color.PINK);
		textArea_nurseNum.setBounds(290, 70, 60, 15);
		panel.add(textArea_nurseNum);
		
		JLabel lbl_nurseNum = new JLabel("Number of nurses on shift:");
		lbl_nurseNum.setBounds(126, 70, 161, 13);
		panel.add(lbl_nurseNum);
		
		JButton btn_addNurse = new JButton("add doctor on shift");
		btn_addNurse.setBackground(UIManager.getColor("Button.highlight"));
		btn_addNurse.setBounds(251, 95, 171, 21);
		panel.add(btn_addNurse);
		
		JButton btn_removeNurse = new JButton("remove nurse on shift");
		btn_removeNurse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_removeNurse.setBackground(UIManager.getColor("Button.highlight"));
		btn_removeNurse.setBounds(251, 120, 171, 21);
		panel.add(btn_removeNurse);
		
		JButton btn_update_2 = new JButton("Update All Changes");
		btn_update_2.setBackground(UIManager.getColor("Button.shadow"));
		btn_update_2.setForeground(UIManager.getColor("Button.shadow"));
		btn_update_2.setBounds(153, 299, 183, 21);
		panel.add(btn_update_2);
	}
	
	
	public static void main(String[] args) {
		HospitalManagement frame = new HospitalManagement();
		frame.setBounds(100, 100, 565, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

