package Super;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;

/**
 * 1.super可以调用父类的非 private 成员变量和方法
 * 2.super(); 可以调用父类的构造方法，只限构造方法中使用，且必须是第一条语句
 * 3.如果子类的构造方法中没有通过super显式调用父类的有参构造方法，也没有通过this显式调用自身的其他构造方法，
 * 则系统会默认先调用父类的无参构造方法。这种情况下，写不写 super(); 语句，效果是一样的
 * 4.创建对象时构造器的调用顺序：
 *      递归初始化父类静态成员和静态代码块，上层优先
 *      初始化本类静态成员和静态代码块
 *      递归父类构造器，上层优先
 *      调用自身构造器
 */
public class Demo01Super {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str="爱变成";
        String str1=new String(str.getBytes("GB2312"),"GBK");
        System.out.println(str1);
        System.out.println(Calendar.getInstance());
        System.out.println(Calendar.getInstance().get(Calendar.YEAR));
    }
}
