package OperatingSystem;

import java.io.*;
import java.util.Arrays;

/**字符流
 * 1.输入流（input）:把硬盘中的数据读取到内存中; 输出流（output）：把内存中的数据写入到硬盘中保存。
*  2.顶层字节流：InputStream,OutputStream; 字符流：Reader,Writer;(任意文件都是字节流)
 * 3.写入数据的原理：java程序-->JVM-->OS(操作系统)-->OS调用写数据的方法-->把数据写入文件中
 * 4.如果写的第一个字节为负数，那第一个字街与第二个字节会组成一个中文显示; 字符串.getBytes()可以得到相应的字节数组
 * 5.new FileOutputStream("day10_File\\b.txt",true);//追加写入
 * 6.FileInputStream: read(byte[] bytes):一次读取多个字节到bytes数组中，new String(byte[] bytes):将字节数组的内容转化为字符串
 */
public class Demo01InOutPutStream {
    public static void main(String[] args) throws IOException {
        //File file=new File("day10_File\\b.txt");
        //file.delete();
        //byte[] bytes={-65,66,-67,68,69};
        //fileOutputStream();
        //fileInputStream();
        //filePutStream();
        fileBufferedStream();
    }

    public static void fileOutputStream() throws IOException{
        byte[] bytes="你好".getBytes();
        System.out.println(Arrays.toString(bytes));
        FileOutputStream fos=new FileOutputStream("day10_File\\b.txt",true);//追加写入
        fos.write(bytes);
        fos.write("\r\n".getBytes());//换行
        fos.close();
    }

    public static void fileInputStream() throws IOException{
        FileInputStream fis=new FileInputStream("day10_File\\b.txt");
        byte[] bytes=new byte[1024];
        int len=0;
        while ((len=fis.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        fis.close();
    }
    //文件的复制
    public static void filePutStream() throws IOException{
        long s=System.currentTimeMillis();
        FileInputStream fis=new FileInputStream("c:\\123.jpg");
        FileOutputStream fos=new FileOutputStream("d:\\123.jpg");
        int len=0;
        while((len=fis.read())!=-1){
            fos.write(len);
        }

        //优化，一次读取多个字节
        /*byte[] bytes=new byte[1024];
        int len=0;
        while ((len=fis.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }*/
        fos.close();
        fis.close();
        long e=System.currentTimeMillis();
        System.out.println("复制文件共耗时"+(e-s)+"毫秒");//5083
    }

    //使用缓冲区进行文件的复制
    public static void fileBufferedStream() throws IOException{
        long s=System.currentTimeMillis();
        FileInputStream fis=new FileInputStream("c:\\123.jpg");
        BufferedInputStream bis=new BufferedInputStream(fis);
        FileOutputStream fos=new FileOutputStream("d:\\123.jpg");
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        int len=0;
        while((len=bis.read())!=-1){
            bos.write(len);
        }

        //优化，一次读取多个字节
        /*byte[] bytes=new byte[1024];
        int len=0;
        while ((len=fis.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }*/
        fos.close();
        fis.close();
        long e=System.currentTimeMillis();
        System.out.println("复制文件共耗时"+(e-s)+"毫秒");//203
    }
}
