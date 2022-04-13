package javaLearn_chapter6.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 风之诗
 * @version 1.0
 * 方法引用：
 *  优点：简化lambda表达式的代码。缺点：无法实现lambda表达式自定义更高级的功能
 *  特点：
 *      1、当lambda表达式仅！调用！一个方法时（不进行更多的操作），可以用方法引用来简化lambda表达式的形式
 *      2、它指示编译器生成一个函数式接口的实列，覆盖这个接口的抽象方法来调用给定的方法
 *      3、方法引用为变量赋值时会生成一个对象
 *      4、方法引用运算分割符的三种情况，
 *          （1）、object::instanceMethod
 *              等价于向方法传递参数的lambda表达式，如：System.out::println等价于x->System.out.println(x)
 *          （2）、Class::instanceMethod
 *              第一个参数成为隐式参数（指定泛型类型），如：String::compareToIgnoreCase等同于(x,y)->x.compareToIgnoreCase(y)
 *          （3）、Class::staticMethod
 *              所有参数都传递到静态方法，如：Math::pow等价于(x,y)->Math.pow(x,y)
 *      5、this指针和super指针：调用该类，或者超类中的某个实现了函数式接口的方法（前提是要在该类或者该类的超类中实现）
 *  构造器引用:类似于方法引用
 */
public class MethodReference {
    public static void main(String[] args) {
        //将函数式接口仅含一个方法的lambda表达式修改为方法引用
        String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order ignore case:");
        /**
         * 比较按字典比较字符串大小且不考虑大小写
         * 用方法引用代替lambda表达式实现简化仅含单个方法的函数式接口
         */
        Arrays.sort(planets,String::compareToIgnoreCase);
        System.out.println(Arrays.toString(planets));
        //此处方法只有一个参数且该参数能由上下文推出，可省略括号和类型
        //Timer timer = new Timer(1000, (ActionEvent event) -> System.out.println("The time is " + new Date()));
        //或者(event)或者event
        /**
         * 直接打印这个事件的对象
         * 用方法引用代替lambda表达式实现简化仅含单个方法的函数式接口
         */
        Timer timer = new Timer(1000, System.out::println);
        timer.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);

    }
}
