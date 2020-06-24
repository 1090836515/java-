package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 1.Stream流是JDK1.8之后出现的,获取Stream有两种方式：a.所有Collection集合都可以通过stream()方法获取流; b.可以通过Stream类的静态方法of获取数组对应的流
 * 2.forEach是Stream流的终结方法，用了之后就不能继续调用别的方法,Stream流属于管道流,只能被消费(使用)一次,第一个Stream流调用完毕方法,数据就会流转到下一个Stream上
 * 3.Stream<T> filter(Predicate<? super T> predicate):filter方法的参数Predicate是一个函数式接口,所以可以传递Lambda表达式,对数据进行过滤
 * 4.如果需要将流中的元素映射到另一个流中，可以使用map方法,该接口需要一个Function函数式接口参数，可以将当前流中的T类型数据转换为另一种R类型的流
 * 5.count方法是一个终结方法,返回值是一个long类型的整数,用于统计Stream流中元素的个数;使用limit对Stream流中的元素进行截取,只要前3个元素
 * stream.skip(3)//使用skip方法跳过前3个元素;Stream流中的静态方法concat:用于把两个流组合到一起
 */
public class Demo01Stream {
    public static void main(String[] args) {
        //stream01();
        //foreach01();
        //filter01();
        //map01();
        limit01();
        //concat01();
    }

    public static void stream01(){
        //创建一个List集合,存储姓名
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        /*List<String> listA=new ArrayList<>();
        for(String s:list){
            if(s.startsWith("张")){
                listA.add(s);
            }
        }

        //对listA集合进行过滤,只要姓名长度为3的人,存储到一个新集合中
        List<String> listB = new ArrayList<>();
        for (String s : listA) {
            if(s.length()==3){
                listB.add(s);
            }
        }

        //遍历listB集合
        for (String s : listB) {
            System.out.println(s);
        }*/

        //使用Stream流的方式优化
        list.stream()
                .filter(name->name.startsWith("张"))
                .filter(name->name.length()==3)
                .forEach(name->System.out.println(name));

        //把数组转化为Stream流
        Integer[] arr={1,2,3,4,5};
        Stream<Integer> arr1 = Stream.of(arr);
        Stream<Integer> arr2 = Stream.of(1, 2, 3, 4, 5,6);
    }

    public static void foreach01(){
        Stream<String> stream = Stream.of("张三", "李四", "王五", "赵六", "田七");
        stream.forEach(name->System.out.println(name));
    }

    public static void filter01(){
        Stream<String> stream = Stream.of("张三丰", "张翠山", "赵敏", "周芷若", "张无忌");
        Stream<String> stream1 = stream.filter(name -> name.startsWith("张"));
        stream1.forEach(name->System.out.println(name));
    }

    public static void map01(){
            //获取一个String类型的Stream流
            Stream<String> stream = Stream.of("1", "2", "3", "4");
            //使用map方法,把字符串类型的整数,转换(映射)为Integer类型的整数
            Stream<Integer> stream1 = stream.map((String name) -> {
                return Integer.parseInt(name);
            });
            //System.out.println(stream1.count());

            stream1.forEach(name -> System.out.println(name));
    }

    public static void limit01(){
        String[] arr = {"美羊羊","喜洋洋","懒洋洋","灰太狼","红太狼"};
        Stream<String> stream = Stream.of(arr);
        Stream<String> stream1 = stream.limit(3);
        stream1.forEach(name->System.out.println(name));
    }

    public static void concat01(){
        //创建一个Stream流
        Stream<String> stream1 = Stream.of("张三丰", "张翠山", "赵敏", "周芷若", "张无忌");
        //获取一个Stream流
        String[] arr = {"美羊羊","喜洋洋","懒洋洋","灰太狼","红太狼"};
        Stream<String> stream2 = Stream.of(arr);
        Stream<String> concat = Stream.concat(stream1, stream2);
        concat.forEach(name->System.out.println(name));
    }

}
