package Map;

/**
 * 1.（1）synchronized修饰普通方法：用的锁是Java3y对象(内置锁)；（2）修饰代码块：用的锁是Java3y对象(内置锁)--->this，
 *      我们使用synchronized修饰代码块时未必使用this，还可以使用其他的对象(随便一个对象都有一个内置锁)（3）修饰静态方法：
 *      获取到的是类锁(类的字节码文件对象)：Java3y.class
 * 2.synchronized修饰静态方法获取的是类锁(类的字节码文件对象)，synchronized修饰普通方法或代码块获取的是对象锁。
 *      它俩是不冲突的，也就是说：获取了类锁的线程和获取了对象锁的线程是不冲突的！
 * 3.synchronized存在的层面是在jvm层面，发生异常jvm会让线程释放锁，而lock是一个类，需要手动释放锁，否则会出现死锁
 * 4.synchronized是一种互斥锁，一次只能允许一个线程进入被锁住的代码块，synchronized是一种内置锁/监视器锁
 *      Java中每个对象都有一个内置锁(监视器,也可以理解成锁标记)，而synchronized就是使用对象的内置锁(监视器)
 *      来将代码块(方法)锁定的！
 * 5.作用：
 *      原子性：synchronized保证语句块内操作是原子的
 *      可见性：synchronized保证可见性（通过“在执行unlock之前，必须先把此变量同步回主内存”实现）
 *      有序性：synchronized保证有序性
 * 6.对于Java ReetrantLock而言，从名字就可以看出是一个重入锁，其名字是Re entrant Lock 重新进入锁。
 * 　　对于Synchronized而言，也是一个可重入锁。可重入锁的一个好处是可一定程度避免死锁。
 * 7.对于Java ReentrantLock而言，其是独享锁。但是对于Lock的另一个实现类ReadWriteLock，其读锁是共享锁，其写锁是独享锁。
 *      读锁的共享锁可保证并发读是非常高效的，读写，写读，写写的过程是互斥的。互斥锁在Java中的具体实现就是ReentrantLock。
 * 　　  读写锁在Java中的具体实现就是ReadWriteLock。
 */
public class synchronized与lock {
}
