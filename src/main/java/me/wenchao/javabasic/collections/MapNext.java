package me.wenchao.javabasic.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wenchaofu
 * @DATE 10:17 2018/7/10
 * @DESC
 */
public class MapNext {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
    }
}

class MA<T> {
    /*
    error
    private T t = new T();
    private T[] tArray = new T[5];
*/
    private List<T> list = new ArrayList<>();

    protected Number print(String... str) {
        List<? extends Number> list = new ArrayList<>(); // 这样写增加不了元素
        List<String> stringList = new ArrayList<>();

        return 0;
    }
}

class MB extends MA {
    @Override
    public Integer print(String... str) {  // 子类比父类窄，协变，override
        return 0;

    }
}
