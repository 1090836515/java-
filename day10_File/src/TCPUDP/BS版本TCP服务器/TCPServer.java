package TCPUDP.BS版本TCP服务器;



import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *获取不了图片，每获取一次图片需要单独开启一个线程
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(8080);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        /*byte[] bytes=new byte[1024];
        int len=0;
        while((len=is.read(bytes))!=-1){
            System.out.println(new String(bytes, 0, len));
        }*/

        //把is网络字节输入流对象,转换为字符缓冲输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        //把客户端请求信息的第一行读取出来 GET /11_Net/web/index.html HTTP/1.1
        String line = br.readLine();
        //把读取的信息进行切割,只要中间部分 /11_Net/web/index.html
        String[] arr = line.split(" ");
        //把路径前边的/去掉,进行截取 11_Net/web/index.html
        String htmlpath = arr[1].substring(1);

        //创建一个本地字节输入流,构造方法中绑定要读取的html路径
        FileInputStream fis = new FileInputStream(htmlpath);
        //使用Socket中的方法getOutputStream获取网络字节输出流OutputStream对象
        OutputStream os = socket.getOutputStream();

        // 写入HTTP协议响应头,固定写法
        os.write("HTTP/1.1 200 OK\r\n".getBytes());
        os.write("Content-Type:text/html\r\n".getBytes());
        // 必须要写入空行,否则浏览器不解析
        os.write("\r\n".getBytes());

        //一读一写复制文件,把服务读取的html文件回写到客户端
        int len = 0;
        byte[] bytes = new byte[1024];
        while((len = fis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }

        //释放资源
        fis.close();
        socket.close();
        server.close();
    }
}
