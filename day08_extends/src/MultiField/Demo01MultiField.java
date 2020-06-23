package MultiField;

/**
 * 1.直接通过对象名访问成员变量，看等号左边是谁，优先用谁，没有则往上找
 * 2.间接使用成员方法访问成员变量，看方法属于谁就用谁，否则向上找，子类没用覆盖重写就是父类，覆盖重写了就是子类，编译看左，运行看右
 */
public class Demo01MultiField {
    public static void main(String[] args){
        Fu obj=new Zi();
        System.out.println(obj.num);//10
        //System.out.println(obj.age);//错误写法
        System.out.println("===========");

        obj.showNum();//20
        //obj.methodZi();//错误写法，编译不通过,
    }
}
