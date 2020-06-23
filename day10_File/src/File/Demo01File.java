package File;

import java.io.File;

/**
 * 1.File类是一个与系统无关的类，任何的操作系统都能使用这个类的方法
 * 2.路径分隔符：windows:分号;  linux: 冒号：   文件名称分隔符：windows:反斜杠\  linux:正斜杠/
 * 3.getAbsolutPath()：返回绝对路径; getPath()：返回路径（重写的toString里使用这个方法）;length()：返回文件的字节大小
 * exist():判断文件路径是否存在; isFile(),isDirectory:判断路径文件是文件还是文件夹; creatNewFile(): 创建文件
 * mkdir():只能创建单级空文件夹; mkdirs():可以创建多级文件夹; delete():可以删除文件或文件夹
 * list()：返回一个String数组，保存File目录下所有的文件和文件夹(包括隐藏文件); listFiles():返回一个File数组，保存File目录下所有的文件和文件夹(包括隐藏文件)
 */
public class Demo01File {
    public static void main(String[] args){
        System.out.println(File.pathSeparator);//路径分隔符：windows:分号;  linux: 冒号：
        System.out.println(File.separator);//文件名称分隔符：windows:反斜杠\  linux:正斜杠/
        File parent=new File("c:\\");
        show01(parent,"a.txt");
    }

    private static void show01(File parent,String child){
        File file=new File(parent,child);//File的构造方法
        System.out.println(file);
        System.out.println(file.length());
    }
}
