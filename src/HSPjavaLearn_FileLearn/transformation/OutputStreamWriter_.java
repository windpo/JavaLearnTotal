package HSPjavaLearn_FileLearn.transformation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author 风之诗
 * @version 1.0
 * 演示OutputStreamWriter的使用  指定写入文件的编码方式
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        final String filePath = "e:\\lxy.txt";
        final String charSet = "gbk";
        //创建字符转换流并指定编码方式
        final OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), charSet);
        //写入字符串
        osw.write("hello,刘旭阳");
        //关闭输出流
        osw.close();
        System.out.println("按照 "+charSet+" 保存文件成功~");
    }
}
