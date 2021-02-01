package OperatingSystem;

import java.io.*;

/**
 * 写入数据的原理：java程序-->JVM-->OS(操作系统)-->OS调用写数据的方法-->把数据写入文件中
 * 1.在读取数据的过程中增加一个数组缓冲区，只要关闭缓冲区就会自动关闭流
 * 2.BufferedWriter的newLine()：写入一个换行符;  BufferedReader的readLine()：读取一行数据，换行符终止(不读)
 *
 */
public class BufferedInOutputStream {
    public static void main(String[] args) throws IOException {
        bufferedOutputStream();
    }

    public static void bufferedOutputStream() throws IOException {
        FileOutputStream fos=new FileOutputStream("day10_File\\d.txt");
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        bos.write("我把数据写入到内部缓冲区中".getBytes());
        bos.flush();
        bos.close();
    }

    public static void bufferedWriter() throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("day10_File\\d.txt"));


        br.close();
    }
}
