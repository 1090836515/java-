package Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1.对于集合遍历过程中删除元素会导致抛出异常，对集合使用for循环本质上是使用Iterator迭代器进行迭代，在ArrayList中，它的修改操作(add/remove)
 *      都会对modCount这个字段+1，modCount可以看作一个版本号，每次集合中的元素被修改后，都会+1(即使溢出)。
 * 2.在Iterator内部类中，有一个字段expectedModCount ，初始化时等于modCount，即当我们调用list.iterator()返回迭代器时，该字段被初始化为
 *      等于modCount。在类Itr中next/remove方法都有调用checkForComodification()方法，在该方法中检测modCount == expectedModCount，
 *      如果不相当则抛出异常ConcurrentModificationException。
 * 3.前面说过，在集合的修改操作(add/remove)中，都对modCount进行了+1。在迭代过程中，执行list.remove(val)，使得modCount+1，当下一次循环时，
 *      执行 it.next()，next()方法中会执行checkForComodification方法发现modCount != expectedModCount，则抛出异常。只有使用迭代器的
 *      remove方法才会修改expectedModCount的值
 */
public class Iterator迭代器 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        list.add(15);
        /*for (Integer i : list) {
            if (i == 5) {
                list.remove(i);
            }
        }*/
        Iterator<Integer> it= list.iterator();
        while(it.hasNext()) {
            int i = it.next();
            if (i == 5) {
                it.remove();
            }
        }
    }

}
