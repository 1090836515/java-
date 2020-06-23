package Annotation;

/**
 * 1.JDK中预定义的一些注解:@Override	：检测被该注解标注的方法是否是继承自父类(接口)的;
 *  @Deprecated：该注解标注的内容，表示已过时; @SuppressWarnings：压制警告
 * 2.注解里的抽象方法是属性，只能返回基本数据类型,String类型,枚举,注解类型(void不行)
 * 3.定义自己的注解：本质就是一个接口，该接口默认继承java.lang.annotation.Annotation
 * 4.如果定义属性时,使用default给属性附加默认值,则使用注解时,可以不进行属性的赋值;如果只有一个属性需要赋值,且名称为value，则可以省略
 * 5.元注解：用于描述的注解：
 *           @Target:描述注解能够作用的位置
 * 				* ElementType取值：
 * 					* TYPE：可以作用于类上
 * 					* METHOD：可以作用于方法上
 * 					* FIELD：可以作用于成员变量上
 * 			* @Retention：描述注解被保留的阶段
 * 				* @Retention(RetentionPolicy.RUNTIME)：当前被描述的注解，会保留到class字节码文件中，并被JVM读取到
 * 			* @Documented：描述注解是否被抽取到api文档中
 * 			* @Inherited：描述注解是否被子类继承
 */
@SuppressWarnings("all")//压制所有警告
public class AnnotationDemo01 {
    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated//过时方法，不建议使用
    public void show1(){
        //有缺陷
    }

    @MyAnnotation(age=12)
    public void show2(){
        //有缺陷
    }

    public void demo(){
        show1();
    }
}
