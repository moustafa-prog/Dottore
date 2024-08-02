		
		package Paziente;
		import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
		
		
		import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
		import java.sql.Statement;
		import javax.swing.JButton;
		import javax.swing.JFrame;
		import javax.swing.JLabel;
		import javax.swing.JOptionPane;
		import javax.swing.JPanel;
		import javax.swing.JScrollPane;
		import javax.swing.JTable;
		import javax.swing.JTextField;
		import javax.swing.table.DefaultTableModel;
		
public class Service_Pane_Paziente extends JFrame {
		   public static final String insertSQL = null;
		static JPanel PanelA = new JPanel(null);
		    JPanel Panela = new JPanel(null);
		    JLabel Label = new JLabel("NOME DELLA CLINICA");
		    JLabel Label2 = new JLabel("PREZZO DI RILEVAMENTO");
		    JLabel ServicePanelform = new JLabel("servizi");
		    JTextField label1 = new JTextField();
		    JTextField label2 = new JTextField();
		    JTable Tabel;
		    DefaultTableModel tableModel;
		    JButton Button1 = new JButton("DELETE");
		    JButton Button2 = new JButton("ADD");
		    JButton Button3 = new JButton("INFORMAZIONE");
		    JButton Button4 = new JButton("+");
		    JButton Button5 = new JButton("");
		  
 public Service_Pane_Paziente() {
		        this.setTitle("ServicePanel");
		        this.setSize(800, 770);
		        this.add(PanelA);
		        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		        PanelA.setBounds(0, 0, 811, 770);
		        Panela.setBounds(0, 0, 811, 150);
		
		        Label.setBounds(0, 50, 190, 35);
		        label1.setBounds(170, 55, 120, 25);
		        Label2.setBounds(480, 50, 190, 35);
		        label2.setBounds(670, 55, 120, 25);
		        ServicePanelform.setBounds(250, 160, 600, 50);
		        Button1.setBounds(50, 600, 130, 35);
		        Button2.setBounds(650, 600, 100, 35);
		        Button3.setBounds(300, 650, 200, 35);
		        Button4.setBounds(0, 300, 50, 35);
		        Button5.setBounds(0, 350, 50, 35);
		        String[] columnNames = {"clincName","price","Colonna 1", "Colonna 2", "Colonna 3", "codice_fiscale"};
		        String[][] data = {};
		
		        tableModel = new DefaultTableModel(data, columnNames);
		        Tabel = new JTable(tableModel);
		        JScrollPane scrollPane = new JScrollPane(Tabel);
		        scrollPane.setBounds(50, 230, 700, 300);
		        PanelA.setBackground(Color.decode("#89CFF0"));
		        Panela.setBackground(Color.decode("#89CFF0"));
		        Button1.setBackground(Color.WHITE);
		        Button2.setBackground(Color.WHITE);
		        Button3.setBackground(Color.WHITE);
		
		        ServicePanelform.setFont(new Font("ALGERIAN", Font.BOLD, 50));
		        Button1.setFont(new Font("Congenial black", Font.BOLD, 20));
		        Button2.setFont(new Font("Congenial black", Font.BOLD, 20));
		        Button3.setFont(new Font("Congenial black", Font.BOLD, 20));
		        Label.setFont(new Font("Congenial black", Font.BOLD, 15));
		        Label2.setFont(new Font("Congenial black", Font.BOLD, 15));
		      //  ImageIcon icon1 = new ImageIcon("C:\\Users\\peschiera721\\OneDrive\\Immagini\\Catture di schermata\\Screenshot 2024-07-20 132009.png");
		
		      PanelA.add(Panela);
		   
		        PanelA.add(ServicePanelform);
		        PanelA.add(scrollPane);
 }
 
 @SuppressWarnings("unused")
private void loadDataFromDatabase() {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        // Carica il driver JDBC
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // Connettiti al database
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/progetto", "root", "Moustafa2001");

	        // Esegui la query SQL per ottenere i dati
	        String SQL = "SELECT clinicName, price, col1, col2, col3, codice_fiscale FROM servizi";
	        pstmt = conn.prepareStatement(SQL);
	        rs = pstmt.executeQuery();

	        // Rimuovi tutte le righe esistenti dal modello della tabella
	        tableModel.setRowCount(0);

	        // Itera attraverso il ResultSet e aggiungi i dati al modello della tabella
	        while (rs.next()) {
	            String clinicName = rs.getString("clinicName");
	            String price = rs.getString("price");
	            String col1 = rs.getString("col1");
	            String col2 = rs.getString("col2");
	            String col3 = rs.getString("col3");
	            String codiceFiscale = rs.getString("codice_fiscale");

	            // Aggiungi la riga al modello della tabella
	            tableModel.addRow(new Object[]{clinicName, price, col1, col2, col3, codiceFiscale});
	        }

	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Errore durante il caricamento dei dati: " + ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	}
  

		    

		    public JPanel getPanelA() {
		        return PanelA ;
		    }
				public static void main(String[] args) {
					 JFrame frame = new JFrame(" ServicePanel");
				        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        frame.add(new Service_Pane_Paziente());
				        frame.setSize(800, 700);
				        frame.setVisible(true);
				
		
				}
		    
		    




}