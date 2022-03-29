package string;

import java.util.Scanner;

/**
 * @author 风之诗
 * 一、String类的对象的创建
 *      1、可以按照创建类的对象的一般方法来创建String类的对象：
 *          String string = new String();
 *      2、也可以直接在创建对象时指定字符串内容：
 *          String string1 = "Hello World";  //string1字符串内容为"Hello World"
 *          String string2 = "";  //string2字符串内容为空
 * 二、length()方法
 *      String类中的length()方法将返回字符串对象的长度
 *          如：int a=str.length();
 *三、compareTo()方法
 *      String类中的compareTo()方法将返回两个字符串对象的比较结果，
 *      若相等，返回0。
 *      不相等时，从两个字符串第1个字符开始比较，返回第一个不相等的字符差；
 *      另一种情况，较长字符串的前面部分恰巧是较短的字符串，返回它们的长度差。
 *          如：if(str1.compareTo(str2)==0) 可表示如果比较的字符串相等
 * 四、Scanner中关于输入字符串的方法
 *      1、scanner.next():输入一个字符串单词，遇到空格或回车符则停止输入，剩下的字符留给下一次输入
 *      2、scanner.nextLine():输入一整行字符串，遇到空格不会停止
 */
public class StringTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1=new String();
        String str2=new String();
        //测试1：scanner.next()
        //str1=scanner.next();
        //str2=scanner.next();
        //侧式2：scanner.nextLine()
        str1=scanner.nextLine();
        str2=scanner.nextLine();
        System.out.println(str1+str2);
    }
}
