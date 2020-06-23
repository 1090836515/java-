package ListSetIterator;

/**
 * 1.可变参数:add(int...arr) 底层是一个数组，参数数量不固定
 * 2.一个方法只能有一个可变参数，且必须放在末尾
 */
public class Demo01VarArgs {
    public static void main(String[] args){
         add(10,20,50);
    }

    public static int add(int...arr){
        System.out.println(arr.length);
        int sum=0;
        for(int i:arr){
            sum+=i;
        }
        System.out.println(sum);
        return 0;
    }
}
