package StringBuilder;

/**
 * 1.String类的字符串是常量，不能改变，底层是一个final修饰的byte[],例如String s="a"+"b"+"c";过程中会产生"ab","abc"等五个字符串，效率低
 * 2.StringBuilder类是一个字符串缓冲区，底层是一个没有被final修饰的byte[]，例如String s="a"+"b"+"c"只会产生一个字符串，容量不够还会扩容
 * 3.append(String str) 为StringBuilder对象添加字符串，地址值不变,reverse() 对StringBuilder对象内容进行反转
 * 4.StringBuilder-->String:使用StringBuilder的toString方法；String-->StringBuilder:使用StringBuilder的构造方法
 * 5.String 是只读字符串，String 对象内容是不能被改变的;StringBuffer 和 StringBuilder 的字符串对象可以对字符串内容进行修改，在修改后的内存地址不会发生改变;
 * StringBuilder 线程不安全；StringBuffer 线程安全
 */
public class Demo01stringBuilder {
    public static void main(String[] args){
        StringBuilder sb=new StringBuilder();
        System.out.println("bu1:"+sb);
        StringBuilder sb2=new StringBuilder("abc");
        System.out.println("bu2:"+sb2);
        sb2.append("edf");
        System.out.println("bu3:"+sb2);
        sb2.append("abc").append(1).append(true).append(8.8).append("中");//链式编程
        System.out.println("bu4:"+sb2);
        System.out.println("======================");

        String str="abc";
        StringBuilder sb3=new StringBuilder(str);
        String str1=sb3.toString();
    }

}
