package me.wenchao.javabasic.exception;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wenchaofu
 * @DATE 14:31 2018/9/3
 * @DESC
 */

@Slf4j
public class ExceptionChain {
    public static void main(String[] args) {

        test();

    }

    private static void test() {
        List<Integer> list = new ArrayList<>();

        try {
            for (int i = 0; i < 10; i++) {
                list.add(i);
            }
            System.out.println(list.toString());
            System.out.println("adalld overExceptionHandle");
            System.out.println("adalld overExceptionHandle");
            System.out.println("adalld overExceptionHandle");
            System.out.println("adalld overExceptionHandle");
            System.out.println("adalld overExceptionHandle");

            getException();
        } catch (Exception e) {

        }
    }

    private static void getException() throws Exception {
        try {
            throw new Exception("reason one2");

        } catch (Exception e) {
            Exception e2 = new Exception("reason two");
            e2.initCause(e);
            throw e2;
        }

    }
}
