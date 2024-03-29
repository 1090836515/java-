package JVM;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 1.垃圾回收算法：
 *      （1）标记清除：首先标记出所有需要回收的对象，在标记完成后统一回收所有被标记的对象；缺点：会产生大量不连续的碎片，分配不了大对象，效率低。
 *      （2）复制算法：将内存分为两块，每次使用其中的一块，将不需要回收的对象复制到另一块，然后将原来的区域全部回收；效率高但可使用内存变小。
 *      （3）标记整理算法：标记过程仍然与“标记-清除”算法一样，然后将所有存活的对象往一端移动，然后清理掉边界外的所有对象。
 *      （4）分代收集算法：这种算法没有什么新的思想，只是根据对象存活周期的不同将内存分为几块。一般将 java 堆分为新生代和老年代，
 *          这样我们就可以根据各个年代的特点选择合适的垃圾收集算法。比如在新生代中，每次收集都会有大量对象死去，所以可以选择复制算法，
 *          只需要付出少量对象的复制成本就可以完成每次垃圾收集。而老年代的对象存活几率是比较高的，而且没有额外的空间对它进行分配担保，
 *          所以我们必须选择“标记-清除”或“标记-整理”算法进行垃圾收集。
 * 2.垃圾回收机制回收任何对象之前，会先调用对象的 finalize()方法
 * 3.分代收集算法：将堆分为新生代，老年代；新生代又分为Eden,from,to区，默认8：1：1，新创建的对象都会被分配到Eden区（大对象直接进入到老年代），
 *      在GC开始的时候，对象只会存在于Eden区和名为“From”的Survivor区，Survivor区“To”是空的。Eden区满时进行MinorGC（复制算法），
 *      Java对象大多数都具备朝生夕死的特性，所以Minor GC非常频繁，一般回收速度比较快。Eden区中所有存活的对象都会被复制到“To”，
 *      而在“From”区中，仍存活的对象会根据他们的年龄值来决定去向。年龄达到一定值的对象会被移动到年老代中，没有达到阈值的对象会被复制到“To”区域。
 *      经过这次GC后，Eden区和From区已经被清空。这个时候，“From”和“To”会进行交换。Minor GC会一直重复这样的过程，直到“To”区被填满,
 *      “To”区被填满之后,会将所有对象移动到年老代中,老年代满了会触发FullGC(标记清除/整理算法)。
 * 4.垃圾收集器：（1）串行收集器：在垃圾收集的时候必须暂停其他所有线程，直到收集结束。（2）多线程收集器：多线程版本收集器，除了使用多线程进行
 *      垃圾收集外，其余行为（控制参数、收集算法、回收策略等等）和 Serial 收集器完全一样。（3）Parallel Scavenge 收集器：也是使用复制算法
 *      的多线程收集器，它看上去几乎和ParNew都一样，关注点是吞吐量（高效率的利用 CPU）（4）CMS 收集器：是一种以获取最短回收停顿时间为目标的
 *      收集器。它非常符合在注重用户体验的应用上使用，是 HotSpot 虚拟机第一款真正意义上的并发收集器，它第一次实现了让垃圾收集线程与用户线程
 *      （基本上）同时工作。（5）G1 收集器：是一款面向服务器的垃圾收集器,主要针对配备多颗处理器及大容量内存的机器. 以极高概率满足 GC 停顿时
 *      间要求的同时,还具备高吞吐量性能特征.
 *             所谓吞吐量就是 CPU 中用于运行用户代码的时间与 CPU 总消耗时间的比值
 *             新生代采用复制算法，老年代采用标记-整理算法。
 * 5.强软弱虚引用：
 *      （1）强引用：Object object = new Object();如果一个对象具有强引用，那就类似于必不可少的生活用品，垃圾回收器绝不会回收它。当内存空间不足，
 *              Java 虚拟机宁愿抛出 OutOfMemoryError 错误，使程序异常终止，也不会靠随意回收具有强引用的对象来解决内存不足问题。
 *      (2)软引用：只有当内存不够用的时候才会回收它，软引用可以很好地用来解决OOM的问题，并且这个特性很适合用来实现缓存：比如网页缓存、图片缓存等。
 *              (SoftReference<String> sr = new SoftReference(new String("123"));)
 *     （3）弱引用：不管内存够不够，只要gc时发现了它就会回收。WeakReference，弱引用可以和一个引用队列（ReferenceQueue）联合使用 (WeakReference<String> wr = new WeakReference(new String("123"));)
 *      (4)虚引用：不管是否回收都找不到引用的对象，仅用于管理直接内存；无论是否回收都获取不到引用的对象，虚引用必须和引用队列（ReferenceQueue）联合使用；
 *          程序可以通过判断引用队列中是否已经加入了虚引用，来了解被引用的对象是否将要被垃圾回收。程序如果发现某个虚引用已经被加入到引用队列，
 *          那么就可以在所引用的对象的内存被回收之前采取必要的行动。
 * 6.判断对象是否死亡：
 *      1.引用计数法：给对象中添加一个引用计数器，每当有一个地方引用它，计数器就加1；当引用失效，计数器就减1，引用数为0就说明对象死亡，
 *           缺点是它很难解决对象之间相互循环引用的问题
 *      2.可达性分析算法：通过一系列的称为 “GC Roots” 的对象作为起点，从这些节点开始向下搜索，节点所走过的路径称为引用链，当一个对象到
 *          GC Roots 没有任何引用链相连的话，则证明此对象是不可用的
 *      3.GC Roots的对象包括：虚拟机栈(栈帧中的本地变量表)中引用的对象、本地方法栈(Native 方法)中引用的对象、方法区中类静态属性引用的对象
 *          方法区中常量引用的对象、所有被同步锁持有的对象
 */
public class JVM垃圾回收 {
    public static void main(String[] args) {
        SoftReference<String> soft = new SoftReference<>(new String("aabbcc"));
        String s = soft.get();
        System.out.println(s);
    }
}
