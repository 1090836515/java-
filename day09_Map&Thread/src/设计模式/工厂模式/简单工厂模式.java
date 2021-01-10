package 设计模式.工厂模式;

/**
 * 1。有一个统一的工厂类，通过传入一个字符串shape,然后通过shape.equalsIgnoreCase("...")比较找出是要创建哪一个对象，
 *      然后new一个对应的对象返回。
 * 2.这样的实现有个问题，如果我们新增产品类的话，就需要修改工厂类中的getShape（）方法，这很明显不符合 开放-封闭原则
 * 3.通过反射可以进行改善,通过obj = Class.forName(shape.getName()).newInstance();创建对象，传入一个需要
 *      创建的Class类对象（UserDao.class）
 */
public class 简单工厂模式 {
}
