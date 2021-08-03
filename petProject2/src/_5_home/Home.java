package _5_home;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import _0_base.Mainframe;
import _1_intro.Intro;
import _2_login.Login;
import _6_diary.Diary_write;
import _6_diary.Diary_list;

public class Home {

	public JFrame frame;
	Login login = new Login(); // 로그인 정보 가져오기 위함

	String name;
	String type;
	String birth;
	String adopt;// 로그인 정보에 있는 등록된 동물 정보 가져오기 위함

	public static void main(String[] args) {

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

	public Home() {
		initialize();
	}

	private void initialize() {
		// 공통프레임 적용
		Mainframe mf = new Mainframe();
		frame = mf.Mainframe;

		// id에 동물등록된 반려동물 데이터 가져오기
		HomeDB hDB = new HomeDB();

		// 반려동물 정보 HomeDB에서 가져와서 변수에 저장
		name = hDB.getName();
		type = hDB.getType();
		birth = hDB.getBirth();
		adopt = hDB.getAdopt();

		System.out.println("TEST 당신의 반려동물은 :");
		System.out.println(type);
		// birth 변수와 adopt변수 화면에 출력할 형식에 맞게 변형
		Calendar cal = new Calendar(); // 캘린더 클래스 불러오기

		try {
			birth = cal.getDays_since_Birth(birth);
			adopt = cal.getDays_since_Adopt(adopt);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		// 화면 구성요소 시작
		JLabel idLabel = new JLabel(login.mem_id + " " + "님 반갑습니다^^");
		idLabel.setBounds(32, 30, 300, 15);
		frame.getContentPane().add(idLabel);

		///////////////////////
		JLabel iconLabel = new JLabel("");
		// 이미지아이콘 경로 상대경로로 바꿔줘야함
		ImageIcon animal;
		if (type.equals("강아지")) { // 등록된 동물이 강아지일 경우 강아지 이미지 출력
			animal = new ImageIcon("image/dog.png");
		} else if(type.equals("고양이")) { // 등록된 동물이 고양이일 경우 고양이 이미지 출력
			animal = new ImageIcon("image/cat.png");
		}else {
			animal = new ImageIcon("image/logo.png");
		}

		Image img = animal.getImage();
		Image changeImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon changeLogo = new ImageIcon(changeImg);

		iconLabel.setIcon(changeLogo);
		iconLabel.setBounds(120, 120, 150, 150);
		iconLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(iconLabel);
		/////////////////////

		JLabel nameLabel = new JLabel(name);
		nameLabel.setBounds(139, 278, 100, 50);
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(nameLabel);

		JLabel birthLabel = new JLabel(birth);
		birthLabel.setBounds(96, 324, 200, 30);
		birthLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(birthLabel);

		JLabel adoptLabel = new JLabel("나와 함께한 지 " + adopt);
		adoptLabel.setBounds(96, 361, 200, 30);
		adoptLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(adoptLabel);

		JButton diary_lookup_Btn = new JButton("일기 보기");
		diary_lookup_Btn.setBounds(80, 450, 100, 80);
		frame.getContentPane().add(diary_lookup_Btn);

		JButton diary_write_Btn = new JButton("일기 쓰기");
		diary_write_Btn.setBounds(220, 450, 100, 80);
		frame.getContentPane().add(diary_write_Btn);

		JButton logout_Btn = new JButton("로그아웃");
		logout_Btn.setBounds(300, 20, 70, 30);
		logout_Btn.setFont(new Font("굴림", Font.BOLD, 7));
		frame.getContentPane().add(logout_Btn);

//액션리스너 적용하기
		// 일기 보기 버튼
		diary_lookup_Btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Diary_list window = new Diary_list();
									window.frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
				});
		
		
		
		
		
		
		
		
		
		
		
		
		// 일기 쓰기 버튼
		diary_write_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {

							Diary_write window = new Diary_write();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		//로그아웃 버튼
		logout_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							//static 변수였던 id,pw 값 없애주기
							login.mem_id=null;
							login.mem_pw=null;
							
							JOptionPane.showMessageDialog(null, "로그아웃이 완료되었습니다!", "알림", JOptionPane.DEFAULT_OPTION);
							
							//처음 화면으로 이동
							Intro window = new Intro();
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
