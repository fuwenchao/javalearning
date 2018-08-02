package me.wenchao.javapro.reference;

/**
 * @Author wenchaofu
 * @DATE 18:14 2018/5/15
 * @DESC
 */

import java.lang.ref.WeakReference;

public class WeakReferenceTest3 extends WeakReference<Car> {


    public WeakReferenceTest3(Car referent) {
        super(referent);
    }

    public static void main(String[] args) {

        WeakReferenceTest3 wenchao = new WeakReferenceTest3(new Car(100, "wenchao"));
        int i=0;
        while(true){
//            System.out.println(car);  // 如果这里打印的话将不会自动回收
            if(wenchao.get()!=null){

                i++;
                System.out.println("Object is alive for "+i+" loops - "+wenchao);
            }else{
                System.out.println("Object has been collected.");
                break;
            }
        }
}
}
