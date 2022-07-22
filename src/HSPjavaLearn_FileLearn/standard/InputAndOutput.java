package HSPjavaLearn_FileLearn.standard;

import java.util.Scanner;

/**
 * @author 风之诗
 * @version 1.0
 * 解读标准输入和标准输出的内容
 */
public class InputAndOutput {
    public static void main(String[] args) {
        //System类的    System.in（标准输入--键盘）  解读
        //编译类型：InputStream
        //运行类型：BufferedInputStream
        System.out.println("输出内容：");
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        System.out.println(next);
        //System类的    System.out（标准输出--显示器）  解读
        //编译类型：PrintStream
        //运行类型：PrintStream
        System.out.println("标准输出");
    }
}
