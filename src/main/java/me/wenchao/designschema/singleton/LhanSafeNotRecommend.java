package me.wenchao.designschema.singleton;

import me.wenchao.annotation.ThreadSafe;

/**
 * @Author wenchaofu
 * @DATE 14:53 2018/6/5
 * @DESC
 */
@ThreadSafe
public class LhanSafeNotRecommend {
    private LhanSafeNotRecommend() {
    }
/*

    instance = new LhanSafeRecommend 将会执行以下三步
    1. memory = allocation() 分配内存空间;
    2. createInstance 初始化实例对象;
    3. instance  = memory 设置instance 指向刚分配的内存
    JVM 和 cpu 优化，发生了指令重排序，导致 2 和 3 发生了倒转
*/

    // volatile + 双重检测机制 --》 禁止指令重排
    private volatile static LhanSafeNotRecommend lhan = null;


    public static LhanSafeNotRecommend getInstance() {
        if (lhan == null) {  //双重检测机制
            synchronized (LhanSafeNotRecommend.class) {  //同步锁
                if (lhan == null) {
                    lhan = new LhanSafeNotRecommend();
                }
            }

        }
        return lhan;
    }
}
