package Interface;

public class Demo01Interface {
    public static void main(String[] args){
        MyInterfaceAbstract a=new MyInterfaceAbstractImpl();
        a.methodAbs1();
        a.methodDefault();
        MyInterfaceAbstract.methodStatic();
    }
}
