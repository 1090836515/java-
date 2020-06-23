package APIDemo02;

import java.util.Random;

public class Demo01Random {
    public static void main(String[] args){
        Random random=new Random();
        int num1=random.nextInt();//随机一个数，正负都有
        int num2=random.nextInt(10);//[0,10)之间的随机整数
        System.out.println("随机数值"+num1);
    }
}
