package test.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by czj on 2016/12/23.
 */
public class DateUtils {

    public static void main(String[] args){
        long[] r = dateDiff("2016-12-01 12:05:20","2017-02-01 01:00:00","yyyy-MM-dd HH:mm:ss");
        for(long s : r){
            System.out.println(s);
        }
        String use = "";
        use += Math.abs(r[0])*24*60 + Math.abs(r[1])*60 + Math.abs(r[2]);
        System.out.println(use);

    }

    public void monthWeekDayTest(){
        DateUtils du = new DateUtils();
        System.out.println(du.formatDate(du.getCurrentDayStart()));
        System.out.println(du.formatDate(du.getCurrentDayEnd()));
        System.out.println(du.formatDate(du.getCurrentWeekStart()));
        System.out.println(du.formatDate(du.getCurrentWeekEnd()));
        System.out.println(du.formatDate(du.getCurrentMonthStart()));
        System.out.println(du.formatDate(du.getCurrentMonthEnd()));
    }

    public void calendarTest(){
        Date start = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date end = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(start));
        System.out.println(sdf.format(end));
    }

    public static String formatDate(Date date){
        // 24小时制 HH:mm:ss
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static String formatDate(Date date, String format){
        // 24小时制 HH:mm:ss
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date getCurrentDayStart(){
//        Calendar currentDate = new GregorianCalendar();
        Calendar currentDate =  Calendar.getInstance();
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        return (Date)currentDate.getTime().clone();
    }

    public static Date getCurrentDayEnd(){
//        Calendar currentDate = new GregorianCalendar();
        Calendar currentDate =  Calendar.getInstance();
        currentDate.set(Calendar.HOUR_OF_DAY, 23);
        currentDate.set(Calendar.MINUTE, 59);
        currentDate.set(Calendar.SECOND, 59);
        return (Date)currentDate.getTime().clone();
    }

    public static Date getCurrentWeekStart(){
//        Calendar currentDate = new GregorianCalendar();
        Calendar currentDate =  Calendar.getInstance();
        currentDate.setFirstDayOfWeek(Calendar.MONDAY);
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return (Date)currentDate.getTime().clone();
    }

    public static Date getCurrentWeekEnd(){
//        Calendar currentDate = new GregorianCalendar();
        Calendar currentDate =  Calendar.getInstance();
        currentDate.setFirstDayOfWeek(Calendar.MONDAY);
        currentDate.set(Calendar.HOUR_OF_DAY, 23);
        currentDate.set(Calendar.MINUTE, 59);
        currentDate.set(Calendar.SECOND, 59);
        currentDate.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return (Date)currentDate.getTime().clone();
    }

    public static Date getCurrentMonthStart(){
//        Calendar currentDate = new GregorianCalendar();
        Calendar currentDate =  Calendar.getInstance();
        currentDate.setTime(new Date());
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.DAY_OF_MONTH, currentDate.getActualMinimum(Calendar.DAY_OF_MONTH));
        return (Date)currentDate.getTime().clone();
    }

    public static Date getCurrentMonthEnd(){
//        Calendar currentDate = new GregorianCalendar();
        Calendar currentDate =  Calendar.getInstance();
        currentDate.setTime(new Date());
        currentDate.set(Calendar.HOUR_OF_DAY, 23);
        currentDate.set(Calendar.MINUTE, 59);
        currentDate.set(Calendar.SECOND, 59);
        currentDate.set(Calendar.DAY_OF_MONTH, currentDate.getActualMaximum(Calendar.DAY_OF_MONTH));
        return (Date)currentDate.getTime().clone();
    }

    public static long[] dateDiff(String startTime, String endTime, String format) {
        Date start = setDateByStr(startTime, format);
        Date end = setDateByStr(endTime, format);
        if (start == null || end == null)
            return null;
        long nd = 86400000L;
        long nh = 3600000L;
        long nm = 60000L;
        long ns = 1000L;
        long[] date = new long[4];
        long diff = start.getTime() - end.getTime();
        date[0] = diff / nd;
        date[1] = diff % nd / nh;
        date[2] = diff % nd % nh / nm;
        date[3] = diff % nd % nh % nm / ns;
        return date;
    }

    public static Date setDateByStr(String str, String format) {
        SimpleDateFormat f = new SimpleDateFormat(format);
        Date d = null;
        try {
            d = f.parse(str);
        } catch (ParseException e) {
            return null;
        }
        return d;
    }

}
