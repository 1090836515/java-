package Thread.Synchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1.出现线程安全问题的解决方法：
 *       synchronized(锁对象){可能出现安全问题的代码块}
 *       定义一个同步方法(锁对象是this)
 *       定义静态同步方法，静态方法的锁对象是本类的class对象（Runnable.class）
 *       通过创建一个ReentrantLock对象,在通过lock(),unlock()方法
 */
public class RunnableImpl3 implements Runnable {

    private static int ticket=100;
    //在成员位置创建一个ReentrantLock对象
    Lock l=new ReentrantLock();

    @Override
    public void run() {
        while(true){
            l.lock();
            if(ticket>0){
                try{
                    Thread.sleep(10);
                    //票存在就卖票
                    System.out.println(Thread.currentThread().getName()+"-->正在卖票"+ticket+"张票");
                    ticket--;
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    //无论是否出现异常，锁都会释放掉
                    l.unlock();
                }
            }
        }
    }

}
