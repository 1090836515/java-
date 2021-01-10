package Redis;

/**
 * 1.Redis使用对象来表示数据库中的键和值。每次我们在Redis数据库中新创建一个键值对时，至少会创建出两个对象。一个是键对象，一个是值对象，键为字符串，
 *      值为五种数据结构（由底层其他数据结构来实现）。
 * 1.sds（简单动态字符串，字符串的底层数据结构）：优点：获取字符串的长度时，时间复杂度只需要O(1)；空间预分配机制，若set时剩余可用长度不足，
 *      则会多于所需空间一倍的大小，减少分配次数（因为执行 APPEND 命令的字符串键数量通常并不多，占用内存的体积通常也不大）；空间不足。先会
 *      扩展空间，再进行修改！(内部实现了动态扩展机制)；二进制安全的。
 *      struct sdshdr{
 *          // 字节数组，用于保存字符串
 *          char buf[];
 *          // 记录buf数组中已使用的字节数量，也是字符串的长度
 *          int len;
 *          // buf 剩余可用长度
 *          int free;
 *      }
 * 2.双端链表（列表的底层数据结构，还有一种时压缩列表）：因为双端链表占用的内存比压缩列表要多，所以当创建新的列表键时，列表会优先考虑使用压缩
 *      列表作为底层实现，并且在有需要的时候，才从压缩列表实现转换到双端链表实现。由list与listNode两个数据结构组成。
 *      特性：节点带有前驱和后继指针，访问前驱节点和后继节点的复杂度为 O(1) ，并且对链表的迭代可以在从表头到表尾和从表尾到表头两个方向进行；
 *      链表使用void *指针来保存节点值，可以保存各种不同类型的值；可以O(1)获得链表的长度
 *      typedef struct listNode {
 *          // 前驱节点
 *          struct listNode *prev;
 *          // 后继节点
 *          struct listNode *next;
 *          // 值
 *          void *value;
 *      } listNode;
 *      typedef struct list {
 *          // 表头指针
 *          listNode *head;
 *          // 表尾指针
 *          listNode *tail;
 *          // 节点数量
 *          unsigned long len;
 *          // 复制函数
 *          void *(*dup)(void *ptr);
 *          // 释放函数
 *          void (*free)(void *ptr);
 *          // 比对函数
 *          int (*match)(void *ptr, void *key);
 *      } list;
 * 3.字典（hash的底层数据结构，还有一种是压缩列表）：因为压缩列表比字典更节省内存，所以程序在创建新Hash键时，默认使用压缩列表作为底层实现，
 *      当有需要时，程序才会将底层实现从压缩列表转换到字典。使用两个hash表实现，0号哈希表（ht[0]）是字典主要使用的哈希表，而1号哈希表（ht[1]）
 *      则只有在程序对 0号哈希表进行rehash(扩容)时才使用，大小至少为 ht[0]的两倍；rehash 程序并不是在激活之后就马上执行直到完成的，而是
 *      分多次、渐进式地完成的；使用链地址法来处理键碰撞；字典还可以进行收缩，过程类似扩展，创建的h[1]要比h[0]小得多
 *      typedef struct dict {
 *          // 特定于类型的处理函数
 *          dictType *type;
 *          // 类型处理函数的私有数据
 *          void *privdata;
 *          // 哈希表（2 个）
 *          dictht ht[2];
 *          // 记录 rehash 进度的标志，值为-1 表示 rehash 未进行
 *          int rehashidx;
 *          // 当前正在运作的安全迭代器数量
 *          int iterators;
 *      } dict;
 * 4.跳跃表（实现sortedSet的底层数据结构）：score 值可重复；对比一个元素需要同时检查它的 score 和 memeber
 * 5.整数集合(intset):集合(Set)的底层数据结构之一。当一个set(集合)只包含整数值元素，并且元素的数量不多时，Redis就会采用整数集合(intset)
 *      作为set(集合)的底层实现;整数集合(intset)保证了元素是不会出现重复的，并且是有序的(从小到大排序)。只支持升级不支持降级
 *      如果本来是INTSET_ENC_INT16的编码，想要存放大于INTSET_ENC_INT16编码能存放的整数值，此时就得编码升级(从16升级成32或者64)。
 *      步骤如下：
 *           1）根据新元素类型拓展整数集合底层数组的空间并为新元素分配空间。
 *           2）将底层数组现有的所以元素都转换成与新元素相同的类型，并将类型转换后的元素放到正确的位上，需要维持底层数组的有序性质不变。
 *           3）将新元素添加到底层数组。
 * 6.压缩列表（list和hash，有序集合的底层实现之一）：如果list的每个都是小整数值，或者是比较短的字符串，压缩列表(ziplist)作为list的底层实现
 */
public class Redis数据结构 {
}
