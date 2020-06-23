package Thread;

public class Demo01Sleep {
    public static void main(String[] args){
        for (int i=0;i<10;i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);//1秒钟打印一次
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
