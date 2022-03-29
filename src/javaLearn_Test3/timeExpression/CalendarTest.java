package timeExpression;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Calendar类的初始化，时间的加减，获取日期，设置日期
 */
public class CalendarTest {
    public static void main(String[] args) {
        //Calendar时间类的使用方法
        Calendar instance = Calendar.getInstance();//创建一个Calendar类的实例，默认为当前时间
        instance.add(Calendar.DATE,7);//当前时间加7天
        int i = instance.get(Calendar.DATE);//获取当前的日期
        System.out.println(i);//打印日期

        //设置时期时间，并输出
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        instance.set(2022,3,19);
        System.out.println(instance.get(Calendar.YEAR)
                +"-"+instance.get(Calendar.MONTH)
                +"-"+instance.get(Calendar.DATE));
    }
}
