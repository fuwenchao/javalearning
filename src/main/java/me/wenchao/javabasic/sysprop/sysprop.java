package me.wenchao.javabasic.sysprop;

import java.io.File;
import java.io.IOException;

/**
 * @Author wenchaofu
 * @DATE 15:24 2018/4/29
 * @DESC
 */
public class sysprop {
    static {
        System.out.println("this is a static code");
    }
    public static void main(String[] args) throws IOException {
//        System.getProperties().forEach((k,v) -> System.out.println(k + " ---> " + v));
//        System.getProperties().list(System.out);
        File f = new File("file.rst");
        if (f.exists()) {
            System.out.println("file exists");
        }
        System.out.println(f.getAbsoluteFile());
        System.out.println(f.getCanonicalFile());
        System.out.println("path is " + f.getCanonicalPath());


    }
}
