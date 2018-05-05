package me.wenchao.javabasic.fileutils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @Author wenchaofu
 * @DATE 11:09 2018/5/2
 * @DESC
 */
public class CommonUtils {
    public static void main(String[] args) throws IOException {
        File file = new File(System.getProperty("user.dir")+"/test/java/test.java");
        String str = "this is a test java";

        FileUtils.writeStringToFile(file,str);

    }
}
