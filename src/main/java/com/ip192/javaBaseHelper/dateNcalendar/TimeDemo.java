package com.ip192.javaBaseHelper.dateNcalendar;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

public class TimeDemo {
    /*
     * SimpleDateFormat 对象实例应单例
     */

    /**
     * 返回指定时间
     * "yyyy-MM-dd" -> "yyyy-MM-dd 00:00:00"
     * "yyyy-MM-dd HH:mm:ss" -> "yyyy-MM-dd HH:mm:ss"
     */
    public Date convertString2Date(String dateStr) throws ParseException {
        if (dateStr.split(" ").length == 1) dateStr = dateStr.concat(" 00:00:00");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(dateStr);
    }
    @Test
    public void testConvertString2Date() throws ParseException {
        System.out.println(convertString2Date("2018-02-15 10:10:10"));
        System.out.println(convertString2Date("2018-02-14"));
    }


    /**
     * @return (String) 1h later
     */
    public String nHourAfter(int n) {
        Date date = new Date();
        date.setTime(System.currentTimeMillis() + n * 60 * 60 * 1000L);
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        String timeStr = time.concat("");
        return timeStr;
    }
    @Test
    public void testNHourAfter() {
        System.out.println(nHourAfter(10));
    }


    /**
     * 两个日期相减
     * @param from
     * @param to
     */
    public String dateMinus(Date from, Date to) {
        System.out.println(to.getTime() - from.getTime());
        return null;
    }
    @Test
    public void testDateMinus() throws ParseException {
        Date from = new Date(),
             to = convertString2Date("2018-02-14");
        dateMinus(from, to);
    }


    /**
     * 设置时间
     * calendar 对象被指定具体时间后，存储fields的数组也就确定了
     */
    public Date getTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DAY_OF_MONTH);
        int week = calendar.get(Calendar.DAY_OF_WEEK); // Sun Mon Tue ...

        System.out.print("现在时间是: ");
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.print(year + "年" + month + "月" + date + "日");
        String[] weeks = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        System.out.print(" " + weeks[week]);
        return null;
    }
    @Test
    public void testSetTime() {
        getTime();
    }
}

class TestMain {

//    public static void main(String[] args) {
//
//    }
}