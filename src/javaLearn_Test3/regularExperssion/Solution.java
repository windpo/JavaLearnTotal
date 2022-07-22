package javaLearn_Test3.regularExperssion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 风之诗
 * @version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        String content="2.39    \n" +
                "2.38    \n" +
                "2.38    \n" +
                "2.37    \n" +
                "2.37    \n" +
                "2.33    \n" +
                "2.31    \n" +
                "2.3   \n" +
                "2.27    \n" +
                "2.27    \n" +
                "2.26    \n" +
                "2.26    \n" +
                "2.24    \n" +
                "2.2   \n" +
                "2.18    \n" +
                "2.07    \n" +
                "2.05    \n" +
                "2.05    \n" +
                "2.04    \n" +
                "2.03    \n" +
                "2.01    \n" +
                "1.97    \n" +
                "1.95    \n" +
                "1.89    \n" +
                "1.88    \n" +
                "1.86    \n" +
                "1.84    \n" +
                "1.82    \n" +
                "1.79    \n" +
                "1.74    \n" +
                "1.74    \n" +
                "1.66    \n" +
                "1.64    \n" +
                "1.5   \n" +
                "1.22    \n" +
                "1.16\n";
        String regString="\\d.\\d+";
        final Matcher matcher = Pattern.compile(regString).matcher(content);
        while (matcher.find()){
            System.out.println(matcher.group(0));
        }

    }
}
