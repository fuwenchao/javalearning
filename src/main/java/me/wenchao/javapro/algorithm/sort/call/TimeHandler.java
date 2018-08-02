package me.wenchao.javapro.algorithm.sort.call;

import me.wenchao.tool.ArrayUtils;
import me.wenchao.tool.Monitor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author wenchaofu
 * @DATE 16:29 2018/7/30
 * @DESC
 */
public class TimeHandler implements InvocationHandler {



    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        int arr[] = ArrayUtils.generateRandomArray(100, 0, 100);

        Monitor.startTime();
        method.invoke(target,args);
        Monitor.finish(target.getClass().getSimpleName(),method.getName());
        return null;
    }
}
