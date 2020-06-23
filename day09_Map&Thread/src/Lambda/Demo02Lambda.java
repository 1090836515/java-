package Lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Demo02Lambda {
    public static void main(String[] args){
        Person[] arr={
                new Person("刘岩",38),
                new Person("王刚",45),
                new Person("杨幂",20)
        };
        /*
        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        */

        //使用Lambda表达式
        Arrays.sort(arr, (Person o1, Person o2) ->{
                return o1.getAge()-o2.getAge();

        });
        for(Person p:arr){
            System.out.println(p);
        }
    }


}
