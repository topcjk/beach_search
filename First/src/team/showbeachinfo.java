package team;

import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import team.region.showbeachlist;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class showbeachinfo extends JFrame {
	String searchbadaname="";
	private JPanel contentPane;
	ArrayList<getdata2> getreviewdata;
	String a,b,c,e;
	int d;
	private URL searchURL;

	private ImageIcon imageicon;
	private Image img;
	Image updatedimage;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//showbeachinfo frame = new showbeachinfo();

	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	
	public  String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
	
	public showbeachinfo(String final_beachname,String siname) throws ClassNotFoundException, SQLException {
		setTitle("바다가자");
		
		searchURL = getClass().getResource("/image/sea.jpg");
		imageicon = new ImageIcon(searchURL);
		img=imageicon.getImage();
		updatedimage=img.getScaledInstance(763, 489, Image.SCALE_SMOOTH);
		ImageIcon updatedicon=new ImageIcon(updatedimage);
		
		String goback=siname;
		telldata tda=new telldata();
		searchbadaname=final_beachname;
		//int reviewcount=tda.reviewcount(searchbadaname);
		getreviewdata=tda.getallreviewdata(searchbadaname);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600,300, 763, 489);
		//getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 40, 660, 295);
		getContentPane().add(scrollPane);
		
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
		getContentPane().add(gobackbtn);
		
		JButton gameover = new JButton("\uC885\uB8CC");
		gameover.setBounds(502, 377, 97, 23);
		gameover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		getContentPane().add(gameover);
		
         
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
