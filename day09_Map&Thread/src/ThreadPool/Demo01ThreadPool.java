package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1.线程池参数：corePoolSize：核心线程数；maximumPoolSize：线程池的最大线程数；keepAliveTime：核心线程数之外的线程，最大空闲存活的时长；
 *     unit：keepAliveTime 的时间单位；workQueue：线程池的任务等待队列；threadFractory：线程工厂，用来为线程池创建线程；
 *     handler：拒绝策略，当线程池无法处理任务时的拒绝方式
 * 2.增长策略：当线程数少于核心线程数时，有新任务来了就创建新线程，在线程数达到核心线程数，再有新任务过来，若没有空闲线程，就将新任务加入到
 *      任务队列中，直到任务队列满才创建新线程，直到线程数量等于maximumPoolSize，并且没有空闲的线程，任务队列也存满了任务，
 *      这时如果还有新的任务进来，就会触发线程池的拒绝策略（handler），如果没有配置拒绝策略就会抛出 RejectedExecutionException 异常
 * 3.任务队列（阻塞队列）：
 * ①ArrayBlockingQueue：基于数组的有界阻塞队列，按FIFO排序。新任务进来后，会放到该队列的队尾。当线程池中线程数量达到corePoolSize后，
 *      再有新任务进来，则会将任务放入该队列的队尾，等待被调度。如果队列已经是满的，则创建一个新线程，如果线程数量已经达到maxPoolSize，
 *      则会执行拒绝策略。
 * ②LinkedBlockingQuene：基于链表的无界阻塞队列（其实默认最大容量为Interger.MAX），按照FIFO排序。由于该队列的近似无界性，当线程池中线程数量
 *      达到corePoolSize后，再有新任务进来，会一直存入该队列，而不会去创建新线程直到maxPoolSize，因此使用该工作队列时，参数maxPoolSize
 *      其实是不起作用的。
 * ③SynchronousQuene:一个不缓存任务的阻塞队列，生产者放入一个任务必须等到消费者取出这个任务。也就是说新任务进来时，不会缓存，而是直接被调度
 *      执行该任务，如果没有可用线程，则创建新线程，如果线程数量达到maxPoolSize，则执行拒绝策略。
 * ④PriorityBlockingQueue:具有优先级的无界阻塞队列，优先级通过参数Comparator实现。
 * 4.拒绝策略:
 *      ①CallerRunsPolicy:该策略下，在调用者线程中直接执行被拒绝任务的run方法，除非线程池已经shutdown，则直接抛弃任务。
 *      ②AbortPolicy:该策略下，超出最大数（maximumPoolSize+队列容量）直接丢弃任务，并抛出RejectedExecutionException异常。（默认）
 *      ③DiscardPolicy:该策略下，直接丢弃任务，什么都不做。
 *      ④DiscardOldestPolicy:该策略下，抛弃进入队列最早的那个任务，然后尝试把这次拒绝的任务放入队列
 * 5.线程池分类：1.CachedThreadPool：创建一个可以缓存线程的线程池，默认缓存60s,适合使用在任务量大但耗时少的任务。
 *      2.FixedThreadPool：初始化一个指定大小的线程池，corePoolSize==maxiPoolSize,适合使用在任务量比较固定但耗时长的任务。
 *      3.ScheduledThreadPool：初始化的线程可以在指定的时间内周期性的执行所提交的任务，适合使用在执行定时任务和具体固定周期的重复任务。
 *      4.SingleThreadPool：初始化只有一个线程的线程池，如果线程异常结束，则会重新创建一个新的线程继续执行任务，适合使用在多个任务顺序执行的场景。
 * 6.实现Runnable接口和Callable接口的区别：Runnable接口或Callable接口实现类都可以被ThreadPoolExecutor,
 *      或ScheduledThreadPoolExecutor执行；call方法可以抛出异常，run方法不可以；Callable规定的方法是call(),Runnable规定的方法
 *      是run()；两者的区别在于 Runnable 接口不会返回结果但是 Callable 接口可以返回结果。
 * 7.执行execute()方法和submit()方法的区别：execute() 方法用于提交不需要返回值的任务，所以无法判断任务是否被线程池执行成功与否；
 *      submit() 方法用于提交需要返回值的任务。线程池会返回一个Future类型的对象，通过这个Future对象可以判断任务是否执行成功，
 *      并且可以通过future的get()方法来获取返回值。
 * 8.实现线程池：
 *      1）如果当前运行的线程数少于corePoolSize，则创建新线程来执行任务。
 *      2）在线程池完成预热之后（当前运行的线程数等于corePoolSize），将任务加入LinkedBlockingQueue。
 *    3）线程执行完1中的任务后，会在循环中反复从LinkedBlockingQueue获取任务来执行
 * 9.为什么要用线程池:降低资源消耗:通过重复利用已创建的线程降低线程创建和销毁造成的消耗。提高响应速度:当任务到达时，任务可以不需要的
 *      等到线程创建就能立即执行。提高线程的可管理性:线程是稀缺资源，如果无限制的创建，不仅会消耗系统资源，还会降低系统的稳定性，
 *      使用线程池可以进行统一的分配，调优和监控。
 * 10.阻塞队列的实现：
 *
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
