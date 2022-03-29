package regularExperssion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//正则表达式实例
public class StringExperssion {
    public static void main(String[] args) {
        /**
         * 利用Pattern类中的matches方法进行字符串匹配的方法
         */
        String content="XinXinYuYangYang";
        String pattern=".*Yang.*";
        boolean ismatche = Pattern.matches(pattern,content);//Pattern类中的判断方法，第一个为正则表达式，第二个为内容，进行比较
        System.out.println("Have content includes Yang?:"+ismatche);

        /**
         * 利用matcher对象.gruop方法来获取捕获组
         */
        //设置在字符串中查找的指定格式
        String line="This order was placed for QT300! OK";
        String pattern2 = "(\\D*)(\\d+)(.*)";//设置正则表达式

        Pattern r = Pattern.compile(pattern2);//创建Pattern的对象（正则表达式的编译表示）,接受正则表达式的字符串
        Matcher m = r.matcher(line);//创建matcher对象（对输入字符串进行解释和匹配操作的引擎），接受普通字符串
        if(m.find()){//判断是否查找到相应的值
            System.out.println("Found value:"+m.group(0));
            System.out.println("Found value:"+m.group(1));
            System.out.println("Found value:"+m.group(2));
            System.out.println("Found value:"+m.group(3));
        }
        else{
            System.out.println("NO MATCH");
        }

    }
}
