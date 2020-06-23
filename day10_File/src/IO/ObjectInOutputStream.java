package IO;

import java.io.*;

/**
 * 1.序列化：把对象以流的的方式写入到文件保存; 反序列化：把文件中保存的对象读出来
 * 2.对象需要实现序列化接口才能启动序列化功能
 * 3.static，transient关键字修饰的成员变量不能被序列化
 * 4.实现序列化接口的类若没有声明serialVersionUID，那每次类的重新修改都会添加一个新的序列号
 * 5.某个类可以被序列化，则其子类也可以被序列化
 * 6.对象中的某个属性是对象类型，需要序列化也必须实现 Serializable 接口
 * 7.声明为 static 和 transient 的成员变量，不能被序列化。static 成员变量是描述类级别的属性，transient 表示临时数据
 * 8.反序列化读取序列化对象的顺序要保持一致
 */
public class ObjectInOutputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //ObjectOutputStream();
        ObjectInputStream();
    }

    public static void ObjectOutputStream() throws IOException {
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("day10_File\\person.txt"));
        oos.writeObject(new Person("小美女",18));
        oos.close();
    }

    public static void ObjectInputStream() throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("day10_File\\person.txt"));
        Object person = ois.readObject();
        System.out.println(person);
        ois.close();
    }
}
