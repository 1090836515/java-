package Abstract;

public class DemoMain {
    public static void main(String[] args){
        Dog2Ha ha=new Dog2Ha();
        ha.sleep();
        Dog dog=new Dog() {
            @Override
            public void sleep() {
                System.out.println("dog睡觉....");
            }
        };
        dog.eat();
    }
}
