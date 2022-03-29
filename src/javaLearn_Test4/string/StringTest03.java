package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest03 {
    public static void main(String[] args) {
        String content="2";
        String regStr="3";
        Matcher matcher = Pattern.compile(regStr).matcher(content);
        while(matcher.find()){
            System.out.println(matcher.start());
        }
    }
}
