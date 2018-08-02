package me.wenchao.javapro.concurrency.sync.diff;

import java.util.Calendar;

/**
 * @Author wenchaofu
 * @DATE 16:04 2018/7/11
 * @DESC
 */
public class Task {
    public void doStuff(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(" 线程名称 : " + Thread.currentThread().getName());
        sb.append(" , 执行时间 ： " + Calendar.getInstance().get(Calendar.SECOND));
        System.out.println(sb.toString());
    }
}
