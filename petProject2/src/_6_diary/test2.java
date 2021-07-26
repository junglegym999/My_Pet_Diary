package _6_diary;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

//Diary_list_DB2에서 list 리턴해서 list안의 내용물 다이어리 idx,date,content 로 나눠서 보관하는 클래스
public class test2 {

	public test2() {
	}

	public void execute() {
		Diary_list_DB2 dl = new Diary_list_DB2();

		List<Diary_list_VO> dlVO = dl.selectAllBoards();

		// Diary_list_DB2에서 만든 리스트 가져오기
		System.out.println(dlVO);
		
		for(int i=0;i<dlVO.size();i++) {
		System.out.println(dlVO.get(i));
		System.out.print(dlVO.get(i).getDiary_idx());
		System.out.print(dlVO.get(i).getDiary_date());
		System.out.println(dlVO.get(i).getDiary_content());
		}
		
	}

//		// 리스트를 ListIteraor 형식으로 변환
//		ListIterator<Diary_list_VO> listIterator = dlVO.listIterator();
//		while (listIterator.hasNext()) {
//			for (int i = 0; i < dlVO.size(); i++) {
//				diary_idx.add(listIterator.next().getDiary_idx());
//				// System.out.println(listIterator.next().getDiary_idx());
//			}
//
//			ListIterator<Diary_list_VO> listIterator2 = dlVO.listIterator();
//			while (listIterator2.hasNext()) {
//				for (int i = 0; i < dlVO.size(); i++) {
//					diary_date.add(listIterator2.next().getDiary_date());
//					// System.out.println(listIterator2.next().getDiary_date());
//				}
//			}
//
//			ListIterator<Diary_list_VO> listIterator3 = dlVO.listIterator();
//			while (listIterator3.hasNext()) {
//				for (int i = 0; i < dlVO.size(); i++) {
//					diary_content.add(listIterator3.next().getDiary_content());
//					// System.out.println(listIterator3.next().getDiary_content());
//				}
//			}
//
//			System.out.println(diary_idx);
//			System.out.println(diary_date);
//			System.out.println(diary_content);
//			
//			setDiary_idx(diary_idx);
//			setDiary_date(diary_date);
//			setDiary_content(diary_content);

		
		public static void main (String[] args) {
			test2 t2=new test2();
			t2.execute();
		}

	

}
