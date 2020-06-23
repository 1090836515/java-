package ObjectDemo01;

/**
 * 1.基本类型-->字符串： 100+""; Integer.toString(100); String.valueOf(100)
 * 2.字符串-->基本类型： Integer.parseInt("100");
 * 3.如果整型字面量的值在-128到127之间，那么不会new新的Integer对象，而是直接引用常量池中的Integer对象
 * 4.装箱拆箱:装箱Integer.valueOf(int); 拆箱Integer.intValue()
 * 5.整型的包装类 valueOf 方法返回对象时，在常用的取值范围内，会返回缓存对象。
 * 浮点型的包装类 valueOf 方法返回新的对象。
 * 布尔型的包装类 valueOf 方法 Boolean类的静态常量 TRUE | FALSE。
 */
public class Demo01Integer {
    public static void main(String[] args){
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);//true
        System.out.println(f3 == f4);//false
    }
}
