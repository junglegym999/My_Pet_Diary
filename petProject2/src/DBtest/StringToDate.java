package DBtest;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
 
// String -> java.sql.Date로 변경
public class StringToDate 
{
    public static void main(String[] args)
    {
        StringToDate st = new StringToDate();
 
        System.out.println(st.transformDate("2016", "11", "22"));
        System.out.println(st.transformDate("20161101"));
    }
    
    // 년, 월, 일이 각각 입력되었을 경우 Date로 변경하는 메서드
    public Date transformDate(String year, String month, String day)
    {
        String date = year+"-"+month+"-"+day;
        Date d = Date.valueOf(date);
        
        return d;
    }
    
    // 날짜가 yyyymmdd 형식으로 입력되었을 경우 Date로 변경하는 메서드
    public Date transformDate(String date)
    {
        SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyymmdd");
        
        // Date로 변경하기 위해서는 날짜 형식을 yyyy-mm-dd로 변경해야 한다.
        SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
        
        java.util.Date tempDate = null;
        
        try {
            // 현재 yyyymmdd로된 날짜 형식으로 java.util.Date객체를 만든다.
            tempDate = beforeFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        // java.util.Date를 yyyy-mm-dd 형식으로 변경하여 String로 반환한다.
        String transDate = afterFormat.format(tempDate);
        
        // 반환된 String 값을 Date로 변경한다.
        Date d = Date.valueOf(transDate);
        
        return d;
    }
}
 
 
/****실행결과*****
*
*  2016-11-22
*  2016-11-01
*
*/

