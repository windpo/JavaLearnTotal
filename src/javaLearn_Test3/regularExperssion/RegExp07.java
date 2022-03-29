package regularExperssion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ?作用与限定符“+”、“*”的非贪婪匹配
 */
public class RegExp07 {
    public static void main(String[] args) {
        String content="hello11111112222221 ok";
        String regString="\\d+?";
        Pattern pattern = Pattern.compile(regString);
        Matcher matcher = pattern.matcher(content);
        while(matcher.find()){
            System.out.println("找到： "+matcher.group(0));
        }
    }
}
