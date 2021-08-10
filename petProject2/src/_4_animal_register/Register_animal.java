package _4_animal_register;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.sql.Date;

import _0_base.Mainframe;
import _2_login.Login;
import _5_home.Home;

public class Register_animal {

	public JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register_animal window = new Register_animal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Register_animal() {
		initialize();
	}

	private void initialize() {
		// 공통 프레임 적용
		Mainframe mf = new Mainframe();
		frame = mf.Mainframe;

		JLabel titleLabel = new JLabel("My Pet Diary");
		titleLabel.setForeground(SystemColor.windowBorder);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
		titleLabel.setBounds(100, 40, 190, 40);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(titleLabel);

		JLabel subtitleLabel = new JLabel("반려동물 등록하기");
		subtitleLabel.setForeground(SystemColor.windowBorder);
		subtitleLabel.setFont(new Font("굴림", Font.BOLD, 13));
		subtitleLabel.setBounds(130, 85, 130, 15);
		subtitleLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(subtitleLabel);

		// 이름 입력--------------------------------------------------------------
		JLabel name_label = new JLabel("이름");
		name_label.setForeground(SystemColor.controlShadow);
		name_label.setFont(new Font("굴림", Font.BOLD, 15));
		name_label.setBounds(50, 130, 40, 30);
		frame.getContentPane().add(name_label);

		JTextField name_text = new JTextField();
		name_text.setColumns(10);
		name_text.setBounds(130, 133, 200, 23);
		frame.getContentPane().add(name_text);

		// 종류 선택---------------------------------------------------------------------
		JLabel species_label = new JLabel("종류");
		species_label.setForeground(SystemColor.controlShadow);
		species_label.setFont(new Font("굴림", Font.BOLD, 15));
		species_label.setBounds(50, 185, 40, 30);
		frame.getContentPane().add(species_label);

		JComboBox type_box = new JComboBox();
		type_box.setFont(new Font("굴림", Font.PLAIN, 10));
		type_box.setBackground(UIManager.getColor("ComboBox.buttonHighlight"));
		type_box.setBounds(130, 189, 68, 23);
		type_box.addItem(" ");
		type_box.addItem("강아지");
		type_box.addItem("고양이");
		type_box.addItem("기타");
		frame.getContentPane().add(type_box);

		// 성별 선택---------------------------------------------------------------------
		JLabel gender_label = new JLabel("성별");
		gender_label.setForeground(SystemColor.controlShadow);
		gender_label.setFont(new Font("굴림", Font.BOLD, 15));
		gender_label.setBounds(50, 242, 40, 30);
		frame.getContentPane().add(gender_label);

		JComboBox gender_box = new JComboBox();
		gender_box.setFont(new Font("굴림", Font.PLAIN, 10));
		gender_box.setBackground(UIManager.getColor("ComboBox.buttonHighlight"));
		gender_box.setBounds(130, 246, 68, 23);
		gender_box.addItem(" ");
		gender_box.addItem("남아");
		gender_box.addItem("여아");
		frame.getContentPane().add(gender_box);

		// 생년월일 선택---------------------------------------------------------------------
		JLabel birth_label = new JLabel("생년월일");
		birth_label.setForeground(SystemColor.controlShadow);
		birth_label.setFont(new Font("굴림", Font.BOLD, 15));
		birth_label.setBounds(50, 300, 80, 30);
		frame.getContentPane().add(birth_label);

		// 콤보박스 세개 (연 월 일)
		// 년 선택
		JComboBox birth_year_box = new JComboBox();
		birth_year_box.setFont(new Font("굴림", Font.PLAIN, 10));
		birth_year_box.setBackground(UIManager.getColor("ComboBox.buttonHighlight"));
		birth_year_box.setBounds(130, 305, 70, 23);
		birth_year_box.addItem(" ");
		for (int i = 2021; i >= 1970; i--) {
			birth_year_box.addItem(i);
		}
		frame.getContentPane().add(birth_year_box);
		// 월 선택
		JComboBox birth_month_box = new JComboBox();
		birth_month_box.setFont(new Font("굴림", Font.PLAIN, 10));
		birth_month_box.setBackground(UIManager.getColor("ComboBox.buttonHighlight"));
		birth_month_box.setBounds(215, 305, 70, 23);
		birth_month_box.addItem(" ");
		for (int i = 1; i <= 12; i++) {
			birth_month_box.addItem(i);
		}
		frame.getContentPane().add(birth_month_box);
		// 일 선택
		JComboBox birth_day_box = new JComboBox();
		birth_day_box.setFont(new Font("굴림", Font.PLAIN, 10));
		birth_day_box.setBackground(UIManager.getColor("ComboBox.buttonHighlight"));
		birth_day_box.setBounds(300, 305, 70, 23);
		birth_day_box.addItem(" ");
		for (int i = 1; i <= 31; i++) {
			birth_day_box.addItem(i);
		}
		frame.getContentPane().add(birth_day_box);

		// 입양월일 선택---------------------------------------------------------
		JLabel adopt_label = new JLabel("입양월일");
		adopt_label.setForeground(SystemColor.controlShadow);
		adopt_label.setFont(new Font("굴림", Font.BOLD, 15));
		adopt_label.setBounds(50, 360, 80, 30);
		frame.getContentPane().add(adopt_label);

		// 년 선택
		JComboBox adopt_year_box = new JComboBox();
		adopt_year_box.setFont(new Font("굴림", Font.PLAIN, 10));
		adopt_year_box.setBackground(UIManager.getColor("ComboBox.buttonHighlight"));
		adopt_year_box.setBounds(130, 360, 70, 23);
		adopt_year_box.addItem(" ");
		for (int i = 2021; i >= 1970; i--) {
			adopt_year_box.addItem(i);
		}
		frame.getContentPane().add(adopt_year_box);
		// 월 선택
		JComboBox adopt_month_box = new JComboBox();
		adopt_month_box.setFont(new Font("굴림", Font.PLAIN, 10));
		adopt_month_box.setBackground(UIManager.getColor("ComboBox.buttonHighlight"));
		adopt_month_box.setBounds(215, 360, 70, 23);
		adopt_month_box.addItem(" ");
		for (int i = 1; i <= 12; i++) {
			adopt_month_box.addItem(i);
		}
		frame.getContentPane().add(adopt_month_box);
		// 일 선택
		JComboBox adopt_day_box = new JComboBox();
		adopt_day_box.setFont(new Font("굴림", Font.PLAIN, 10));
		adopt_day_box.setBackground(UIManager.getColor("ComboBox.buttonHighlight"));
		adopt_day_box.setBounds(300, 360, 70, 23);
		adopt_day_box.addItem(" ");
		for (int i = 1; i <= 31; i++) {
			adopt_day_box.addItem(i);
		}
		frame.getContentPane().add(adopt_day_box);

		// 취소 버튼-----------------------------------------------------------------
		JButton back_btn = new JButton("취소");
		back_btn.setFont(new Font("굴림", Font.BOLD, 15));
		back_btn.setBounds(100, 480, 80, 30);
		back_btn.setHorizontalAlignment(JButton.CENTER);
		frame.getContentPane().add(back_btn);

		// 등록 버튼-------------------------------------------------------------------
		JButton register_btn = new JButton("등록");
		register_btn.setFont(new Font("굴림", Font.BOLD, 15));
		register_btn.setBounds(200, 480, 80, 30);
		frame.getContentPane().add(register_btn);

//액션리스너 시작~~~~~~~~~~~~
		// 등록버튼 눌렀을 때
		register_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 입력한 값들 체크
				String name = name_text.getText().trim();

				String type = type_box.getSelectedItem().toString();

				String gender = gender_box.getSelectedItem().toString();

				String birth_year = birth_year_box.getSelectedItem().toString();// 년
				String birth_month = birth_month_box.getSelectedItem().toString();// 월
				String birth_day = birth_day_box.getSelectedItem().toString();// 일
				String birth = birth_year + "." + birth_month + "." + birth_day;
				// birth 변수를 데이터베이스에 넣어야 함

				String adopt_year = adopt_year_box.getSelectedItem().toString();// 년
				String adopt_month = adopt_month_box.getSelectedItem().toString();// 월
				String adopt_day = adopt_day_box.getSelectedItem().toString();// 일
				String adopt = adopt_year + "." + adopt_month + "." + adopt_day;

				// + 주인 아이디는 Login.java에서 static 변수로 저장한 값으로 가져오기
				String id = Login.mem_id;

//////////////////////날짜는 yyyy-mm-dd 이런 형식으로 바꿔주기
				// 모든 입력칸이 채워져있는지 확인

				while (name.length() == 0 || type == " " || gender == " " || birth_year == " " || birth_month == " "
						|| birth_day == " " || adopt_year == " " || adopt_month == " " || adopt_day == " ") {
					JOptionPane.showMessageDialog(null, "모든 칸을 입력해주세요", "알림 ", JOptionPane.DEFAULT_OPTION);
					return;
				}

				// 입력받은 값 DB에 넣기
				registerDB rDB = new registerDB(name, type, gender, birth, adopt, id);
				rDB.execute();

				// DB pet_member 테이블, 로그인한 아이디의 HAVE_PET 필드를 1(동물등록완료)값으로 바꿔주기
				Have_Pet hpt = new Have_Pet();
				hpt.execute();

				frame.setVisible(false);
				///// Home 화면으로 이동
				JOptionPane.showMessageDialog(null, "반려동물이 등록되었습니다 ! ", "알림", JOptionPane.DEFAULT_OPTION);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Home window = new Home();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		// 취소버튼 눌렀을 때
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Register_intro window = new Register_intro();
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
