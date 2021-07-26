package _2_login;

import java.sql.*;
/////////////////////////
//Login.java에서 입력받은 id,pw 유효성 체크하는 class

public class IdPwCheck {
	private String id;
	private String pw;
	public boolean loginPass = false; //default값 false

	//다른 클래스에서 이 클래서 참조시 쓸 method
	/*
	public static void main(String[] args) {
		IdPwCheck ipck = new IdPwCheck("asdf", "asdf");
		ipck.execute();
	}
	*/
	
	// 입력받은 id,pw  class변수로 초기화하는 method 
	public IdPwCheck(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	// DB접속 

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

			String sql = "SELECT id,pw FROM pet_member ";
			ResultSet rs = stmt.executeQuery(sql);
			// 아이디 비밀번호 확인
			while (rs.next()) {
				if (id.equals(rs.getString("id"))) {
					if (pw.equals(rs.getString("pw"))) {
						System.out.println("로그인 성공 "+"id :"+id+"pw :"+pw);
						//로그인 성공시 loginPass 변수 false에서 true로 바꿔주기
						loginPass = true;
					}
				}
			}

		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver loading fail");
		} catch (SQLException e) {
			System.out.println("oracle connection fail");
		}

	}
}
