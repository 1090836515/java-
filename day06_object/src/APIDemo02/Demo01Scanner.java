package APIDemo02;

import java.util.Scanner;

/**1.官方提供的类叫做API
 * 2.java.lang包下的类不需要导包，其他都要
 */
public class Demo01Scanner {
    public static void main(String[] args){
        /**
         * 有两次接收就必须输入两次
         */
        Scanner sc=new Scanner(System.in);//System.in表示键盘输入
        System.out.println("输入的数字是："+sc.nextInt());
        System.out.println("输入的字符串是:"+sc.next());//输出键盘输入的字符串
        /**
         * 匿名对象，只能使用唯一的一次
         */
        int num=new Scanner(System.in).nextInt();
        methodParam(new Scanner(System.in));

    }

    public static void methodParam(Scanner sc){

    }
}
