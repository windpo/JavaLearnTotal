package regularExperssion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 演示分组的使用
 *  1、非命名分组
 *  2、命名分组
 */
public class RegExp05 {
    public static void main(String[] args) {
        String content="aoawijd 1995 2351321 1152 132a 1123";
        String regString1="(\\d\\d)(\\d\\d)";//普通分组
        String regString2="(?<num1>\\d\\d)(?<num2>\\d\\d)";//命名分组
        Pattern pattern = Pattern.compile(regString2);
        Matcher matcher = pattern.matcher(content);
        while(matcher.find()){
            System.out.println("找到： "+matcher.group(0));
            System.out.println("找到第一组： "+matcher.group("num1"));
            System.out.println("找到第二组： "+matcher.group("num2"));
        }
    }
}
