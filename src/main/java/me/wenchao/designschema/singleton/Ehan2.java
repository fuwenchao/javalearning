package me.wenchao.designschema.singleton;

import me.wenchao.annotation.ThreadSafe;

/**
 * @Author wenchaofu
 * @DATE 14:51 2018/6/5
 * @DESC
 */

@ThreadSafe
public class Ehan2 {
    private Ehan2() {
    }
    private  static Ehan2 ehan = null;

    static{
        ehan = new Ehan2();
    }
    public static Ehan2 getInstance(){
        return ehan;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }

}
