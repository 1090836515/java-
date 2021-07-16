package toStringEquals;

/**
 * 1.字符串效果上相当于char[]字符数组，但是底层原理是byte[]字节数组
 * 2.程序当中直接写的双引号字符串，就在字符串常量池中,常量池存在堆当中，其中存放了字节数组的地址
 * 3.char charAt(int index):获取指定索引位置的字符,
 * String subString(int begin,int end):截取字符串，originStr.substring(1)表示把originStr这个字符串的索引为1及之后的字符（也就是originStr字符串
 * 的第二个字符以后的子串，即"23456"）拿出来
 * byte[] getBytes[]:将字符串转换成字节数组,
 * replace(charSequence oldString,CharSequence newString):将所有老的字符串替换为新的字符串
 * String[] split(String regex):按照参数的规则，将字符串分割为若干份,split的参数是一个正则表达式
 * ToCharArray():String转化为char[]
 * public String replace(CharSequence target, CharSequence replacement);public String replace(char oldChar, char newChar)
 * replaceAll方法：基于正则表达式的字符串替换
 * 4.String : final 修饰，String 类的方法都是返回 new String。即对 String 对象的任何改变都不影响到原对象，对字符串的修改操作都会生成新的对象。
 * 5.StringBuffer : 对字符串的操作的方法都加了synchronized，保证线程安全。
 * StringBuilder : 不保证线程安全，在方法体内需要进行字符串的修改操作，可以 new StringBuilder 对象，调用 StringBuilder 对象的 append()、replace()、delete() 等方法修改字符串。
 * 6.Java 编译器对字符串常量直接相加的表达式进行优化，不等到运行期去进行加法运算，在编译时就去掉了加号，直接将其编译成一个这些常量相连的结果
 */
public class Demo01String {
    public static void main(String[] args){
        /*String str1=new String();//空参构造，不含内容

        char[] charArray={'a','b','c'};
        String str2=new String(charArray);//根据字符数组创建
        System.out.println(str2);
        System.out.println("===========");

        byte[] bytes={97,98,99};
        String str3=new String(bytes);//根据字节数组创建
        System.out.println(str3);
        System.out.println("===========");

        String str4="abc";
        String str5="abc";
        System.out.println(str2==str3);//false
        System.out.println(str3==str4);//false
        System.out.println(str4==str5);//true
        String str6=null;
        System.out.println("abc".equals(str6));//推荐
        //System.out.println("abc".equals(str6));//会出现空指针异常
        System.out.println("===========");

        String str7=str2.concat(str3);//创建了一个新的字符串
        System.out.println(str7);
        int index=str7.indexOf("b");
        System.out.println(index);
        char s=str7.charAt(4);
        System.out.println(s);
        System.out.println(str7==str2);
        System.out.println(str7.substring(1,4));
        System.out.println("========");

        String str8="aaa";
        str8="ccc";//地址变了，但没创建新的字符串
        String str9=str7.replace('a','*');
        System.out.println(str9);
        System.out.println("========");

        String str10="aaa.bbb.ccc";
        String[] array1=str10.split("\\.");
        for (int i=0;i<array1.length;i++){
            System.out.println(array1[i]);
        }*/

        /*String a = "hello2";
        String b = "hello";
        String c = b + "2";
        String d = "hello2";
        System.out.println(c);
        System.out.println(a == c);
        System.out.println(a == d);*/

        char[] s = {'1', '2', '3'};
        s[0] = '5';
        char[] r = {'a', 'b', 'c'};
        s = r;
        System.out.println(s);

    }
}
