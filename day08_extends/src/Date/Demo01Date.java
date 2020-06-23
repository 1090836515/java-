package Date;

import java.util.Date;

public class Demo01Date {
    public static void main(String[] args){
        System.out.println(System.currentTimeMillis());//获取当前系统时间到1970年1月1日经历了多少毫秒
        System.out.println(new Date());//获取当前系统的时间
        Date d1=new Date(12545525L);//把毫秒值转化为日期
        long time=d1.getTime();//把日期转化为毫秒
        System.out.println(d1);
        System.out.println(time);
    }
}
