package me.wenchao.javapro.algorithm.tree.BST;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author wenchaofu
 * @DATE 17:29 2018/8/5
 * @DESC
 */
public class MainApp {
    public static void main(String[] args) throws Exception {
        BST<String, Integer> stringBST = new BST<String, Integer>();
        List<String> fileWordsList = FileOps.getFileWordsList("G:\\demo\\bible.txt");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < fileWordsList.size(); i++) {
            String key = fileWordsList.get(i);
            Integer value = stringBST.search(key);
            value = value == null ? 1 : value + 1;
            stringBST.insert(key, value);


        }
        System.out.println("god count " + stringBST.search("god"));

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < fileWordsList.size(); i++) {
            String key = fileWordsList.get(i);
            Integer value = map.get(key);
            value = value == null ? 1 : value + 1;
            map.put(key, value);
        }
        System.out.println("god count " + map.get("god"));
        long endTime2 = System.currentTimeMillis();
        System.out.println(endTime2 - endTime);

    }
}