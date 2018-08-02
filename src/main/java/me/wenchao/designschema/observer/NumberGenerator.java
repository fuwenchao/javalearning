package me.wenchao.designschema.observer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author wenchaofu
 * @DATE 11:12 2018/6/11
 * @DESC
 */
public abstract class NumberGenerator {


    ArrayList<IObserver> obList = new ArrayList<>();

    //注册OB
    public void register(IObserver iObserver){
        obList.add(iObserver);
    }

    //删除OB
    public void remove(IObserver iObserver) {
        obList.remove(iObserver);
    }

    // 通知OB
    public void notifyAllOB() {
        Iterator<IObserver> iterator = obList.iterator();
        while (iterator.hasNext()) {
            IObserver ob = iterator.next();
            ob.update(this);

        }
    }

    public abstract int getNumber();
    public abstract void executor();


}
