package ObjectDemo01;

/**
 * 1.堆（Heap）:凡是new出来的,都在堆内存当中
 * 2.方法区（Method Area）：存储.class相关信息，包含方法信息
 * 3.两个方法在堆内存保存的地址是同一个
 * 4.调用方法时方法进栈，调用完了后出栈
 * 5.成员变量有默认值，局部变量没有默认值，需要赋值才能使用
 * 6.成员变量位于堆内存当中，局部变量位于栈内存当中
 */
public class objectDemo01 {
    public static void main(String[] args){
        Phone phone1=new Phone();
        Phone phone2=new Phone();
        System.out.println(phone1.brand);//null
        System.out.println(phone1.price);//0.0
        phone1.call("乔布斯");
        System.out.println(phone2.brand);//null
        System.out.println(phone2.price);//0.0
        phone2.call("马云");
    }
}
