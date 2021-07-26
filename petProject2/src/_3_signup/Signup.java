package _3_signup;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import _0_base.Mainframe;
import _2_login.Login;
//import _3_signup.IdDoubleChk;
//import _3_signup.MemberInfo;

import javax.swing.JButton;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Signup {

	public JFrame frame;
	

	//실행하기 ~ 
	public static void main(String[] args) {
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

	
	public Signup() {
		initialize();
	}

	
	private void initialize() {
		// 공통 프레임 적용
		Mainframe mf = new Mainframe();
		frame = mf.Mainframe;

		// 화면 요소들
		JLabel titleLabel = new JLabel("My Pet Diary");
		titleLabel.setForeground(SystemColor.windowBorder);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
		titleLabel.setBounds(100, 40, 180, 30);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(titleLabel);
		
		JLabel subLabel = new JLabel("회원가입");
		subLabel.setForeground(SystemColor.controlShadow);
		subLabel.setFont(new Font("굴림", Font.BOLD, 13));
		subLabel.setBounds(160, 70, 55, 20);
		subLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(subLabel);

		JLabel idLabel = new JLabel("ID");
		idLabel.setForeground(SystemColor.controlShadow);
		idLabel.setFont(new Font("Arial", Font.BOLD, 15));
		idLabel.setBounds(40, 110, 30, 30);
		frame.getContentPane().add(idLabel);

		JTextField idText = new JTextField();
		idText.setColumns(10);
		idText.setBounds(40, 140, 286, 30);
		frame.getContentPane().add(idText);

		JLabel pwLabel = new JLabel("PASSWORD");
		pwLabel.setForeground(SystemColor.controlShadow);
		pwLabel.setFont(new Font("Arial", Font.BOLD, 15));
		pwLabel.setBounds(40, 180, 112, 30);
		frame.getContentPane().add(pwLabel);

		JTextField pwText = new JTextField();
		pwText.setColumns(10);
		pwText.setBounds(40, 210, 286, 30);
		frame.getContentPane().add(pwText);

		JLabel emailLabel = new JLabel("E-MAIL");
		emailLabel.setForeground(SystemColor.controlShadow);
		emailLabel.setFont(new Font("Arial", Font.BOLD, 15));
		emailLabel.setBounds(40, 250, 112, 30);
		frame.getContentPane().add(emailLabel);

		JTextField emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(40, 280, 286, 30);
		frame.getContentPane().add(emailText);

		JLabel phoneLabel = new JLabel("PHONE");
		phoneLabel.setForeground(SystemColor.controlShadow);
		phoneLabel.setFont(new Font("Arial", Font.BOLD, 15));
		phoneLabel.setBounds(40, 320, 112, 30);
		frame.getContentPane().add(phoneLabel);

		JTextField phoneText = new JTextField();
		phoneText.setColumns(10);
		phoneText.setBounds(40, 350, 286, 30);
		frame.getContentPane().add(phoneText);

		JButton singupBtn = new JButton("등록하기");
		singupBtn.setFont(new Font("굴림", Font.BOLD, 13));
		singupBtn.setBounds(130, 430, 100, 35);
		frame.getContentPane().add(singupBtn);
		
		JButton backBtn = new JButton("뒤로가기");
		backBtn.setFont(new Font("굴림", Font.BOLD, 13));
		backBtn.setBounds(130, 480, 100, 35);
		frame.getContentPane().add(backBtn);
		
		////// signup 버튼 눌렀을 때
		singupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 입력칸에 있는 값 저장
				String id = idText.getText().trim();
				String pw = pwText.getText().trim();
				String email = emailText.getText().trim();
				String phone = phoneText.getText().trim();

				// 모든 입력칸이 채워져있는지 확인
				while (id.length() == 0 || pw.length() == 0 || email.length() == 0 || phone.length() == 0) {
					JOptionPane.showMessageDialog(null, "모든 칸을 입력해주세요", "알림 ", JOptionPane.DEFAULT_OPTION);
					return;
				}

				// 아이디중복체크
				IdDoubleChk idck = new IdDoubleChk(id);
				idck.execute();

				if (idck.idDouble != 0) {
					JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다! \n 다른 아이디를 입력해주세요", "알림",
							JOptionPane.DEFAULT_OPTION);
					return;
				}

				/// 회원가입 완료시
				frame.setVisible(false);
				
				JOptionPane.showMessageDialog(null, "회원가입 성공! \n 로그인 화면으로 이동합니다", "알림",
						JOptionPane.DEFAULT_OPTION);
				
				//회원정보 DB에 넣기
				MemberInfo mifo = new MemberInfo(id, pw, email, phone);
				mifo.execute();

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
