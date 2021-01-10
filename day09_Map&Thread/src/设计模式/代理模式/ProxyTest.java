package 设计模式.代理模式;

import org.junit.Test;

import java.lang.reflect.Proxy;
/**
 * 1.Class.forName("全类名")：将字节码文件加载进内存返回一个Class对象;
 * 2.已经加载的可以通过 类名.class获取Class类对象（BuyHouse.class）;
 * 3.new出对象后(Runntime)可以通过 类名.getClass()获取(在Object中定义)(buyHouse.getClass())
 */
public class ProxyTest {
    public static void main(String[] args) {
        BuyHouse buyHouse = new BuyHouseImpl();
        String name = buyHouse.getClass().getName();
        System.out.println(name);
    }

    @Test
    public void test1() {
        BuyHouse buyHouse = new BuyHouseImpl();
        BuyHouse buyHouseProxy = (BuyHouse) Proxy.newProxyInstance(buyHouse.getClass().getClassLoader(),
                buyHouse.getClass().getInterfaces(),
                new JDK动态代理(buyHouse));
        buyHouseProxy.buyHouse();
    }

    @Test
    public void test2() {
        /*BuyHouse buyHouse = new BuyHouseImpl();
        CGLib动态代理 cglib = new CGLib动态代理();
        BuyHouse buyHouseProxy = (BuyHouse) cglib.getInstance(buyHouse);
        buyHouseProxy.buyHouse();*/
    }
}
