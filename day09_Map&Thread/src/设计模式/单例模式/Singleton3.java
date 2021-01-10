package 设计模式.单例模式;

/**
 * 1.懒汉式：延迟创建这个对象,会有线程安全问题
 */
public class Singleton3 {//懒汉式的线程安全版本，每次创建对象都要加锁，但只有第一次创建对象时才会发生线程安全问题，效率低
    private static Singleton3 INSTANCE;
    private Singleton3(){

    }
    public static synchronized Singleton3 getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Singleton3();
        }
        return INSTANCE;
    }
}
