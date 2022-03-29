package regularExperssion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 使用特别分组
 */
public class RegExp06 {
    public static void main(String[] args) {
        String content="xinxinbao xinxinguaiguai xinxinbei xinxinguaibaobei xinxinheiheihei xinxinwa";
        //String regString="xinxin(?:bao|bei)";// 查找xinxinbao xinxinbei 两种
        //String regString="xinxin(?=bao|bei)";//查找xinxinbao 和xinxinbei 中的xinxin
        String regString="xinxin(?!bao|bei)";//查找除了xinxinbao和xinxinbei之外的xinxin
        /**
         *
         * xixin(?:pattern):匹配含有后面多者之一的整个串
         * xinxin(?=pattern):匹配含有后面多者之一的前面的串
         * xinxin(?!pattern):匹配不含有后面多者之一的前面的串
         */
        Pattern pattern = Pattern.compile(regString);
        Matcher matcher = pattern.matcher(content);
        while(matcher.find()){
            System.out.println("找到： "+matcher.group(0));
        }
    }
}
