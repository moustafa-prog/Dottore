package Dottore;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registrazione extends JFrame implements ActionListener{
	JButton Chiuso = new JButton("CHIUSO");
    JButton Conferma= new JButton("CONFERMA");
            JLabel Email = new JLabel("EMAIL");
    		  JLabel Password = new JLabel("PASSWORD");
    		  	JLabel Nome = new JLabel("NOME");
				  JLabel Cognome  = new JLabel("COGNOME");
				  	JLabel CodiceFiscale = new JLabel("CODICE FISCALE");
				  	 JLabel DataNascita = new JLabel("DATA DI NASCITA");
				      JLabel Indirizzio = new JLabel("INDIRIZZIO");
				       JLabel Registirform = new JLabel("NOUVO UTENTE");
				        JCheckBox show = new JCheckBox("MOSTRA IL PASSWORD");
				        JRadioButton Radio1= new JRadioButton("SONO DOTTORE");
				        JRadioButton Radio2= new JRadioButton("SONO PAZIENTE");
				        JLabel idDottore = new JLabel("ID DOTTORE");
				        						//TEXT FILED EMAIL
	JTextField email = new JTextField();	
		JPasswordField pass = new JPasswordField();	//TEXT FILED PASSWORD
			JTextField nome = new JTextField();								 
	     		JTextField cognome = new JTextField();	
	     			JTextField codicefiscale = new JTextField();	
	     				JTextField datanascita = new JTextField();	
	     					JTextField indirizzio = new JTextField();	
	     						JPanel panel = new JPanel(null); 
	     						 ButtonGroup radioGroup = new ButtonGroup();
	     						JTextField Iddottore = new JTextField();	
	
	public Registrazione() {
			this.setTitle("REGISTRAZIONE");
	        this.setLayout(null);
	        this.setResizable(false);
	        this.setSize(1000, 1000);
	        this.setLocationRelativeTo(null);
	        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        this.add(panel);
	        panel.add(Registirform);
	        	panel.add(Email);
	        		panel.add(Password);
	        			panel.add(Nome);
	        				panel.add(Cognome);
	        					panel.add(CodiceFiscale);
	        						panel.add(DataNascita);
	        							panel.add(Indirizzio);
	        								panel.add(email);
	        									panel.add(pass);
	        										panel.add(nome);
	        											panel.add(cognome);
	        												panel.add(codicefiscale);
	        													panel.add(datanascita);
	        														panel.add(indirizzio);
	        															panel.add(Conferma);
	        																panel.add(Chiuso);
	        																 	panel.add(show);
	        																 		panel.add(Radio1);
	        																 			panel.add(Radio2);
	        																 			//panel.add(Iddottore);
	        																 			//panel.add(idDottore);
	        				           // DIMENSIONI PER TESTI E BORDI	      
	        panel.setBounds(0, 0, 1000, 1000);
	        Registirform.setBounds(330, 200, 600, 70);
	        Email.setBounds(200, 320, 150, 100);
	        email.setBounds(300, 350, 400, 40);
	        Password.setBounds(135, 400, 200, 40);
	        pass.setBounds(300, 400, 400, 40);
	        Nome.setBounds(200, 420, 150, 100);
	        nome.setBounds(300, 450, 400, 40);
	        Cognome.setBounds(150, 470, 150, 100);
	        cognome.setBounds(300, 500, 400, 40);
	        CodiceFiscale.setBounds(60,520,300,100 );
	        codicefiscale.setBounds(300,550,400,40);
	        DataNascita.setBounds(50, 570, 300, 100);
	        datanascita.setBounds(300,600,400,40); 
	        Indirizzio.setBounds(120, 620, 300, 100);
	        indirizzio.setBounds(300, 650, 400, 40);
	        Chiuso.setBounds(50, 800, 150, 50);
	        Conferma.setBounds(760, 800, 190, 50);
	        show.setBounds(750, 410, 180, 20);
	        Radio1.setBounds(200, 290, 130, 20);
	        Radio2.setBounds(750, 290, 130, 20);
	        //Iddottore.setBounds(500,290,150,20);
	        //idDottore.setBounds(400,290 ,100 ,20 );
	     
	        panel.setBackground(Color.decode("#89CFF0"));
	        Conferma.setBackground(Color.LIGHT_GRAY);
	        Chiuso.setBackground(Color.LIGHT_GRAY);
	        show.setBackground(Color.decode("#89CFF0"));
	        Radio1.setBackground(Color.decode("#89CFF0"));
	        Radio2.setBackground(Color.decode("#89CFF0"));
	        Conferma.setFont(new Font("Congenial black",Font.BOLD,20));
	        Chiuso.setFont(new Font("Congenial black",Font.BOLD,20));
	        idDottore.setFont(new Font("BODONI MT",Font.BOLD,15));
	        Registirform.setFont(new Font("ALGERIAN",Font.BOLD,50));
	        Email.setFont(new Font("BODONI MT",Font.BOLD,30));
	        Password.setFont(new Font("BODONI MT",Font.BOLD,30));
	        Nome.setFont(new Font("BODONI MT",Font.BOLD,30));
	        Cognome.setFont(new Font("BODONI MT",Font.BOLD,30));
	        CodiceFiscale.setFont(new Font("BODONI MT",Font.BOLD,30));
	        DataNascita.setFont(new Font("BODONI MT",Font.BOLD,30));
	        Indirizzio.setFont(new Font("BODONI MT",Font.BOLD,30));

	        show.addActionListener(this);
	        Chiuso.addActionListener(this);
	        Conferma.addActionListener(this);
	        Radio1.addActionListener(this);
	        Radio2.addActionListener(this);
	        radioGroup.add(Radio1);
	        radioGroup.add(Radio2);
	        Iddottore.setVisible(false);
	        idDottore.setVisible(false);
	}

	public static void main(String[] args) {
		 new Registrazione().setVisible(true);

	}
	 @Override  
	 public void actionPerformed(ActionEvent e) {
	       if(e.getSource()== show){
	           if(show.isSelected()){
	               pass.setEchoChar('\0');
	               show.setText("NASCONDI LA PASSWORD");
	           }else{
	                      pass.setEchoChar('*');
	                      show.setText("MOSTRARE LA PASSWORD");
	                       }
	       } else if(e.getSource() == Chiuso) {
	                    	int c = JOptionPane.showConfirmDialog(null, "VOUI CHIUDERE L'REGISTRAZIONE", "SCELTA",JOptionPane.YES_NO_OPTION);
	                 if(c == 0)   {
	                	 System.exit(EXIT_ON_CLOSE);;
	                	 }
	                 }else if (e.getSource() == Conferma) {
	                	 if (Radio1.isSelected() && Radio2.isSelected()) {
	                         JOptionPane.showMessageDialog(this, "NON PUOI SELEZIONARE ENTRAMBI DOTTORE E PAZIENTE", "ERRORE", JOptionPane.ERROR_MESSAGE);
	                     } else if (!Radio1.isSelected() && !Radio2.isSelected()) {
	                         JOptionPane.showMessageDialog(this, "DEVI SELEZIONARE UN'OPZIONE TRA DOTTORE E PAZIENTE", "ERRORE", JOptionPane.ERROR_MESSAGE);
	                     } else {
	                         registerUser();
	                     }  if (e.getSource() == Radio1) {
	                         Radio1.setVisible(true);
	                         Radio2.setVisible(false);
	                         panel.revalidate();
	                         panel.repaint();
	                     
	                     } else  {
	                	 Radio1.setVisible(false);
                         Radio2.setVisible(true);
                        idDottore.setVisible(true);
                        Iddottore.setVisible(true);
                        panel.add(Iddottore);
                        Iddottore.setBounds(500,290,150,20);
                         panel.revalidate();
                         panel.repaint();
	                 }
	                 }
	 }
	    private void registerUser() {
	        String emailText = email.getText();
	        String passwordText = new String(pass.getPassword());
	        String nomeText = nome.getText();
	        String cognomeText = cognome.getText();
	        String codiceFiscaleText = codicefiscale.getText();
	        String dataNascitaText = datanascita.getText(); // Format:ANNI-MESE-GIRONI
	        String indirizzioText = indirizzio.getText();
	        String tipoUtente = Radio1.isSelected() ? "Dottore" : "Paziente";

	      	 String insertSQL = "INSERT INTO user (username, password, nome, cognome, codice_fiscale, data_nascita, indirizzo, tipo_di_utente) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

	        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/progetto", "root", "Moustafa2001");
	             PreparedStatement pstmt = con.prepareStatement(insertSQL)) {
	    
	            pstmt.setString(1, emailText);
	            pstmt.setString(2, passwordText);
	            pstmt.setString(3, nomeText);
	            pstmt.setString(4, cognomeText);
	            pstmt.setString(5, codiceFiscaleText);
	            pstmt.setString(6, dataNascitaText);
	            pstmt.setString(7, indirizzioText);
	            pstmt.setString(8, tipoUtente);
	      
	            pstmt.executeUpdate();
	       
	            JOptionPane.showMessageDialog(this, "Registrazione avvenuta con successo:)");
	      
	          

	       
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Errore durante la registrazione!", "Errore", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	    
	    	}

	    	