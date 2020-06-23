package TCPUDP.TCP文件上传案例;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 文件上传到客户端
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("c:\\1.jpg");
        Socket socket=new Socket("127.0.0.1",7777);
        OutputStream os = socket.getOutputStream();
        byte[] bytes=new byte[1024];
        int len =0;
        while((len=fis.read(bytes))!=-1){
            os.write(bytes,0,len);//把读取到的文件上传到服务器,-1是读取不到的
        }

        socket.shutdownOutput();//写一个结束标记

        InputStream is = socket.getInputStream();
        while((len=is.read(bytes))!=-1){//读取服务器端响应回的数据，等不到就会陷入阻塞状态
            System.out.println(new String(bytes,0,len));
        }

        fis.close();
        socket.close();

    }
}
