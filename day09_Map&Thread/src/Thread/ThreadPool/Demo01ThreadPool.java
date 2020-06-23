package Thread.ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 可以是线程重复利用，不会用完就销毁，再用又重建这样反复的浪费资源
 */
public class Demo01ThreadPool {
    public static void main(String[] args){
        //使用线程池工厂类Executors的newFixedThreadPool方法创建一个指定数量的线程池
        ExecutorService es = Executors.newFixedThreadPool(2);
        //调用submit方法,传递线程任务，开启线程，执行run方法
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        //销毁线程池
        es.shutdown();
    }
}
