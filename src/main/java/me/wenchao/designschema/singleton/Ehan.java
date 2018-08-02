package me.wenchao.designschema.singleton;

import me.wenchao.annotation.ThreadSafe;

/**
 * @Author wenchaofu
 * @DATE 14:51 2018/6/5
 * @DESC
 */

@ThreadSafe
public class Ehan {
    private Ehan() {
    }
    private  static Ehan ehan = new Ehan();
    public static  Ehan getInstance(){
        return ehan;
    }

}
