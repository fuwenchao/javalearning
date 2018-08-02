package me.wenchao.javapro.comm.bio.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Author wenchaofu
 * @DATE 11:48 2018/5/1
 * @DESC
 */
public class Client {
    public static void main(String[] args) {
        String msg = "client data";
        try {
            Socket socket = new Socket("localhost", 8080);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //发送数据
            printWriter.println(msg);
            printWriter.flush();
            //接受数据
            String line = bufferedReader.readLine();
            System.out.println("received from server ---> " + line);
            printWriter.close();
            bufferedReader.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
