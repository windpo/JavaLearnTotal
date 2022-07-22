package HSPjavaLearn_FileLearn.printStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 风之诗
 * @version 1.0
 * 演示PrintWriter使用方法
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        final String filePath = "e:\\f2.txt";
        //标准输出
        final PrintWriter pw = new PrintWriter(System.out);
        pw.println("hello,hi,须弥");
        //输出到文件
        final PrintWriter pwf = new PrintWriter(new FileWriter(filePath));
        pwf.print("今天打卡，");
        pw.close();
        pwf.close();
        System.out.println("打印成功");
    }
}
