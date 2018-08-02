package me.wenchao.javabasic.basic;

/**
 * @Author wenchaofu
 * @DATE 18:07 2018/7/14
 * @DESC
 */
class  DecorateFather{
    public void print(){
        System.out.println("Dfather");
    }

}
class DecorateSon extends DecorateFather{

    @Override
    public void print() {
        System.out.println("Dson");
        super.print();
    }
}
public class SuperTest extends DecorateSon {
    @Override
    public void print() {
        super.print();
        System.out.println("SuperTest");
    }

    public static void main(String[] args) {
        SuperTest st = new SuperTest();
        st.print();
    }
}
