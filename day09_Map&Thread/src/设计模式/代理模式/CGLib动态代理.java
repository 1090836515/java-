package 设计模式.代理模式;

/**
 * 1.它的原理是对指定目标类生成一个子类，并覆盖其中方法实现增强，但因为采用的是继承，所以不能对final修饰的类进行代理。
 * 2.使用cglib实现动态代理，完全不受代理类必须实现接口的限制，而且cglib底层采用ASM字节码生成框架，使用字节码
 *      技术生成代理类，比使用java反射效率要高。
 * 3.定义了一个拦截器，在调用目标方法之前，cglib回调MethodInterceptor接口方法拦截，来实现自己的业务逻辑，类似
 *      于JDK中的InvocationHandler接口。
 * 4.CGLIB创建的动态代理对象比JDK创建的动态代理对象的性能更高，但是CGLIB创建代理对象时所花费的时间却比JDK多得多。
 *      所以对于单例的对象，因为无需频繁创建对象，用CGLIB合适，反之使用JDK方式要更为合适一些。
 * 5.CGLIB是基于继承机制,继承被代理类,所以方法不要声明为final,然后重写父类方法达到增强了类的作用.
 *      它底层是基于asm第三方框架,是对代理对象类的class文件加载进来,通过修改其字节码生成子类来处理.
 *      生成类的速度慢,但是后续执行类的操作时候很快.可以针对类和接口
 */
/*public class CGLib动态代理 implements MethodInterceptor{
    private Object target;
     public Object getInstance(final Object target) {
                 this.target = target;
                 Enhancer enhancer = new Enhancer();
                 enhancer.setSuperclass(this.target.getClass());
                 enhancer.setCallback(this);
                 return enhancer.create();
             }
             public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                 System.out.println("买房前准备");
                 Object result = methodProxy.invoke(object, args);
                 System.out.println("买房后装修");
                 return result;
             }
}*/
