package me.wenchao.javapro.comm.bio.multithreadbio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @Author wenchaofu
 * @DATE 16:37 2018/7/20
 * @DESC
 * 这里我们针对了SocketServer增加了阻塞等待时间，实际上只实现了非阻塞IO模型中的第一步：
 * 监听连接状态的非阻塞。通过运行代码，我们可以发现read()方法还是被阻塞的，
 * 说明socket套接字等待数据读取的过程，还是阻塞方式。
 */
@Slf4j
public class ServerUnblock {

    private static Object xWait = new Object();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8889);
        server.setSoTimeout(100);

        try {
            while (true) {


                log.info("server started ...");
                Socket socket = null;
                try {
                    socket = server.accept();
                } catch (SocketTimeoutException e) {
                    //===========================================================
                    //      执行到这里，说明本次accept没有接收到任何数据报文
                    //      主线程在这里就可以做一些事情，记为X
                    //===========================================================
                    synchronized (xWait) {
                        log.info("这次没有从底层获取到任何TCP连接，等待10毫秒，模拟事件X的处理");
                        xWait.wait(1000);
                    }
                    continue;
                }
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
