package HSPjavaLearn_FileLearn.transformation;

import java.io.*;

/**
 * @author 风之诗
 * @version 1.0
 * 演示使用InputStreamReader转化流 解决中文乱码问题
 * 将字节流FileInputStream转换为字符流 InputStreamReader，并指定编码
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        final String filePath = "e:\\a.txt";
//        //1、将文件字节流FileInputStream转化为字符流InputStreamReader并指定编码
//        final InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
//        //2、将字符流InputStreamReader包装成BufferedReader
//        final BufferedReader br = new BufferedReader(isr);

        //将1和2合在一起
        final BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "gbk"));

        //3、读取文件内容
        final String s = br.readLine();
        System.out.println(s);
        //4、关闭文件
        br.close();
    }
}
