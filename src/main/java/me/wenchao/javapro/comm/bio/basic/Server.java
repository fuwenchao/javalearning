package me.wenchao.javapro.comm.bio.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.channels.ServerSocketChannel;

/**
 * @Author wenchaofu
 * @DATE 11:38 2018/5/1
 * @DESC
 */
public class Server {
    private static final String port = "8080";
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(port));
            System.out.println("开始接受数据........");
            Socket socket = serverSocket.accept();
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = is.readLine();
            System.out.println("received from client --> " + line);

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println("received data ---> " + line);
            printWriter.flush();

            printWriter.close();
            is.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
