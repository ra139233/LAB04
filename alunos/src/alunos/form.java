package alunos;

import alunos.buscaCep;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.InputMismatchException;

public class form extends JFrame {

	public JPanel contentPane;
	public JTextField textfirstName;
	public JTextField textlastName;
	public JFormattedTextField textbirthDate;
	public JTextField textEmail;
	public JFormattedTextField textCPF;
	public JFormattedTextField textCEP;
	public JTextField textAddress1;
	public JTextField textAddress2;
	public JFormattedTextField textPhone;
	public JTextField textCity;
	public JTextField textState;
	public JTextField textCountry;
	public JLabel rf1;
	public JLabel rf2;
	public JLabel rf3;
	public JLabel rf4;
	public JLabel rf5;
	public JLabel rf6;
	public JLabel buttonSearch;
	public JLabel inv1;
	public JLabel inv2;
	public JLabel inv3;
	public MaskFormatter ftmDate;//Atributo formatador para data  
	public MaskFormatter ftmCPF;//Atributo formatador para CPF
	public MaskFormatter ftmCEP;//Atributo formatador para CPF
	public MaskFormatter ftmPhone;//Atributo formatador para CPF
	boolean v1, v2, v3, v4, v5, v6, bs;
	int deslocamento = 120;
	
	
	public boolean verificaEmail (JTextField jTextFieldemail){	
		
		// verifica se a string possui os caracteres descritos abaixo e não possui espaço
		if ((jTextFieldemail.getText().contains("@")) && 
				(jTextFieldemail.getText().contains(".")) && 
				(!jTextFieldemail.getText().contains(" "))) {

			//quebra em duas partes, usuário até antes do @, e dominio, após.
				String usuario = new String(jTextFieldemail.getText().substring(0, 
				jTextFieldemail.getText().lastIndexOf('@')));

				            String dominio = new String(jTextFieldemail.getText().substring(jTextFieldemail.getText().lastIndexOf
				('@') + 1, jTextFieldemail.getText().length()));

				// validação do email pelo tamanho do pedaço usuario, ou pela presença de @
				// pela presença de . e não conter @ no dominio, ou o . ser o ultimo caractere
				            if ((usuario.length() >=1) && (!usuario.contains("@")) && 
				(dominio.contains(".")) && (!dominio.contains("@")) && (dominio.indexOf(".") >= 
				1) && (dominio.lastIndexOf(".") < dominio.length() - 1)) {

				            return true;

				            } else {
				            	rf4.setVisible(false);
				            	inv1.setVisible(true);
				              	jTextFieldemail.requestFocus();
				                return false;

				            }

				        } else {			   
				        	rf4.setVisible(false);
			            	inv1.setVisible(true);
			              	jTextFieldemail.requestFocus();
				            return false;

				        }
	}

	
	public boolean verificaCPF(JFormattedTextField JCPF){
		int sm, peso, i, r, num, dig10, dig11;   
		
		if (JCPF.getText().equals("000.000.000-00") || JCPF.getText().equals("111.111.111-11") ||
				JCPF.getText().equals("222.222.222-22") || JCPF.getText().equals("333.333.333-33") ||
				JCPF.getText().equals("444.444.444-44") || JCPF.getText().equals("555.555.555-55") ||
				JCPF.getText().equals("666.666.666-66") || JCPF.getText().equals("777.777.777-77") ||
				JCPF.getText().equals("888.888.888-88") || JCPF.getText().equals("999.999.999-99"))
			return false;
		
		try {
			// Calculo do 1o. Digito Verificador
			  sm = 0;
			  peso = 10;
			  		for (i=0; i<11; i++) {
			  			if(!(JCPF.getText().charAt(i) == '.')){
			  				num = (int)(JCPF.getText().charAt(i) - 48);
			  				sm = sm + (num * peso);
			  				peso = peso - 1;
			  			}
			      }

			      r = 11 - (sm % 11);
			      if ((r == 10) || (r == 11))
			         dig10 = '0';
			      else 
			    	  dig10 = (char )r + 48;
			   
			// Calculo do 2o. Digito Verificador
		      sm = 0;
		      peso = 11;
		      
		      	for(i=0; i<13; i++) {
		      		if(!(JCPF.getText().charAt(i) == '.') && !(JCPF.getText().charAt(i) == '-')){
			      		num = (int)(JCPF.getText().charAt(i) - 48);
			       		sm = sm + (num * peso);
			      		peso = peso - 1;
		      		}
		      	}
	
		      	r = 11 - (sm % 11);
		      	
		      	if ((r == 10) || (r == 11))
		      		dig11 = '0';
		      	else 
		      		dig11 = (char )r + 48;
	
		// Verifica se os digitos calculados conferem com os digitos informados.
		      	if ((dig10 == JCPF.getText().charAt(12)) && (dig11 == JCPF.getText().charAt(13)))
		      		return(true);
		      	else
		      		rf5.setVisible(false);
		      		inv2.setVisible(true);
		      		return(false);
		      		
		    }catch (InputMismatchException erro) {
		    	rf5.setVisible(false);
	      		inv2.setVisible(true);
		        return(false);
		    }
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form frame = new form();
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
	public form() throws ParseException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.white);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		v1 = v2 = v3 = v4 = v5 = v6 = bs = false;
		
	//--------------Primeiro nome-----------------
	
		textfirstName = new JTextField();
		textfirstName.setBounds(99 + deslocamento, 58, 114, 19);
		contentPane.add(textfirstName);
		textfirstName.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(12 + deslocamento, 60, 90, 15);
		contentPane.add(lblFirstName);
		
		rf1 = new JLabel("* Required Field");
		rf1.setBounds(230+ deslocamento, 60, 180, 15);
		rf1.setVisible(false);
		rf1.setForeground(Color.red);
		contentPane.add(rf1);
		
		
		
	//--------------Ultimo nome-----------------
		textlastName = new JTextField();
		textlastName.setBounds(99 + deslocamento, 89, 114, 19);
		contentPane.add(textlastName);
		textlastName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(12 + deslocamento, 91, 90, 15);
		contentPane.add(lblLastName);
		
		rf2 = new JLabel("* Required Field.");
		rf2.setBounds(230 + deslocamento, 91, 180, 15);
		rf2.setVisible(false);
		rf2.setForeground(Color.red);
		contentPane.add(rf2);
				
	//--------------Data Nascimento-----------------
		ftmDate = new MaskFormatter("##/##/####");
		textbirthDate = new JFormattedTextField(ftmDate);
		textbirthDate.setBounds(99 + deslocamento, 120, 114, 19);
		contentPane.add(textbirthDate);
		textbirthDate.setColumns(10);
		
		JLabel lblbirthDate = new JLabel("Birthdate:");
		lblbirthDate.setBounds(12 + deslocamento, 122, 90, 15);
		contentPane.add(lblbirthDate);
		
		rf3 = new JLabel("* Required Field.");
		rf3.setBounds(230 + deslocamento, 122, 180, 15);
		rf3.setVisible(false);
		rf3.setForeground(Color.red);
		contentPane.add(rf3);
				
	//-------------- Email -----------------
		textEmail = new JTextField();
		textEmail.setBounds(99 + deslocamento, 151, 114, 19);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(12 + deslocamento, 153, 90, 15);
		contentPane.add(lblEmail);
		
		rf4 = new JLabel("* Required Field.");
		rf4.setBounds(230+ deslocamento, 153, 180, 15);
		rf4.setForeground(Color.red);
		rf4.setVisible(false);
		contentPane.add(rf4);
		
		inv1 = new JLabel("* Invalid Field");
		inv1.setBounds(250 + deslocamento, 153, 180, 15);
		inv1.setVisible(false);
		inv1.setForeground(Color.red);
		contentPane.add(inv1);
		
		
	//-------------- CPF -----------------
		ftmCPF = new MaskFormatter("###.###.###-##");
		textCPF = new JFormattedTextField(ftmCPF);
		textCPF.setBounds(99 + deslocamento, 182, 114, 19);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(12 + deslocamento, 184, 90, 15);
		contentPane.add(lblCPF);
		
		rf5 = new JLabel("* Required Field.");
		rf5.setBounds(230 + deslocamento, 184, 180, 15);
		rf5.setForeground(Color.red);
		rf5.setVisible(false);
		contentPane.add(rf5);
		
		inv2 = new JLabel("* Invalid Field");
		inv2.setBounds(250 + deslocamento, 184, 180, 15);
		inv2.setVisible(false);
		inv2.setForeground(Color.red);
		contentPane.add(inv2);
		

	//-------------- CEP -----------------
		ftmCEP = new MaskFormatter("#####-###");
		textCEP = new JFormattedTextField(ftmCEP);
		textCEP.setBounds(99 + deslocamento , 213, 114, 19);
		contentPane.add(textCEP);
		textCEP.setColumns(10);		
		
		JLabel lblCEP = new JLabel("CEP:");
		lblCEP.setBounds(12 + deslocamento, 215, 90, 15);
		contentPane.add(lblCEP);
		
		rf6 = new JLabel("Required Field *");
		rf6.setBounds(12, 215, 180, 15);
		rf6.setVisible(false);
		rf6.setForeground(Color.red);
		contentPane.add(rf6);
		
		inv3 = new JLabel("Invalid Field *");
		inv3.setBounds(12, 215, 180, 15);
		inv3.setVisible(false);
		inv3.setForeground(Color.red);
		contentPane.add(inv3);
		
		buttonSearch = new JLabel("* Use the button \"Search CEP\" please");
		buttonSearch.setBounds(110, 480, 300, 15);
		buttonSearch.setVisible(false);
		buttonSearch.setForeground(Color.red);
		contentPane.add(buttonSearch);
		
		
		
	//-------------- Address 1 -----------------
		textAddress1 = new JTextField();
		textAddress1.setBounds(99 + deslocamento, 244, 114, 19);
		contentPane.add(textAddress1);
		textAddress1.setColumns(10);
		
		JLabel lblAddress1 = new JLabel("Address 1:");
		lblAddress1.setBounds(12 + deslocamento, 246, 90, 15);
		contentPane.add(lblAddress1);
		
	//-------------- Address 2 -----------------
		textAddress2 = new JTextField();
		textAddress2.setBounds(99 + deslocamento, 275, 114, 19);
		contentPane.add(textAddress2);
		textAddress2.setColumns(10);
		
		JLabel lblAddress2 = new JLabel("Address 2:");
		lblAddress2.setBounds(12 + deslocamento, 277, 90, 15);
		contentPane.add(lblAddress2);
				
	//-------------- Phone  -----------------
		ftmPhone = new MaskFormatter("+## (###) ####-####");
		textPhone = new JFormattedTextField(ftmPhone);
		textPhone.setBounds(99 + deslocamento, 306, 114, 19);
		contentPane.add(textPhone);
		textPhone.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(12 + deslocamento, 308, 90, 15);
		contentPane.add(lblPhone);
		
	//-------------- City  -----------------
		textCity = new JTextField();
		textCity.setBounds(99 + deslocamento, 337, 114, 19);
		contentPane.add(textCity);
		textCity.setColumns(10);

		JLabel lblCity = new JLabel("City:");
		lblCity.setBounds(12 + deslocamento, 339, 90, 15);
		contentPane.add(lblCity);
		
    //	-------------- State  -----------------
		textState = new JTextField();
		textState.setBounds(99 + deslocamento, 368, 114, 19);
		contentPane.add(textState);
		textState.setColumns(10);
		
		JLabel lblState = new JLabel("State:");
		lblState.setBounds(12 + deslocamento, 370, 90, 15);
		contentPane.add(lblState);
		
    //	-------------- Country  -----------------
		textCountry = new JTextField();
		textCountry.setBounds(99 + deslocamento, 399, 114, 19);
		contentPane.add(textCountry);
		textCountry.setColumns(10);

		JLabel lblCountry = new JLabel("Country:");
		lblCountry.setBounds(12 + deslocamento, 401, 90, 15);
		contentPane.add(lblCountry);

	// 	--------------- Title ----------------------
		
		final JComboBox comboTitle = new JComboBox();
		comboTitle.setModel(new DefaultComboBoxModel(new String[] {"Mr.", "Mrs.", "Miss.", "Ms.", "Dr.", "Other"}));
		comboTitle.setToolTipText("");
		comboTitle.setBounds(89 + deslocamento, 12, 81, 24);
		contentPane.add(comboTitle);	
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(45+ deslocamento, 17, 90, 15);
		contentPane.add(lblTitle);
		
	// ----------------- Button CEP --------------------------
		JButton btnSearch = new JButton("Search CEP");
		btnSearch.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
				bs = true;
				
				if(textCEP.getText().charAt(0)==' '){
					rf6.setVisible(true);
				}
				else{
					String CodigoEP = textCEP.getText();
					buscaCep CEP = new buscaCep(CodigoEP);
					
					try {
						if(CEP.getEndereco().equals("Falso")){
							rf6.setVisible(false);
							inv3.setVisible(true);
						}
						
						else{
							textAddress1.setText(CEP.getEndereco());
							textCity.setText(CEP.getCidade());
							textState.setText(CEP.getUF());
							rf6.setVisible(false);
							inv3.setVisible(false);
							buttonSearch.setVisible(false);
							v6 = true;
						}
					} 
					
					catch (IOException e1) {
					}
					
				}
				
				
			}
		});
		btnSearch.setBounds(230+ deslocamento, 211, 115, 25);
		contentPane.add(btnSearch);
	


	// ----------------- Button --------------------------
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
								
				if(textfirstName.getText().isEmpty()){
					rf1.setVisible(true);					
				}
				else{
					rf1.setVisible(false);
					v1 = true;
				}
				
				
				if(textlastName.getText().isEmpty()){
					rf2.setVisible(true);					
				}
				else{
					rf2.setVisible(false);
					v2 = true;
				}				
				
				if(textbirthDate.getText().charAt(0) == ' '){
					rf3.setVisible(true);					
				}
				else{
					rf3.setVisible(false);
					v3 = true;
				}
				
				
				if(textEmail.getText().isEmpty()){
					inv1.setVisible(false);
					rf4.setVisible(true);					
				}
				else if(verificaEmail(textEmail) && !v4){
					inv1.setVisible(false);
					rf4.setVisible(false);
					v4 = true;
				}

				if(textCPF.getText().charAt(0) == ' '){
					inv2.setVisible(false);
					rf5.setVisible(true);					
				}
				else if(verificaCPF(textCPF) && !v5){
					inv2.setVisible(false);
					rf5.setVisible(false);
					v5 = true;
				}
				
				if(textCEP.getText().charAt(0)==' '){
					rf6.setVisible(true);			
				}
				else if (!v6 && !bs){
					rf6.setVisible(false);
					inv3.setVisible(false);
					buttonSearch.setVisible(true);
				}
					
				if(v1 && v2 && v3 && v4 && v5 && v6){		
					//contentPane.setVisible(false);
					print printForm = new print();
					printForm.titleLabel.setText((String) comboTitle.getSelectedItem());
					printForm.firstNameLabel.setText(textfirstName.getText());
					printForm.lastNameLabel.setText(textlastName.getText());
					printForm.birthDateLabel.setText(textbirthDate.getText());
					printForm.emailLabel.setText(textEmail.getText());
					printForm.CPFLabel.setText(textCPF.getText());
					printForm.CEPLabel.setText(textCEP.getText());
					printForm.address1Label.setText(textAddress1.getText());
					printForm.address2Label.setText(textAddress2.getText());
					printForm.phoneLabel.setText(textPhone.getText());
					printForm.cityLabel.setText(textCity.getText());
					printForm.stateLabel.setText(textState.getText());
					printForm.countryLabel.setText(textCountry.getText());
									
					//printForm.contentPane.setVisible(true);				
					printForm.show();
				}
			}
		});
		btnPrint.setBounds(85 + deslocamento, 450, 74, 25);
		contentPane.add(btnPrint);
	}
}
