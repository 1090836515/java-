package Abstract;

public class Dog2Ha extends Dog {
    @Override
    public void sleep() {
        System.out.println("Dog2Ha呼呼呼。。。"+a);
    }
    public Dog2Ha(){
        System.out.println("子子类构造方法执行了....");
    }
}
