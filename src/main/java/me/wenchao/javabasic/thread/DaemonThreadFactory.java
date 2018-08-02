package me.wenchao.javabasic.thread;

import java.util.concurrent.ThreadFactory;

/**
 * @Author wenchaofu
 * @DATE 16:58 2018/6/1
 * @DESC
 */
public class DaemonThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
