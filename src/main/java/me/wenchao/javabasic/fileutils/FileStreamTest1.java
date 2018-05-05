package me.wenchao.javabasic.fileutils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author wenchaofu
 * @DATE 16:32 2018/5/3
 * @DESC
 */
public class FileStreamTest1 {
    public static void main(String[] args) throws IOException {
     /*   FileInputStream fileInputStream = new FileInputStream("D:\\file.txt");
        int n = fileInputStream.read();
        while(n != -1){
            System.out.println((char)n);
            n = fileInputStream.read();
        }

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\file.txt");
        fileOutputStream.write(Integer.parseInt("1"));
        fileOutputStream.flush();
        fileInputStream.close();
        fileOutputStream.close();*/


        System.out.println("********************");

        FileInputStream fis = new FileInputStream("D:\\file.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        int n = 0;
        char[] cbuf = new char[10];
        while((n=isr.read()) != -1){ // read a single character
            System.out.println((char)n);
        }

        while((n = isr.read(cbuf)) != -1){ // read to cbuf
            String str = new String(cbuf,0,n);
            System.out.println(str);
        }
    }
}
