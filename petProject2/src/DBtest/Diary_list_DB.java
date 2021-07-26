package DBtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import _2_login.Login;

public class Diary_list_DB {

	// DIARY_INDEX,DIARY_DATE,DIARY_CONTENT,ID
	private String diary_idx;
	private String diary_date;
	private String diary_content;
	private String id;

	public Diary_list_DB() {
	}

	public String getDiary_idx() {
		return diary_idx;
	}

	public void setDiary_idx(String diary_idx) {
		this.diary_idx = diary_idx;
	}

	public String getDiary_date() {
		return diary_date;
	}

	public void setDiary_date(String diary_date) {
		this.diary_date = diary_date;
	}

	public String getDiary_content() {
		return diary_content;
	}

	public void setDiary_content(String diary_content) {
		this.diary_content = diary_content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// DB 접속
	public void execute() {
		Login login = new Login(); // 로그인한 아이디 가져오기 위한 객체 생성 (static login.mem_id)

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
			String sql = "SELECT * from pet_diary where id='" + login.mem_id + "'";

			ResultSet rs = stmt.executeQuery(sql);
//		System.out.println(sql);

			// 아이디 비밀번호 확인
			while (rs.next()) {

				setDiary_idx(rs.getString("DIARY_INDEX"));
				setDiary_date(rs.getString("DIARY_DATE"));
				setDiary_content(rs.getString("DIARY_CONTENT"));
				setId(rs.getString("ID"));

			}
			System.out.println("Diary_list 실행완료");
			System.out.println(diary_idx + " " + diary_date + " " + diary_content + " " + id );

		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver loading fail");
		} catch (SQLException e) {
			System.out.println("oracle connection fail");
		}
	}
}
