/**
1.自动类型转换（隐式）
	1. 特点：代码不需要进行特殊处理，自动完成。
	2. 规则：数据范围从小到大。

2.强制类型转换
	1. 特点：代码需要进行特殊的格式处理，不能自动完成。
	2. 格式：范围小的类型 范围小的变量名 = (范围小的类型) 原本范围大的数据;
注意事项：
	1. 强制类型转换一般不推荐使用，因为有可能发生精度损失、数据溢出。
	2. byte/short/char这三种类型都可以发生数学运算，例如加法“+”.
	3. byte/short/char这三种类型在运算的时候，都会被首先提升成为int类型，然后再计算。
	4. boolean类型不能发生数据类型转换

 round() ：返回四舍五入，负 .5 小数返回较大整数，如 -1.5 返回 -1。
 ceil() ：返回小数所在两整数间的较大值，如 -1.5 返回 -1。
 floor() ：返回小数所在两整数间的较小值，如 -1.5 返回 -2。
 */
public class Demo01Math {
    public static void main(String[] args){
        byte num4 = 40; // 注意！右侧的数值大小不能超过左侧的类型范围
        short num6 = 60;
        // byte + short --> int + int --> int
        // int强制转换为short：注意必须保证逻辑上真实大小本来就没有超过short范围，否则会发生数据溢出
        short result2 = (short) (num4 + num6);

        System.out.println(Math.ceil(3.1));//向上取整4.0
        System.out.println(Math.floor(3.1));//向下取整3.0
        System.out.println(Math.round(-3.5));//四舍五入，不带小数点-3
        System.out.println(Math.PI);
    }
}
