package FanXing;

/**
 * 1.使用泛型可以在new出具体对象后再指定参数类型，更加灵活
 * 2.类是抽象的，不占用内存；对象是具体的，占用存储空间
 * @param <T>
 */
public class MyClass<T> {

    public void print(T t){
        System.out.println(t);
    }
}
