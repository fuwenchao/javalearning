package me.wenchao.javapro.guava;

import com.google.common.base.Optional;


/**
 * @Author wenchaofu
 * @DATE 14:22 2018/5/2
 * @DESC
 */

public class Optionals {

    public static void main(String args[]) {
        Optionals guavaTester = new Optionals();

        Integer value1 = null;
        Integer value2 = new Integer(10);
        //Optional.fromNullable - allows passed parameter to be null.
        Optional<Integer> a = Optional.fromNullable(value1);
        //Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value2);

        System.out.println(guavaTester.sum(a, b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        //Optional.isPresent - checks the value is present or not
        System.out.println("First parameter is present: " + a.isPresent());

        System.out.println("Second parameter is present: " + b.isPresent());

        //Optional.or - returns the value if present otherwise returns
        //the default value passed.
        Integer value1 = a.or(new Integer(0));


        //Optional.get - gets the value, value should be present
        Integer value2 = b.get();

        Integer or = b.or(new Integer(18));
        return value1 + value2;
    }
}
