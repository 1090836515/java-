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
 * 5.HashCode()（效率高）相等，equals()（效率低）并不一定相等；反过来equals()比较相等，则hashCode()一定相等；
 *      重写了equals(重写前效果等同于==，重写后比较两个对象的值，==在基本数据类型时比较的是值，基本数据类型不能调用方法，在引用类型时比较的是地址)，
 *      则必须重写hashCode。所以一般先比较hash，若不等，则不用比了；若相等再比较equals，两个都相等才说明两者对象相同。
 *      重写equals方法的目的是判断两个对象的内容(内容可以有很多，比如同时比较姓名和年龄，同时相同的才是用一个对象)是否相同。
 *      (1)当obj1.equals(obj2)为true时，obj1.hashCode() == obj2.hashCode()必须为true（规定）
 *      (2)当obj1.hashCode() == obj2.hashCode()为false时，obj1.equals(obj2)必须为false
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
