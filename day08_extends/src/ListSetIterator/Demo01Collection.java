package ListSetIterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 1.vector,ArrayList,Linkedlist继承List接口,vector是单线程的，速度很慢;  TreeSet,HashSet,LinkedHashSet继承Set接口;
 * List,Set都继承于Collection接口; Collection继承Iterable<E>，继承这个接口的都可以使用增强for循环foreach
 * 2.list接口特点：  有序的集合;  允许存取重复的元素;  有索引，可以使用for循环进行遍历
 * 3.Set特点：不允许存储重复元素;  没有索引，不可以使用for循环进行遍历(LinkedhashSet是有序的集合)
 * 4.ArrayList:底层数组实现，查询快，增删慢; LinkedList:底层链表实现，查询慢，增删快
 * 5.HashSet:底层哈希表+红黑树实现，无索引，不可以存出重复元素，存储无序; LinkedHashSet:底层哈希表+链表实现，无索引，不可以存出重复元素，存储有序;
 * TreeSet:底层二叉树实现,一般用于排序
 * 6.      //接口               //实现类对象
 *         Iterator<String> it=coll.iterator();//取出集合的通用方法
 * 7.使用HashSet存储自定义类型要保证元素不重复，就必须重写equals和hashCode方法
 * 8.LinkedList实现了Deque与List的接口，Deque继承Queue,是双端队列
 *
 */
public class Demo01Collection {
    public static void main(String[] args){
        Collection<String> coll=new ArrayList<>();
        coll.add("hello");//添加元素
        coll.add("world");
        boolean result=coll.contains("hello");
        System.out.println(result);
        coll.clear();//清空
        System.out.println(coll.isEmpty());

        Object[] arr=coll.toArray();//将集合转化为数组
        System.out.println("=========================");
        iterator();
    }

    private static void iterator(){
        Collection<String> coll=new ArrayList<>();
        coll.add("hello");//添加元素
        coll.add("world");
        coll.add("hello");//添加元素
        coll.add("world");
        //接口                    //实现类对象
        Iterator<String> it=coll.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
