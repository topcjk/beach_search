package login;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import membership.SignUpComplete;
import membership.SignUpMain;
import packVO.TBL_USER_VO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginMain extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JPasswordField textPW;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginMain frame = new LoginMain();
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
	public LoginMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 240);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("������� ExtraBold", Font.BOLD, 30));
		lblNewLabel.setBounds(31, 16, 108, 57);
		contentPane.add(lblNewLabel);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblID.setBounds(41, 73, 35, 35);
		contentPane.add(lblID);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(40, 116, 99, 18);
		contentPane.add(lblNewLabel_1);
		
		textID = new JTextField();
		textID.setBounds(125, 83, 116, 21);
		contentPane.add(textID);
		textID.setColumns(10);
		
		textPW = new JPasswordField();
		textPW.setBounds(125, 118, 116, 21);
		contentPane.add(textPW);
		textPW.setColumns(10);
	//	textPW.setEchoChar('*');
		
		/////////////�α��ι�ư////////////
		JButton btnLogin = new JButton("\uB85C\uADF8\uC778");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Ŭ���̺�Ʈ
				Connection con1 = null;
				ResultSet rs = null;
				try {
				//���ῡ �ʿ��� ����
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "hr";
				String pw = "hr";
				
				//����̹��� �޸𸮿� �Ҵ�
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//����� ��ü ��������
				con1 = DriverManager.getConnection(url, user, pw);
				}catch(ClassNotFoundException e1) {
					System.out.println("����̹� �ε� ����"); //����̹� �ּ� �߸���
				}catch(SQLException e1) {
					System.out.println("���� ����"); //url �߸���
				}catch(Exception e1) {
					System.out.println("�� �� ���� ����");
				}
				System.out.println("db�����");
			
				// Ŭ���̺�Ʈ
				String query = "SELECT mem_pw FROM memberinfo WHERE mem_id=?";
				PreparedStatement pstm = null;
				try {
					pstm = con1.prepareStatement(query);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				try {
					pstm = con1.prepareStatement(query);
					
					pstm.setString(1, textID.getText());
					rs = pstm.executeQuery();
					
					if(rs.next()) {
						if(rs.getString(1).equals(textPW.getText())) {
						dispose();
						setVisible(false);
						new LoginSuccess().setVisible(true);
						}else {
							new PasswordFail().setVisible(true);
							return;
						}
					  }else {
						  new IdFail().setVisible(true);
					  }
						
				} catch (SQLException e1) {
					System.out.println("join SQL�� ����");
				} catch (Exception e1) {
					e1.printStackTrace();
				} // catch-end
				
				try {
					if(con1 != null) {
						con1.close();
					}
					if(pstm != null) {
						pstm.close();
					}
					if(rs != null) {
						rs.close();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			}//mouse-end
		});
		btnLogin.setFont(new Font("����", Font.BOLD, 12));
		btnLogin.setForeground(SystemColor.window);
		btnLogin.setBackground(SystemColor.textHighlight);
		btnLogin.setBounds(263, 82, 74, 57);
		contentPane.add(btnLogin);
		
		JLabel lblSignUp = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblSignUp.setFont(new Font("�������", Font.PLAIN, 12));
		lblSignUp.addMouseListener(new MouseAdapter() {
			///////////ȸ������ ���콺Ŭ���̺�Ʈ//////////////
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new SignUpMain().setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSignUp.setForeground(Color.blue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSignUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblSignUp.setForeground(Color.black);
			}
		});
		lblSignUp.setBounds(125, 150, 57, 15);
		contentPane.add(lblSignUp);
		
	}
}


