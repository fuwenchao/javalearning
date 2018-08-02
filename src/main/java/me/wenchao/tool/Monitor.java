package me.wenchao.tool;

import java.lang.reflect.Method;

/**
 * @Author wenchaofu
 * @DATE 16:33 2018/7/30
 * @DESC
 */
public class Monitor {
    private static ThreadLocal<Long> t = new ThreadLocal();

    public static void startTime(){
        t.set(System.nanoTime());
    }
    public static void finish(String clzName,String methodName){
        long finishTime = System.nanoTime();
        System.out.println("类【" + clzName + "】中方法【" + methodName +"】耗时" + (finishTime - t.get())/1000000.0 + " ms");
    }
}


