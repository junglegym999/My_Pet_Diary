package _6_diary;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Register_animal.java에서 입력받은 동물정보 DB에 넣는 작업 수행하는 클래스
public class DiaryDB {

	private String today;
	private String diary_content;
	private String id;

	public DiaryDB() {
	}

	public DiaryDB(String today, String diary_content, String id) {

		this.today = today;
		this.diary_content = diary_content;
		this.id = id;
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


			// 다이어리 내용 DB에 넣는 쿼리문
			String sql = "INSERT INTO pet_diary (DIARY_INDEX,DIARY_DATE,DIARY_CONTENT,ID)VALUES("
					+ "seq_diary_index.nextval" + ",'" + today + "','" + diary_content + "','" + id + "')";

			ResultSet rs = stmt.executeQuery(sql);
			System.out.print(sql);

		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver loading fail");
		} catch (SQLException e) {
			System.out.println("oracle connection fail");
		}

	}

}
