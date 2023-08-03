package miniProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class main_open extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_open frame = new main_open();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public main_open() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC804\uAD6D \uD574\uC218\uC695\uC7A5");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel.setBounds(102, 25, 188, 76);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			
			///////////////////////////////////////////
			@Override
			public void mouseClicked(MouseEvent e) {
				
					//gangwon�뜝�럩紐드슖�댙�삕 �뤆�룊�삕占썩뫅�삕 �뜝�럡�룎�뜝�럥裕� close
					dispose();
					setVisible(false);
					new gangwon().setVisible(true);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(main_open.class.getResource("/image2/gyeonggi.png")));
		lblNewLabel_1.setBounds(196, 111, 126, 137);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(main_open.class.getResource("/image2/gyeonggi.png")));
		lblNewLabel_1_1.setBounds(96, 130, 106, 99);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setIcon(new ImageIcon(main_open.class.getResource("/image2/jeonBug.png")));
		lblNewLabel_1_3.setBounds(184, 355, 106, 99);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("");
		lblNewLabel_1_3_1.setIcon(new ImageIcon(main_open.class.getResource("/image2/jeonNam.png")));
		lblNewLabel_1_3_1.setBounds(71, 400, 106, 99);
		contentPane.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("");
		lblNewLabel_1_3_2.setIcon(new ImageIcon(main_open.class.getResource("/image2/gyeonggi.png")));
		lblNewLabel_1_3_2.setBounds(97, 310, 106, 99);
		contentPane.add(lblNewLabel_1_3_2);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("");
		lblNewLabel_1_3_3.setIcon(new ImageIcon(main_open.class.getResource("/image2/chungNam.png")));
		lblNewLabel_1_3_3.setBounds(97, 226, 106, 99);
		contentPane.add(lblNewLabel_1_3_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(main_open.class.getResource("/image2/gyeonggi.png")));
		lblNewLabel_1_2.setBounds(223, 235, 126, 160);
		contentPane.add(lblNewLabel_1_2);
	}
}
