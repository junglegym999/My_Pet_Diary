package DBtest;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import _6_diary.Diary_list_DB2;
import _6_diary.Diary_list_VO;

//Diary_list_DB2에서 list 리턴해서 list안의 내용물 다이어리 idx,date,content 로 나눠서 보관하는 클래스
public class test {

	public ArrayList<Integer> diary_idx = new ArrayList<>();
	public ArrayList<String> diary_date = new ArrayList<>();
	public ArrayList<String> diary_content = new ArrayList<>();
	
	
	public ArrayList<Integer> getDiary_idx() {
		return diary_idx;
	}

	public void setDiary_idx(ArrayList<Integer> diary_idx) {
		this.diary_idx = diary_idx;
	}

	public ArrayList<String> getDiary_date() {
		return diary_date;
	}

	public void setDiary_date(ArrayList<String> diary_date) {
		this.diary_date = diary_date;
	}

	public ArrayList<String> getDiary_content() {
		return diary_content;
	}

	public void setDiary_content(ArrayList<String> diary_content) {
		this.diary_content = diary_content;
	}

	

	public test() {
	}

	public void execute() {
		Diary_list_DB2 dl = new Diary_list_DB2();

		List<Diary_list_VO> dlVO = dl.selectAllBoards();

		// Diary_list_DB2에서 만든 리스트 가져오기
		System.out.println(dlVO);
		dlVO.get(0);


		// 리스트를 ListIteraor 형식으로 변환
		ListIterator<Diary_list_VO> listIterator = dlVO.listIterator();
		while (listIterator.hasNext()) {
			for (int i = 0; i < dlVO.size(); i++) {
				diary_idx.add(listIterator.next().getDiary_idx());
				// System.out.println(listIterator.next().getDiary_idx());
			}

			ListIterator<Diary_list_VO> listIterator2 = dlVO.listIterator();
			while (listIterator2.hasNext()) {
				for (int i = 0; i < dlVO.size(); i++) {
					diary_date.add(listIterator2.next().getDiary_date());
					// System.out.println(listIterator2.next().getDiary_date());
				}
			}

			ListIterator<Diary_list_VO> listIterator3 = dlVO.listIterator();
			while (listIterator3.hasNext()) {
				for (int i = 0; i < dlVO.size(); i++) {
					diary_content.add(listIterator3.next().getDiary_content());
					// System.out.println(listIterator3.next().getDiary_content());
				}
			}

			System.out.println(diary_idx);
			System.out.println(diary_date);
			System.out.println(diary_content);
			
			setDiary_idx(diary_idx);
			setDiary_date(diary_date);
			setDiary_content(diary_content);
//
//			System.out.println(listIterator.next().getDiary_date());
//			System.out.println(listIterator.next().getDiary_date());
//			System.out.println(listIterator.next().getDiary_date());
//			
//			System.out.println(listIterator.next().getDiary_content());
//			System.out.println(listIterator.next().getDiary_content());
//			System.out.println(listIterator.next().getDiary_content());

		}

	}

}
