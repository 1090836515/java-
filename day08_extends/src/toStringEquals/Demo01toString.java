package toStringEquals;

import java.util.Objects;

/**
 * 1.Collection，String重写了toStirng,equals方法
 * 2.使用工具类Objects的equals方法没有安全问题
 * 3.String类重写了hashCode（）方法
 * 1、==如果作用于基本数据类型，则比较的是值是否相等；
 * 　　　如果作用于引用类型，则比较的是变量所指向的对象的地址
 *
 * 2、对于非String、Date类型equals比较的是引用类型的变量所指向的对象的地址
 * 　　但对于String、Date类型，在其类中重写了equals()，所以比较的是值
 *
 * 3、Object类型相等判断为什么重写equals()和hashcode()？
 * 　　equals()方法是比较两个对象的内存地址是否相等，如果不重写，显然两个对象由于不同存储地址所以是不相等的
 *
 * 4、重写equals()为什么一定要重写hashcode()
 * 　　如果两个对象判断相等只重写了euqals()方法，而没有重写hashcode()方法，虽然p1.equals(p2)结果是true，
 * 但执行p1.hashCode()==p2.hashCode()结果却是false，这与“两个对象相等，其hashcode必然相等”矛盾，所以重写了equals()必然需要重写hashcode()。
 * 　　hashcode()判断是equals()判断的先决条件，所以对象重写了equals()需要重写hashcode()
 *    hashCode 方法的常规协定声明相等对象必须具有相等的哈希码 　
 */
public class Demo01toString {
    public static void main(String[] args){
        String str1=null;
        String str2="abc";
        String str5=null;
        System.out.println(Objects.equals(str1,str2));//使用工具类Objects的equals方法没有安全问题
        System.out.println("abc".equals(str5)); // 推荐：false
//        System.out.println(str5.equals("abc")); // 不推荐：报错，空指针异常NullPointerException
    }
}
