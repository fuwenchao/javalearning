package me.wenchao.javabasic.innerclass;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author wenchaofu
 * @DATE 9:43 2018/5/23
 * @DESC
 */
public class InnerClassTest {
    Map hashMap = Collections.synchronizedMap(new HashMap<String,String>());
    public class Inner{
        public void test(){
            System.out.println("this is inner test method");
        }
    }

    public static void main(String[] args) {
        InnerClassTest innerClassTest = new InnerClassTest();
        Inner inner = innerClassTest.new Inner();
        inner.test();
    }
}
