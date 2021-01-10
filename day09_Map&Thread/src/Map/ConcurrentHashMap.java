package Map;

import org.junit.Assert;

/**
 * 1.CAS:旧的值A,预期值B,修改值C,只有当A与B相同时才修改为C,否则不做任何修改；多线程同时操作时，只有一个线程能修改成功，是乐观锁、
 *      自旋锁。
 * 2.CAS是原子操作，是CPU的一个指令，自旋时间过长，消耗CPU资源，如果资源竞争激烈，多线程自旋长时间消耗资源
 * 3.JDK1.7时采用segment分段加锁的方式，对部分加锁；1.8之后采用sychronized+CAS的加锁方式
 * 4.get操作可以无锁是由于Node的元素val和指针next是用volatile修饰的，在多线程环境下线程A修改结点的val或者新增节点的时候是对线程B
 *      是可见的。
 * 5.put操作判断存储的key、value是否为空，若为空，则抛出异常，否则，进入步骤②
 * 　　② 计算key的hash值，随后进入无限循环，该无限循环可以确保成功插入数据，若table表为空或者长度为0，则初始化table表，否则，进入
 *      步骤③
 * 　　③ 根据key的hash值取出table表中的结点元素，若取出的结点为空（该桶为空），则使用CAS将key、value、hash值生成的结点放入桶中。
 *      否则，进入步骤④
 * 　　④ 若该结点的的hash值为MOVED，则对该桶中的结点进行转移，否则，进入步骤⑤
 * 　　⑤ 对桶中的第一个结点（即table表中的结点）进行加锁，synchronized只锁定当前链表或红黑二叉树的首节点，对该桶进行遍历，
 *      桶中的结点的hash值与key值与给定的hash值和key值相等，则根据标识选择是否进行更新操作（用给定的value值），否则插入
 *      尾部
 */
public class ConcurrentHashMap {
    public static void main(String[] args) {
    }
}
