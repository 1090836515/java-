package ObjectDemo01;

public class Person {
    String name;

    public void sayHello(String name){
        System.out.println(name+"你好，我是"+this.name);//this关键字解决重名问题
    }
}
