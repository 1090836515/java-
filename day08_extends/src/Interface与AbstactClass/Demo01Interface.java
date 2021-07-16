package Interface与AbstactClass;

/**
 * 1.在java开发中90%使用的都是接口，抽象类往往只是实现一个过渡。抽象类定义的抽象方法与接口定义的方法有点不同，抽象类定义的方法父类不要求子类强制覆写，
 *      接口定义的方法，其实现子类必须覆写。
 * 2.接口与抽象类的选择：如果你拥有一些方法并且想让它们中的一些有默认实现，那么使用抽象类。
 *      如果你想实现多重继承，那么你必须使用接口。由于Java不支持多继承，子类不能够继承多个类，但可以实现多个接口。因此你就可以使用接口来解决它。
 *      如果基本功能在不断改变，那么就需要使用抽象类。如果不断改变基本功能并且使用接口，那么就需要改变所有实现了该接口的类。
 */
public class Demo01Interface {
    public static void main(String[] args){
        MyInterfaceAbstract a=new MyInterfaceAbstractImpl();
        a.methodAbs1();
        a.methodDefault();
        MyInterfaceAbstract.methodStatic();
    }
}
