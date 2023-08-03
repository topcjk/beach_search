package team;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import team.getdata;

import java.sql.Date;

import team.makeconn.*;
public class telldata {
	private Connection con;
	PreparedStatement pstmt=null;
	ResultSet rs;
	public telldata() throws ClassNotFoundException, SQLException {
		con=new makeconn().getConnection();
		System.out.println("연결시작");
	
	}
	
	public int getbeachnum(String bada_location) throws SQLException {
		System.out.println("해수욕장 갯수");
		String sql="select count(*) as num"
				+" from badagaja"
				+" where bada_location='" +bada_location+ "'"
				+" group by bada_location";
		pstmt=con.prepareStatement(sql);
		
		rs=pstmt.executeQuery();
		int beachsnumber = 0;
		while(rs.next()) {
			beachsnumber=rs.getInt("num");
		}
		
		return beachsnumber;
	}
	
	public ArrayList<getdata> getbeachs(String bada_location) throws SQLException {
		ArrayList<getdata> resultstr=new ArrayList<getdata>();

		String sql="select bada_name "
				+" from badagaja"
				+" where bada_location='" +bada_location+ "'";
		
		pstmt=con.prepareStatement(sql);
		
		rs=pstmt.executeQuery();
		
		
		
		while(rs.next()) {
			String result1=rs.getString("bada_name");
			
			getdata gd=new getdata(result1);
			resultstr.add(gd);
			}
		return resultstr;
	}
	
	public ArrayList<getdata> searchsometext(String searchtext,String searchabout) throws SQLException {
		ArrayList<getdata> resultstr=new ArrayList<getdata>();

		String sql="select bada_name"
				+" from badagaja"
				+" where bada_location='" +searchtext+ "'"
				+" and bada_name like '%"+searchabout+"%'";
		
		pstmt=con.prepareStatement(sql);
		
		rs=pstmt.executeQuery();
		
		
		
		while(rs.next()) {
			
			String result1=rs.getString("bada_name");
			
			getdata gd=new getdata(result1);
			resultstr.add(gd);
			System.out.println(gd);
			}
		
		return resultstr;
	}
	
//	public String[] getbeachs(String doe) throws SQLException {
//		
//		int a=getbeachnum(doe);
//		System.out.println(a);
//		String[] resultstr=new String[a];
//
//		String sql="select beachname"
//				+" from koreabeach"
//				+" where doe='" +doe+ "'";
//		
//		pstmt=con.prepareStatement(sql);
//		
//		rs=pstmt.executeQuery();
//		
//		
//		
//		while(rs.next()) {
//			String result1=rs.getString("beachname");
//			int i=0;
//			resultstr[i]=result1;
//			i++;
//			System.out.println(result1);
//			}
//		
//		
//		return resultstr;
//	}
	public int searchedbeachsnumber(String searchtext,String searchabout) 
			throws SQLException {
		//System.out.println("�빐�닔�슃�옣 寃��깋�썑 媛��닔�꽭湲�");
		String sql="select count(*) as num"
				+" from badagaja"
				+" where bada_location='" +searchtext+ "'"
				+" and bada_name like '%"+searchabout+"%'";
		pstmt=con.prepareStatement(sql);
		
		rs=pstmt.executeQuery();
		int searchedbeachsnumber = 0;
		while(rs.next()) {
			searchedbeachsnumber=rs.getInt("num");
		}
		
		return searchedbeachsnumber;
	}
	
	
	
//	public int reviewcount(String searchtext) throws SQLException {
//		String sql="select count(*) as num"
//				+" from badagaja g, badareview v"
//				+" where g.bada_id=v.bada_id and g.bada_name='" +searchtext+ "'";
//		pstmt=con.prepareStatement(sql);
//		
//		rs=pstmt.executeQuery();
//		int searchedbeachsnumber = 0;
//		while(rs.next()) {
//			searchedbeachsnumber=rs.getInt("num");
//		}
//		
//		return searchedbeachsnumber;
//	}
	
	public ArrayList<getdata2> getallreviewdata(String badaname)throws SQLException{
		ArrayList<getdata2> tiarray=new ArrayList<getdata2>();
		//System.out.println("�뜲�씠�꽣 李얘린 �떆�옉");
		
		String sql="select v.facility as facility,"
				+ " v.congestion as congestion ,v.transport as transport,"
				+ " v.review as review"
				+ " from badagaja g, badareview v"
				+ " where g.bada_id=v.bada_id and g.bada_name='"+badaname+"'";
		
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		
		while(rs.next()) {
			//System.out.println("�뜲�씠�꽣 �꽔�뒗以�");
			String fac=rs.getString("FACILITY");
			String cong=rs.getString("CONGESTION");
			String trans=rs.getString("TRANSPORT");
			String review=rs.getString("REVIEW");
			
			getdata2 gd2=new getdata2(fac,cong,trans,review);
			//System.out.println(gd2);
			tiarray.add(gd2);
			}
		//System.out.println("�뜲�씠�꽣 �떎 �꽔�쓬");
		return tiarray;
	}
	
	//-----------鍮꾩긽�슜
	
	
}