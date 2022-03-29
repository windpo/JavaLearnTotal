package regularExperssion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoocRefactCode {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入慕课上的代码，接下来会将其转化为正确格式的代码");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));//字符串读入
        String regString = "(?!\n|\u200C|\u200E|\u200D).+";//正则表达式
        Pattern pattern = Pattern.compile(regString);
        String str;
        do {
            str = bufferedReader.readLine();
            Stream<String> stream=Stream.of(str);//把字符串转化为流，保存在字符串流中
            //流中的方法，filter过滤器：相当于筛子，c代表流中的每一个元素，里面用lamda表达式加上正则matches匹配方法、
            //再用collect方法把流转化为字符串
            //注：Array工具类为Arrays Collectors为collect的工具类
            str=stream.filter(c -> c.matches("(?!\n|\u200C|\u200E|\u200D|\u200B|\u200F).+")).collect(Collectors.joining());
            Matcher matcher = pattern.matcher(str);
            while(matcher.find()){
                System.out.println(matcher.group(0));
            }
        } while (!str.equals("end"));
        }
    }
