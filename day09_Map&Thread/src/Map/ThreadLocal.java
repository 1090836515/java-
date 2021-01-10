package Map;

/**
 * 1.每个Thread维护着一个ThreadLocalMap的引用
 * 2.ThreadLocalMap是ThreadLocal的内部类，用Entry来进行存储
 * 3.调用ThreadLocal的set()方法时，实际上就是往ThreadLocalMap设置值，key是ThreadLocal对象本身，值是传递进来的对象
 * 4.调用ThreadLocal的get()方法时，实际上就是往ThreadLocalMap获取值，key是ThreadLocal对象
 * 5.ThreadLocal本身并不存储值，它只是作为一个key来让线程从ThreadLocalMap获取value。
 * 6.ThreadLocal内存泄漏的根源是：由于ThreadLocalMap的生命周期跟Thread一样长，如果没有手动删除对应key就会导致内存泄漏，
 *      而不是因为弱引用。想要避免内存泄露就要手动remove()掉！
 * 7.ThreadLocal设计的目的就是为了能够在当前线程中有属于自己的变量，并不是为了解决并发或者共享变量的问题
 */
public class ThreadLocal {
}
