package Thread;

/**
 * 1.出现线程安全问题的解决方法：
 *       synchronized(锁对象){可能出现安全问题的代码块}
 */
public class RunnableImpl implements Runnable {

    private int ticket=100;
    //创建一个锁对象
    Object obj=new Object();

    @Override
    public void run() {
        while(true){
            synchronized (obj){
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
    }
}
