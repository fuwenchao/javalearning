package me.wenchao.javabasic.basic;

/**
 * @Author wenchaofu
 * @DATE 16:31 2018/7/6
 * @DESC
 */
class AA {
    public int i = 12;


    public AA(){}
//    public AA(int i ){
//        this.i = i;
//
//    }

    public void print(){
        System.out.println("this is AA");
    }
    public final void finalPrint(){
        System.out.println("this is final AA");
    }
}

public class BB extends AA {

    public int i = -6;

//    public BB(int i){
//        super(i);
//    }

    public BB(){}

    public void print(){
        System.out.println("this is BB");
    }
    /*
    public final void finalPrint(){
        System.out.println("this is final BB");
    }*/

    public static void main(String[] args) {
        AA xx = new BB();
        System.out.println(xx.i);
        xx.print();
//        print();
        xx.finalPrint();
    }
}