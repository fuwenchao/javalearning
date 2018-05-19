package me.wenchao.javabasic.strings;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.apache.commons.io.Charsets;

import java.nio.charset.Charset;

/**
 * @Author wenchaofu
 * @DATE 17:53 2018/5/8
 * @DESC
 */
public class StringTest {
    public static void main(String[] args) {
        Joiner joiner = Joiner.on(",").skipNulls();
        String str = joiner.join("a,b","c","d");
        System.out.println(str);

        Iterable<String> split = Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("foo,bar,,   qux");

        split.forEach(System.out::println);

    }

}
