package me.wenchao.designschema.singleton;

import me.wenchao.annotation.NotThreadSafe;

/**
 * @Author wenchaofu
 * @DATE 14:53 2018/6/5
 * @DESC 单例的实例在第一次使用的时候创建，在多线程环境下可能会出现问题（实例化两次）
 */
@NotThreadSafe
public class Lhan {
    private Lhan() {
    }

    private static volatile Lhan lhan = null;

    public static  Lhan getInstance() {
        if (lhan == null) {
            lhan = new Lhan();
        }
        return lhan;
    }
}
