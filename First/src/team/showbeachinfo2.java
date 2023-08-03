package team;

import team.*;
import team.region.showbeachlist;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class showbeachinfo2 extends JFrame {
	public String beachnames[]= {};
	private JPanel contentPane;
	private JTextField searchtext;
	ArrayList<getdata> str;
	String siname="";
	String final_beachname="";
	private URL searchURL;

	private ImageIcon imageicon;
	private Image img;
	Image updatedimage;
	String searchbadaname="";
	ArrayList<getdata2> getreviewdata;
	String a,b,c,e;
	int d;
	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		//seoul s1=new seoul(" ");
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public  String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
	public showbeachinfo2(String final_beachname,String siname) throws ClassNotFoundException, SQLException {
		setTitle("바다가자");
		String goback=siname;
		telldata tda=new telldata();
		searchbadaname=final_beachname;
		//int reviewcount=tda.reviewcount(searchbadaname);
		getreviewdata=tda.getallreviewdata(searchbadaname);
	
		//System.out.println("여기까지 검색전");
		searchURL = getClass().getResource("/image/sea.jpg");
		imageicon = new ImageIcon(searchURL);
		img=imageicon.getImage();
		updatedimage=img.getScaledInstance(763, 489, Image.SCALE_SMOOTH);
		ImageIcon updatedicon=new ImageIcon(updatedimage);
		
		JLabel imgLabel = new JLabel(imageicon);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 763, 489);
		contentPane = new JPanel() {
			 public void paintComponent(Graphics g) {
				 g.drawImage(updatedicon.getImage(), 0, 0, null);
				 setOpaque(false); //그림을 표시하게 설정,투명하게 조절
	             super.paintComponent(g);
			 }
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.add(imgLabel);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		

		
		
		
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 40, 660, 295);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);//수정불가
		
		JButton gobackbtn = new JButton("<---\uC774\uC804");
		gobackbtn.setBounds(166, 377, 97, 23);
		gobackbtn.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				try {
					new showbeachlist(goback);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		contentPane.add(gobackbtn);
		
		JButton gameover = new JButton("\uC885\uB8CC");
		gameover.setBounds(502, 377, 97, 23);
		gameover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(gameover);
		
         
		//System.out.println("슬슬 결과출력");
		
		for(getdata2 imsi:getreviewdata) {
			a=padRight(imsi.getFacility(), 12);
			b=padRight(imsi.getCongestion(),12);
			c=padRight(imsi.getTransport(), 9);
			e=imsi.getReview();
			
			textArea.append("편의시설:"+a+"\t  혼잡도:"+b+
					"\t  교통시설:"+c+"\n\n   리뷰:"+e+"\n");
			textArea.append("==".repeat(45)+"\n");
			
			//System.out.print("편의시설:"+a+"\t  혼잡도:"+b+
				//	"\t  교통시설:"+c+"\t   리뷰:"+e);
			
		}
		if(getreviewdata.size()==0) {
			textArea.append("리뷰가 존재하지 않습니다");
		}
		//System.out.println(getreviewdata);
		setVisible(true);
		
	}
}
