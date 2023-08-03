package team;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import team.region.showbeachlist;
import javax.swing.Icon;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextArea;


public class beachmaintest1 extends JFrame {
	
	private JPanel contentPane;
	private URL searchURL;

	private ImageIcon imageicon;

	private JButton button;
	
	
	   

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					beachmaintest1 frame = new beachmaintest1();
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
	public beachmaintest1() {
		
		setTitle("바다가자");
		int a=40;
	      
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 795, 563);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255, 255, 255));
		
		
		searchURL = getClass().getResource("/image/southchungcheong.png");
		imageicon = new ImageIcon(searchURL);
		JButton southchungcheong = new JButton(imageicon);
		southchungcheong.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				try {
					new showbeachlist("충청남도");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		southchungcheong.setBounds(247, 149, 111, 115);
		contentPane.add(southchungcheong);
		southchungcheong.setBackground(new Color(204,255,204));
		
		southchungcheong.setBorderPainted(false);

		southchungcheong.setFocusPainted(false);

		southchungcheong.setContentAreaFilled(false);
		
		
		

		searchURL = getClass().getResource("/image/northjeonla.png");
		imageicon = new ImageIcon(searchURL);
		JButton northjeonla = new JButton(imageicon);
		northjeonla.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				try {
					new showbeachlist("전라북도");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		northjeonla.setBounds(261, 241, 111, 105);
		contentPane.add(northjeonla);
		northjeonla.setBackground(new Color(153,204,153));
		
		northjeonla.setBorderPainted(false);

		northjeonla.setFocusPainted(false);

		northjeonla.setContentAreaFilled(false);
		
		
		
		searchURL = getClass().getResource("/image/northgyeongsang.png");
		imageicon = new ImageIcon(searchURL);
		JButton northgyongsang = new JButton(imageicon);
		northgyongsang.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				try {
					new showbeachlist("경상북도");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		northgyongsang.setBounds(374, 176, 132, 180);
		contentPane.add(northgyongsang);
		northgyongsang.setBackground(new Color(102,153,102));
		
		northgyongsang.setBorderPainted(false);

		northgyongsang.setFocusPainted(false);

		northgyongsang.setContentAreaFilled(false);
		
		
		searchURL = getClass().getResource("/image/jeju.png");
		imageicon = new ImageIcon(searchURL);
		JButton jeju = new JButton(imageicon);
		jeju.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				try {
					new showbeachlist("제주도");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		jeju.setBounds(214, 419, 91, 53);
		contentPane.add(jeju);
		jeju.setBackground(new Color(51,102,51));
		
		jeju.setBorderPainted(false);

		jeju.setFocusPainted(false);

		jeju.setContentAreaFilled(false);
		
		
		
		searchURL = getClass().getResource("/image/gyeongi.png");
		imageicon = new ImageIcon(searchURL);
		JButton gyeongi = new JButton(imageicon);
		gyeongi.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				try {
					new showbeachlist("경기도");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		gyeongi.setBounds(247, 50, 125, 127);
		contentPane.add(gyeongi);
		gyeongi.setBackground(new Color(153,255,153));
		
		gyeongi.setBorderPainted(false);

		gyeongi.setFocusPainted(false);

		gyeongi.setContentAreaFilled(false);
		
		
		
		searchURL = getClass().getResource("/image/southjeonra.png");
		imageicon = new ImageIcon(searchURL);
		JButton southjeonra = new JButton(imageicon);
		southjeonra.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				try {
					new showbeachlist("전라남도");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		southjeonra.setBounds(224, 313, 127, 127);
		contentPane.add(southjeonra);
		southjeonra.setBackground(new Color(102,204,102));
		
		southjeonra.setBorderPainted(false);

		southjeonra.setFocusPainted(false);

		southjeonra.setContentAreaFilled(false);
		
		
		searchURL = getClass().getResource("/image/southgyeongsang.png");
		imageicon = new ImageIcon(searchURL);
		JButton southgyongsang = new JButton(imageicon);
		southgyongsang.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				try {
					new showbeachlist("경상남도");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		southgyongsang.setBounds(344, 327, 111, 110);
		contentPane.add(southgyongsang);
		southgyongsang.setBackground(new Color(51,153,51));
		
		southgyongsang.setBorderPainted(false);

		southgyongsang.setFocusPainted(false);

		southgyongsang.setContentAreaFilled(false);
		
		
		searchURL = getClass().getResource("/image/gangwon_.png");
		imageicon = new ImageIcon(searchURL);
		JButton gwangwon = new JButton(imageicon);
		gwangwon.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				try {
					new showbeachlist("강원도");
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		gwangwon.setBounds(348, 50, 118, 127);
		contentPane.add(gwangwon);
		gwangwon.setBackground(new Color(0,102,0));
		
		gwangwon.setBorderPainted(false);

		gwangwon.setFocusPainted(false);

		gwangwon.setContentAreaFilled(false);
		
	
		JButton exit = new JButton("\uC885\uB8CC");
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		exit.setBounds(637, 479, 97, 23);
		contentPane.add(exit);
		
		searchURL = getClass().getResource("/image/beach (4).png");
		imageicon = new ImageIcon(searchURL);
		JLabel lblNewLabel = new JLabel(imageicon);
		
		lblNewLabel.setBounds(-110, 0, 896, 524);
		contentPane.add(lblNewLabel);
		

	}
}
