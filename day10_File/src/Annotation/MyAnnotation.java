package Annotation;

import java.lang.annotation.*;

/**
 * 定义自己的注解：本质就是一个接口，该接口默认继承java.lang.annotation.Annotation
 */
@Target(value={ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})//表示该注解可以作用于类上，方法上，成员变量上
@Retention(RetentionPolicy.RUNTIME)//表示会被保存到class字节码文件,并被JVM读取到
@Documented//将注解加到抽取的API文档中
@Inherited//表示注解会随类的继承而继承
public @interface MyAnnotation {

    int age();
    String name() default "张三";
}
