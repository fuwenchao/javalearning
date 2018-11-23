package me.wenchao.javabasic.basic;

import java.io.File;
import java.io.IOException;

/**
 * @Author wenchaofu
 * @DATE 15:43 2018/11/2
 * @DESC
 */
public class CreateFile {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\abc\\xx.ok"; // abc 不存在时不能创建文件

        File file = new File(filePath);

        if (!file.exists()) {
            file.createNewFile();

        }

    }
}
