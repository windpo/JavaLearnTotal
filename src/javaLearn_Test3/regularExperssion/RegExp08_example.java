package regularExperssion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式的综合应用
 *  \\d：匹配数字0-9
 *  \\w：匹配字母以及数字和下划线
 *  \\s：匹配非空字符（包括空格、换行符）
 *  \\un：匹配n，其中n为四位数字的unicode字符
 *  汉字匹配：[\u0391-\uffe5]+$
 *  ^：指定起始字符
 *  $：指定结束字符
 */
public class RegExp08_example {
    public static void main(String[] args) {
        String content="www.bilibili.com/video/BV11R4y1L7Gk?spm_id_from=333.851.b_7265636f6d6d656e64.3";
        //验证是否为汉字
        String regString1="^[\u0391-\uffe5]+$";

        //验证为邮政编码
        //要求：是1-9开头的一个六位数，如：12890
        String regString2="^[1-9]\\d{5}$";

        //验证为qq号码
        //要求：是一个1-9开头的一个（5-10）位数
        String regString3="^[1-9]\\d{4,9}$";

        //验证手机号码
        //要求：必须以13，14，15，18 开头的11位数字
        String regString4="^1[3458]\\d{9}$";//注意：[]匹配一个字符,不能写[13|14|15|18]，括号中仅能表示一个，如果要多加得用限定符

        //验证复杂的url
        //先确定url的开头部分 https：// |http：//
        //通过([\w-]+\.)+[\w-]+  来匹配www.baidu.com
        //通过(\/[\w-#?=&/%.]*)?$  来匹配最后的字符，注意：[]中的内容全部均不用转意
        String regString5="^((https?)://)?([\\w-]+\\.)+[\\w-]+(\\/[\\w-#?=&/%.]*)?$";

        Pattern pattern = Pattern.compile(regString5);
        Matcher matcher = pattern.matcher(content);
        if(matcher.find()){
            System.out.println("匹配成功");
        }
        else {
            System.out.println("匹配失败");
        }

        //这里如果使用pattern的matches 整体匹配 更加简洁，自动从头开始检验,省略了^$，而find方法不是
        System.out.println(Pattern.matches(regString5,content));
    }

}
