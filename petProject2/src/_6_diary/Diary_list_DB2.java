package _6_diary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import _2_login.Login;
import _6_diary.Diary_list_VO;

public class Diary_list_DB2 {

	// DB 접속해서 다이어리 기록한 거 ArrayList 형식으로 리턴하는 함수
	public List<Diary_list_VO> selectAllBoards() {
		Login login = new Login(); // 로그인한 아이디 가져오기 위한 객체 생성 (static login.mem_id)

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "green";
		String password = "green1234";

		List<Diary_list_VO> list = new ArrayList<Diary_list_VO>();

		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.");

			Statement stmt = conn.createStatement();//

			// 회원정보 DB에 넣는 쿼리문
			String sql = "SELECT * from pet_diary where id='" + login.mem_id + "'";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Diary_list_VO dVO = new Diary_list_VO();

				dVO.setDiary_idx(rs.getInt("DIARY_INDEX"));
				dVO.setDiary_date(rs.getString("DIARY_DATE"));
				dVO.setDiary_content(rs.getString("DIARY_CONTENT"));
				dVO.setId(rs.getString("ID"));

				list.add(dVO);

			}
			System.out.println("Diary_list 실행완료");

//			rs.close();
//			stmt.close();
//			conn.close();

		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver loading fail");
		} catch (SQLException e) {
			System.out.println("oracle connection fail");
		} finally {

			return list;
		}
	}
}
