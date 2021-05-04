package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hospital.DataContracts.Employee;
import hospital.DataContracts.Receptionist;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class Add_Receptionist extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField emp_ssn;
	private JTextField emp_fn;
	private JTextField emp_ln;
	private JTextField salary;
	private JTextField phone_number;
	private JTextField dob;
	private JTextField country;
	private JTextField zip;
	private JTextField street;
	private JTextField working_hours;
	private JTextField internal_number;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Receptionist frame = new Add_Receptionist();
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
	public Add_Receptionist() {
		DatabaseHelper dbHelper = new DatabaseHelper();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		emp_ssn = new JTextField();
		emp_ssn.setBounds(104, 49, 96, 20);
		contentPane.add(emp_ssn);
		emp_ssn.setColumns(10);
		
		emp_fn = new JTextField();
		emp_fn.setBounds(104, 80, 96, 20);
		contentPane.add(emp_fn);
		emp_fn.setColumns(10);
		
		emp_ln = new JTextField();
		emp_ln.setBounds(104, 111, 96, 20);
		contentPane.add(emp_ln);
		emp_ln.setColumns(10);
		
		salary = new JTextField();
		salary.setBounds(104, 142, 96, 20);
		contentPane.add(salary);
		salary.setColumns(10);
		
		phone_number = new JTextField();
		phone_number.setBounds(104, 173, 96, 20);
		contentPane.add(phone_number);
		phone_number.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SSN");
		lblNewLabel.setBounds(10, 52, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(10, 83, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setBounds(10, 114, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Salary");
		lblNewLabel_3.setBounds(10, 145, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phone Number");
		lblNewLabel_4.setBounds(10, 176, 86, 14);
		contentPane.add(lblNewLabel_4);
		
		JComboBox gender = new JComboBox();
		gender.addItem("male");
		gender.addItem("female");
		gender.setBounds(347, 141, 96, 22);
		contentPane.add(gender);
		gender.setSelectedItem(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(204, 247, 89, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_14 = new JLabel("Password");
		lblNewLabel_14.setBounds(136, 250, 64, 14);
		contentPane.add(lblNewLabel_14);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee emp = new Employee();
				Receptionist rec = new Receptionist();
				
				try {
				String fn = emp_fn.getText();
				String _dob = dob.getText();
				String _country = country.getText();
				String _street = street.getText();
				int _zip = Integer.parseInt(zip.getText());
				int _internalnum = Integer.parseInt(internal_number.getText());
				String ln = emp_ln.getText();
				int _working_hours = Integer.parseInt(working_hours.getText());
				String _gender = (String) gender.getSelectedItem();
				int ssn = Integer.parseInt(emp_ssn.getText());
				int phone_numberr = Integer.parseInt(phone_number.getText());
				int salaryy = Integer.parseInt(salary.getText());
				String password = passwordField.getText();
				
				emp.ssn = ssn;
				emp.fname = fn;
				emp.lname = ln;
				emp.salary = salaryy;
				emp.phone = phone_numberr;
				emp.dob = _dob;
				emp.gender = _gender;
				emp.country = _country;
				emp.zip = _zip;
				emp.street = _street;
				
				rec.ssn = ssn;
				rec.working_hours = _working_hours;
				rec.internal_number = _internalnum;
				rec.pass = password;
				
				dbHelper.AddEmployee(emp);
				dbHelper.AddReceptionist(rec);
				
				JOptionPane.showMessageDialog(frame, "Successfully added this employee", "Success", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frame, "Oops, something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(204, 278, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Add Receptionist");
		lblNewLabel_5.setBounds(190, 8, 141, 30);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("DOB");
		lblNewLabel_6.setBounds(10, 207, 49, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Gender");
		lblNewLabel_8.setBounds(258, 145, 49, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_11 = new JLabel("Country");
		lblNewLabel_11.setBounds(258, 52, 49, 14);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("ZIP");
		lblNewLabel_12.setBounds(258, 83, 49, 14);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Street");
		lblNewLabel_13.setBounds(258, 114, 49, 14);
		contentPane.add(lblNewLabel_13);
		
		dob = new JTextField();
		dob.setBounds(104, 204, 96, 20);
		contentPane.add(dob);
		dob.setColumns(10);
		
		country = new JTextField();
		country.setBounds(347, 49, 96, 20);
		contentPane.add(country);
		country.setColumns(10);
		
		zip = new JTextField();
		zip.setBounds(347, 80, 96, 20);
		contentPane.add(zip);
		zip.setColumns(10);
		
		street = new JTextField();
		street.setBounds(347, 111, 96, 20);
		contentPane.add(street);
		street.setColumns(10);
		
		JLabel lblType = new JLabel("Working Hours");
		lblType.setBounds(258, 176, 116, 14);
		contentPane.add(lblType);
		
		working_hours = new JTextField();
		working_hours.setColumns(10);
		working_hours.setBounds(347, 173, 96, 20);
		contentPane.add(working_hours);
		
		JLabel lblNewLabel_10 = new JLabel("Internal Num.");
		lblNewLabel_10.setBounds(258, 207, 78, 14);
		contentPane.add(lblNewLabel_10);
		
		internal_number = new JTextField();
		internal_number.setBounds(347, 204, 96, 20);
		contentPane.add(internal_number);
		internal_number.setColumns(10);
		

		
		JButton btnNewButton_1 = new JButton("back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnNewButton_1.setBounds(7, 8, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		
	
		

	}
}
