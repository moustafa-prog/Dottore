package Dottore;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class ButtonDiIformazioneServise extends JFrame{
	 static JPanel Panel1 = new JPanel(null);
	    JPanel Panel2 = new JPanel(null);
	    JLabel Label = new JLabel("PREZZO DI RILEVAMENTO");
	    JLabel Label2 = new JLabel("NOME DELLA CLINICA");
	    JTextField label1 = new JTextField();
	    JTextField label2 = new JTextField();
	    JTable Tabel = new JTable();
	    JTable Tabel2 = new JTable();
	    DefaultTableModel tableModel;
	    DefaultTableModel tableModel2;
	    JButton Button1 = new JButton("+");
	    JButton Button2 = new JButton("");
	    private int lastAddedRow = -1;
	    JButton Button4 = new JButton("+");
	    JButton Button5 = new JButton("");
	    JButton Button3 = new JButton("DELETE");
	public ButtonDiIformazioneServise() {
		 this.setTitle("INFORMAZIONE");
	        this.setSize(800, 770);
	        this.add(Panel1);
	        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	        Panel1.setBounds(0, 0, 811, 770);
	        Panel2.setBounds(0, 0, 811, 250);
	        Label.setBounds(460, 100, 190, 35);
	        label1.setBounds(650, 55, 120, 25);
	        Label2.setBounds(460, 50, 190, 35);
	        label2.setBounds(650, 100, 120, 25);
	        Button1.setBounds(0, 300, 50, 35);
	        Button2.setBounds(0, 350, 50, 35);
	        Button3.setBounds(50, 600, 130, 35);
	        Button4.setBounds(10, 50, 50, 35);
	        Button5.setBounds(10, 100, 50, 35);
	        Panel1.setBackground(Color.decode("#89CFF0"));
	        Panel2.setBackground(Color.yellow);
	        Label.setFont(new Font("Congenial black", Font.BOLD, 15));
	        Label2.setFont(new Font("Congenial black", Font.BOLD, 15));
	        ImageIcon icon = new ImageIcon("C:\\Users\\peschiera721\\OneDrive\\Immagini\\Catture di schermata\\Screenshot 2024-07-20 132009.png");
	        Button3.setFont(new Font("Congenial black", Font.BOLD, 20));
	        Panel1.add(Panel2);
	        Panel2.add(Label);
	        Panel2.add(label1);
	        Panel2.add(Label2);
	        Panel2.add(label2);
	        Panel1.add(Button1);
	        Panel1.add(Button2);
	        Button2.setIcon(icon);
	        Panel1.add(Button3);
	        Panel2.add(Button4);
	        Panel2.add(Button5);
	        Button5.setIcon(icon);
	        Button1.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {

	                tableModel.addRow(new String[]{"", "", "", ""});
	          
	            }
	        });
	        Button2.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	             
	                int[] selectedRows = Tabel.getSelectedRows();
	                for (int i = selectedRows.length - 1; i >= 0; i--) {
	                    tableModel.removeRow(selectedRows[i]);
	                }
	             
	                if (lastAddedRow >= 0 && lastAddedRow < tableModel.getRowCount()) {
	                    tableModel.removeRow(lastAddedRow);
	                    lastAddedRow = 1; 
	                }
	                	
	                																	
	                for (int i = 0; i < tableModel.getRowCount(); i++) {
	                    tableModel.setValueAt(i + 1, i, 0); 						
	                }
	            }
	        });
	        Button3.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {

	            	 tableModel.setRowCount(0);
	              
	                 label1.setText("");
	                 label2.setText("");
	                 tableModel2.setRowCount(0);;
	                 lastAddedRow = -1;
	            }
	        });
	        String[] columnNames = {"NOME DELLA CLINICA", "PREZZO DI RILEVAMENTO "};
	        String[][] data = {
	        		{"", ""},
	        		{"", ""},
	        		{"", ""},
	        		{"", ""},
	        		{"", ""}
	        };
	        tableModel2 = new DefaultTableModel(data, columnNames);
	        Tabel2= new JTable(tableModel2);
	        JScrollPane scrollPane = new JScrollPane(Tabel2);
	        scrollPane.setBounds(70, 40, 350, 100);
	        Panel2.add(scrollPane);
	        
	        String[] columnNames1 = {"Colonna 1", "Colonna 2", "Colonna 3", "Colonna 4"};
	        String[][] data1 = {};

	        tableModel = new DefaultTableModel(data1, columnNames1);
	        Tabel = new JTable(tableModel);
	        JScrollPane scrollpane = new JScrollPane(Tabel);
	        scrollpane.setBounds(50, 250, 700, 300);
	        Panel1.add(scrollpane);
	        Button4.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {

	                tableModel2.addRow(new String[]{"", "", "", ""});
	          
	            }
	        });
	        Button5.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	             
	                int[] selectedRows = Tabel2.getSelectedRows();
	                for (int i = selectedRows.length - 1; i >= 0; i--) {
	                    tableModel2.removeRow(selectedRows[i]);
	                }
	             
	                if (lastAddedRow >= 0 && lastAddedRow < tableModel2.getRowCount()) {
	                    tableModel2.removeRow(lastAddedRow);
	                    lastAddedRow = 1; 
	                }
	                	
	                																	
	                for (int i = 0; i < tableModel2.getRowCount(); i++) {
	                    tableModel2.setValueAt(i + 1, i, 0); 						
	                }
	            }
	        });
	}

	public static void main(String[] args) {
		 new ButtonDiIformazioneServise().setVisible(true);

	}

}
