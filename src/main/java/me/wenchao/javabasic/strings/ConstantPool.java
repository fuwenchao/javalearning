package me.wenchao.javabasic.strings;

/**
 * @Author wenchaofu
 * @DATE 22:27 2018/5/20
 * @DESC
 */
public class ConstantPool {
        public static void main(String[] args) {
            Float f1=10.0f;
            Float f2=10.0f;
            System.out.println(f1==f2);
            Double d1=12.0;
            Double d2=12.0;
            System.out.println(d1==d2);
            Integer i1 = 10;
            Integer i2 = 10;
            System.out.println(i1 == i2);

            Integer i3 = 9999;
            Integer i4 = 9999;
            System.out.println(i3 == i4);
        }
}
