package Reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 创建一个简单的框架，通过配置文件来创建需要的对象
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        Properties  prop=new Properties();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        prop.load(is);

        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");
        //加载进内存
        Class cls = Class.forName(className);
        //创建对象
        Object o = cls.newInstance();
        //执行方法
        Method method = cls.getMethod(methodName);
        method.invoke(o);

    }
}
