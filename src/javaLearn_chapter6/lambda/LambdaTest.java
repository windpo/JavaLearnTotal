package javaLearn_chapter6.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Date;

/**
 *
 *
 * lambda表达式：
 *  1、本质为定义一个代码块，用来解决java没有函数式编程的缺点
 *  2、可以直接用lambda表达式来代替先创建对象再定义方法的缺陷（实现函数式接口，如实现comparator接口以及ActionEvent接口）
 *  3、仅能赋值给函数式接口（仅有一个方法的接口）
 *  4、演示lambda表达式的使用来代替实现一个比较器Comparator和一个动作监听器ActionListener
 *
 * @author 风之诗
 * @version 1.0
 */
public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length:");
        //此处lambda表达式类型能从planets String数组推出，可省略添加String类型
        Arrays.sort(planets, (String first, String second) -> first.length() - second.length());
        //或者(first,second)
        System.out.println(Arrays.toString(planets));
        //此处方法只有一个参数且该参数能由上下文推出，可省略括号和类型
        Timer timer = new Timer(1000, (ActionEvent event) -> System.out.println("The time is " + new Date()));
        //或者(event)或者event
        timer.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);

    }
}
