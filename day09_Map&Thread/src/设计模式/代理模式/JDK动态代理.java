package 设计模式.代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 1.JDK动态代理需要类实现一个接口，没有实现接口的类不适用
 * 2.有两个重要的接口和类。一个是接口InvoactionHandler，一个是类Proxy，这一个类和一个接口是实现JDK动态代理所必须用到的。
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
