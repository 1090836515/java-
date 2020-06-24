package Reflect;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 1.Class.forName("全类名")：将字节码文件加载进内存返回一个Class对象; 已经加载的可以通过 类名.class获取Class类对象;
 *  new出对象后(Runntime)可以通过 类名.getClass()获取(在Object中定义)
 *  2.反射：将类的各个组成部分封装为其他对象,Method,Field,Constructor,可以在程序运行的过程中操作这些对象
 *  3.getFields(),getField();//只能获取public修饰的成员变量;  getDeclaredFields()：获取所有的成员变量，不考虑修饰符
 *  4.(Field)d.setAccessiable(true);//暴力反射,忽略访问权限修饰符的安全检查.强行获取私有成员变量
 *  5.getDeclaredFields(): 获取所有本类自己声明的属性, 不能获取父类和实现的接口中的属性
 * getFields(): 只能获取所有 public 声明的属性, 包括获取父类和实现的接口中的属性
 */
public class ReflectDemo01 {
    public static void main(String[] args) throws Exception {
        //class01();
        //field01();
        //constructor01();
        method01();
    }

    public static void class01() throws ClassNotFoundException {
        //多用于配置文件
        Class cls1 = Class.forName("Reflect.Person");
        System.out.println(cls1);

        //多用于参数的传递
        Class<Person> cls2 = Person.class;
        System.out.println(cls2);

        //多用于对象的获取字节码的方式
        Person person = new Person();
        Class cls3 = person.getClass();
        System.out.println(cls3);

        System.out.println(cls1==cls2);
    }

    public static void field01() throws Exception {
        Class personClass = Person.class;
        Field[] fields = personClass.getFields();//只能获取public修饰的成员变量
        for (Field field:fields){
            System.out.println(field);
        }

        System.out.println("----------");
        Field a = personClass.getField("a");
        //获取a的值
        Person p=new Person();
        Object value = a.get(p);
        System.out.println(value);
        //设置a的值
        a.set(p,"张三");
        System.out.println(p);

        //Field[] getDeclaredFields()：获取所有的成员变量，不考虑修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        //Field getDeclaredField(String name)
        Field d = personClass.getDeclaredField("d");
        //忽略访问权限修饰符的安全检查
        d.setAccessible(true);//暴力反射
        Object value2 = d.get(p);
        System.out.println(value2);
    }

    public static void constructor01() throws Exception{
        Class personClass = Person.class;
        //获取带参数的构造器创建对象
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        Object person = constructor.newInstance("张三", 23);
        System.out.println(person);
        System.out.println("------------------");

        //使用空参构造器创建对象
        Object person2 = personClass.newInstance();
    }

    public static void method01() throws Exception{
        Class personClass = Person.class;

        Method eat1 = personClass.getMethod("eat");
        //执行方法
        Person p=new Person();
        eat1.invoke(p);

        //获取带参的方法
        Method eat2 = personClass.getMethod("eat", String.class);
        String name = eat2.getName();
        System.out.println(name);
        eat2.invoke(p,"饭");
    }
}
