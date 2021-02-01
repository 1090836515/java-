package OperatingSystem;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * 1.为其他的输出流添加了功能，使它们能够方便的打印各种数据指表示形式
 * 2.只负责输出，不负责数据的读取; 永远不会抛出IOException
 * 3.PrintStream extends OutoutStream
 * 4.如果使用父类的write()方法输出，则会按照编码表输出;  若使用自己的print/println方法输出，则会原样输出
 * 5.System.setOut(PrintStream ps)方法可以改变输出语句(System.out.print)的打印目的地
 */
public class Demo01PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        printStream01();
    }

    public static void printStream01() throws FileNotFoundException {
        PrintStream ps=new PrintStream("day10_File\\print.txt");
        ps.write(97);
        ps.println(97);
        ps.println('a');
        ps.println("helloworld");
        ps.close();
    }
}
