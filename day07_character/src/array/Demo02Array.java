package array;

import java.util.Arrays;

/**
 * 如果sort的对象是自定义的类型，那么这个自定义的类型要有Comparable或者Comparator接口的支持
 * Arrays.toString(数组) 用来以String类型输出数组，直接输出 数组.toString()会打印出地址
 */
public class Demo02Array {
    public static void main(String[] args){
        int[] intArray={2,1,3,10,6};
        Arrays.sort(intArray);//Arrays的静态方法
        System.out.println(intArray);
        System.out.println(Arrays.toString(intArray));




    }

}
