package me.wenchao.javabasic.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author wenchaofu
 * @DATE 11:42 2018/5/21
 * @DESC
 */
public class MapTest {
    static HashMap<String,Integer> map = new HashMap<String,Integer>();
    static TreeMap<String, String> treeMap = new TreeMap<>();

    static Map<String, String> hashTable = new Hashtable<>();

    private static <K,V>  void  printMap(HashMap<K,V> hashMap){
        for (Map.Entry<K, V> kvEntry : hashMap.entrySet()) {
            System.out.println(kvEntry.getKey() + "---->>>" + kvEntry.getValue());
        }
    }

    public static void main(String[] args) {
        map.put("123",1);
        printMap(map);
        map.put("123",2);
        System.out.println("------after------");
        printMap(map);
        treeMap.put("str", null);

        byte a = 1;
        byte b = 2;
        a += b;

        a = (byte)(a + b);

        hashTable.put("", "");
    }
}
