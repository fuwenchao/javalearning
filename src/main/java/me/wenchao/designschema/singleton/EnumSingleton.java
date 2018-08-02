package me.wenchao.designschema.singleton;

import lombok.extern.slf4j.Slf4j;
import me.wenchao.annotation.Recommend;
import me.wenchao.annotation.ThreadSafe;

/**
 * @Author wenchaofu
 * @DATE 15:15 2018/6/13
 * @DESC
 */


/**
 * 枚举模式，最安全
 */
@ThreadSafe
@Recommend
public class EnumSingleton {
    private EnumSingleton() {

    }

    public static EnumSingleton getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;
        private EnumSingleton singleton;
        private Singleton(){
            singleton = new EnumSingleton();
        }

        public EnumSingleton getInstance() {
            return singleton;
        }
    }

}
