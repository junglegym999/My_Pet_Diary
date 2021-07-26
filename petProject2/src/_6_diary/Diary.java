package _6_diary;

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
import javax.swing.UIManager;

import _0_base.Mainframe;
import _2_login.Login;
import _3_signup.Signup;
import _4_animal_register.registerDB;
import _4_animal_register.Have_Pet;
import _5_home.Home;

import javax.swing.JTextArea;

public class Diary {

	public JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Diary window = new Diary();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Diary() {
		initialize();
	}

	private void initialize() {
		// 공통프레임 적용
		Mainframe mf = new Mainframe();
		frame = mf.Mainframe;

		JLabel titleLabel = new JLabel("My Pet Diary");
		titleLabel.setForeground(SystemColor.windowBorder);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
		titleLabel.setBounds(100, 40, 190, 40);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(titleLabel);

		JLabel subtitleLabel = new JLabel("반려동물 일기 쓰기"); // 내 반려동물 이름에 따라 다르게 나올 수 있도록 하고 싶,,
		subtitleLabel.setForeground(SystemColor.windowBorder);
		subtitleLabel.setFont(new Font("굴림", Font.BOLD, 13));
		subtitleLabel.setBounds(130, 85, 130, 15);
		subtitleLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(subtitleLabel);

	// 일기 쓸 년,월,일 선택---------------------------------------------------------
		JLabel today_label = new JLabel("오늘 날짜");
		today_label.setForeground(SystemColor.controlShadow);
		today_label.setFont(new Font("굴림", Font.BOLD, 15));
		today_label.setBounds(23, 134, 80, 30);
		frame.getContentPane().add(today_label);

		// 년 선택
		JComboBox today_year_box = new JComboBox();
		today_year_box.setFont(new Font("굴림", Font.PLAIN, 10));
		today_year_box.setBackground(UIManager.getColor("ComboBox.buttonHighlight"));
		today_year_box.setBounds(100, 140, 70, 23);
		today_year_box.addItem(" ");
		for (int i = 2021; i >= 1970; i--) {
			today_year_box.addItem(i);
		}
		frame.getContentPane().add(today_year_box);
		// 월 선택
		JComboBox today_month_box = new JComboBox();
		today_month_box.setFont(new Font("굴림", Font.PLAIN, 10));
		today_month_box.setBackground(UIManager.getColor("ComboBox.buttonHighlight"));
		today_month_box.setBounds(182, 140, 70, 23);
		today_month_box.addItem(" ");
		for (int i = 1; i <= 12; i++) {
			today_month_box.addItem(i);
		}
		frame.getContentPane().add(today_month_box);
		// 일 선택
		JComboBox today_day_box = new JComboBox();
		today_day_box.setFont(new Font("굴림", Font.PLAIN, 10));
		today_day_box.setBackground(UIManager.getColor("ComboBox.buttonHighlight"));
		today_day_box.setBounds(264, 140, 70, 23);
		today_day_box.addItem(" ");
		for (int i = 1; i <= 31; i++) {
			today_day_box.addItem(i);
		}
		frame.getContentPane().add(today_day_box);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(42, 196, 303, 246);
		frame.getContentPane().add(textArea);

		// 취소 버튼-----------------------------------------------------------------
		JButton back_btn = new JButton("취소");
		back_btn.setFont(new Font("굴림", Font.BOLD, 15));
		back_btn.setBounds(100, 480, 80, 30);
		back_btn.setHorizontalAlignment(JButton.CENTER);
		frame.getContentPane().add(back_btn);

		// 저장 버튼-------------------------------------------------------------------
		JButton save_btn = new JButton("저장");
		save_btn.setFont(new Font("굴림", Font.BOLD, 15));
		save_btn.setBounds(200, 480, 80, 30);
		frame.getContentPane().add(save_btn);

//저장버튼 눌렀을 때---------------------------------------------------
		//취소버튼 눌렀을 떄 Home 화면으로 돌아감
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
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
		
		
		
		
		
		
		
		
		
		
		// 등록버튼 눌렀을 때
		save_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String today_year = today_year_box.getSelectedItem().toString();// 년
				String today_month = today_month_box.getSelectedItem().toString();// 월
				String today_day = today_day_box.getSelectedItem().toString();// 일
				String today = today_year + "." + today_month + "." + today_day; // 년+월+일
				// today 변수를 데이터베이스에 넣어야 함

				String diary_text = textArea.getText();

				// + 주인 아이디는 Login.java에서 static 변수로 저장한 값으로 가져오기
				String id = Login.mem_id;

				////////////////////// 날짜는 yyyy-mm-dd 이런 형식으로 바꿔주기
				// 모든 입력칸이 채워져있는지 확인

				while (diary_text.length() == 0 || today_year == " " || today_month == " " || today_day == " ") {
					JOptionPane.showMessageDialog(null, "모든 칸을 입력해주세요", "알림 ", JOptionPane.DEFAULT_OPTION);
					return;
				}

				// 입력받은 값 DB에 넣기
				DiaryDB ddb = new DiaryDB(today, diary_text, id);
				ddb.execute();

				frame.setVisible(false);
				///// Home 화면으로 이동
				JOptionPane.showMessageDialog(null, "일기가 등록되었습니다 ! ", "알림", JOptionPane.DEFAULT_OPTION);
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

	}
}
