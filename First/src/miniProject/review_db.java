package miniProject;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import team.region.showbeachlist;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class review_db extends JFrame {
	
	
	
	private JPanel contentPane;
	review_main rm = new review_main();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					review_db frame = new review_db();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
	public  review_db() {
		
	}
	
	public review_db(String badaname, String siname) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("리뷰작성완료");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGoback = new JButton("\uB9AC\uBDF0\uBAA9\uB85D\uBCF4\uAE30");
		btnGoback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGoback.addMouseListener(new MouseAdapter() {
			private JTextArea textArea;

			@Override
			public void mouseClicked(MouseEvent e) {
				
				dispose();
				try {
					new showbeachlist(siname);
					System.out.println(siname);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnGoback.setBounds(139, 228, 128, 23);
		getContentPane().add(btnGoback);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 10, 350, 150);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea(rm.rv);
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setDragEnabled(false);
		
		JLabel lblNewLabel = new JLabel("\uD3B8\uC758\uC2DC\uC124 :");
		lblNewLabel.setBounds(34, 170, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uAD50\uD1B5\uD3B8 :");
		lblNewLabel_1.setBounds(34, 189, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uD63C\uC7A1\uB3C4 :");
		lblNewLabel_2.setBounds(34, 206, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(rm.selFac);
		lblNewLabel_3.setBounds(100, 170, 150, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel(rm.selTrans);
		lblNewLabel_3_1.setBounds(100, 189, 150, 15);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel(rm.selCong);
		lblNewLabel_3_2.setBounds(100, 206, 150, 15);
		contentPane.add(lblNewLabel_3_2);
		
	}

	

	
}
	