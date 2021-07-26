package _2_login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AnimalCheck {
	private int have_pet;
	public boolean animalPass=false; //default값 false, 동물등록 완료-> true, 동물 미등록 ->false
	// 입력받은 id,pw  class변수로 초기화하는 method 
		

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

				String sql = "SELECT have_pet FROM pet_member where id"+"="+"'"+Login.mem_id+"'";
				ResultSet rs = stmt.executeQuery(sql);
				// 아이디 비밀번호 확인
				while (rs.next()) {
					if (rs.getInt("have_pet")==1) {
						animalPass=true;
						}
					}
				System.out.println("AnimalCheck// 완료");
				

			} catch (ClassNotFoundException e) {
				System.out.println("jdbc driver loading fail");
			} catch (SQLException e) {
				System.out.println("oracle connection fail");
			}

		}
	
	

}
