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
 * 8.ThreadLocal 适用于每个线程需要自己独立的实例且该实例需要在多个方法中被使用，也即变量在线程间隔离而在方法或类间共享的场景
 * 9.因为每个 Thread 内有自己的实例副本，且该副本只能由当前 Thread 使用。这是也是 ThreadLocal 命名的由来。既然每个 Thread 有自己的实例副本，
 *      且其它 Thread 不可访问，那就不存在多线程间共享的问题。
 * 10.每个Thread对象都有一个ThreadLocalMap，当创建一个ThreadLocal的时候，就会将该ThreadLocal对象添加到该Map中，其中键就是ThreadLocal，
 *      值可以是任意类型.
 * 11.向ThreadLocal存入一个值，实际上是向当前线程对象中的ThreadLocalMap存入值，ThreadLocalMap我们可以简单的理解成一个Map，而向这个Map存值
 *      的key就是ThreadLocal实例本身
 * 12.在每个线程中，都维护了一个threadlocals对象，在没有ThreadLocal变量的时候是null的。一旦在ThreadLocal的createMap函数中初始化之后，
 *      这个threadlocals就初始化了。以后每次那个ThreadLocal对象想要访问变量的时候，比如set函数和get函数，都是先通过getMap(t)函数，先将线程
 *      的map取出，然后再从这个在线程（Thread）中维护的map中取出数据【以当前threadlocal作为参数】
 */
public class ThreadLocalDemo1 {
    public static void main(String[] args) {
        ThreadLocal<String> t = new ThreadLocal<>();
        t.set("aaa");
    }
}
