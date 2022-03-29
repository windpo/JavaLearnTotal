package regularExperssion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式练习
 */
public class RegExp12_exercise {
    public static void main(String[] args) {
        /**
         * 1、验证电子邮件是否合法：
         *      （1）、只能有一个@
         *      （2）、@前面是用户名，可以是a-z A-Z 0-9 _-字符
         *      （3）、@后面是域名，并且域名只能是英文字母，比如sohu.com 或者tsinghua.org.cn
         */
        String content1="29-_2asd149@tsinghua.org.cn";
        String regStr1="^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$";
        //注：matches方法为整体匹配，不用添加^$定位符
        if (content1.matches(regStr1)) {
            System.out.println("合法");
        }
        else {
            System.out.println("不合法");
        }
        /**
         * 2、验证是不是整数或者小数
         *  注：此题要考虑正数和负数
         *  如：123 -345 34.89 -87.9 -0.01 0.45等
         *  特殊情况如：  0开头：    0.89
         *             非零数字开头   0023.9--->23.9
         *             正号开头：    +1.36
         */
        String content2="+0.23";
        String regStr2="^[+-]?([1-9]\\d*|0)(\\.\\d+)?$";
        if (content2.matches(regStr2)) {
            System.out.println("验证成功");
        }
        else {
            System.out.println("验证失败");
        }
        /**
         * 3、对一个url进行解析
         * 如：http://www.sohu.com:8080/abc/index.html
         *  （1）、要求得到协议是什么  http
         *  （2）、域名  www.sohu.com
         *  （3）、端口是什么 8080
         *  （4）、文件名是什么 index.html
         */
        //法一：分割字符串得到
        String content3="http://www.sohu.com:8080/abc/index.html";
        String regStr3="(://)|:|/(.+/)?";
        String[] split = content3.split(regStr3);
        for (String str :
                split) {
            System.out.println(str);
        }
        //法二：分组得到
        System.out.println("========");
        String regStr31="^([a-zA-Z]+)://([a-zA-Z.]+):(\\d+)[\\w-/]*/([a-zA-Z.]+)$";
        Matcher matcher = Pattern.compile(regStr31).matcher(content3);
        if(matcher.matches()){//整体匹配，如果匹配成功，可以通过group（x），获取对应分组的内容
            System.out.println("整体匹配="+matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            System.out.println(matcher.group(4));
        }
        else {
            System.out.println("匹配不成功");
        }
    }
}
