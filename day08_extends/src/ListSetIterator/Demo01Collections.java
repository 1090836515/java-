package ListSetIterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * 1.Collections.addAll(list,"a","b","c");//往集合中添加多个元素
 * 2.Collections.shuffle(list);//打乱集合元素的顺序
 * 3.sort() 自定义规则进行排序，默认升序，Arrays的sort()方法对象也需要，被排序元素必须实现Comparable接口重写comparableTo方法,String类已经重写了，或者通过Comparator<T>()对象
 */
public class Demo01Collections {
    public static void main(String[] args){
        ArrayList<String> list=new ArrayList<>();
        Collections.addAll(list,"a","b","c","e","d");//往集合中添加多个元素
        Collections.shuffle(list);//打乱集合元素的顺序
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        System.out.println("================");
        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        Collections.sort(list1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 01-02;//按降序排序，反之就升序
            }
        });
        System.out.println(list1);
    }
}
