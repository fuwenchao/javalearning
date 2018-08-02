package me.wenchao.javapro.concurrency.CommonSafe;

import me.wenchao.annotation.NotThreadSafe;

import java.util.Iterator;
import java.util.Vector;

/**
 * @Author wenchaofu
 * @DATE 17:34 2018/6/13
 * @DESC
 */
@NotThreadSafe
public class VectorRemoveError {



    // java.util.ConcurrentModificationException
    private static void test1(Vector<Integer> vector){

        for (Integer i : vector) {
            if (i.equals(3)) {
                vector.remove(i);
            }
        }



    }


    // java.util.ConcurrentModificationException
    private static void test2(Vector<Integer> v1){

        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i.equals(3)) {
                System.out.println(" i " + i);
                v1.remove(i);
            }
        }
    }

    // success
    private static void test3(Vector<Integer> vector){
        for (int i = 0; i < vector.size(); i++) {
            if (vector.get(i).equals(3)) {
                System.out.println(" i is " + i);
                vector.remove(i);
            }
        }
    }


    private static void test4(Vector<Integer> v1){

        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i.equals(3)) {
                System.out.println(" i " + i);
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(12);
        vector.add(3);
        vector.add(4);
        vector.add(7);
        test2(vector);
        System.out.println(vector.toString());


    }

}
