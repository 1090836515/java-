package ThreadPool;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.concurrent.*;

/**
 * 1.Executor是线程池的顶级接口，只是一个执行线程的工具，只提供一个execute(Runnable command)的方法，真正的线程池接口是ExecutorService,
 *      AbstractExecutorService实现了ExecutorService接口，实现了其中大部分的方法（有没有实现的方法，所以被声明为Abstract），ThreadPoolExecutor
 *      继承了AbstractExecutorService，是ExecutorService的默认实现。
 * 2.在控制台打印日志, logger.info(Thread.currentThread().getName() + "没有获得锁" + new Date())
 */
public class ThreadPoolUtil {

    private final Logger logger = LoggerFactory.getLogger(ThreadPoolUtil.class);

    private static BlockingQueue<Runnable> queue;
    private static ThreadFactory threadFactory;
    private static ThreadPoolExecutor threadPoolExecutor;

    public static ThreadPoolExecutor getThreadPoolExecutor(String perfix) {
        if (queue == null) {
            queue = new LinkedBlockingDeque<>(50000);
        }

        if (threadFactory == null) {
            //threadFactory = DefaultThreadPool.instance(perfix);
        }

        if (threadPoolExecutor == null) {
            threadPoolExecutor = new ThreadPoolExecutor(20, 200, 60L, TimeUnit.SECONDS,
                    queue, threadFactory);
        }
        return threadPoolExecutor;
    }


}
