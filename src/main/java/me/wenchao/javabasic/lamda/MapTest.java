package javabasic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MapTest {
    public static void main(String[] args) {
        List<String> listStr = Arrays.asList("Java","python","scala","javascript");
        listStr.stream().map(lang -> lang + "'wenchao").forEach(System.out::println);

        List<Integer> prices = Arrays.asList(100,200,250,300);
        Integer sum = prices.stream().map(price -> price + 1000).reduce((a,b)-> a+b).get();
        System.out.println(sum);


        System.out.println(listStr.stream().filter(x -> x.length() > 4).collect(Collectors.toList()));
        System.out.println(listStr.stream().filter(x -> x.length() > 4).collect(Collectors.joining("=====")));
    }
}
