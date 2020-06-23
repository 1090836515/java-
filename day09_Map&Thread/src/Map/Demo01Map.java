package Map;

import java.util.*;

/**
 * 1.Set<String> set=map.keySet();//将map集合中的所有key取出来，存储到一个Set集合中，可以通过迭代器或增强for循环进行遍历
 * 2.Map对象一创建，那么就会在Map集合中创建一个Entry对象，用来记录键与值
 * 3.entrySet():将Map对象中的所有Entry对象取出，存入Set集合中； getValue(),getKey()取出对应的值
 * 4.Map的key值必须为唯一，如果重复，后一个value值会覆盖前一个value值，要保证唯一，存储的value对象必须重写hashCode与equals方法,存取无序
 * 5.Hashtable单线程安全，不能存取null值，其他集合可以
 * 5.List,Map,Set接口可以使用of(元素一，元素二....)添加元素，不适用于接口的实现类，返回值是一个不能改变的集合，集合不能使用add等方法
 * 6.map.values();//把Map集合中的值存到Collection集合中，map.entrySet();//返回键值对的映射关系，map.keySet();//返回所有的键
 */
public class Demo01Map {
    public static void main(String[] args){
        keySet();
        entrySet();
    }

    public static void keySet(){
        Map<String,Integer> map=new HashMap<>();
        map.put("赵丽颖",168);
        map.put("杨颖",181);
        map.put("林志玲",178);
        //将map集合中的所有key取出来，存储到一个Set集合中
        Set<String> set=map.keySet();
        Collection<Integer> values = map.values();//把Map集合中的值存到Collection集合中

        Iterator<String> it=set.iterator();
        while (it.hasNext()){
            String key=it.next();
            Integer value=map.get(key);
            System.out.println(key+":"+value);
        }
        System.out.println("-----------------------");
        for(String key:map.keySet()){
            Integer value=map.get(key);
            System.out.println(key+":"+value);
        }
    }

    public static void entrySet(){
        Map<String,Integer> map=new HashMap<>();
        map.put("赵丽颖",168);
        map.put("杨颖",181);
        map.put("林志玲",178);
        Set<Map.Entry<String,Integer>> entries = map.entrySet();//返回键值对的映射关系
        Iterator<Map.Entry<String, Integer>> it = entries.iterator();
        while (it.hasNext()){
            Map.Entry<String,Integer> entry=it.next();
            String key=entry.getKey();
            Integer value=entry.getValue();
            System.out.println(key+":"+value);
        }
    }
}
