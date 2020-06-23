package TCPUDP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1.java.net.ServerSocket:此类实现服务器套接字; accept()：获取到请求的客户端对象
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(8888);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        byte[] bytes=new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));

        OutputStream os = socket.getOutputStream();
        os.write("收到谢谢".getBytes());
        socket.close();
        server.close();


    }
}
