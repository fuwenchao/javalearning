package me.wenchao.javapro.generic;

import me.wenchao.tool.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

import static me.wenchao.tool.ArrayUtils.toArray;

/**
 * @Author wenchaofu
 * @DATE 14:21 2018/7/10
 * @DESC
 */
public class GenericInit<T> {
    /*
    error
    private T t = new T();
    private T[] tArray = new T[5];
*/

    // 声明，但是不初始化，由构造函数初始化
    private T t;
    private T[] tArray;
    private List<T> list = new ArrayList<T>();

    public static void main(String[] args) {
        List<String> list = ArrayUtils.asList();
        list.add("str");
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("+=========+");
        List<String> stringList = ArrayUtils.asList("a", "b", "c");
        for (String s : toArray(stringList,String.class)) {
            System.out.println(s);

        }

    }


}
