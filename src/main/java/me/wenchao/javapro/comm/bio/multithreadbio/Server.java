package me.wenchao.javapro.comm.bio.multithreadbio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author wenchaofu
 * @DATE 16:37 2018/7/20
 * @DESC
 */
@Slf4j
public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8889);

        try {
            while (true) {


                log.info("server started ...");
                Socket socket = server.accept();
                // 接受信息

                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                Integer port = socket.getPort();
                int maxLen = 1024;
                byte[] contextBytes = new byte[maxLen];

                // 这里也会阻塞，直到数据准备好
                int read = in.read(contextBytes, 0, maxLen);
                String message = new String(contextBytes, 0, maxLen);

                log.info("server receive message : " + message);

                out.write("回发响应消息".getBytes());


                in.close();
                out.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            server.close();
        }


    }

}
