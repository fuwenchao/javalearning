package me.wenchao.designschema.proxy.givemoney;

/**
 * @Author wenchaofu
 * @DATE 15:42 2018/6/4
 * @DESC
 */
public class MonitorTools {
    private static ThreadLocal<Long> t = new ThreadLocal();

    public static void startTime(){
        t.set(System.currentTimeMillis());
    }
    public static void finish(){
        long finishTime = System.currentTimeMillis();
        System.out.println("方法耗时" + (finishTime - t.get()) + " ms");
    }
}
