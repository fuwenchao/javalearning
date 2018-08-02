package me.wenchao.javabasic.matcher;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author wenchaofu
 * @DATE 17:50 2018/6/29
 * @DESC
 */
public class WordMatch {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int wordCount = 0;
            String str = input.nextLine();
            String regex = "\\btest\\b";
            Pattern compile = Pattern.compile(regex);
            Matcher matcher = compile.matcher(str);
            while (matcher.find()) {
                wordCount++;
                System.out.println(matcher.toString());
            }

            System.out.println(wordCount + " is count");
        }
    }
}
