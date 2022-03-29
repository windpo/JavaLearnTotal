package regularExperssion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 反向引用
 *  内部的反向引用：\\
 *  外部的反向引用：$
 */
public class RegExp10 {
    public static void main(String[] args) {
        String content3 = "12321-999888777";
        String content4 = "我...我要.....学学学学...编程java!";
        /**
         *  1、\\1可以调用第一个分组，引用第一个分组的规则  (\\d)\\1 -->两个相同的数 (\\d)\\1{4}  --->五个相同的数
         *  2、(\\d)(\\d)\\2\\1 --->  1551 2442格式
         *  3、检索12321-999888777 前面一个五位数，中间一个-，最后连续三个相同的9位数
         *  4、结巴程序:
         *         (1).去掉所有的点:   \.+
         *         (2).去掉所有重复的字:  1使用(.)\\1+匹配任意多个相同的字符  2使用反向引用$1来替换匹配到的内容
         */
        String regString3 = "^\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}$";

        /**(1).去掉所有的点*/
        String regString41 = "\\.+";

//        Pattern pattern = Pattern.compile(regString41);
//        Matcher matcher = pattern.matcher(content4);
//        content4 = matcher.replaceAll("");
        //使用一条语句替换
        content4 = Pattern.compile(regString41).matcher(content4).replaceAll("");

        System.out.println("content4= " + content4);

        /**(2).去掉所有重复的字*/
        String regString42="(.)\\1+";

//        Pattern pattern1 = Pattern.compile(regString42);
//        matcher=pattern1.matcher(content4);
//        content4 = matcher.replaceAll("$1");
        //使用一条语句直接替换
        content4 = Pattern.compile(regString42).matcher(content4).replaceAll("$1");
        System.out.println("content4= "+content4);
    }
}
