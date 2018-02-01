package com.ip192.javaBaseHelper.dateNcalendar;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

public class TimeDemo {
    private final String[] weeks = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
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
        System.out.print(" " + weeks[week]);
        return null;
    }
    @Test
    public void testGetTime() {
        getTime();
    }


    /**
     * 打印当前月份的日历
     */
    public void monthPrint() {
        int[][] month = new int[5][7];

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 0);
        int week01 = calendar.get(Calendar.DAY_OF_WEEK); // 1号星期几
        int monthLength = calendar.getActualMaximum(Calendar.DATE); // 当前月天数

        for (int d = 1; d <= monthLength; d++) {
            month[d / 7][d % 7 + week01 - 1] = d;
        }

        System.out.println(" 日  一  二  三  四  五  六");
        for (int i = 0; i < 5; i++) {
           for (int j = 0; j < 7; j++) {
               if (month[i][j] < 10) {
                   System.out.print("  " + month[i][j]);
               } else {
                   System.out.print(" " + month[i][j]);
               }
           }
            System.out.println();
        }
    }
    @Test
    public void testMonthPrint() {
        monthPrint();
    }


    /**
     * 指定时间
     */
    public void setTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 30);
        System.out.println(calendar.get(Calendar.DATE));
    }
    @Test
    public void testSetTime() {
        setTime();
    }
}

class TestMain {

//    public static void main(String[] args) {
//
//    }
}