package me.wenchao.javapro.algorithm.tree.BST;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author wenchaofu
 * @DATE 17:09 2018/8/5
 * @DESC
 */
public class FileOps {

    private static Pattern pattern = Pattern.compile("\\b\\w+\\b");

    public static List<String> getFileWordsList(String fileName) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        List<String> list = new ArrayList<>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String group = matcher.group();
                list.add(group.toLowerCase());

            }
        }
        return list;
    }

    public static void main(String[] args) throws Exception{
        List<String> fileWordsList = getFileWordsList("G:\\demo\\test.txt");

    }
}
