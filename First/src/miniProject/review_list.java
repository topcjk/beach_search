package miniProject;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class review_list extends JFrame {

	private JPanel contentPane;

	Connection con; // 
	String query;
	Statement stmt;
	ResultSet rs;

	public void review_list() {
		
	}

	

	public review_list(String r) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uB9AC\uBDF01");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dispose();
				setVisible(false);
				
				
			}
		});
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(26, 26, 71, 24);
		getContentPane().add(lblNewLabel);
		
	}



	public review_list() {
		
		// TODO Auto-generated constructor stub
	}
}

