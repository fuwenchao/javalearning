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
 * 然并卵，这种处理方式实际上并没有解决accept方法、read方法阻塞的根本问题。
 * 根据上文的叙述，accept方法、read方法阻塞的根本问题是底层接受数据报文时的“同步IO”工作方式。
 * 这两次改进过程，只是解决了IO操作的两步中的第一步：将程序层面的阻塞方式变成了非阻塞方式。
 */
@Slf4j
public class ServerUnblockReadUnblock {

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
                        log.info("这次没有从底层获取到任何的TCP连接，等待10毫秒，模拟事件X的处理");
                        xWait.wait(1000);
                    }
                    continue;
                }
                // 接受信息

                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                Integer port = socket.getPort();
                int maxLen = 1024;
                int readLen;
                byte[] contextBytes = new byte[maxLen];
                StringBuilder message = new StringBuilder();
                socket.setSoTimeout(10);
                int count = 0;
                // 这里也会阻塞，直到数据准备好
                BIORead:while (true) {
                    try {
                        while ((readLen = in.read(contextBytes, 0, maxLen)) != -1) {
                            message.append(new String(contextBytes, 0, maxLen));
                            // 客户端发来了over
                            if (message.indexOf("over") != -1) {
                                break BIORead;
                            }

                        }

                    } catch (SocketTimeoutException e) {
                        if (count++ > 3) {
                            break BIORead;
                        }
                        log.info("这次没有从底层收到任何的数据报文，等到10毫秒模拟事件退出 --->" + count);
//                        Thread.sleep(100);
                        continue;

                    }
                }

                message.append("----");
                System.out.println(message);

                log.info("serversssss receive message : " + message);

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
