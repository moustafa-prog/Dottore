package Dottore;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class InterfacciaPrincipale extends JFrame implements ActionListener {
	JMenuBar Bar1  = new JMenuBar();
	JMenuItem Edit1 =  new JMenuItem("RICEVIMENTI");
	JMenu Edit = new JMenu("EDIT");
	JMenu File = new JMenu("FILE");
	JMenu Opizione = new JMenu("OPIZIONE");
	JMenu Aiutarsi = new JMenu("AIUTO");
	JMenu Account = new JMenu("ACCOUNTS");
	JLabel Dottore =new JLabel("DOTTORE");
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel(); 
	JPanel panel3 = new JPanel(); 
	JButton num1 = new JButton("RICEVIMENTI");		//الاستقبال
	JButton num2 = new JButton("SUCCESSIVO");		//التالي
	JButton num3 = new JButton("SERVIZI");			//الخدمات
	JButton num4 = new JButton("I DOTTORI");		//الاطباء
	JButton num5 = new JButton("DIPENDENTI");		// الموظفين
	JButton num6 = new JButton("STIPENDI");			//مصروفات
	JButton num7 = new JButton("CONTI/MEDICI");		//حسابات اطباء
	JButton num8 = new JButton("CONTI/DIP.");		//حسابات موظفين
	JButton num9 = new JButton("ASSISTENTE");		//مساعده
	JButton num10 = new JButton(" UTENTI");			//المستخدمين
	JButton num11 = new JButton("I PAZIENTI");		//المرضي
	JButton num12 = new JButton("USCITA");	//خروج
		
	public InterfacciaPrincipale() {
		 this.setTitle("UTENTE");
	      this.setLayout(null);
	        this.setResizable(false);
	       this.setSize(1006, 900);
	        this.setLocationRelativeTo(null);
	        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        this.add(Bar1);
	        this.add(panel1);
	        this.add(panel2);
	        this.add(panel3);
	        num12.addActionListener(this);
	       num3.addActionListener(this);

	        
	        						//DIMENSIONI DI PANELLI E BAR
 Bar1.setBounds(0,0,1000,20);
 	panel1.setBounds(0, 20,1000,75);
 		panel2.setBounds(800, 30,200,900);
 			panel3.setBounds(0, 95,800,900);
 			panel3.setLayout(new BorderLayout());
 				Dottore.setBounds(0,100,10,50);
	      
 									//COLORE DI BACKGROUND DI PANELLI E BOTTON
 panel1.setBackground(Color.yellow);
 	panel2.setBackground(Color.LIGHT_GRAY);
 		panel3.setBackground(Color.white);
 			num1.setBackground(Color.WHITE);
 				num2.setBackground(Color.WHITE);
 					num3.setBackground(Color.WHITE);
 						num4.setBackground(Color.WHITE); 
 							num5.setBackground(Color.WHITE);
 								num6.setBackground(Color.WHITE);
 									num7.setBackground(Color.WHITE);
 										num8.setBackground(Color.WHITE);
 											num9.setBackground(Color.WHITE);
 												num10.setBackground(Color.WHITE);
 													num11.setBackground(Color.WHITE);
 														num12.setBackground(Color.WHITE);
 									//DIMENSIONI DI FONT IN PANELLI E BUTTON
 Dottore.setFont(new Font("ALGERIAN",Font.BOLD,50));
 	num1.setFont(new Font("Congenial black",Font.BOLD,19));
 		num2.setFont(new Font("Congenial black",Font.BOLD,18));
 			num3.setFont(new Font("Congenial black",Font.BOLD,20));
 				num4.setFont(new Font("Congenial black",Font.BOLD,20));
 					num5.setFont(new Font("Congenial black",Font.BOLD,20));
 						num6.setFont(new Font("Congenial black",Font.BOLD,20));
 							num7.setFont(new Font("Congenial black",Font.BOLD,17));
 								num8.setFont(new Font("Congenial black",Font.BOLD,18));
 									num9.setFont(new Font("Congenial black",Font.BOLD,18));
 										num10.setFont(new Font("Congenial black",Font.BOLD,20));
 											num11.setFont(new Font("Congenial black",Font.BOLD,20));
 												num12.setFont(new Font("Congenial black",Font.BOLD,20));
	        
 					//MOSTRARE I BAR E PANELLI IN FINISTRA
 			Edit.add(Edit1);
 			Bar1.add(Edit);
	        Bar1.add(File);
	        Bar1.add(Opizione);
	        Bar1.add(Aiutarsi);
	        panel1.add(Dottore);

	        ImageIcon icon = new ImageIcon("C:\\Users\\peschiera721\\OneDrive\\Immagini\\Catture di schermata\\Screenshot 2024-07-19 191350.png");
	        ImageIcon icon1 = new ImageIcon("C:\\Users\\peschiera721\\OneDrive\\Immagini\\Catture di schermata\\Screenshot 2024-07-20 132009.png");
	        num1.setIcon(icon);
	        num2.setIcon(icon);
	        num3.setIcon(icon);
	        num4.setIcon(icon);
	        num5.setIcon(icon);
	        num6.setIcon(icon);
	        num7.setIcon(icon);
	        num8.setIcon(icon);
	        num9.setIcon(icon);
	        num10.setIcon(icon);
	        num11.setIcon(icon);
	        num12.setIcon(icon1);
	    
	    	 panel2.setLayout(new GridBagLayout());
	    	 
	       GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(10, 0, 20, 10); // Add vertical spacing
	        gbc.gridx = 0;
	        gbc.gridy = 1;
	     gbc.fill = GridBagConstraints.HORIZONTAL; // Make buttons fill the horizontal space
	     
	        gbc.gridy = 1;
	        panel2.add(num1, gbc);
	        gbc.gridy = 2;
	        panel2.add(num2, gbc);
	        gbc.gridy = 3;
	        panel2.add(num3, gbc);
	        gbc.gridy = 4;
	        panel2.add(num4, gbc);
	        gbc.gridy = 5;
	        panel2.add(num5, gbc);
	        gbc.gridy = 6;
	        panel2.add(num6, gbc);
	        gbc.gridy = 7;
	        panel2.add(num7, gbc);
	        gbc.gridy = 8;
	        panel2.add(num8, gbc);
	        gbc.gridy = 9;
	        panel2.add(num9, gbc);
	        gbc.gridy = 10;
	        panel2.add(num10, gbc);
	        gbc.gridy = 11;
	        panel2.add(num11, gbc);
	        gbc.gridy = 12;
	        panel2.add(num12, gbc);
	       
	} public JPanel getpanel3() {
        return panel3;
	}

	public static void main(String[] args) {
        new InterfacciaPrincipale().setVisible(true);
    }
	 public void actionPerformed(ActionEvent e) {
		 if(e.getSource() == num12) {
         	int c = JOptionPane.showConfirmDialog(null, "VOUI CHIUDERE L'APP", "SCELTA",JOptionPane.YES_NO_OPTION);
      if(c == 0)   {
     	 System.exit(0);}
      
     	 }else if (e.getSource() == num3) {
     		
     		ServicePanel servicePanel = new ServicePanel();
            panel3.removeAll();
            panel3.revalidate();
            panel3.repaint();
            panel3.add(servicePanel.getPanelA(), BorderLayout.CENTER);
       
	 }
}	
}