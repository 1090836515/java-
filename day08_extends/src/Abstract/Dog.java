package Abstract;

public abstract class Dog extends Animal{
    //int a=20;
    @Override
    public void eat() {
        System.out.println("啃骨头"+a);
    }
    public Dog(){
        System.out.println("子类构造方法执行了...");
    }
}
