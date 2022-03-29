package regularExperssion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp09_matcher {
    public static void main(String[] args) {
        String content="hello xuyang hello xin xuyang hello hanser";
        String regString="xuyang";
        Pattern pattern = Pattern.compile(regString);
        Matcher matcher = pattern.matcher(content);
        /**
         *   matcher.start():返回找到的字符串的首索引
         *   matcher.end():返回找到的字符串的末尾索引+1
         *   matcher.matches():整体匹配,常用于去检验某个字符串是否满足某种规则
         */
        while(matcher.find()){
            System.out.println("==========");
            System.out.println(matcher.start());
            System.out.println(matcher.end());
            System.out.println("找到："+content.substring(matcher.start(),matcher.end()));//利用substring方法来输出字符串
        }

        //整体匹配方法，常用于去检验某个字符串是否满足某种规则
        System.out.println("整体匹配="+matcher.matches());
        //完成如果content 有hspedu替换成 韩顺平教育
        String regString2="xuyang";
        //注意：返回的是新的字符串，原来的字符串无变化
        String newString = matcher.replaceAll("旭阳");
        System.out.println("newString= "+newString);
    }
}
