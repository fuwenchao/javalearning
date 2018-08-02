package me.wenchao.javabasic.suggest;

/**
 * @Author wenchaofu
 * @DATE 17:12 2018/6/28
 * @DESC
 */
public class MethodOverRide {
    private static Base base = new Sub();

    public static void main(String[] args) {
        base.print(1,"a");

        System.out.println("========");
        int count = 0;
        for (int i = 0; i < 10; i++) {
            count = ++count;
        }
        System.out.println(count);
    }
}

class Base {
    public void print(int a , String... str){
        System.out.println("this is base");

    }
}
class Sub extends Base {

    @Override
    public void print(int a , String[] str) {
        System.out.println("this is sub");
    }
}
