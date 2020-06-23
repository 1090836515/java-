package System;

import java.util.Arrays;

/**
 * 1.System.currentTimeMills() 获取当前程序执行时间
 * 2.System.arraycopy(src,0,dest,0,3); 将src的前3个元素复制到dest的前三个元素
 */
public class Demo01System {
    public static void main(String[] args){
        demo01();
        demo02();
    }

    private static void demo01(){
        long s=System.currentTimeMillis();
        for(int i=0;i<9999;i++){
            System.out.println(i);
        }
        long e=System.currentTimeMillis();
        System.out.println("耗时"+(e-s));
    }

    private static void demo02(){
        int[] src={1,2,3,4,5};
        int[] dest={6,7,8,9,10};
        System.out.println("复制前"+Arrays.toString(dest));
        System.arraycopy(src,0,dest,0,3);
        System.out.println("复制后"+Arrays.toString(dest));
    }
}
