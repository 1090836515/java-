package ListSetIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1.ArrayList初始容量为10，每次扩容为原来的1.5倍，oldCapacity + (oldCapacity >> 1)，添加或者删除时调用的是
 *      System.arraycopy()(本地方法，C++实现)方法把数据都往前(后)移一位，线程不安全，数据可以为null（等待垃圾回收）
 * 2.arraycopy()需要目标数组，将原数组拷贝到你自己定义的数组里，而且可以选择拷贝的起点和长度以及放入新数组中的位置；
 *      copyOf()是系统自动在内部新建一个数组，调用arraycopy()将original内容复制到copy中去，并且长度为newLength。返回copy;
 *      即将原数组拷贝到一个长度为newLength的新数组中，并返回该数组。
 * 3.Vector底层是数组,区别是方法经过synchronized修饰，线程安全,如果想要ArrayList实现同步，可以使用
 *      Collections.synchronizedList(new ArrayList(...));也是几乎都是每个方法都加上synchronized关键字的，
 *      只不过它不是加在方法的声明处，而是方法的内部。
 * 4.LinkedList底层是双向链表，实现了Deque(队列)接口，有头、尾指针，添加或删除元素时先判断下标若小于链表长度的一半则从头遍历，否则
 *      从尾开始遍历。
 * 5.总的来说：查询多用ArrayList，增删多用LinkedList。但ArrayList增删慢不是绝对的，如果增加或者删除元素一直是使用add()(增加
 *      到末尾)的话，那是ArrayList要快。
 * 6.CopyOnWriteArrayList: 通过final transient ReentrantLock lock加锁，读（get方法）不加锁，写（add,set）加锁，
 *      写的时候会复制一个新数组，增加操作在新数组上完成，将array指向到新数组中，最后解锁；在使用迭代器遍历的时候，操作的
 *      都是原数组！
 */
public class ArrayList与LinkedList与Vector {
    public static void main(String[] args) {
        List<Integer> lists = Arrays.asList(1, 2, 3, 4, 5);//数组转列表
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        Integer[] integers= list.toArray(new Integer[4]);//列表转指定类型的数组
        for(Integer list1 : lists) {
            System.out.println(list1);
        }
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
