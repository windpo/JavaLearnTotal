package regularExperssion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 演示选择匹配符的使用
 */
public class RegExp03 {
    public static void main(String[] args) {
        String content="liuxuyang 杨洋 旭阳";
        String regStr="yang|洋|阳";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while(matcher.find()){
            System.out.println("找到： "+matcher.group(0));
        }
    }
}
