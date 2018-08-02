package me.wenchao.javabasic.innerclass;

/**
 * @Author wenchaofu
 * @DATE 17:55 2018/5/28
 * @DESC
 */
public class Outter {
    private int i = 1;
    class Inner{
        @Override
        public String toString() {
            System.out.println(i);
            return "inner class";
        }
    }

    public static void main(String[] args) {
        Outter outter = new Outter();
        Outter.Inner inner = outter.new Inner();
        System.out.println(inner);
    }
}
