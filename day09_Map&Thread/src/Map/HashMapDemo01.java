package Map;

import java.util.HashMap;

/**
 * 1.HashCode()（效率高）相等，equals()（效率低）并不一定相等；反过来equals()比较相等，则hashCode()一定相等；
 *      重写了equals(重写前效果等同于==，重写后比较两个对象的值，==在基本数据类型时比较的是值，基本数据类型不能调用方法，在引用类型时比较的是地址)，则必须
 *      重写hashCode。所以一般先比较hash，若不等，则不用比了；若相等再比较equals，两个都相等才说明两者对象相同。
 *      重写equals方法的目的是判断两个对象的内容(内容可以有很多，比如同时比较姓名和年龄，同时相同的才是用一个对象)是否相同。
 *      (1)当obj1.equals(obj2)为true时，obj1.hashCode() == obj2.hashCode()必须为true（规定）
 *      (2)当obj1.hashCode() == obj2.hashCode()为false时，obj1.equals(obj2)必须为false
 * 2.HashMap初始容量为16,负载因子为0.75,数组加链表的结构，大于0.75*16时进行扩容，每次扩容为原来的两倍
 * 3.负载因子越大，hash冲突的可能性越高，查询会越慢，构造函数不传入负载因子则默认为0.75
 * 4.HashMap利用位运算替代取模，能更高效的计算元素的位置，所以容量的大小必须保证为2的次幂
 * 5.put时才进行初始化，调用resize()方法，第二次扩容开始每次扩容为原来的两倍，先计算hash找到数组对应位置，如果没有hash冲突，则加
 *      到该位置，若有，则遍历链表（红黑树），若有key相同则覆盖，否则加到链表尾部，当容量大于64且链表长度大于8，则转化为红黑树，小于
 *      6则退化为链表。
 * 6.get时对key做hash运算，计算出该key所在的index，然后判断是否有hash冲突，假设没有直接返回，假设有则判断当前数据结构是链表还是红
 *      黑树，分别从不同的数据结构中取出，先比较hash再比较equals。
 * 7.线程不安全的原因是put时会多线程操作可能发生数据覆盖（不同的值都插到末尾同一位置），或者size数值错误，（长度加了2，但是size只加了1）
 * 8.LinkedHashMap采用数组+双向链表，保证了插入顺序，LinkedHashMap比HashMap多了一个双向链表的维护，所以初始容量对遍历没有影响
 * 9.Map下面是HashMap:接口实现类 ，没有同步， 线程不安全;TreeMap(上面是SortedMap),WeakHashMap:弱引用的时候使用，键是“弱键”，
 *      在 WeakHashMap 中，当某个键不再正常使用时，会被从WeakHashMap中被自动移除；HashTable:接口实现类，同步，线程安全；IdentifyHashMap
 */
public class HashMapDemo01 {
    public static void main(String[] args) {
    }

}
