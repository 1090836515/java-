package Thread;

/**
 * 1.getName();//获取线程名称；Thread t=Thread.currentThread();//获取当前正在执行线程对象的引用
 * 2.通过构造方法调用super(name);//通过父类设置线程的名字
 */
public class MyThread extends Thread {
    public MyThread() {
    }

    public MyThread(String name) {
        super(name);//通过父类设置线程的名字
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println("run:"+i);
            System.out.println(getName());//获取线程名称
            Thread t=Thread.currentThread();//获取当前线程信息
            System.out.println(t);
        }
    }
}
