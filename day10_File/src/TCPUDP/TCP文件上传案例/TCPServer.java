package TCPUDP.TCP文件上传案例;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * 读取客户端上传的文件，保存到服务器的硬盘，给客户端回写 “上传成功”
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(7777);

        while(true) {//通过死循环保证服务器不断监听
            Socket socket = server.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {//run方法没有抛出异常，所以里面的异常只能通过try,catch处理
                    try{
                        InputStream is = socket.getInputStream();
                        File file = new File("d:\\upload");
                        if (!file.exists()) {//判断文件路径是否存在，不存在就创建一个
                            file.mkdirs();
                        }
                        String fileName = "itcast" + System.currentTimeMillis() + new Random().nextInt(999999) + ".jpg";//自定义命名规则，防止重复
                        FileOutputStream fos = new FileOutputStream(file + "\\" + fileName);
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        while ((len = is.read(bytes)) != -1) {//服务器端读取客户端传的文件并将文件保存在本地硬盘
                            fos.write(bytes, 0, len);
                        }
                        socket.getOutputStream().write("上传成功".getBytes());

                        fos.close();
                        socket.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
