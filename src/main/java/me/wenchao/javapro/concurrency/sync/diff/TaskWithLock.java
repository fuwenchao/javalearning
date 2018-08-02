package me.wenchao.javapro.concurrency.sync.diff;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author wenchaofu
 * @DATE 16:07 2018/7/11
 * @DESC
 */
public class TaskWithLock extends Task implements Runnable {
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        try {
            lock.lock();
            doStuff();
        }finally {
            lock.unlock();
        }
    }
}
