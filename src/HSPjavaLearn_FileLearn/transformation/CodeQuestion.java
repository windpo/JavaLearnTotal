package HSPjavaLearn_FileLearn.transformation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 风之诗
 * @version 1.0
 * 一个中文乱码问题，引出转换流
 */
public class CodeQuestion {
    public static void main(String[] args) throws IOException {
        //读取e:\\a.txt 文件到程序
        //1、创建字符输入流BufferedReader
        //2、使用BufferedReader对象读取文件
        //3、默认情况，读取文件按照UTF-8 编码，但如果编码不同，则会出现乱码
        final String filePath = "e:\\lxy.txt";
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        final String s = bufferedReader.readLine();
        System.out.println(s);
    }
}
