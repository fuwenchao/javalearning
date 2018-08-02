package me.wenchao.javapro.comm.bio.multithreadbio;

import java.util.concurrent.CountDownLatch;

/**
 * @Author wenchaofu
 * @DATE 16:30 2018/7/20
 * @DESC
 */
public class Client {

    public static final int THREAD_NUM = 10;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUM);

        for (int i = 0; i < THREAD_NUM; i++,countDownLatch.countDown()) {
            RequestThread requestThread = new RequestThread(countDownLatch, i);
            new Thread(requestThread).start();
        }

        //这个wait不涉及到具体的实验逻辑，只是为了保证守护线程在启动所有线程后，进入等待状态
        synchronized (Client.class) {
            Client.class.wait();
        }



    }
}
