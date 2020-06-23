package Interface;

/**
 * 1.接口就是多个类的公共规范，最重要的就是其中的抽象方法
 * 2.接口都可以定义抽象方法，不能有构造方法
 * 3.接口当中的抽象方法修饰符必须是两个固定的关键字:public abstract，可以省略
 * 4.接口不能直接使用，必须要有一个实现类实现接口，实现类需要覆盖重写接口的所有抽象方法,如果没有，那这个类必须是抽象类
 * 5.默认方法可以选择是否实现重写，实现了就调用子类的默认方法，否则就调用父类的
 * 6.接口的静态方法不能通过实现类调用，调用方式为：接口名.静态方法名(参数)
 * 7.接口里可以定义私有方法，仅供接口里默认方法调用
 * 8.接口当中的成员变量都是常量,public static final可以省略
 * 9.接口可以多继承
 */
public interface MyInterfaceAbstract {

    //接口当中的成员变量都是常量,public static final可以省略
    public static final int NUM=10;

    public abstract void methodAbs1();

    //这也是抽象方法
    abstract void methodAbs2();

    //这也是抽象方法
    public void methodAbs3();

    //这也是抽象方法
    void methodAbs4();

    //新添加的默认方法
    public default void methodDefault(){
        System.out.println("这是新添加的默认方法");
    }

    //静态方法
    public static void methodStatic(){
        System.out.println("这是接口的静态方法");
    }
}
