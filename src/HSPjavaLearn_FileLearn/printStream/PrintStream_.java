package HSPjavaLearn_FileLearn.printStream;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * @author 风之诗
 * @version 1.0
 * 演示PrintStream（字节打印流）
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        final String filePath = "e:\\f1.txt";
        final PrintStream out = System.out;

        //1、在默认情况下，PrintStream输出的位置是 标准输出，即显示器
        out.print("john,hello");

        //2、或者（print方法的底层为write方法，通过字节形式输出）
        out.write("john,hello".getBytes(StandardCharsets.UTF_8));

        //3、我们可以去修改打印流输出的位置/设备
        System.setOut(new PrintStream(filePath));
        System.out.print("刘旭阳hello");
        out.close();
    }
}
