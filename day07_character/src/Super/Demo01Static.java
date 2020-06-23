package Super;

/**
 * 1.内存当中现有静态内容，后有非静态内容
 * 2.方法区中有一个静态区存放静态变量，访问静态变量全程跟对象没关系
 * 3.静态方法先执行，且只执行一次，构造方法后执行
 * 4.静态方法只能访问静态变量
 * 5.static 修饰表示静态或全局，被修饰的属性和方法属于类，可以用类名.静态属性 / 方法名 访问
 * 6.static 修饰的代码块表示静态代码块，当 Java 虚拟机（JVM）加载类时，就会执行该代码块,只会被执行一次
 * 7.static 修饰的属性，也就是类变量，是在类加载时被创建并进行初始化，只会被创建一次
 * 8.static 修饰的变量可以重新赋值
 * 9.static 方法中不能用 this 和 super 关键字
 * 10.static 方法必须被实现，而不能是抽象的abstract
 * 11.static 方法不能被重写
 * 12.static 不可以修饰方法内的局部变量，final 可以。
 * 13.都不能用于修饰构造方法。
 * 14.static 变量是这个类所有，由该类创建的所有对象共享同一个 static 属性
 * 15.static 修饰的变量只能是类的成员变量
 */
public class Demo01Static {

    int num=1;
    static int numStatic;

    public static void methodStatic(){
        //System.out.println(num);//静态方法不能直接访问非静态变量
        //System.out.println(this);//错误写法
    }
    static {
        System.out.println("静态方法执行");
        //System.out.println(num);//错误代码
    }
    public Demo01Static(){
        System.out.println("构造方法执行");
    }
    public static void main(String[] args){
        new Demo01Static();
    }
}
