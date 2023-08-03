package membership;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import packCon.DBConnection;
import packVO.TBL_USER_VO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUpMain extends JFrame {

	private JPanel contentPane;
	private JPasswordField textPW;
	private JTextField textNickname;
	private JTextField textEamil;
	private JTextField textAddress;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpMain frame = new SignUpMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}// run-end
		});
	}// main-end

	/**
	 * Create the frame.
	 */
	public SignUpMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 396);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// JLabel
		JLabel lblID = new JLabel("\uC544\uC774\uB514*");
		lblID.setBounds(12, 96, 57, 15);
		contentPane.add(lblID);

		JLabel lblPassword = new JLabel("\uBE44\uBC00\uBC88\uD638*");
		lblPassword.setBounds(12, 134, 57, 15);
		contentPane.add(lblPassword);

		JLabel lblNickname = new JLabel("\uB2C9\uB124\uC784*");
		lblNickname.setBounds(12, 174, 57, 15);
		contentPane.add(lblNickname);

		JLabel lblEmail = new JLabel("\uC774\uBA54\uC77C");
		lblEmail.setBounds(12, 213, 57, 15);
		contentPane.add(lblEmail);

		JLabel lblAddress = new JLabel("\uC8FC\uC18C");
		lblAddress.setBounds(12, 252, 57, 15);
		contentPane.add(lblAddress);

		// JTextField
		JTextField textID = new JTextField();
		textID.setBounds(68, 93, 116, 21);
		contentPane.add(textID);
		textID.setColumns(10);

		textPW = new JPasswordField();
		textPW.setBounds(68, 131, 116, 21);
		textPW.setColumns(10);
		contentPane.add(textPW);

		textNickname = new JTextField();
		textNickname.setBounds(68, 171, 116, 21);
		textNickname.setColumns(10);
		contentPane.add(textNickname);

		textEamil = new JTextField();
		textEamil.setBounds(68, 210, 166, 21);
		textEamil.setColumns(10);
		contentPane.add(textEamil);

		textAddress = new JTextField();
		textAddress.setBounds(68, 249, 249, 21);
		textAddress.setColumns(10);
		contentPane.add(textAddress);

		//////////////////// 회원가입버튼//////////////////////
		JButton btnYES = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnYES.setFont(new Font("나눔고딕", Font.BOLD, 12));
		btnYES.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				////////////////////////
				Connection con1 = null;
				try {
				//연결에 필요한 정보
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "c##bada";
				String pw = "bada";
				
				//드라이버를 메모리에 할당
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//연결된 객체 가져오기
				con1 = DriverManager.getConnection(url, user, pw);
				}catch(ClassNotFoundException e1) {
					System.out.println("드라이버 로딩 실패"); //드라이버 주소 잘못됨
				}catch(SQLException e1) {
					System.out.println("연결 실패"); //url 잘못됨
				}catch(Exception e1) {
					System.out.println("알 수 없는 오류");
				}
				System.out.println("db연결됨");
				
			
			
				// 클릭이벤트
				String query = "INSERT INTO memberinfo(mem_name, nickname, mem_id, mem_pw, email," +
				        " address)"
						+ "VALUES(?,?,?,?,?,?)";
				PreparedStatement pstm = null;
				try {
					pstm = con1.prepareStatement(query);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				try {
					pstm = con1.prepareStatement(query);

					pstm.setString(1, textName.getText());
					pstm.setString(2, textNickname.getText());
					pstm.setString(3, textID.getText());
					pstm.setString(4, textPW.getText());
					pstm.setString(5, textEamil.getText());
					pstm.setString(6, textAddress.getText());

				} catch (SQLException e1) {
					System.out.println("join SQL문 오류");
				} catch (Exception e1) {
					e1.printStackTrace();
				} // catch-end

				int cnt = 0;
				try {
					cnt = pstm.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (cnt >= 1) {
					System.out.println(cnt + "행 update");// update 행 갯수
				} else {
					System.out.println("update error");
				}

				//닫기
				try {
					if(con1 != null) {
						con1.close();
					}
					if(pstm != null) {
						pstm.close();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dispose();
				setVisible(false);
				new SignUpComplete().setVisible(true);

			}// mcEvent-end
		});
		btnYES.setBackground(SystemColor.textHighlight);
		btnYES.setForeground(SystemColor.textHighlightText);
		btnYES.setBounds(68, 293, 95, 32);
		contentPane.add(btnYES);

		//////////////////// 회원가입 닫기버튼//////////////////////
		JButton btnNO = new JButton("\uB2EB\uAE30");
		btnNO.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnNO.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 클릭이벤트
				System.exit(0);
			}
		});
		btnNO.setBackground(SystemColor.window);
		btnNO.setForeground(SystemColor.desktop);
		btnNO.setBounds(175, 293, 95, 32);
		btnNO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNO);

		JLabel lblNewLabel_4 = new JLabel("Information");
		lblNewLabel_4.setForeground(SystemColor.textHighlight);
		lblNewLabel_4.setBounds(12, 10, 101, 34);
		lblNewLabel_4.setFont(new Font("나눔고딕", Font.BOLD, 16));
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984*");
		lblNewLabel_1.setBounds(12, 57, 57, 15);
		contentPane.add(lblNewLabel_1);

		textName = new JTextField();
		textName.setBounds(68, 54, 116, 21);
		contentPane.add(textName);
		textName.setColumns(10);
	}
}
