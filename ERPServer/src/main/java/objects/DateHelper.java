package objects;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期是辅助工具，获取日期，判断日期
 */
public class DateHelper {
   public String getDate(){
      Calendar calendar = Calendar.getInstance();
      Date date = calendar.getTime();
      SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
      String s = f.format(date);
      return s;
   }

   public boolean isSameDay(String date1, String date2){
      return date1.equals(date2);
   }


}
