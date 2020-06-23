package Thread.Synchronized;

/**
 * 1.出现线程安全问题的解决方法：
 *        synchronized(锁对象){可能出现安全问题的代码块}
 *        定义一个同步方法(锁对象是this),定义静态同步方法，静态方法的锁对象是本类的class对象（Runnable.class）
 *        通过创建一个ReentrantLock（Lock的子类）对象,在通过lock(),unlock()方法
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
