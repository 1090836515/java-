package Thread.Synchronized;

/**
 * 1.出现线程安全问题的解决方法：
 *        synchronized(锁对象){可能出现安全问题的代码块}
 *        定义一个同步方法(锁对象是this),定义静态同步方法，静态方法的锁对象是本类的class对象（Runnable.class）
 *        通过创建一个ReentrantLock（Lock的子类）对象,在通过lock(),unlock()方法
 * 2.同步方法就是在方法前加关键字 synchronized；同步代码块则是在方法内部使用 synchronized
 * 3.加锁对象相同的话，同步方法锁的范围大于等于同步方法块。一般加锁范围越大，性能越差
 * 4.同步方法如果是 static 方法，等同于同步方法块加锁在该 Class 对象上
 */
public class Demo01Ticket {
    public static void main(String[] args){
        RunnableImpl1 run=new RunnableImpl1();
        Thread t0=new Thread(run);
        Thread t1=new Thread(run);
        Thread t2=new Thread(run);
        t0.start();
        t1.start();
        t2.start();
    }
}
