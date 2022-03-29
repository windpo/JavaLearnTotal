package regularExperssion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 演示限定符的使用
 */
public class RegExp04 {
    public static void main(String[] args) {
        /**
         *
         *  *:表示匹配指定字符的0到n次  (abc)*-->abc、abcabc
         *  +：表示匹配指定字符的1到n次  m+(abc)-->m、mabc、mabcabc
         *  ?:表示匹配指定字符的0或1次  m+abc?--->mab、mabc
         *  {n}:匹配长度为n的指定字符串  [abcd]{3}---->abc、acd、adc、bcd。。。。
         *  {n,}:匹配长度最少为n的指定字符串  [abcd]{4,}---->abcd、aabcd、bcdaaaa
         *  {a,b}:匹配长度最少为a最多为b的指定字符串 [abcd]{1,2}---->ab、a、cd
         */
        String content="1111111aaaahello";
        //String regStr="\\d{2,7}";//匹配任意2到7个数字，默认尽可能匹配多的
        //String regStr="\\d+";//匹配1个数字或者多个数字
        //String regStr="\\d*";//匹配0个数字或者多个数字
        String regStr="1a?";//匹配1或者1a
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while(matcher.find()){
            System.out.println("找到： "+matcher.group(0));
        }
    }
}
