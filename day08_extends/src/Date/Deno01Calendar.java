package Date;

import java.util.Calendar;
import java.util.Date;

/**
 * 1.Calendar是一个抽象类，无法直接创建对象，需要通过getInstance()方法获得
 * 2.get(int field) 获取指定字段的值
 * 3.set(int field,int value) 设定指定字段为指定的值
 * 4.add(int field,int amount) 指定字段的值进行增加或减少
 * 5.getTime() 把日历转化为日期
 */
public class Deno01Calendar {
    public static void main(String[] args){
        Calendar c=Calendar.getInstance();
        System.out.println(c);
        demo();

    }

    private static void demo(){
        Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DATE);
        System.out.println(year+"年"+month+"月"+day+"日");
        c.set(Calendar.YEAR,2018);
        year=c.get(Calendar.YEAR);
        System.out.println(year+"年"+month+"月"+day+"日");
        c.add(Calendar.YEAR,1);
        year=c.get(Calendar.YEAR);
        System.out.println(year+"年"+month+"月"+day+"日");
        Date date=c.getTime();
        System.out.println(date);
    }
}
