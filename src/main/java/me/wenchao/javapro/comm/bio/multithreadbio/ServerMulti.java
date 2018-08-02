package me.wenchao.javapro.comm.bio.multithreadbio;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author wenchaofu
 * @DATE 17:23 2018/7/20
 * @DESC
 */

@Slf4j
public class ServerMulti {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8889);
        while (true) {
            //当然业务处理过程可以交给一个线程（这里可以使用线程池）,并且线程的创建是很耗资源的。
            //最终改变不了.accept()只能一个一个接受socket的情况,并且被阻塞的情况
            Socket socket = server.accept();
            new Thread(new ServerThread(socket)).start();

        }


    }
}

@Slf4j
class ServerThread implements Runnable {

    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 接受信息
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}