package me.wenchao.javabasic.oom;

/**
 * @Author wenchaofu
 * @DATE 13:22 2018/5/18
 * @DESC -Xss2M (虚拟机栈设置大一些)
 */
public class StackOOM2 {
    private void noStop() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    noStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        StackOOM2 stackOOM2 = new StackOOM2();
        stackOOM2.stackLeakByThread();
    }
}
