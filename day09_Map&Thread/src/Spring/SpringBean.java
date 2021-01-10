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
 */
public class SpringBean {
}
