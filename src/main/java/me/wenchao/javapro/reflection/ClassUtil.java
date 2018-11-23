package me.wenchao.javapro.reflection;

import java.lang.reflect.*;
import java.util.List;

/**
 * @Author wenchaofu
 * @DATE 17:25 2018/4/30
 * @DESC
 */
public class ClassUtil {
    public static void printObjectMessage(Object obj){
        Class<?> c = obj.getClass();
        String classNameStr = c.getName();
        System.out.println("类的名称是" + classNameStr);

        /**
         * Method 方法对象
         * getMethods() 获取public方法，包括父类继承而来的 -----> 对应 getFileds
         * getDeclaredMethods() 获取所有方法   -----> 对应 getDeclareFileds
         */
        Method[] declaredMethods = c.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            //得到方法返回值类型的类类型
            Class mc = declaredMethod.getReturnType();
            System.out.println("得到方法的返回值类型: " + mc.getName());
            System.out.print("得到方法的签名是 --" + declaredMethod.getName());
            // 获取参数类型 --> 得到参数列表类型的类类型
            System.out.print("(");
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.print(parameterType.getName() + ",");
            }
            System.out.println(")");

            System.out.println("===========");
            Type[] parameters = declaredMethod.getGenericParameterTypes();

            for (Type parameter : parameters) {
                System.out.println(((ParameterizedType) parameter).getTypeName());
            }
        }



        // 获取构造函数信息
        //构造函数也是对象
        //c.getConstructors() 获取public的构造函数
        Constructor<?>[] declaredConstructors = c.getDeclaredConstructors();

    }
}
