package Thread.Synchronized;

/**
 * 1.出现线程安全问题的解决方法：
 *       synchronized(锁对象){可能出现安全问题的代码块}
 *       定义一个同步方法(锁对象是this)
 *       定义静态同步方法，静态方法的锁对象是本类的class对象（Runnable.class）
 */
public class RunnableImpl2 implements Runnable {

    private static int ticket=100;

    @Override
    public void run() {
        while(true){
            payTicket();
        }
    }
    //定义一个同步方法
    public static synchronized void payTicket(){
        if(ticket>0){
            try{
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            //票存在就卖票
            System.out.println(Thread.currentThread().getName()+"-->正在卖票"+ticket+"张票");
            ticket--;
        }
    }
}
