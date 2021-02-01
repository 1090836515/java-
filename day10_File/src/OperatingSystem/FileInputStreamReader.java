package OperatingSystem;

import java.io.*;

/**
 * 1.FileReader，FileOutputStream只能读取默认编码（UTF-8）,底层是通过FileInputStream读取再进行转换,ASIN是GBK编码; GBK使用两个字节存取一个中文，UTF-8使用三个字节存取一个中文
 * 2.转换流：OutPutStreamWriter,InputStreamReader:可以指定编码表
 */
public class FileInputStreamReader {
    public static void main(String[] args) throws IOException {
        //outputStreamWriter();
        inputStreamReader();
    }

    public static void outputStreamWriter() throws IOException {
        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("day10_File\\新建文本文档.txt"),"gbk");//不区分大小写
        osw.write("你好");
        osw.flush();
        osw.close();
    }

    public static void inputStreamReader() throws IOException {
        InputStreamReader isr=new InputStreamReader(new FileInputStream("day10_File\\新建文本文档.txt"),"gbk");
        int len=0;
        char[] c=new char[1024];
        while((len=isr.read(c))!=-1){
            System.out.println(new String(c));
        }
        isr.close();
    }
}
