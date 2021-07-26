package _2_login;

import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;

import _0_base.Mainframe;
import _3_signup.Signup;
import _2_login.IdPwCheck;
import _5_home.Home;
import _4_animal_register.*;

import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class Login {

	public JFrame frame;
	private JTextField idText;
	private JPasswordField pwText;

	// 로그인 성공시 Home.java로 가져갈 회원정보
	public static String mem_id = null;
	public static String mem_pw = null;

//실행하기
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		initialize();
	}

	public Login(String id, String pw) {
		mem_id = id;
		mem_pw = pw;
	}

	// 화면 요소
	private void initialize() {
		// 공통프레임 적용
		Mainframe mf = new Mainframe();
		frame = mf.Mainframe;

		// \uB098\uB9CC\uC758 \uBC18\uB824\uB3D9\uBB3C \uAD00\uB9AC \uC571
		JLabel subLabel = new JLabel("나만의 반려동물 관리 앱");
		subLabel.setForeground(SystemColor.controlShadow);
		subLabel.setFont(new Font("굴림", Font.BOLD, 15));
		subLabel.setBounds(105, 70, 175, 20);
		subLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(subLabel);

		JLabel titleLabel = new JLabel("My Pet Diary");
		titleLabel.setForeground(SystemColor.windowBorder);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
		titleLabel.setBounds(80, 100, 225, 45);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(titleLabel);

		JLabel idLabel = new JLabel("ID");
		idLabel.setForeground(SystemColor.controlShadow);
		idLabel.setFont(new Font("Arial", Font.BOLD, 18));
		idLabel.setBounds(79, 176, 40, 29);
		frame.getContentPane().add(idLabel);

		JLabel pwLabel = new JLabel("PW");
		pwLabel.setForeground(SystemColor.controlShadow);
		pwLabel.setFont(new Font("Arial", Font.BOLD, 18));
		pwLabel.setBounds(79, 222, 40, 29);
		frame.getContentPane().add(pwLabel);

		// ID입력란
		idText = new JTextField();
		idText.setBounds(131, 178, 152, 29);
		frame.getContentPane().add(idText);
		idText.setColumns(10);

		// PW입력란
		pwText = new JPasswordField();
		pwText.setBounds(131, 224, 152, 29);
		frame.getContentPane().add(pwText);

		JButton loginButton = new JButton("LOGIN");
		loginButton.setBackground(UIManager.getColor("Button.light"));
		loginButton.setForeground(SystemColor.controlDkShadow);
		loginButton.setFont(new Font("Arial", Font.BOLD, 12));
		loginButton.setBounds(120, 309, 152, 41);
		frame.getContentPane().add(loginButton);

		JButton signupButton = new JButton("SIGN UP");
		signupButton.setForeground(SystemColor.controlDkShadow);
		signupButton.setFont(new Font("Arial", Font.BOLD, 12));
		signupButton.setSize(152, 41);
		signupButton.setLocation(120, 370);
		frame.getContentPane().add(signupButton);

//login 버튼에 액션리스너 적용--------------------------------------------------------------------
		// login 버튼 눌렀을 시
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 아이디 비번 칸 모두 채워졌는지 확인
				String id = idText.getText().trim();
				String pw = pwText.getText().trim();

				// id,pw 입력칸 하나라도 공란일 때는 알림 출력, 다 채울 때 까지 반복
				while (id.length() == 0 || pw.length() == 0) {
					JOptionPane.showMessageDialog(null, "모든 칸을 입력해주세요", "알림", JOptionPane.DEFAULT_OPTION);
					return;
				}

				// 로그인 성공,실패 체크하는 클래스 함수 실행
				IdPwCheck idck = new IdPwCheck(id, pw);
				idck.execute();
				

				// id,pw 입력칸 모두 채웠으면 로그인 시도하기
				if (idck.loginPass == false) {
					// id,pw DB와 불일치할 때
					JOptionPane.showMessageDialog(null, "아이디, 비밀번호를 다시 확인해주세요", "알림", JOptionPane.DEFAULT_OPTION);
					return;
				} else {
					JOptionPane.showMessageDialog(null, "로그인 성공!", "알림", JOptionPane.DEFAULT_OPTION);
					frame.setVisible(false);
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								// 로그인 성공한 id,pw를 Login 클래스 static 변수로 저장하기
								Login login = new Login(id, pw);

								// Login 클래스의 static 변수로 잘 저장되었는지 확인하는 클래스(콘솔확인)
								LoginComplete cplt = new LoginComplete();
								cplt.execute();

								// 로그인한 id에 동물등록이 되어있는지 확인하는 클래스
								AnimalCheck anck = new AnimalCheck();
								anck.execute();

								if (anck.animalPass == true) {
									// 동물등록이 되어있다면
									Home window = new Home();
									window.frame.setVisible(true);
								} else {
									Register_intro window = new Register_intro();
									window.frame.setVisible(true);
								}

							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}

			}
			
		});
// sign up 버튼에 액션리스너 적용--------------------------------------------------------------------
		// sign up 버튼 눌렀을시 Signup.java로 이동
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {

							Signup window = new Signup();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

	}
}
