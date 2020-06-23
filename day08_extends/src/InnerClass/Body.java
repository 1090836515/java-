package InnerClass;
/**
 * 1.内部类可以随意访问外部类，外部类访问内部类需要内部类对象
 * 2.局部内部类：只有当前所属的方法才能使用它，除了这个方法就不能用了,修饰符什么都不能写，局部变量不能变
 * 3.匿名内部类：如果接口的实现类或者父类的子类只需要使用一次
 * 4.Static Nested Class是被声明为静态（static）的内部类，它可以不依赖于外部类实例被实例化。而通常的内部类需要在外部类实例化后才能实例化
 * 5.内部类声明成静态的，就不能随便的访问外部类的成员变量了，此时内部类只能访问外部类的静态成员变量
 *
 * extends与implements的不同
 *
 * 1、在类的声明中，通过关键字extends来创建一个类的子类。
 *
 * 一个类通过关键字implements声明自己使用一个或者多个接口。
 *
 * extends 是继承某个类, 继承之后可以使用父类的方法, 也可以重写父类的方法;
 *
 * implements 是实现多个接口, 接口的方法一般为空的, 必须重写才能使用
 *
 * 2、extends是继承父类，只要那个类不是声明为final或者那个类定义为abstract的就能继承
 *
 * Java中不支持多重继承，但是可以用接口 来实现，这样就要用到implements，继承只能继承一个类，
 *
 * 但implements可以实现多个接口，用逗号分开就行了 比如 ：
 *
 * class A extends B implements C,D,E
 *
 * 接口实现的注意点：
 *
 * a.实现一个接口就是要实现该接口的所有的方法(抽象类除外)。
 *
 * b.接口中的方法都是抽象的。
 *
 * c.多个无关的类可以实现同一个接口，一个类可以实现多个无关的接口。
 */
public class Body {
    int num=10;//外部类的成员变量
    private String name;

    public void methodBody(){
        System.out.println("外部类的方法");
        //外部类访问内部类
        Heart heart=new Heart();
        heart.beat();
    }

    //成员内部类
    public class Heart{
        int num=20;//内部类的成员变量
        //内部类的方法
        public void beat(){
            System.out.println("内部类的方法");
            System.out.println("我叫："+name);
        }
        public void methodInner(){
            int num=30;//内部类方法的局部变量
            System.out.println(num);
            System.out.println(this.num);//内部类的成员变量
            System.out.println(Body.this.num);//外部类的成员变量
        }
    }

    public void methodOuter(){
        class Inner{//局部内部类
            int num=10;
            public void methodInner(){
                System.out.println(num);//10
            }
        }
        Inner inner=new Inner();
        inner.methodInner();
    }
}
