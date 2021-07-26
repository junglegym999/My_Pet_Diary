package _6_diary;

//다이어리 리스트에 들어가는 요소들 모음집
public class Diary_list_VO {
	private int diary_idx;
	private String diary_date;
	private String diary_content;
	private String id;
	
	public int getDiary_idx() {
		return diary_idx;
	}
	public void setDiary_idx(int diary_idx) {
		this.diary_idx = diary_idx;
	}
	public String getDiary_date() {
		return diary_date;
	}
	public void setDiary_date(String diary_date) {
		this.diary_date = diary_date;
	}
	public String getDiary_content() {
		return diary_content;
	}
	public void setDiary_content(String diary_content) {
		this.diary_content = diary_content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
