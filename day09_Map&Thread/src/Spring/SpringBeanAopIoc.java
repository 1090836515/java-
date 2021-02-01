package Spring;

/**
 * 1.spring Bean的生命周期：
 *      (1)spring实例化bean（new）。
 *      (2)然后Ioc注入，spring对实例化的bean进行配置。
 *      (3)执行实现BeanNameAware接口的setBeanName()方法。
 *      (4)执行实现了BeanFactory的setBeanFactory()方法。
 *      (5)执行实现了ApplicationContextAware接口的setApplicationContext()方法。
 *      (6)执行实现了BeanPostProcessor对应的方法。
 *      (7)执行init-method或者实现了InitializingBean接口的afterPropertiesSet初始化方法（后先执行）。
 *      (8)调用destory-method销毁方法。
 * 2.如果某个类实现了InitializingBean接口，会在类初始化完成后，并在setApplicationContext()方法执行完毕后，调用
 *      afterPropertiesSet()方法进行操作
 * 3.InitializingBean接口为bean提供了初始化方法的方式，它只包括afterPropertiesSet方法，凡是继承该接口的类，在初始化bean过程中执行该方法。
 * 4.BeanFactory在初始化容器时，并未实例化Bean，直到第一次访问某个Bean时才实例目标Bean；
 * 	    ApplicationContext ctx = new ClassPathXmlApplicationContext(xxx.xml),而ApplicationContext则在初始化应用上下文时就
 * 	    实例化所有单实例的Bean,调用getBean(beanName)返回Bean。
 * 5.applicationContext.getBeansOfType(EventHandler.class);//获取指定类型的所有JavaBean对象，使用BeanFatory
 *      的 getBeansOfType()方法，该方法返回一个Map类型的实例，Map中的key为Bean的名，key对应的内容为Bean的实例。
 * 6.控制反转（IoC），即上层控制下层，而不是下层控制着上层。我们用依赖注入（Dependency Injection）这种方式来实现控制反转。
 *      所谓依赖注入，就是把底层类作为参数传入上层类，实现上层类对下层类的“控制”。
 * 7.依赖倒置原则——把原本的高层建筑依赖底层建筑“倒置”过来，变成底层建筑依赖高层建筑。高层建筑决定需要什么，底层去实现这样的
 *      需求，但是高层并不用管底层是怎么实现的。这样就不会出现前面的“牵一发动全身”的情况。
 * 8.AOP:在运行时通过动态代理技术对方法进行了增强，添加了记录日志的功能;日志记录，性能监控，异常处理这样的非核心功能，单独被抽取出来，与业务代码分离，
 *      横切在核心业务代码之上。
 *          前置通知（before）：在目标方法执行之前执行;
 *          后置通知（after）:在目标方法执行之后执行;
 *          后置返回通知（after returning）:在目标方法返回之后执行，先执行后置通知再执行后置返回通知;
 *          异常通知(after throwing):在目标方法抛出异常时执行;
 *          环绕通知(around):在目标函数执行中执行
 */
public class SpringBeanAopIoc {
}
