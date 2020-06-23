package TCPUDP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 1.java.net.Socket:此类实现客户端套接字; 套接字：包含了IP地址和端口号的网络单位
 * 2.Socket(String host,int port): host:服务器主机名/服务器的IP地址
 * 3.当创建Socket对象时，就会请求服务器与服务器建立经过三次握手的连接通路，这时如果服务器没有启动，那么就会抛出异常；如果服务器已经启动，
 * 那么就可以进行交互了
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",8888);
        OutputStream os = socket.getOutputStream();
        os.write("你好服务器".getBytes());

        InputStream is = socket.getInputStream();
        byte[] bytes=new byte[1024];
        int len=is.read(bytes);
        System.out.println(new String(bytes,0,len));
        os.close();

    }

}
