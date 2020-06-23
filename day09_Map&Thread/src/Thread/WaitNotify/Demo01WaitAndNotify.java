package Thread.WaitNotify;

/**
 * 1.等待唤醒机制必须保证锁对象唯一，需要使用同步技术
 * 2.wait(),notify()方法在Object对象中定义
 */
public class Demo01WaitAndNotify {
    public static void main(String[] args){
        //创建锁对象，保证唯一
        Object obj=new Object();

        new Thread(){
            @Override
            public void run() {
                synchronized (obj){
                    System.out.println("告知老板要的包子的数量");
                    try{
                        obj.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("包子做好了，开吃");
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                    try{
                        Thread.sleep(5000);//花5秒做好包子
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    synchronized (obj){
                        System.out.println("老板5秒钟之后做好包子，告知顾客");
                        obj.notify();
                    }

            }
        }.start();
    }
}
