package Map;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1.多线程情况下，每个线程都会从主物理内存中读取数据，拷贝到自己的内存空间（工作内存）进行操作，操作完写回主内存.
 * 2.保证可见性（声明变量是 volatile的，JVM 保证了每次读变量都从内存中读，跳过CPU cache 这一步，保证新值能立即同步到主内存，
 *      每次使用前都能立即从主内存刷新；而普通的共享变量不能保证可见性，因为普通共享变量被修改之后，什么时候被写入主存是不确定的），
 *      不保证原子性（可以使用atomicInteger解决），禁止指令重排（编译器会指令优化重排，单线程下会保证执行结果一致，多线程下就会有问题）
 * 3.Memory Barrier所做的另外一件事是强制刷出各种CPU cache，如一个Write-Barrier（写入屏障）将刷出所有在Barrier之前写入 cache 的数据，
 *      因此，任何CPU上的线程都能读取到这些数据的最新版本。java内存模型中讲到的volatile是基于Memory Barrier实现的。
 * 4.如果一个变量是volatile修饰的，JMM会在写入这个字段之后插进一个Write-Barrier指令，并在读这个字段之前插入一个Read-Barrier指令。这意味着，
 *      如果写入一个volatile变量，就可以保证：1.一个线程写入变量a后，任何线程访问该变量都会拿到最新值。2.在写入变量a之前的写入操作，其更新的数据
 *      对于其他线程也是可见的。因为Memory Barrier会刷出cache中的所有先前的写入。
 */
public class Volatile {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        int i = atomicInteger.addAndGet(5);
        System.out.println(i);
    }
}
