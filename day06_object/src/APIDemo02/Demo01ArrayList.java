package APIDemo02;

import java.util.ArrayList;

/**
 * 1.数组也可以存放对象，缺点是一旦创建出来，长度固定,而ArrayList长度不固定
 * 2.<E>代表泛型，代表全都是统一的类型，泛型只能是引用类型，不能是基本类型
 * 3.ArrayList不能存基本数据类型,只能存引用类型
 */
public class Demo01ArrayList {
    public static void main(String[] args){
        Person[] array=new Person[3];
        ArrayList<String> list=new ArrayList<>();
        //ArrayList<int> list=new ArrayList<>()//ArrayList不能存基本数据类型
        list.add("赵丽颖");
        list.add("赵又廷");
        list.add("李小璐");
        list.add("贾乃亮");
        System.out.println(list);
        String name=list.get(2);
        System.out.println("第二号索引位置:"+name);
        String whoRemove=list.remove(3);
        System.out.println("被删除的人是:"+whoRemove);
        int size=list.size();
        System.out.println("集合的长度是:"+size);
        test();
    }

    public static void test(){
        ArrayList<Integer> list=new ArrayList<>();//存放int类型
        list.add(100);
        list.add(200);
        int num=list.get(0);
        System.out.println("存放的int类型数字是:"+num);
    }
}
