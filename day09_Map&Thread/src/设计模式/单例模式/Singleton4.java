package 设计模式.单例模式;

public class Singleton4 {//懒汉式双重检查加锁版本
    /*private static volatile Singleton4 INSTANCE;
    private Singleton4 (){
    }
    public static Singleton4 getInstance() {
        if(INSTANCE == null) {
            //只有第一次才执行这里的代码
            synchronized (Singleton4.class) {
                if(INSTANCE == null) {//锁了之后对象还为空才能说明对象是真没创建
                    *//**
                     * 初始化一个对象并使一个引用指向他，这个过程不是原子的。导致了可能会出现引用指向了对象并未初始化好的那块堆内存，
                     *      也就是对象引用有了，但构造函数并未执行，对象没有初始化，变量都是默认值，使用volatile修饰对象引用，防
                     *      止指令重排序即可解决。
                     *//*
                    INSTANCE = new Singleton4();
                }
            }
        }
        return INSTANCE;
    }*/
    private static volatile Singleton4 INSTANCE;
    private Singleton4() {

    }
    public static Singleton4 getInstance() {
        if(INSTANCE == null) {
            synchronized (Singleton4.class) {
                if(INSTANCE == null) {
                    INSTANCE = new Singleton4();
                }
            }
        }
        return INSTANCE;
    }
}
