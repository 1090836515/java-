package Reflect;

/**
 * 1.回收 JVM 堆内存里的对象空间，不负责回收栈内存数据
 * 2.无法处理一些操作系统资源的释放，如数据库连接、输入流输出流、Socket 连接
 * 3.垃圾回收发生具有不可预知性，程序无法精确控制垃圾回收机制执行
 * 4.可以将对象的引用变量设置为 null，垃圾回收机制可以在下次执行时回收该对象。
 * 5.JVM 有多种垃圾回收 实现算法，表现各异
 * 6.垃圾回收机制回收任何对象之前，会先调用对象的 finalize() 方法
 * 7.可以通过 System.gc() 或 Runtime.getRuntime().gc() 通知系统进行垃圾回收，会有一些效果，但系统是否进行垃圾回收依然不确定
 * 8.不要主动调用对象的 finalize() 方法，应该交给垃圾回收机制调用
 */
public class GC {
}