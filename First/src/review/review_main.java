
package review;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import team.region.showbeachlist;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class review_main extends JFrame {

	
	private JPanel contentPane;
	private JTextArea textArea;
	private JRadioButton rb1_1,rb1_2,rb1_3,rb2_1,rb2_2,rb2_3,rb3_1,rb3_2,rb3_3;
	
	public static String selFac ="";
	public static String selTrans = "";	// 선택된 교통수단 넣을 곳
	public static String selCong = "";	// 선택된 혼잡도 넣을 곳
	public static String rv;
	 
	public static String badaname;
	public static String siname;
	 
	private URL searchURL;

	private ImageIcon imageicon;
	private Image img;
	Image updatedimage;

	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					review_main frame = new review_main(badaname, siname);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
//	public review_main() {
//		getContentPane().setLayout(null);
//	}
	
	public review_main(String final_beachname, String siname) {
		
		this.badaname = final_beachname;
		this.siname = siname;
		
		searchURL = getClass().getResource("/image/writeBeach.jpg");
	    imageicon = new ImageIcon(searchURL);
	    img=imageicon.getImage();
	    updatedimage=img.getScaledInstance(471, 546, Image.SCALE_SMOOTH);
	    ImageIcon updatedicon=new ImageIcon(updatedimage);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("리뷰");
		setBounds(100, 100, 471, 546);
		setLocationRelativeTo(null);
		contentPane = new JPanel() {
			 public void paintComponent(Graphics g) {
	             g.drawImage(updatedicon.getImage(), 0, 0, null);
	             setOpaque(false); //그림을 표시하게 설정,투명하게 조절
	             super.paintComponent(g);
	          }
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
	
		JButton btnNewButton = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		btnNewButton.setBounds(174, 474, 97, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dispose();
				setVisible(false);
				
				try {
					new showbeachlist(siname);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(29, 150, 390, 157);
		contentPane.add(scrollPane_1);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		textArea.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uB9AC\uBDF0 \uC791\uC131");
		lblNewLabel.setBounds(169, 34, 122, 51);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("편의시설 :");
		lblNewLabel_1.setBounds(29, 326, 62, 23);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 13));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uC774\uB3D9\uC218\uB2E8 :");
		lblNewLabel_1_1.setBounds(29, 368, 57, 15);
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uD63C\uC7A1\uB3C4 :");
		lblNewLabel_1_2.setBounds(29, 403, 57, 15);
		lblNewLabel_1_2.setFont(new Font("굴림", Font.PLAIN, 13));
		contentPane.add(lblNewLabel_1_2);
		
		JRadioButton rb2_1 = new JRadioButton("\uC9C0\uD558\uCCA0");
		rb2_1.setBounds(114, 364, 81, 23);
		rb2_1.setFont(new Font("굴림", Font.PLAIN, 13));
		contentPane.add(rb2_1);
		rb2_1.setText("지하철");
		rb2_1.setOpaque(false);
			
		JRadioButton rb2_2 = new JRadioButton("\uBC84\uC2A4");
		rb2_2.setBounds(224, 364, 81, 23);
		rb2_2.setFont(new Font("굴림", Font.PLAIN, 13));
		contentPane.add(rb2_2);
		rb2_2.setOpaque(false);
		
		JRadioButton rb2_3 = new JRadioButton("\uC790\uCC28");
		rb2_3.setBounds(333, 364, 81, 23);
		rb2_3.setFont(new Font("굴림", Font.PLAIN, 13));
		contentPane.add(rb2_3);
		rb2_3.setOpaque(false);
		
		JRadioButton rb3_1 = new JRadioButton("\uC6D0\uD65C");
		rb3_1.setBounds(114, 399, 81, 23);
		rb3_1.setFont(new Font("굴림", Font.PLAIN, 13));
		contentPane.add(rb3_1);
		rb3_1.setOpaque(false);
		
		JRadioButton rb3_2 = new JRadioButton("\uBCF4\uD1B5");
		rb3_2.setBounds(224, 399, 81, 23);
		rb3_2.setFont(new Font("굴림", Font.PLAIN, 13));
		contentPane.add(rb3_2);
		rb3_2.setOpaque(false);
		
		JRadioButton rb3_3 = new JRadioButton("\uD63C\uC7A1");
		rb3_3.setBounds(333, 399, 81, 23);
		rb3_3.setFont(new Font("굴림", Font.PLAIN, 13));
		contentPane.add(rb3_3);
		rb3_3.setOpaque(false);
		
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(rb2_1);
		bg2.add(rb2_2);
		bg2.add(rb2_3);
		ButtonGroup bg3 = new ButtonGroup();
		bg3.add(rb3_1);
		bg3.add(rb3_2);
		bg3.add(rb3_3);
		
		
		// 체크박스
		
		JCheckBox cb = new JCheckBox("\uD3B8\uC758\uC810");
		cb.setBounds(114, 326, 67, 23);
		cb.setFont(new Font("굴림", Font.PLAIN, 13));
		contentPane.add(cb);
		cb.setOpaque(false);
		
		JCheckBox cb2 = new JCheckBox("\uC0E4\uC6CC\uC7A5");
		cb2.setBounds(224, 326, 67, 23);
		cb2.setFont(new Font("굴림", Font.PLAIN, 13));
		contentPane.add(cb2);
		cb2.setOpaque(false);
		
		JCheckBox cb3 = new JCheckBox("\uD30C\uB77C\uC194");
		cb3.setBounds(333, 326, 67, 23);
		cb3.setFont(new Font("굴림", Font.PLAIN, 13));
		contentPane.add(cb3);
		cb3.setOpaque(false);
		
		
		JButton btnNewButton_1 = new JButton("\uC791\uC131\uC644\uB8CC");
		btnNewButton_1.setBounds(174, 441, 97, 23);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				rv = textArea.getText();
				System.out.println(rv);
				
				List<String> facList = new ArrayList();
	
				if(cb.isSelected()) facList.add(cb.getText());
				if(cb2.isSelected()) facList.add(cb2.getText());
				if(cb3.isSelected()) facList.add(cb3.getText());
				
				selFac = facList.toString();
				selFac = selFac.replace("[", "");
				selFac = selFac.replace("]", "");
				
			
		
				
				Enumeration<AbstractButton> enums = bg2.getElements();
				while(enums.hasMoreElements()){ //hasMoreElements() Enum에 더 꺼낼 개체가 있는지
				                                      // 체크한다. 없으며 false 반환
					AbstractButton ab = enums.nextElement(); //제네릭스가 AbstractButton 이니까 당연히             
													// AbstractButton으로 받아야함
				    JRadioButton jb = (JRadioButton)ab;         
					    	//형변환. 물론 윗줄과 이줄을 합쳐서 바로 형변환 해서 받아도 된다.

				    if(jb.isSelected()) {         //받아낸 라디오버튼의 체크 상태를 확인한다. 체크되었을경우 true 반환.
				    	selTrans = jb.getText(); //getText() 메소드로 문자열 받아낸다.
				    	System.out.println(selTrans);
				    	System.out.println(selTrans.getClass().getName());
				    }
				 }
				
				Enumeration<AbstractButton> enums2 = bg3.getElements();
				while(enums2.hasMoreElements()){ //hasMoreElements() Enum에 더 꺼낼 개체가 있는지
				                                      // 체크한다. 없으며 false 반환
					AbstractButton ab2 = enums2.nextElement(); //제네릭스가 AbstractButton 이니까 당연히             
													// AbstractButton으로 받아야함
				    JRadioButton jb2 = (JRadioButton)ab2;         
					    	//형변환. 물론 윗줄과 이줄을 합쳐서 바로 형변환 해서 받아도 된다.

				    if(jb2.isSelected()) {         //받아낸 라디오버튼의 체크 상태를 확인한다. 체크되었을경우 true 반환.
				    	selCong = jb2.getText(); //getText() 메소드로 문자열 받아낸다.
				    	System.out.println(selCong);
				    	System.out.println(selCong.getClass().getName());
				    }
				 }
	
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				Connection conn = null;
				try {
					conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				if(conn==null) 	{System.out.println("DB접속에 실패");}
				else			{System.out.println("DB접속 성공");}
				
				
				//String amenity = textArea.getText();
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				

				String sql="insert into badareview (bada_id, review, facility, transport, congestion) "
						+ "values((select bada_id from badagaja "
						+ "where bada_name like ?)"
						+ ",?,?,?,?)";
				
				//	미리 문장을 만들어 놓는다.
				
				try {
					System.out.println("************");
					System.out.println(rv);
					System.out.println(selFac);
					System.out.println(selFac.getClass().getName());
					System.out.println(selTrans);
					System.out.println(selCong);
					System.out.println("************");
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setNString(1, badaname);
					pstmt.setNString(2, rv);
					pstmt.setNString(3, selFac);
					pstmt.setNString(4, selTrans);
					pstmt.setNString(5, selCong);
					rs = pstmt.executeQuery();
					System.out.println("DB저장 성공");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dispose();
				setVisible(false);
				new review_db(badaname, siname).setVisible(true);			
			}	
		});
		contentPane.add(btnNewButton_1);
		
		

	    }
	}

