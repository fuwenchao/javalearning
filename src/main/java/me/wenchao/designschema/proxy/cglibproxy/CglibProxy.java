package me.wenchao.designschema.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author wenchaofu
 * @DATE 10:14 2018/5/2
 * @DESC
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    //创建代理类
    public Object getProxy(Class clz){
        enhancer.setSuperclass(clz);
        enhancer.setCallback(this);
        return enhancer.create();

    }


    /**
     * 拦截所有目标类方法的调用
     * @param o 目标类的实例
     * @param method 目标类的方法
     * @param args 方法的参数
     * @param methodProxy 代理类的实例
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("begin to logging ...");
        // 代理类调用父类的方法
        methodProxy.invokeSuper(o,args);
        System.out.println("end logging.....");
        return null;
    }
}
