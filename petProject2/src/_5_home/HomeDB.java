package _5_home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import _2_login.Login;

public class HomeDB {

	private String name;
	private String type;
	private String birth;
	private String adopt;
	private String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getAdopt() {
		return adopt;
	}

	public void setAdopt(String adopt) {
		this.adopt = adopt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HomeDB() {

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
			String sql = "SELECT PET_NAME,PET_TYPE,PET_BIRTH,PET_ADOPT,id FROM pet_list where id='" + login.mem_id
					+ "'";

			ResultSet rs = stmt.executeQuery(sql);
//			System.out.println(sql);

			// 아이디 비밀번호 확인
			while (rs.next()) {
				setName(rs.getString("PET_NAME"));
				setType(rs.getString("PET_TYPE"));
				setBirth(rs.getString("PET_BIRTH"));
				setAdopt(rs.getString("PET_ADOPT"));
				setId(rs.getString("id"));
			}
			
			System.out.println(name + " "+ type + " " + birth + " "+ adopt + " "+ id);

		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver loading fail");
		} catch (SQLException e) {
			System.out.println("oracle connection fail");
		}

	}

//	Login login = new Login();
//

//	public HomeDB(String name, String type, String birth, String adopt, String id) {
//
//		this.name = name;
//		this.type = type;
//		this.birth = birth;
//		this.adopt = adopt;
//		this.id = id;
//	}

}
