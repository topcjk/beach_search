package team.region;

import team.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import review.review_main;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class showbeachlist extends JFrame {
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
	public showbeachlist(String location_name) throws ClassNotFoundException, SQLException {
		setTitle("바다가자");
		telldata tda=new telldata();
		siname=location_name;
		int beachcount=tda.getbeachnum(siname);
		
		ArrayList<getdata> str= tda.getbeachs(siname);
		String beachnames[]=new String[beachcount];
		int x=0;
		for(getdata imsi:str) {
			
			beachnames[x]=(imsi.getName());
//			System.out.println(imsi.getName());
//			System.out.println(x+beachnames[x]);
			x++;
		}
		for(int i=0;i<beachcount;i++) {
//			System.out.println(beachnames[i]);
		}
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
		
		searchtext = new JTextField();
		//searchtext.setText("해수욕장검색");
		searchtext.setBounds(72, 35, 116, 21);
		contentPane.add(searchtext);
		searchtext.setColumns(10);
		

		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 79, 449, 301);
		contentPane.add(scrollPane);
		
		JList list = new JList(beachnames);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				final_beachname=(String)list.getSelectedValue();
				System.out.println("선택됨:"+final_beachname);
				
			}
		});
		scrollPane.setViewportView(list);
		
		
		JButton beachsearch = new JButton("\uAC80\uC0C9\uD558\uAE30");
		beachsearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String searchabout=searchtext.getText();
				try {
//					System.out.println("조건입력후");
					
					String siname=location_name;
					
					ArrayList<getdata> str= tda.searchsometext(location_name, searchabout);
					int searchcount=tda.searchedbeachsnumber(location_name,searchabout);
					String searchedbeachnames[]=new String[searchcount];
					int x=0;
					for(getdata imsi:str) {
						
						searchedbeachnames[x]=(imsi.getName());
						x++;
					}
					JList list = new JList(searchedbeachnames);
					list.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							final_beachname=(String) list.getSelectedValue();
							System.out.println("선택됨:"+final_beachname);
						}
					});
					scrollPane.setViewportView(list);					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		beachsearch.setBounds(230, 34, 97, 23);
		contentPane.add(beachsearch);
		
		JButton gobackbtn = new JButton("<----\uC774\uC804");
		gobackbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				try {
					beachmaintest1 frame = new beachmaintest1();
					frame.setVisible(true);
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		gobackbtn.setBounds(71, 396, 97, 23);
		contentPane.add(gobackbtn);
		
		JLabel doe = new JLabel(location_name);
		doe.setBounds(72, 10, 57, 15);
		contentPane.add(doe);
		
		
		JButton showbeach = new JButton("\uB9AC\uBDF0\uBCF4\uAE30");//리뷰보기
		showbeach.setBounds(573, 396, 97, 23);
		contentPane.add(showbeach);
		
		JButton btnWrite = new JButton("\uB9AC\uBDF0\uC791\uC131");
		btnWrite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnWrite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(final_beachname!="") {
		               //System.out.println("가즈아"+list.getSelectedValue());
						setVisible(false);
		            	   new review_main(final_beachname,siname).setVisible(true);
		         }
				
			}
		});
		btnWrite.setBounds(573, 363, 97, 23);
		contentPane.add(btnWrite);
		
		showbeach.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(final_beachname!="") {
		               dispose();
		               try {
		                  new showbeachinfo2(final_beachname,siname);
		                  
		               } catch (ClassNotFoundException | SQLException e1) {
		                  // TODO Auto-generated catch block
		                  e1.printStackTrace();
		               }
		        }
			}
		});
		setVisible(true);
		
	}
}
