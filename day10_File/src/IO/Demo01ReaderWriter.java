package IO;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * 1.1个中文：GBK:占用两个字节;UTF-8:占用三个字节.
 * 2.FileReader extends InputStreamReader extends Reader,字节流
 * 3.FileWriter中的write()方法会把数据写入到内存缓冲区，然后使用flush()方法，数据才会从内存缓冲区写入到文件；直接close()会执行flush()方法
 * 4.流中出现了异常就需要使用try{}catch{}处理异常，否则出现异常，流无法关闭
 * 5.java.util.Properties extends Hashtable<K,V> implents Map<K,V>; Properties集合中的key和value默认都是字符串，是唯一的与IO流相结合的集合
 * 6.Properties类：store(new FileWriter("day10_File\\prop.txt"),"");//后面的是注释，不能是中文;
 * load():把硬盘的文件以键值对的方式读取
 */
public class Demo01ReaderWriter {
    public static void main(String[] args) throws IOException {
       //fileReader();
        // fileWriter();
        //properties01();
        //properties02();
        propertiesLoad();
    }

    public static void fileReader() throws IOException {
        FileReader fr=new FileReader("day10_File\\b.txt");
        /*int len=0;
        while ((len=fr.read())!=-1){
            System.out.println((char) len);
        }*/
        char[] cs=new char[1024];
        int len=0;
        while((len=fr.read(cs))!=-1){
            System.out.println(new String(cs,0,len));//将字符数组的内容转化为字符串
        }
        fr.close();
    }

    public static void fileWriter() throws IOException {
        FileWriter fw=new FileWriter("day10_File\\c.txt",true);
        char[] cs={'a','b','c','d','e'};
        //fw.write(cs,0,2);
        fw.write("传智播客\r\n");
        fw.flush();//刷新之后流可以继续使用
        fw.close();
    }

    public static void properties01(){
        Properties prop=new Properties();
        prop.setProperty("赵丽颖","168");
        prop.setProperty("迪丽热巴","165");
        prop.setProperty("杨颖","160");

        //相当于Map里的keySet()方法
        Set<String> set = prop.stringPropertyNames();
        for(String key:set){
            String value=prop.getProperty(key);
            System.out.println(key+":"+value);
        }
    }

    public static void properties02() throws IOException {
        Properties prop=new Properties();
        prop.setProperty("赵丽颖","168");
        prop.setProperty("迪丽热巴","165");
        prop.setProperty("杨颖","160");

        //prop.store(new FileOutputStream("day10_File\\prop.txt"),"");//不能写入中文，会出现乱码
        prop.store(new FileWriter("day10_File\\prop.txt"),"");//后面的是注释，不能是中文
    }

    public static void propertiesLoad() throws IOException {
        Properties prop=new Properties();
        prop.load(new FileReader("day10_File\\prop.txt"));
        Set<String> set = prop.stringPropertyNames();
        for(String key:set){
            String value=prop.getProperty(key);
            System.out.println(key+":"+value);
        }

    }
}
