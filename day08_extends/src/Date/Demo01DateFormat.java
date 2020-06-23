package Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 1.String format(Date date)  按照指定的格式，将Date日期转化为符合模式的字符串
 * 2.Date parse(String source)  把符合模式的字符串，解析为DateFormat的子类,会抛出一个ParseException异常
 */
public class Demo01DateFormat {
    public static void main(String[] args) throws ParseException{
        format();
        parse();
    }

    private static void format(){
        DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        String format = sdf.format(date);
        System.out.println(date);
        System.out.println(format);
    }

    private static void parse() throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH点mm分ss秒");
        Date date=sdf.parse("2018年05月07日 20点01分01秒");
        System.out.println(date);
    }
}
