package me.wenchao.javapro.reference;

/**
 * @Author wenchaofu
 * @DATE 18:07 2018/5/15
 * @DESC
 */

import java.util.Date;

public class MyDate extends Date {

    /** Creates a new instance of MyDate */
    public MyDate() {
        System.out.println("mydate new");
    }
    // 覆盖finalize()方法
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("obj [Date: " + this.getTime() + "] is gc");
    }

    public String toString() {
        return "Date: " + this.getTime();
    }
}