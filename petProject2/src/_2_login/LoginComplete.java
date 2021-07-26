package _2_login;

public class LoginComplete {

	public void execute() {

		Login login = new Login();
		System.out.println("LoginComplete//");
		System.out.print("Login 클래스에 static 변수로 저장되었습니다(아이디, 비번) ->");
		System.out.print(login.mem_id +" ");
		System.out.println(login.mem_pw);

	}

}
