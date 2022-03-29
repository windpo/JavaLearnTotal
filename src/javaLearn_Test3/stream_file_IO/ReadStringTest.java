package stream_file_IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 读入字符或者字符串
 */
public class ReadStringTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));//创建一个字符流
        //BufferedReader 对象创建后，我们便可以使用 read() 方法从控制台读取一个字符，或者用 readLine() 方法读取一个字符串。
        char[] chars=new char[10000];
        for (int i = 0; i < chars.length; i++) {
            chars[i]='0';
        }
        int i=0;
        char c;
        /**
         * 字符的读入：每次调用 read() 方法，它从输入流读取一个字符并把该字符作为整数值返回。 当流结束的时候返回 -1
         */
//        do{
//            c = (char) bufferedReader.read();
//            chars[i++]=c;
//        }while(c!='~');
//        for (int j = 0; j < chars.length&&chars[j]!='0'; j++) {
//            System.out.print(chars[j]);
//        }
        /**
         * 字符串的读入：每次调用readLine()方法
         * 注：readLine不会把回车符读入，而read会把字符读入
         */
        System.out.println("输入字符串，以end作为结束");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = new String();
        do {
            s = reader.readLine();
            System.out.println(s);
        }while(!s.equals("end"));
    }
}
