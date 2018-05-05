package me.wenchao.javapro.javanio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * @Author wenchaofu
 * @DATE 23:18 2018/4/28
 * @DESC
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        InetSocketAddress endpoint = new InetSocketAddress(8080);
        System.out.println("开始监听端口8080");
        ssc.socket().bind(endpoint);
        ssc.configureBlocking(false);

        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        Handler handler = new Handler(1024);
        while (true) {
            //select 返回有多少个通道就绪了，timeout为阻塞时间
            if (selector.select(2000)==0) {
                System.out.println("Listening.....");
                continue;
            }
            System.out.println("开始处理请求....");

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                //SelectionKey 代表注册到该selector的通道
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    handler.handlerAccept(key);

                }
                if (key.isReadable()) {
                    handler.handlerRead(key);
                }
                iterator.remove();
            }
        }



    }
    private static class Handler{
        private int bufferSize = 1024;
        private String localCharset = "UTF-8";
        public Handler(){

        }
        public Handler(int bufferSize){
            this(bufferSize,null);

        }
        public Handler(String localCharset){
            this(-1,localCharset);
        }
        public Handler(int bufferSize,String localCharset){
            if (bufferSize>0) {
                this.bufferSize=bufferSize;
            }
            if (localCharset != null) {
                this.localCharset = localCharset;
            }

        }

        public void handlerAccept(SelectionKey key) throws IOException {
            SocketChannel socketChannel = ((ServerSocketChannel) key.channel()).accept();
            socketChannel.configureBlocking(false);
            //将通道注册到selector
            socketChannel.register(key.selector(),SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
        }

        public void handlerRead(SelectionKey key) throws IOException {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
            byteBuffer.clear();
            if (socketChannel.read(byteBuffer)==-1) {
                socketChannel.close();
            } else{
                //将buffer转换为读状态
                byteBuffer.flip();
                String receivedString = Charset.forName(localCharset).newDecoder().decode(byteBuffer).toString();
                System.out.println("接收到的字符串是  " + receivedString);

                //返回数据给客户端

                String sendString = "server send data is-->"+receivedString;

                byteBuffer = ByteBuffer.wrap(sendString.getBytes(localCharset));
                socketChannel.write(byteBuffer);
                socketChannel.close();
            }


        }

    }
}
