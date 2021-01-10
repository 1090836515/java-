package 设计模式.单例模式;

public class Singleton5 {//最简单的懒汉式线程安全版本，在内部类被加载和初始化时才创建对象
    private Singleton5 (){
    }
    /*private static class Inner{//只有第一次使用这个单例的实例的时候才加载，同时不会有线程安全问题
        private static Singleton5 INSTANCE = new Singleton5();
    }*/
    private static class Inner {
        private static Singleton5 INSTANCE = new Singleton5();
    }
    public static Singleton5 getInstance() {
        return Inner.INSTANCE;
    }
}
