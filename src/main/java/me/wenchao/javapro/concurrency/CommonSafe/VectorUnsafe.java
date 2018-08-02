package me.wenchao.javapro.concurrency.CommonSafe;

import me.wenchao.annotation.NotThreadSafe;

import java.util.Vector;

/**
 * @Author wenchaofu
 * @DATE 17:34 2018/6/13
 * @DESC
 */
@NotThreadSafe
public class VectorUnsafe {
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {


            for (int i = 0; i < 10; i++) {
                vector.add(i);

            }
            Thread thread1 = new Thread() {

                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }

                }
            };

            Thread thread2 = new Thread() {

                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.get(i);
                    }

                }
            };
            thread1.start();
            thread2.start();
        }
    }
}
