package regularExperssion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 演示字符匹配符的使用
 */
public class RegExp02 {
    public static void main(String[] args) {
        String content="a11c8AC_Yya@";
        String RegStr1="(?i)[a-z]";//(?i)后面的内容不区分大小写
        String RegStr2="[^a-z]{2}";//^表示非，匹配两个不是a-z的字符,{2}两个重复语句，即[^a-z][^a-z]
        String RegStr3="[abcd]";//匹配abcd中的任意一个字符
        /**
         * //d:匹配0-9数字
         * //D：匹配非0-9数字
         * //w：匹配任意英文字符，数字以及下划线
         * //W：匹配非任意英文字符，数字以及下划线
         * //s：匹配任何空白字符（空格、制表符）
         * //S：匹配任何非空白字符
         * . ：匹配除任何\n之外的所有字符
         */
        Pattern pattern = Pattern.compile(RegStr3);
        Matcher matcher = pattern.matcher(content);
        while(matcher.find()){
            System.out.println("找到： "+matcher.group(0));
        }
    }
}
