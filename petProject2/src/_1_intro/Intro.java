package _1_intro;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import _0_base.Mainframe;
import _2_login.Login;

public class Intro {

	public JFrame frame = new JFrame();

//실행하기
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Intro window = new Intro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Intro() {
		initialize();
	}

	// 화면 요소
	private void initialize() {
		// 공통프레임 적용
		Mainframe mf = new Mainframe();
		frame = mf.Mainframe;

		JLabel subLabel = new JLabel("나만의 반려동물 관리 앱");
		subLabel.setForeground(SystemColor.controlShadow);
		subLabel.setFont(new Font("굴림", Font.BOLD, 15));
		subLabel.setBounds(100, 60, 180, 30);
		subLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(subLabel);

		///////////////////////
		JLabel iconLabel = new JLabel("");

		ImageIcon logo = new ImageIcon("image/logo.png"); // 이미지는 상대경로로 써두기

		Image img = logo.getImage();
		Image changeImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon changeLogo = new ImageIcon(changeImg);

		iconLabel.setIcon(changeLogo);
		iconLabel.setBounds(100, 118, 200, 200);
		iconLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(iconLabel);

		//////////////////////////
		JLabel titleLabel = new JLabel("My Pet Diary");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
		titleLabel.setForeground(SystemColor.DARK_GRAY);
		titleLabel.setBounds(95, 350, 200, 40);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(titleLabel);

		JButton startBtn = new JButton("시작하기");
		startBtn.setFont(new Font("굴림", Font.BOLD, 15));
		startBtn.setBounds(132, 450, 120, 40);
		startBtn.setHorizontalAlignment(JButton.CENTER);
		frame.getContentPane().add(startBtn);

		// 액션 리스너 시작
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
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
		});
	}
}
