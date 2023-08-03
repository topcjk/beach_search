package start;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

import login.LoginMain;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Start extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 236);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Start.class.getResource("/mapimg/\uB85C\uACE0.jpg")));
		lblNewLabel.setBounds(13, 10, 200, 174);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uC2DC\uC791\uD558\uAE30");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dispose();
				setVisible(false);
				JOptionPane.showMessageDialog(btnNewButton, "로그인이 필요합니다");
				new LoginMain().setVisible(true);
			}
		});
		btnNewButton.setBounds(261, 161, 97, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\uC804\uAD6D \uD574\uC218\uC695\uC7A5 \uC815\uBCF4 \uBC0F \uB9AC\uBDF0");
		lblNewLabel_1.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(233, 60, 160, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\"\uBC14\uB2E4\uAC00\uC790\"");
		lblNewLabel_2.setBackground(new Color(0, 128, 255));
		lblNewLabel_2.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(280, 111, 57, 15);
		contentPane.add(lblNewLabel_2);
	}
}



































