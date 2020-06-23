package Annotation;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 创建一个简单的框架，通过配置文件来创建需要的对象
 */
@Pro(className = "Annotation.Demo1",methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //解析注解
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        //获取上边的注解对象
        Pro annotation = reflectTestClass.getAnnotation(Pro.class);//其实就是内存中生成了一个该注解接口子类的实现对象
        String className = annotation.className();
        String methodName = annotation.methodName();


        //加载进内存
        Class cls = Class.forName(className);
        //创建对象
        Object o = cls.newInstance();
        //执行方法
        Method method = cls.getMethod(methodName);
        method.invoke(o);

    }
}
