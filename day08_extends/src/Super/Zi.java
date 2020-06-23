package Super;

/**1.子类重写父类方法的返回值类型的范围必须小于或等于父类被重写方法的返回值范围
 * 2.子类重写父类方法的权限必须大于或等于父类被重写方法的返回值
 * 3.只有子类构造方法能调用父类构造方法，且必须在第一行，父类构造方法先执行，子类构造方法后执行
 * 4.本类的无参构造调用本类的有参构造,必须在第一行,写了这个，super（）语句不再默认附带
 */

public class Zi extends Fu{
    int num = 20;

    public void method() {
        int num = 30;
        System.out.println(num);
        System.out.println(this.num);//本类的成员变量
        System.out.println(super.num);//父类的成员变量
    }
    @Override
    public String fuMethod(){
        return "子类方法";
    }

    public Zi(){
        //super();//不写默认附带
        this(123);//
        System.out.println("子类构造方法执行");
    }

    public Zi(int n){
        //super();//不写默认附带
        System.out.println("子类构造方法执行n");
    }
}
