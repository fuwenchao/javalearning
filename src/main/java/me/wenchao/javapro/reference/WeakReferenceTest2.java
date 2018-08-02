package me.wenchao.javapro.reference;

/**
 * @Author wenchaofu
 * @DATE 18:14 2018/5/15
 * @DESC
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.lang.ref.WeakReference;

public class WeakReferenceTest2 {


    public static void main(String[] args) {

        Car car = new Car(22000,"silver");
        WeakReference<Car> weakCar = new WeakReference<Car>(car);
        int i=0;
        while(true){
//            System.out.println(car);  // 如果这里打印的话将不会自动回收
            if(weakCar.get()!=null){

                i++;
                System.out.println("Object is alive for "+i+" loops - "+weakCar);
            }else{
                System.out.println("Object has been collected.");
                break;
            }
        }
}
}

@Data
@ToString
@AllArgsConstructor
class Car {
    private  int carNo;
    private String carName;
}