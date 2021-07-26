package _4_animal_register;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Register_animal.java에서 입력받은 동물정보 DB에 넣는 작업 수행하는 클래스
public class registerDB {

	
	private String name;
	private String type;
	private String gender;
	private String birth;
	private String adopt;
	private String id;

	public registerDB() {
	}

	public registerDB(String name, String type, String gender, String birth, String adopt, String id) {
		
		this.name = name;
		this.type = type;
		this.gender = gender;
		this.birth = birth;
		this.adopt = adopt;
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

			// 회원정보 DB에 넣는 쿼리문
			String sql = "INSERT INTO pet_list (PET_IDX,PET_NAME,PET_TYPE,PET_GENDER,PET_BIRTH,PET_ADOPT,ID)VALUES("
					+ "seq_pet_idx.nextval" + ",'" + name + "','" + type + "','" + gender + "','" + birth + "','" + adopt + "','" + id
					+ "')";
			
			
			ResultSet rs = stmt.executeQuery(sql);
			System.out.print(sql);

		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver loading fail");
		} catch (SQLException e) {
			System.out.println("oracle connection fail");
		}

	}
}