package me.wenchao.javapro.concurrency.sync.diff;

/**
 * @Author wenchaofu
 * @DATE 16:08 2018/7/11
 * @DESC
 */
public class TaskWithSync extends Task implements Runnable {

    @Override
    public void run() {
        // 注意，代码块是类级别的(this 是对象级别，常量是类级别)，方法是对象级别的
        synchronized ("A"){
            doStuff();
        }
//       doStuff();
    }

    /*@Override
    public synchronized void doStuff() {
        super.doStuff();
    }*/
}
