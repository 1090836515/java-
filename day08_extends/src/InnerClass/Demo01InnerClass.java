package InnerClass;


public class Demo01InnerClass {
   public static void main(String[] args){
        Body body=new Body();
        body.methodBody();
        System.out.println("===============");
        //第二种使用内部类的方法
        Body.Heart heart=new Body().new Heart();
        heart.beat();
        body.methodOuter();
        System.out.println("=============");

        //使用匿名内部类
       MyInterface obj=new MyInterface() {
           @Override
           public void method() {
               System.out.println("匿名内部类使用了方法.....");
           }
       };
       obj.method();
       /*
       MyInterface obj=new MyInterface() {
           @Override
           public void method() {
               System.out.println("匿名内部类使用了方法.....");
           }
       }.method();
        */
   }
}
