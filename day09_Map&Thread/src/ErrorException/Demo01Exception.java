package ErrorException;

import java.util.Stack;

/**
 * Throwable下继承了Error与Exception两个子类，Error属于严重的错误，程序不能处理；Exception错误程序可以处理（编译期异常）
 * 2.Exception：编译期异常
 *       RunException:运行异常
 * 3.将异常抛出（throws）是给虚拟机处理，而虚拟机处理异常的方式通常是中断处理，后续代码不执行；而通过try catch方式后续代码（try之外的代码）也会正常执行
 * 4.throw new xxxException：抛出指定的异常.必须定义在方法内部；对象必须是Exception或其子类；必须处理这个对象（RuntimeException或其子类除外,不用处理，会默认交给JVM处理）；
 * 5.若try中没有异常，catch里的代码就不会执行
 * 6.Throwable中定义了String getMessage(),String toString(),void printStackTrace()三个方法，越往后信息越全面
 * 7.如果finally中有return语句，try中也有，那返回的值是finally中的值
 * 8.父类方法没有抛出异常，那子类重写方法出现异常只能捕获处理，不能抛出
 * 9.自定义异常必须继承Exception或RuntimeException
 * 10.throw:
 *      表示方法内抛出某种异常对象(只能是一个)
 *      用于程序员自行产生并抛出异常
 *      位于方法体内部，可以作为单独语句使用
 *      如果异常对象是非 RuntimeException 则需要在方法申明时加上该异常的抛出，即需要加上 throws 语句 或者 在方法体内 try catch 处理该异常，否则编译报错
 *      执行到 throw 语句则后面的语句块不再执行
 */
public class Demo01Exception {

    public static void main(String[] args){
        String a="}";
        System.out.println(addBinary(a));

    }
    private static boolean addBinary(String a) {
        Stack<Character> s=new Stack<>();
        for(int i=0;i<a.length();i++){
            char c=a.charAt(i);
            switch (c){
                case '[':s.push('[');break;
                case '{':s.push('{');break;
                case '(':s.push('(');break;
                case ']':if(!s.empty()&&s.peek()=='['){ s.pop();break;} else {return false;}
                case '}':if(!s.empty()&&s.peek()=='{') {s.pop();break;} else {return false;}
                case ')':if(!s.empty()&&s.peek()=='(') {s.pop();break;} else {return false;}
            }
        }
        if(s.empty()){
            return true;
        }
            return false;
    }
}
