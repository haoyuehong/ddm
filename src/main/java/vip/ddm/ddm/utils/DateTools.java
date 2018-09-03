package vip.ddm.ddm.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateTools {

    /**
     * 日期转星期
     *
     * @param datetime
     * @return
     */
    public static String dateToWeek(String datetime) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        try {
            datet = f.parse(datetime);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /*public static void main(String[] args) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        //System.out.println(DateTools.dateToWeek("2019:08:29"));
        System.out.println(changeDay());
    }*/

    public static List<Date> changeDay(){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        List<Date> dates = new ArrayList<>();
        Calendar calen = Calendar.getInstance();
        for(int i=0;i<=7;i++){
            calen.setTime(new Date());
            calen.add(Calendar.DATE, i);
            Date date = calen.getTime();
            //System.out.println("加"+i+"天后的日期:"+f.format(date));
            dates.add(date);
        }
        return dates;
    }

    public static Date tomrrow(){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calen = Calendar.getInstance();
        calen.setTime(new Date());
        calen.add(Calendar.DATE, 1);
        Date date = calen.getTime();
        return date;
    }
}
