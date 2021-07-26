package _3_signup;

import java.sql.*;
/////////////////////////
//id 중복체크하는 클래스 ~

public class IdDoubleChk {

	private String id;
	public int idDouble;

	public IdDoubleChk() {
	}

	public IdDoubleChk(String id) {
		this.id = id;
	}

	// DB접속해서 확인

	public void execute() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "green";
		String password = "green1234";

		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.");

			Statement stmt = conn.createStatement();//

			// 입력한 아이디와 동일한 아이디 있는지 확인
			String sql = "select count(*)from pet_member where id='" + id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			//업으면 0, 있으면 1
			while (rs.next()) {
				if (rs.getInt("count(*)") == 0) {
					idDouble = 0;
				} else {
					idDouble = 1;
				}
			}

		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver loading fail");
		} catch (SQLException e) {
			System.out.println("oracle connection fail");
		}
	}

}
