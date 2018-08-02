package me.wenchao.designschema.proxy.givemoney;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author wenchaofu
 * @DATE 15:40 2018/6/4
 * @DESC
 */
public class TimeHandler implements InvocationHandler {
    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MonitorTools.startTime();
        method.invoke(target);
        MonitorTools.finish();
        return null;
    }
}
