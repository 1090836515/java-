package 设计模式.单例模式;

/**
 * 1.饿汉式：直接创建实例对象，不管你是否需要这个对象
 * （1）构造器私有化
 * （2）用静态变量保存
 */
public class Singleton1 {//饿汉式
    private static final Singleton1 INSTANCE = new Singleton1();
    private Singleton1(){

    }
    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}
