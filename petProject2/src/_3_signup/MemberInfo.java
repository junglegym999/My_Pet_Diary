package _3_signup;

import java.sql.*;

//Signup.java에서 입력받은 회원정보 DB에 넣는 작업 수행하는 클래스
public class MemberInfo {
	
	public MemberInfo() {
	}

	private String id;
	private String pw;
	private String email;
	private String phone;

	public MemberInfo(String id, String pw, String email, String phone) {
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.phone = phone;
	}

	// DB 접속
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

			// 회원정보 DB에 넣는 쿼리문
			String sql = "INSERT INTO pet_member (id,pw,email,phone)VALUES('" + id + "','" + pw + "','" + email + "','"
					+ phone + "')";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.print(sql);

		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver loading fail");
		} catch (SQLException e) {
			System.out.println("oracle connection fail");
		}

	}
}
