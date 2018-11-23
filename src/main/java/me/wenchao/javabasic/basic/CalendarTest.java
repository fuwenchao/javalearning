package me.wenchao.javabasic.basic;

import java.util.Calendar;

/**
 * @Author wenchaofu
 * @DATE 16:00 2018/7/11
 * @DESC
 */
public class CalendarTest {
    static Calendar calendar = Calendar.getInstance();
    public static void main(String[] args) {
        System.out.println(Calendar.getInstance().get(Calendar.SECOND));
        calendar.roll(Calendar.DATE,-1);
        System.out.println(calendar.getTime());

    }
}
