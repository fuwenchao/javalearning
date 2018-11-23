package me.wenchao.javapro.reflection;

/**
 * @Author wenchaofu
 * @DATE 11:42 2018/8/10
 * @DESC
 */
public class X {
    String outField = "outField";


    class Xx {
        String inField = "inField";

        public void testUseOutMethod() {
            print(inField); // 访问外部类的方法
        }
    }
    public void print(String string){
        System.out.println(" this is print " + string);

    }

    public static void main(String[] args) {
        Xx xx = new X().new Xx();
        xx.testUseOutMethod();

    }
}
