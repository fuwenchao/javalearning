package me.wenchao.designschema.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author wenchaofu
 * @DATE 9:44 2018/5/2
 * @DESC
 */
public class TimeHandler implements InvocationHandler {

    private Object target;


    public TimeHandler(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy 被代理对象
     * @param method 被代理对象的方法
     * @param args 方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始代理....");
        method.invoke(target);
        System.out.println("结束代理....");
        return null;
    }
}
