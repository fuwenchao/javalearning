package me.wenchao.designschema.singleton;

import me.wenchao.annotation.NotRecommend;
import me.wenchao.annotation.ThreadSafe;

/**
 * @Author wenchaofu
 * @DATE 14:53 2018/6/5
 * @DESC 单例的实例在第一次使用的时候创建，在多线程环境下可能会出现问题（实例化两次）
 */
@ThreadSafe
@NotRecommend  //synchronized导致性能开销
public class LhanSafe {
    private LhanSafe() {
    }

    private static volatile LhanSafe lhan = null;

    public static  synchronized LhanSafe getInstance() {
        if (lhan == null) {
            lhan = new LhanSafe();
        }
        return lhan;
    }
}
