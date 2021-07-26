package _5_home;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

//날짜 간의 차 구하는 클래스 
public class Calendar {
	// 오늘 날짜 구하기
	GregorianCalendar cal = new GregorianCalendar();
	SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd");
	// System.out.println(today.format(cal.getTime())); // 오늘 날짜 가져오기

	// 나이(오늘날짜-태어난날짜)리턴하는 함수
	public String getDays_since_Birth(String birthdate) throws ParseException {
		String message;

		String date1 = today.format(cal.getTime()); // 날짜1 오늘 날짜
		String date2 = birthdate; // 날짜2 옛날 날짜

		Date format1 = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
		Date format2 = new SimpleDateFormat("yyyy-MM-dd").parse(date2);

		long diffSec = (format1.getTime() - format2.getTime()) / 1000; // 초 차이
		long diffMin = (format1.getTime() - format2.getTime()) / 60000; // 분 차이
		long diffHor = (format1.getTime() - format2.getTime()) / 3600000; // 시 차이
		long diffDays = diffSec / (24 * 60 * 60); // 일자수 차이
		long diffMon = diffDays / 30; // 월 차이... 완전 정확하진 않음 (일단위 오차 있을 수 있)
		long diffYear = diffMon / 12; // 년 차이..... 완전 정확하진 않음 (일단위 오차 있을 수 있)

		message = diffYear + "년" + diffMon % 12 + "개월";

		return message;
	}
	
	// 나와 함께한 날 수(오늘날짜-태어난날짜)리턴하는 함수
	public String getDays_since_Adopt(String adoptdate) throws ParseException {
		String message;

		String date1 = today.format(cal.getTime()); // 날짜1 오늘 날짜
		String date2 = adoptdate; // 날짜2 옛날 날짜

		Date format1 = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
		Date format2 = new SimpleDateFormat("yyyy-MM-dd").parse(date2);

		long diffSec = (format1.getTime() - format2.getTime()) / 1000; // 초 차이
		long diffMin = (format1.getTime() - format2.getTime()) / 60000; // 분 차이
		long diffHor = (format1.getTime() - format2.getTime()) / 3600000; // 시 차이
		long diffDays = diffSec / (24 * 60 * 60); // 일자수 차이

		message = diffDays + "일";

		return message;
	}

//	public static void main(String[] args) throws ParseException {
//		// 오늘 날짜 구하기
//		GregorianCalendar cal = new GregorianCalendar();
//		SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println(today.format(cal.getTime())); // 오늘 날짜 가져오기
//
//		String date1 = today.format(cal.getTime()); // 날짜1 오늘 날짜
//		String date2 = "2020-10-25 00:00:00"; // 날짜2 옛날 날짜
//
//		Date format1 = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
//		Date format2 = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
//
//		long diffSec = (format1.getTime() - format2.getTime()) / 1000; // 초 차이
//		long diffMin = (format1.getTime() - format2.getTime()) / 60000; // 분 차이
//		long diffHor = (format1.getTime() - format2.getTime()) / 3600000; // 시 차이
//		long diffDays = diffSec / (24 * 60 * 60); // 일자수 차이
//		long diffMon = diffDays / 30; // 월 차이... 완전 정확하진 않음 (일단위 오차 있을 수 있)
//		long diffYear = diffMon / 12; // 년 차이..... 완전 정확하진 않음 (일단위 오차 있을 수 있)
//
//		System.out.println(diffSec + "초 차이");
//		System.out.println(diffMin + "분 차이");
//		System.out.println(diffHor + "시 차이");
//		System.out.println(diffDays + "일 차이");
//		System.out.println(diffMon + "월 차이");
//		System.out.println(diffYear + "년 차이");
//		System.out.println(diffYear + "년" + diffMon % 12 + "개월");
//
//	}
}
