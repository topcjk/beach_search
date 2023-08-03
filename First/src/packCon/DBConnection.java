package packCon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() {
		Connection con1 = null;
		try {
		//연결에 필요한 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "project1";
		String pw = "pro";
		
		//드라이버를 메모리에 할당
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//연결된 객체 가져오기
		con1 = DriverManager.getConnection(url, user, pw);
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패"); //드라이버 주소 잘못됨
		}catch(SQLException e) {
			System.out.println("연결 실패"); //url 잘못됨
		}catch(Exception e) {
			System.out.println("알 수 없는 오류");
		}
		return con1;
	}

}
