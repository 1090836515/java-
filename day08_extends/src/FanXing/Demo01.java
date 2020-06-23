package FanXing;

import java.util.ArrayList;

/**
 * 1.使用泛型可以在new出具体对象后再指定参数类型，更加灵活
 * 2.ArrayList<?> 使用通配符表示泛型;也可以使用这种方式: static<E>
 * 3.每个方法最多只有一个可变参数
 * 可变参数必须是方法的最后一个参数
 * 可变参数可以设置为任意类型：引用类型，基本类型
 * 参数的个数可以是 0 个、1 个或多个
 * 可变参数也可以传入数组
 * 无法仅通过改变 可变参数的类型，来重载方法
 * 通过对 class 文件反编译可以发现，可变参数被编译器处理成了数组
 */
public class Demo01 {
    public static void main(String[] args){
        MyClass<String> my=new MyClass<>();
        my.print("abc");
        MyClass<Integer> my2=new MyClass<>();
        my2.print(123);
    }

    public static void print(ArrayList<?> list){
        System.out.println(list);
    }
    public static<E> void print2(ArrayList list){
        System.out.println(list);
    }
}
