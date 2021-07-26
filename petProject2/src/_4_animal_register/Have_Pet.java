package _4_animal_register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import _2_login.Login;

public class Have_Pet {


	public Have_Pet() {
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
			String sql = "UPDATE pet_member SET HAVE_PET='1' WHERE id="+"'"+Login.mem_id+"'";
			// 1의 값을 넣는것 == 동물 등록이 완료되었다는 것

			ResultSet rs = stmt.executeQuery(sql);
			System.out.print(sql);

		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver loading fail");
		} catch (SQLException e) {
			System.out.println("oracle connection fail");
		}

	}
}
