package me.wenchao.javapro.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.PreparedStatement;

/**
 * @Author wenchaofu
 * @DATE 18:12 2018/5/9
 * @DESC
 */
public class Dao<T> {
    private static PreparedStatement st = null;
    public Class clazz;

    public Dao() {
        Type superclass = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = null;
        if (superclass instanceof ParameterizedType) {
            parameterizedType = (ParameterizedType) superclass;
            Type[] typeArray = parameterizedType.getActualTypeArguments();
            if (typeArray != null && typeArray.length > 0) {
                clazz = (Class) typeArray[0];

            }
        }
    }
}