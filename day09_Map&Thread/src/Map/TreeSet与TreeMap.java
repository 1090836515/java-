package Map;

/**
 * 1.实际上TreeSet还是用TreeMap来保存set元素。
 * 2.TreeMap底层采用一种被称为“红黑树”的排序二叉树来保存Map中的每个Entry——每个Entry都被当做红黑树的一个节点来对待,TreeMap的key不能为null
 *      （如果为null，那还怎么排序呢）.
 * 3.相同点：
 *      （1）都是有序集合，也就是说他们存储的值（key）都是排好序的。
 *      （2）都是非同步的，因此它们不能在多线程之间共享，不过可以使用方法Collections.synchroinzedMap()或者Collections.synchroinzedSet()来实现同步。
 *      （3）运行速度都要比Hash集合慢，它们内部对元素的操作时间复杂度为O(logN)，而HashMap和HashSet则为O(1)。
 * 4.不同点：TreeSet和TreeMap实现的接口规范不同，分别实现Set和Map接口。
 * 5.TreeSet和TreeMap要求存放的对象（对TreeMap来说是键值对映射的键）所属的类必须实现Comparable接口（或者通过Comparator实例化TreeSet和TreeMap对象），
 *      该接口提供了比较元素的compareTo()方法，当插入元素时会调用该方法比较元素的大小
 */
public class TreeSet与TreeMap {
}
