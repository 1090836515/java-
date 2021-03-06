package Map;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1.多线程情况下，每个线程都会从主物理内存中读取数据，拷贝到自己的内存空间（工作内存）进行操作，操作完写回主内存.
 * 2.保证可见性（声明变量是 volatile的，JVM 保证了每次读变量都从内存中读，跳过CPU cache 这一步，保证新值能立即同步到主内存，
 *      每次使用前都能立即从主内存刷新；而普通的共享变量不能保证可见性，因为普通共享变量被修改之后，什么时候被写入主存是不确定的），
 *      不保证原子性（可以使用atomicInteger解决），禁止指令重排（编译器会指令优化重排，单线程下会保证执行结果一致，多线程下就会有问题）
 */
public class Volatile {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        int i = atomicInteger.addAndGet(5);
        System.out.println(i);
    }
}
