package array;

import java.util.Arrays;

/**
 * 1.堆（Heap）:凡是new出来的,都在堆内存当中
 * 2.方法区（Method Area）：存储.class相关信息，包含方法信息
 * 3.两个方法在堆内存保存的地址是同一个
 * 4.调用方法时方法进栈，调用完了后出栈
 * 5.成员变量有默认值，局部变量没有默认值，需要赋值才能使用
 * 6.成员变量位于堆内存当中，局部变量位于栈内存当中
 * 7.内存当中现有静态内容，后有非静态内容
 * 8.方法区中有一个静态区存放静态变量，访问静态变量全程跟对象没关系
 * 9.静态方法先执行，且只执行一次，构造方法后执行
 * 10.每个数组元素都有默认值，基本类型的默认值为 0、0.0、false，引用类型的默认值为 null
 * 11.数组的长度一经确定，无法改变，即定长。要改变长度，只能重新申明一个
 */
public class Demo01Array {
    public static void main(String[] args){
        int[] a=new int[]{10,20,30};
        int[] b={10,20,30};
        System.out.println(a.length);
        calculate(5,6,7);
        System.out.println(Arrays.toString(a));
    }
    public static int[] calculate(int x,int y,int z){
        int d=x+y;
        int e=y+z;
        int[] sum={d,e};
        return sum;
    }
}
