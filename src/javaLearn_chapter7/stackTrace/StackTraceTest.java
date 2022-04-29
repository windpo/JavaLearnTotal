package javaLearn_chapter7.stackTrace;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.logging.Logger;

/**
 * @author 风之诗
 * @version 1.0
 * 打印递归函数调用的轨迹（以递归为例子）
 * 堆栈特点：先入后出，后入先出，首先调用最后的factorial（5），再逐步调用到factorial（1），最后从1开始返回值
 */
public class StackTraceTest {
    public static int factorial(int n) {
        System.out.println("factorial(" + n + "):");
        //打印堆栈轨迹信息
        StackWalker walker = StackWalker.getInstance();
        //此处System.out::println使用lambda表达式方法引用模式，省略了函数式接口StackWalker.StackFrame
//        walker.forEach(System.out::println);
        //lambda表达式写法，idea可以自动转化
        walker.forEach((StackWalker.StackFrame s)-> System.out.println(s));
        //递归结束条件
        int r;
        if (n <= 1) {
            r = 1;
        } else {
            r = n * factorial(n - 1);
        }
        System.out.println("return " + r);
        return r;
    }

    public static void main(String[] args) {
        Logger.getGlobal().info("File->Open menu item selected");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter n: ");
            int n = scanner.nextInt();
            factorial(n);
        }
    }
}
