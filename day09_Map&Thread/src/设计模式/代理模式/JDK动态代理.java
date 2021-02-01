package 设计模式.代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 1.有两个重要的接口和类。一个是接口InvoactionHandler，一个是类Proxy，这一个类和一个接口是实现JDK动态代理所必须用到的。
 * 2.JDK是基于反射机制,生成一个实现代理接口的匿名类,然后重写方法,实现方法的增强.它生成类的速度很快,但是运行时因为是基于反射,调用后续的类操作会很慢，
 *      而且他是只能针对接口编程的，没有实现接口的类不能用.
 */
public class JDK动态代理 implements InvocationHandler {
    private Object object;

    public  JDK动态代理(final Object object) {
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("买房前准备");
        Object result = method.invoke(object, args);
        System.out.println("买房后装修");
        return result;
    }
}
