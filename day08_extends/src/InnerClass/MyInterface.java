package InnerClass;
/**
 * class OuterFish {
* 	static class InnerFish {
* 	    }
 * }
 静态嵌套类，并没有对实例的共享关系，仅仅是代码块在外部类内部
 静态的含义是该内部类可以像其他静态成员一样，没有外部类对象时，也能够访问它
 静态嵌套类仅能访问外部类的静态成员和方法
 在静态方法中定义的内部类也是静态嵌套类，这时候不能在类前面加static关键字
 */
public interface MyInterface {
    void method();
}
