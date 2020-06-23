package Lambda;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * 1.Lambda表达式由三部分组成：a.一些参数;b.一个箭头,将前面的参数传给方法体{};c.一段代码
 * 2.可推导的内容，就可以省略
 * 3.使用前提：必须有接口，且接口中有且只有一个抽象方法，具有上下文推断
 */
public class Demo01Lambda {
    public static void main(String[] args){
        //使用匿名内部类
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"新线程创建了");
            }
        }.start();

        //使用Lambda表达式实现多线程
        new Thread(()-> {
            System.out.println(Thread.currentThread().getName() + "新线程创建了");
        }
            ).start();

        invokeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("吃饭了");
            }
        });

        invokeCook(()->{
                System.out.println("吃饭了");
            }
        );

        }

        public static void invokeCook(Cook cook){
            cook.makeFood();
        }
}
