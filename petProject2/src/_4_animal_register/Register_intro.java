package _4_animal_register;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

import _0_base.Mainframe;
import _2_login.Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//반려동물 등록하는 클래쓰
public class Register_intro {

	public JFrame frame;

	
	public static void main(String[] args) {
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

	
	public Register_intro() {
		initialize();
	}

	
	private void initialize() {
		// 공통 프레임 적용
		Mainframe mf = new Mainframe();
		frame = mf.Mainframe;
		
	//화면 구성요소 
		JLabel titleLabel = new JLabel("My Pet Diary");
		titleLabel.setForeground(SystemColor.windowBorder);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
		titleLabel.setBounds(100, 80, 190, 40);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(titleLabel);

		JLabel subLabel = new JLabel("반려동물을 등록해주세요");
		subLabel.setForeground(SystemColor.controlShadow);
		subLabel.setFont(new Font("굴림", Font.BOLD, 15));
		subLabel.setBounds(100, 200, 180, 30);
		subLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(subLabel);

		JButton btnNewButton = new JButton("+");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 47));
		btnNewButton.setBounds(140, 253, 95, 89);
		btnNewButton.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(btnNewButton);
		
		//액션리스너_버튼 누르면
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);

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
		});
	}
}
