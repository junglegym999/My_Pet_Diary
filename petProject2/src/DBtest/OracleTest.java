package DBtest;

import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleTest {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";//
		String user = "green";//���� �̸�
		String password = "green1234";//���� ��й�ȣ
		
		try {
			Class.forName(driver);
			System.out.println("jdbc driver �ε� ����");
			DriverManager.getConnection(url, user, password);
			System.out.println("����Ŭ ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver �ε� ����");
		} catch (SQLException e) {
			System.out.println("����Ŭ ���� ����");
		}
	}
}