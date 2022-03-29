package timeExpression;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义格式化时期对象
 */
public class DateTest {
    public static void main(String[] args) {
        Date today=new Date();//初始化时间（为当前默认时间）
        SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//创造自定义格式化时期的对象实例
        System.out.println(today.toString());//tostring方法打印时间
        System.out.println("当前时间为："+ft.format(today));
    }
}
