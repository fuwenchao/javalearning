package me.wenchao.javapro.comm.bio.multithreadbio;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 * @Author wenchaofu
 * @DATE 16:10 2018/7/20
 * @DESC
 */
@AllArgsConstructor
@Slf4j
public class RequestThread implements Runnable {

    private CountDownLatch countDownLatch;
    private Integer index;



    @Override
    public void run() {

        Socket socket = null;
        InputStream clientResponse = null;
        OutputStream clientRequest = null;
        StringBuilder sb = new StringBuilder();


        try{
            socket = new Socket("localhost", 8889);
            clientRequest = socket.getOutputStream();
            clientResponse = socket.getInputStream();

            // 在这里开始等待，然后统一发送请求
            this.countDownLatch.await();

            // 发送请求
            clientRequest.write((" this is " + index + " request").getBytes());
            clientRequest.flush();

            // 在这里等待，知道服务器返回信息

            log.info(" " + index + " request is down");
            int maxLen = 1024;
            byte[] contextBytes = new byte[maxLen];
            int readLen;
            // 程序执行到这里会一直等待服务器返回信息，（注意，前提是int 和 out 都不能close，如果close就收不到返回信息了）
            while ((readLen = clientResponse.read(contextBytes, 0, maxLen)) != -1 ) {
                sb.append(new String(contextBytes,0,maxLen));

            }
//            sb.append("   wenchaofu ");
            log.info("get message from server " + sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (clientRequest != null) {
                    clientRequest.close();
                }
                if (clientResponse != null) {
                    clientResponse.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
