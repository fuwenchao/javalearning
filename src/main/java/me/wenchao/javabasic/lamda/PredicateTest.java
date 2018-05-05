package javabasic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {

        List<String> listStr = Arrays.asList("java","c++","c#","python");
//        filter(listStr,(str)->str.startWith("a"));

        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter2(languages, (str)->((String)str).startsWith("J"));
    }
    private static void filter(List<String> names,Predicate consumer){

        for (String name : names) {
            if (consumer.test(name)) {
                System.out.println(name);

            }
        }
    }

    private static void filter2(List<String> names , Predicate comsumer){
        names.stream().filter(name -> comsumer.test(name)).forEach(str-> System.out.println("this is str in fileter2 " + str));

    }
}
