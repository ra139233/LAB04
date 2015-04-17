package alunos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class print extends JFrame {

	public JPanel contentPane;
	JLabel titleLabel = new JLabel("Title");
	JLabel firstNameLabel = new JLabel("First Name");
	JLabel lastNameLabel = new JLabel("Last Name");
	JLabel birthDateLabel = new JLabel("Birthdate");
	JLabel emailLabel = new JLabel("Email");
	JLabel CPFLabel = new JLabel("CPF");
	JLabel phoneLabel = new JLabel("Phone");
	JLabel address1Label = new JLabel("Adress 1");
	JLabel address2Label = new JLabel("Adress 2");
	JLabel CEPLabel = new JLabel("CEP");
	JLabel cityLabel = new JLabel("City");
	JLabel stateLabel = new JLabel("State");
	JLabel countryLabel = new JLabel("Country");
	int deslocamento = 140;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					print frame = new print();					
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
	public print() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.white);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		// -------------------------------------------------------------------------
		
		firstNameLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		firstNameLabel.setBounds(102 + deslocamento, 82, 216, 15);
		contentPane.add(firstNameLabel);	
		
		JLabel lblNewLabel_2 = new JLabel("First Name:");
		lblNewLabel_2.setBounds(12 + deslocamento, 82, 106, 15);
		lblNewLabel_2.setForeground(Color.blue);
		contentPane.add(lblNewLabel_2);
		
		// -------------------------------------------------------------------------
		
		lastNameLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		lastNameLabel.setBounds(102 + deslocamento, 109, 216, 15);
		contentPane.add(lastNameLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Last Name:");
		lblNewLabel_3.setBounds(12 + deslocamento, 109, 98, 15);
		lblNewLabel_3.setForeground(Color.blue);
		contentPane.add(lblNewLabel_3);
		
		// -------------------------------------------------------------------------

		birthDateLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		birthDateLabel.setBounds(102 + deslocamento, 136, 216, 15);
		contentPane.add(birthDateLabel);
	
		JLabel lblNewLabel_4 = new JLabel("Birthdate:");
		lblNewLabel_4.setBounds(12 + deslocamento, 136, 98, 15);
		lblNewLabel_4.setForeground(Color.blue);
		contentPane.add(lblNewLabel_4);
		
		// -------------------------------------------------------------------------	
		
		emailLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		emailLabel.setBounds(102 + deslocamento, 163, 216, 15);
		contentPane.add(emailLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Email:");
		lblNewLabel_5.setForeground(Color.blue);
		lblNewLabel_5.setBounds(12 + deslocamento, 163, 98, 15);
		contentPane.add(lblNewLabel_5);
		
		// -------------------------------------------------------------------------	
		
		CPFLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		CPFLabel.setBounds(102 + deslocamento, 190, 216, 15);
		contentPane.add(CPFLabel);
		
		JLabel lblNewLabel_6 = new JLabel("CPF:");
		lblNewLabel_6.setBounds(12 + deslocamento, 190, 98, 15);
		lblNewLabel_6.setForeground(Color.blue);
		contentPane.add(lblNewLabel_6);
				
		// -------------------------------------------------------------------------			
		
		CEPLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		CEPLabel.setBounds(102 + deslocamento, 217, 216, 15);
		contentPane.add(CEPLabel);
		
		JLabel lblNewLabel_7 = new JLabel("CEP:");
		lblNewLabel_7.setBounds(12 + deslocamento, 217, 98, 15);
		lblNewLabel_7.setForeground(Color.blue);
		contentPane.add(lblNewLabel_7);
		
		// -------------------------------------------------------------------------
		
		address1Label.setFont(new Font("Dialog", Font.PLAIN, 12));
		address1Label.setBounds(102 + deslocamento, 244, 325, 15);
		contentPane.add(address1Label);
		
		JLabel lblNewLabel_8 = new JLabel("Address 1:");
		lblNewLabel_8.setBounds(12 + deslocamento, 244, 98, 15);
		lblNewLabel_8.setForeground(Color.blue);
		contentPane.add(lblNewLabel_8);
		
		// -------------------------------------------------------------------------
		
		address2Label.setFont(new Font("Dialog", Font.PLAIN, 12));
		address2Label.setBounds(102 + deslocamento, 271, 216, 15);
		contentPane.add(address2Label);
		
		JLabel lblNewLabel_9 = new JLabel("Address 2:");
		lblNewLabel_9.setBounds(12 + deslocamento, 271, 98, 15);
		lblNewLabel_9.setForeground(Color.blue);
		contentPane.add(lblNewLabel_9);
		
		// -------------------------------------------------------------------------
		
		phoneLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		phoneLabel.setBounds(102 + deslocamento, 298, 200, 15);
		contentPane.add(phoneLabel);
		
		JLabel lblNewLabel_10 = new JLabel("Address 1:");
		lblNewLabel_10.setBounds(12 + deslocamento, 298, 98, 15);
		lblNewLabel_10.setForeground(Color.blue);
		contentPane.add(lblNewLabel_10);
		
		// -------------------------------------------------------------------------
		
		cityLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		cityLabel.setBounds(102 + deslocamento, 319, 98, 15);
		contentPane.add(cityLabel);
		
		JLabel lblNewLabel_11 = new JLabel("City:");
		lblNewLabel_11.setBounds(12 + deslocamento, 319, 98, 15);
		lblNewLabel_11.setForeground(Color.blue);
		contentPane.add(lblNewLabel_11);
		
		// -------------------------------------------------------------------------
		
		stateLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		stateLabel.setBounds(102 + deslocamento, 346, 98, 15);
		contentPane.add(stateLabel);
		
		JLabel lblNewLabel_12 = new JLabel("State:");
		lblNewLabel_12.setBounds(12 + deslocamento, 346, 98, 15);
		lblNewLabel_12.setForeground(Color.blue);
		contentPane.add(lblNewLabel_12);
		
		// -------------------------------------------------------------------------
		
		countryLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		countryLabel.setBounds(102 + deslocamento, 373, 98, 15);
		contentPane.add(countryLabel);
		
		JLabel lblNewLabel_13 = new JLabel("Country:");
		lblNewLabel_13.setBounds(12 + deslocamento, 373, 98, 15);
		lblNewLabel_13.setForeground(Color.blue);
		contentPane.add(lblNewLabel_13);
		
		// -------------------------------------------------------------------------
		
		JLabel lblNewLabel_1 = new JLabel("Title:");
		lblNewLabel_1.setBounds(12 + deslocamento, 55, 70, 15);
		lblNewLabel_1.setForeground(Color.blue);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_x = new JLabel("Form Printed");
		lblNewLabel_x.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_x.setBounds(150, 12, 159, 31);
		lblNewLabel_x.setForeground(Color.orange);
		contentPane.add(lblNewLabel_x);
		
				
		titleLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		titleLabel.setBounds(102 + deslocamento, 55, 216, 15);
		contentPane.add(titleLabel);
				
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(12, 500, 117, 25);
		contentPane.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

}
