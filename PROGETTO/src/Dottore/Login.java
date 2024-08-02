package Dottore;

import java.awt.Color;
import java.awt.Font;

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

import Paziente.Interfaccia_di_Paziente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {
    JButton login = new JButton("ACCESSO");
    JButton Registrazione = new JButton("REGISTRAZIONE");
    JLabel l_name = new JLabel("E-MAIL");
    JLabel l_pass = new JLabel("PASSWORD");
    JTextField txt_name = new JTextField();
    JPasswordField pass = new JPasswordField();
    JCheckBox show = new JCheckBox("MOSTRA IL PASSWORD");
    JLabel loginform = new JLabel("BENVENUTO");
    JPanel panel = new JPanel(null); 
    JRadioButton Radio1= new JRadioButton("SONO DOTTORE");
    JRadioButton Radio2= new JRadioButton("SONO PAZIENTE");
    JTextField idDottoreField = new JTextField();
    JTextField idPazienteField = new JTextField();
    ButtonGroup radioGroup = new ButtonGroup();
    public Login() {
        this.setTitle("ACCESSO");
        this.setLayout(null);
       this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.add(panel);
        this.setResizable(false);
        
        panel.setBounds(0, 0, 1000, 1000);
        loginform.setBounds(350, 200, 600, 100);
        l_name.setBounds(180, 450, 120, 35);
        txt_name.setBounds(300, 450, 400, 35);
        l_pass.setBounds(135, 500, 180, 35);
        pass.setBounds(300, 500, 400, 35);
        show.setBounds(750, 500, 150, 20);
        login.setBounds(550, 650, 150, 25);
        Registrazione.setBounds(300, 650, 200, 25);
        Radio1.setBounds(250,550,130,25);
       Radio2.setBounds(550,550,200,25);
        // AGGUINGE IL COLORE 
        panel.setBackground(Color.decode("#D4AF37"));
        login.setBackground(Color.LIGHT_GRAY);
        Registrazione.setBackground(Color.LIGHT_GRAY);
        show.setBackground(Color.decode("#D4AF37"));
        Radio1.setBackground(Color.decode("#D4AF37"));
        Radio2.setBackground(Color.decode("#D4AF37"));
        // CAMBIAMENTO LA FONTE
        loginform.setFont(new Font("ALGERIAN",Font.BOLD,50));
        l_name.setFont(new Font("BODONI MT",Font.BOLD,30));
        l_pass.setFont(new Font("BODONI MT",Font.BOLD,30));
        login.setFont(new Font("Congenial black",Font.BOLD,20));
        Registrazione.setFont(new Font("Congenial black",Font.BOLD,20));
        show.setFont(new Font("Congenial black",Font.BOLD,10));

        // PER MOSTRA TUTTO NEL NOSRTA INTERFACCIA
        panel.add(loginform);
        panel.add(l_name);
        panel.add(l_pass);
        panel.add(txt_name);
        panel.add(pass);
        panel.add(login);
        panel.add(Registrazione);
        panel.add(show);
        panel.add(Radio1);
        panel.add(Radio2);
        panel.add(idDottoreField);
        panel.add(idPazienteField);
        radioGroup.add(Radio1);
        radioGroup.add(Radio2);
        
        show.addActionListener(this);
        Registrazione.addActionListener(this);
        login.addActionListener(this);
        Radio1.addActionListener(this);
        Radio2.addActionListener(this);
        idDottoreField.setVisible(false);
        idPazienteField.setVisible(false);
        Registrazione.setVisible(false);
    }
    public static void main(String[] args) {
        new Login().setVisible(true);
    }
    
    @Override                // L'ACTION LISTENER DELL'INTERFACCIA LOGIN
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()== show){
           if(show.isSelected()){
               pass.setEchoChar('\0');
               show.setText("NASCONDI LA PASSWORD");
           }else{
                      pass.setEchoChar('*');
                      show.setText("MOSTRARE LA PASSWORD");
                       }
        }else if (e.getSource() == Registrazione) {
            new Registrazione().setVisible(true);
    	}else 
    		if(e.getSource()== login) {
    			 if (Radio1.isSelected() && Radio2.isSelected()) {
                     JOptionPane.showMessageDialog(this, "NON PUOI SELEZIONARE ENTRAMBI DOTTORE E PAZIENTE", "ERRORE", JOptionPane.ERROR_MESSAGE);
                 } else if (!Radio1.isSelected() && !Radio2.isSelected()) {
                     JOptionPane.showMessageDialog(this, "DEVI SELEZIONARE UN'OPZIONE TRA DOTTORE E PAZIENTE", "ERRORE", JOptionPane.ERROR_MESSAGE);
                 }else
    		checkEmail();
    
		} 
    		else if (e.getSource() == Radio1) {
                idDottoreField.setVisible(true);
                idPazienteField.setVisible(false);
              Registrazione.setVisible(true);
                panel.add(idDottoreField);
                idDottoreField.setBounds(300, 580, 400, 35);
                panel.revalidate();
                panel.repaint();
            } else if (e.getSource() == Radio2) {
                idPazienteField.setVisible(true);
                idDottoreField.setVisible(false);
                panel.add(idPazienteField);
                idPazienteField.setBounds(300, 580, 400, 35);
                panel.revalidate();
                panel.repaint();
              
        }
    }
    public void checkEmail() {
    	 try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto", "root", "Moustafa2001");
             String username = txt_name.getText();
             String password = new String(pass.getPassword());
             String sql;
             PreparedStatement pst;

             if (Radio1.isSelected()) {
                 String idDottore = idDottoreField.getText();
                 sql = "SELECT * FROM user WHERE username = ? AND password = ? AND idDottore = ?";
                 pst = con.prepareStatement(sql);
                 pst.setString(1, username);
                 pst.setString(2, password);
                 pst.setString(3, idDottore);
             } else {
                 String idPaziente = idPazienteField.getText();
                 sql = "SELECT * FROM user WHERE username = ? AND password = ? AND idPaziente = ?";
                 pst = con.prepareStatement(sql);
                 pst.setString(1, username);
                 pst.setString(2, password);
                 pst.setString(3, idPaziente);
             
             }
    	 

             ResultSet rs = pst.executeQuery();
             String user = "", pass = "", id = "";
             boolean isDoctor = Radio1.isSelected();

             while (rs.next()) {
                 user = rs.getString("username");
                 pass = rs.getString("password");
                 id = isDoctor ? rs.getString("idDottore") : rs.getString("idPaziente");
             }

             rs.close();
             pst.close();
             con.close();

             if (username.isEmpty() || password.isEmpty()) {
                 JOptionPane.showMessageDialog(null, "Perfavore assicurati dei dati", "Errore", JOptionPane.ERROR_MESSAGE);
             } 
             else if (username.equals(user) && password.equals(pass) && ((isDoctor && idDottoreField.getText().equals(id)) || (!isDoctor && idPazienteField.getText().equals(id)))) {
                 if (!isDoctor) {
                     new Interfaccia_di_Paziente().setVisible(true);
                 } else {
                 }
             } else {
                 new InterfacciaPrincipale().setVisible(true);
             }

         } catch (Exception ex) {
             ex.printStackTrace();
             JOptionPane.showMessageDialog(null, "Errore durante il login: " + ex.getMessage());
         }
     }
}
 