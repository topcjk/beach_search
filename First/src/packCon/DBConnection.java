package packCon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() {
		Connection con1 = null;
		try {
		//���ῡ �ʿ��� ����
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "project1";
		String pw = "pro";
		
		//����̹��� �޸𸮿� �Ҵ�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//����� ��ü ��������
		con1 = DriverManager.getConnection(url, user, pw);
		}catch(ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����"); //����̹� �ּ� �߸���
		}catch(SQLException e) {
			System.out.println("���� ����"); //url �߸���
		}catch(Exception e) {
			System.out.println("�� �� ���� ����");
		}
		return con1;
	}

}
