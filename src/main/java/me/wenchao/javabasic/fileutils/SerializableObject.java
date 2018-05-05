package me.wenchao.javabasic.fileutils;

import java.io.*;

/**
 * @Author wenchaofu
 * @DATE 18:28 2018/5/3
 * @DESC
 */
public class SerializableObject {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(4096);
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(new Object());


        // TODO
        byte[] bytes = baos.toByteArray();

        ObjectInputStream bis = new ObjectInputStream(new ByteArrayInputStream(bytes));
        Object obj = bis.readObject();
        System.out.println(obj);

    }

}
