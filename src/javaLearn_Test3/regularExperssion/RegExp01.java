package regularExperssion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 定位符用法演示
 */
public class RegExp01 {
    public static void main(String[] args) {
            String content="韩顺平a教育";
            String regString1="^[\u0391-\uffe5]+a[\u0391-\uffe5]+$";
            String regString2="[\u0391-\uffe5]+$";
        /**
         *   ^:指定起始字符，整个字符串必须以^后面的内容开头  ^[0-9]+[a-z]*--->以至少一个数字开头，后面接任意个小写字母的字符串 123、6aa
         *   $：指定结束字符，整个字符串必须以$前面的内容结束  ^[0-9]\\-[a-z]+$ ---->以一个数字开头，中间用“-”连接，并以至少一个小写字母结尾 1-a
         */
        Pattern pattern = Pattern.compile(regString1);
            Matcher matcher = pattern.matcher(content);
            while(matcher.find()){
                System.out.println("找到： "+matcher.group(0));
            }
        }

}
