package _6_diary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import _0_base.Mainframe;
import _5_home.Home;

public class Diary_list {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the application.
	 */
	public Diary_list() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// 공통프레임 적용
		Mainframe mf = new Mainframe();
		frame = mf.Mainframe;

		JButton HomeBtn = new JButton("홈으로");
		HomeBtn.setFont(new Font("굴림", Font.PLAIN, 9));
		HomeBtn.setBounds(10, 10, 70, 40);
		frame.getContentPane().add(HomeBtn);

		JLabel titleLabel = new JLabel("My Pet Diary");
		titleLabel.setForeground(SystemColor.windowBorder);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
		titleLabel.setBounds(100, 40, 190, 40);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(titleLabel);

		JLabel subtitleLabel = new JLabel("반려동물 일기 보기"); // 내 반려동물 이름에 따라 다르게 나올 수 있도록 하고 싶,,
		subtitleLabel.setForeground(SystemColor.windowBorder);
		subtitleLabel.setFont(new Font("굴림", Font.BOLD, 13));
		subtitleLabel.setBounds(130, 85, 130, 15);
		subtitleLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(subtitleLabel);

		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(23, 120, 330, 350);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 0));

		JPanel[] sub_panel = new JPanel[3];// 하나의 게시물이 올라갈 패널 (diary_date, diary_content,상세보기 버튼)
		JLabel dateLabel;
		JLabel contentLabel;
		JButton selectBtn;

		// Diary_list_DB2에서 만든 리스트 가져오기
		Diary_list_DB2 dl = new Diary_list_DB2();

		List<Diary_list_VO> dlVO = dl.selectAllBoards();

		for (int i = 0; i < 3; i++) {
			sub_panel[i] = new JPanel();
			sub_panel[i].setLayout(new GridLayout(0, 3));

			dateLabel = new JLabel(dlVO.get(i).getDiary_date());
//		
			contentLabel = new JLabel(dlVO.get(i).getDiary_content());

			selectBtn = new JButton("상세보기");

			sub_panel[i].add(dateLabel);
			sub_panel[i].add(contentLabel);
			sub_panel[i].add(selectBtn);

			panel.add(sub_panel[i]);
		}

//		sub_panel1.setBackground(Color.BLACK);
//		sub_panel2.setBackground(Color.white);
//		sub_panel3.setBackground(Color.BLACK);

//		panel.add(sub_panel1);
//		panel.add(sub_panel2);
//		panel.add(sub_panel3);

		//////////// 하단
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(100, 500, 180, 40);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout());

		JButton btnNewButton = new JButton("1");
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("2");
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("3");
		panel_1.add(btnNewButton_2);

		// 액션 리스너 시작
		HomeBtn.addActionListener(new ActionListener() {
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

	}
}
