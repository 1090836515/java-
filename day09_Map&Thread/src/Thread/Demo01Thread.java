package Thread;

/**
 * 1.并行：多个事件在同一时间段发生，高速切换;并发：多个事件在同一时间同时发生
 * 2.cpu负责调度多个线程的切换，分时调度或抢占式调度，java属于抢占式调度，哪个线程优先级高就先执行哪个，main主线程执行完了，再执行其他子线程
 * 3.创建多线程的两种方式：
 *          继承Thread类并重写run方法，通过start()方法执行，继承只能继承一个
 *          实现Runnable接口,new Thread(run),将实现Runnable接口的实现类传入，调用start方法执行，实现可以实现多个接口
 *          使用匿名内部类直接new Thread()或Runnable（）
 */
public class Demo01Thread {
    public static void main(String[] args){
        MyThread myThread=new MyThread();
        myThread.start();
        for (int i=0;i<10;i++){
            System.out.println("main:"+i);
        }
        new MyThread("小强").start();
        new MyThread("df").run();
    }
}
