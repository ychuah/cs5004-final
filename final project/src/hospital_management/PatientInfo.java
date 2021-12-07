package hospital_management;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class PatientInfo extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField text_name;	
	private JTextField text_age;
	private JTextField text_dob;
	private JTextField text_contact;
	private String[] gender = {"Male", "Female", "(or Enter Manually Here)"};
	private JTextField text_purpose;
	private JTable table;

	public PatientInfo() {
		setTitle("Patient Registration Form");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 348, 1000);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_ptRegistration = new JLabel("Patient Registration Form");
		lbl_ptRegistration.setBounds(113, 10, 190, 28);
		lbl_ptRegistration.setFont(new Font("Dubai", Font.PLAIN, 16));
		panel.add(lbl_ptRegistration);
		
		JLabel lbl_name = new JLabel("Name: ");
		lbl_name.setBounds(10, 59, 133, 13);
		panel.add(lbl_name);
		
		text_name = new JTextField();
		text_name.setBounds(183, 59, 120, 19);
		panel.add(text_name);
		text_name.setColumns(10);
		
		JLabel lbl_age = new JLabel("Age:");
		lbl_age.setBounds(10, 85, 133, 13);
		panel.add(lbl_age);
		
		text_age = new JTextField();
		text_age.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					
					if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
						e.consume();
						throw new InputMismatchException("Must be numbers");
					}
		}});
		
		text_age.setColumns(10);
		text_age.setBounds(183, 85, 120, 19);
		panel.add(text_age);
		
		JLabel lbl_dob = new JLabel("Date of Birth:");
		lbl_dob.setBounds(10, 111, 133, 13);
		panel.add(lbl_dob);
		
		text_dob = new JTextField();
		text_dob.setColumns(10);
		text_dob.setBounds(183, 111, 120, 19);
		panel.add(text_dob);
		
		JLabel lbl_contact = new JLabel("Contact Number:");
		lbl_contact.setBounds(10, 137, 133, 13);
		panel.add(lbl_contact);
		
		text_contact = new JTextField();
		text_contact.setColumns(10);
		text_contact.setBounds(183, 137, 120, 19);
		panel.add(text_contact);
		
		JLabel lbl_gender = new JLabel("Gender: ");
		lbl_gender.setBounds(10, 170, 133, 13);
		panel.add(lbl_gender);
		
		JComboBox<String> combo_gender = new JComboBox<String>();
		for (int i = 0; i < gender.length; i++) {
			combo_gender.addItem(gender[i]);
		}
		combo_gender.setEditable(true);
		combo_gender.setBounds(181, 166, 122, 21);
		panel.add(combo_gender);
		
		JLabel lbl_purpose = new JLabel("Purpose of Visit:");
		lbl_purpose.setBounds(10, 201, 133, 13);
		panel.add(lbl_purpose);
		
		text_purpose = new JTextField();
		text_purpose.setColumns(10);
		text_purpose.setBounds(183, 195, 120, 19);
		panel.add(text_purpose);
		
		JLabel lbl_covid = new JLabel(" Covid-19 Case?");
		lbl_covid.setBounds(10, 230, 133, 13);
		panel.add(lbl_covid);
		
		JRadioButton rdbtn_Yes = new JRadioButton("Yes");
		rdbtn_Yes.setSelected(true);
		rdbtn_Yes.setBounds(182, 226, 58, 21);
		panel.add(rdbtn_Yes);
		
		JRadioButton rdbtn_No = new JRadioButton("No");		
		rdbtn_No.setBounds(242, 226, 61, 21);
		panel.add(rdbtn_No);
		
		ButtonGroup buttonGroupYN = new ButtonGroup();
		buttonGroupYN.add(rdbtn_Yes);
		buttonGroupYN.add(rdbtn_No);
		

		JPanel panel_csv = new JPanel();
		panel_csv.setBounds(368, 10, 775, 430);
		getContentPane().add(panel_csv);
		panel_csv.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		scrollPane.setBounds(0, 0, 775
				, 430);
		panel_csv.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Age", "Date of Birth", "Contact", "Gender", "Purpose of Visit", "Covid-related Case?"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btn_addPatient = new JButton("Add Patient");
		btn_addPatient.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model_ptTable = (DefaultTableModel) table.getModel();
				model_ptTable.addRow(new Object[] {
						text_name.getText(),
						text_age.getText(),
						text_dob.getText(),
						text_contact.getText(),
						combo_gender.getSelectedItem(),
						text_purpose.getText(),
						getSelectedButtonText(buttonGroupYN)});

				if (table.getSelectedRow() == -1) {
					if (table.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Patient registration completed", "Patient Registration", JOptionPane.OK_OPTION);
					}
				}

				}
		});
		
		
		btn_addPatient.setBackground(UIManager.getColor("Button.highlight"));
		btn_addPatient.setBounds(45, 272, 120, 21);
		panel.add(btn_addPatient);
		
		JButton btn_removePatient = new JButton("Discharge Patient");
		btn_removePatient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model_ptTable = (DefaultTableModel) table.getModel();

				if (table.getSelectedRow() == -1) {
					if (table.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "No patient to remove from system", "Error: Cannot remove patient", JOptionPane.OK_OPTION);	
					}
					else {
						JOptionPane.showMessageDialog(null, "Select patient to remove from system", "Remove patient", JOptionPane.OK_OPTION);	
					}
				} else {
					model_ptTable.removeRow(table.getSelectedRow());
				}
			}
		});
		btn_removePatient.setBounds(183, 272, 120, 21);
		panel.add(btn_removePatient);
		
		JButton btn_csv = new JButton("Parse to CSV file");
		btn_csv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    String filePath = "./patient_list.csv";

				try {
					File csv = new File(filePath);
					
					if (!csv.exists()) 
						csv.createNewFile(); 

					FileWriter patientCSV = new FileWriter(csv);
					//BufferedReader br = new BufferedReader(new FileReader(csv));
					BufferedWriter bw = new BufferedWriter(patientCSV);
					DefaultTableModel model = (DefaultTableModel) table.getModel();
			        
			        for (int c = 0; c < model.getColumnCount(); c++) {
			        	bw.write(model.getColumnName(c) + ",");
	
			        }
			        bw.write("\n");
			        
			        for (int r = 0; r < model.getRowCount(); r++) {
			            for (int c = 0; c < model.getColumnCount(); c++) {
			            	String patientInfo = (String)model.getValueAt(r, c);
			            	if (patientInfo == null) {
			            		patientInfo = "";
			            				            }
			            bw.write(patientInfo.toString() + ",");
			        }
			            bw.write("\n");
			            }   
				    //bw.flush();
			        bw.close();
					JOptionPane.showMessageDialog(null, "Look for 'patient_list.csv'", "Success", JOptionPane.PLAIN_MESSAGE);	

			        
					
			    } catch (IOException io) {
			        io.printStackTrace();
					JOptionPane.showMessageDialog(null, "Cannot parse to csv", "ERROR", JOptionPane.OK_OPTION);	
			    
				}
		}
			
		});
		btn_csv.setBounds(101, 308, 139, 21);
		panel.add(btn_csv);
		
		JButton btn_exitPt = new JButton("Exit");
		btn_exitPt.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}});
		
		btn_exitPt.setBounds(132, 345, 85, 21);
		panel.add(btn_exitPt);
}
	   public String getSelectedButtonText(ButtonGroup buttonGroupYN) {
	        for (Enumeration<AbstractButton> buttons = buttonGroupYN.getElements(); buttons.hasMoreElements();) {
	            AbstractButton button = buttons.nextElement();

	            if (button.isSelected()) {
	                return button.getText();
	            }
	        }

	        return null;
	    }
	   
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	public static void main(String[] args) {
		PatientInfo frame = new PatientInfo();
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);


	}
}

